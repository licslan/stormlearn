package com.licslan.stormlearn.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.licslan.stormlearn.kafka.KafkaUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * 发送数据到kafka服务器
 *
 * author -----------[licslan]
 * */
@Slf4j
public class SendMes2Kafka {

    static List<String> listPhones = new ArrayList<>();
    static List<String> listMemis = new ArrayList<>();
    static List<String> listIps = new ArrayList<>();
    public static void main(String[] args) {
        //   type -------->  login_fail   login_suc_memi    login_ip_suc  login_memi_suc
        int e =100;
        List<String> login_failList = productData("login_memi_suc");
        for(int i=0;i<e;i++){
            String key = UUID.randomUUID().toString();
            KafkaUtils.KafkaUtils().send(new ProducerRecord<>("mykafka", key,login_failList.get(i)));
            log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>发送消息到kafka服务器成功！发送了第  "+ (i+1) + "次"+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            try {
                Thread.sleep(200);
            } catch (InterruptedException x) {
                x.printStackTrace();
            }

        }
    }


    /**
     *     --------------------------
     *          测试数据生产格式
     *     --------------------------
     * 	LOGIN_FAIL_USEID("login_fail",3,10*60,"5分钟内登陆失败3次，加入黑名单10分钟"),
     * 	LOGIN_SUC_MEMI("login_suc_memi",3,60*60,"5分钟内一个设备出现了3个及以上不同手机号登陆行为，加入黑名单60分钟"),
     * 	LOGIN_IP_SUC("login_ip_suc",3,60*60,"5分钟内一个设备出现了3个及以上不同IP登陆行为，加入黑名单60分钟"),
     * 	LOGIN_MEMI_SUC("login_memi_suc",3,60*60,"5分钟内，同一个手机号拥有3个不同设备上登陆的行为，加入黑名单60分钟"),
     *
     * 	--------------------------
     * 	         5分钟内登陆失败3次                 type   ------->login_fail
     *  --------------------------
     * 			 5分钟内同一个设备出现3个不同手机号  type   ----->login_suc_memi
     * 	--------------------------
     * 	         5分钟内同一个设备出现3个不同IP     type    ----->login_ip_suc
     * 	--------------------------
     * 		     5分钟内同一个手机出现3个不同设备   type    ----->login_memi_suc
     *  --------------------------
     *
     * */

    //生产数据
    public static List<String> productData(String parmas){
        List<String> jsonStr = new ArrayList<>();
        switch(parmas){
            case "login_fail":
                int a=100;
                for(int i=0;i<a;i++){
                    //组装数据  5分钟内登陆失败3次
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("userId","33333");
                    //ip随机生成
                    jsonObject.put("ip",getIps().get(i));
                    //手机随机生成
                    jsonObject.put("phone","13125181111");
                    //设备随机生成
                    jsonObject.put("miei",getMemis().get(i));
                    jsonObject.put("sim","xxx");
                    jsonObject.put("did","yyy");
                    jsonObject.put("datetime","1533232323");
                    jsonObject.put("type","login_fail");
                    jsonObject.put("system","zzz");
                    jsonObject.put("value","555");
                    jsonStr.add(JSON.toJSONString(jsonObject));
                }
                break;
            case "login_suc_memi":
                int b=100;
                for(int i=0;i<b;i++){
                    //组装数据  5分钟内同一个设备出现3个不同手机号
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("userId","33333");
                    //同一设备表明IP也应该相同基本上一段时间内
                    jsonObject.put("ip","192.168.0.150");
                    //手机随机生成
                    jsonObject.put("phone",getPhones().get(i));
                    //设备相同  手机号不同
                    jsonObject.put("miei","testBBBBBB");
                    jsonObject.put("sim","xxx");
                    jsonObject.put("did","yyy");
                    jsonObject.put("datetime","1533232323");
                    jsonObject.put("type","login_suc_memi");
                    jsonObject.put("system","zzz");
                    jsonObject.put("value","555");
                    jsonStr.add(JSON.toJSONString(jsonObject));
                }
                break;
            case "login_ip_suc":
                int c=100;
                for(int i=0;i<c;i++){
                    //组装数据  5分钟内同一个设备出现3个不同IP
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("userId","33333");
                    //ip随机生成  同一设备 不同IP
                    jsonObject.put("ip",getIps().get(i));
                    //手机号码可以相同 可以不同
                    jsonObject.put("phone","13125181234");
                    //同一设备
                    jsonObject.put("miei","testAAAAA");
                    jsonObject.put("sim","xxx");
                    jsonObject.put("did","yyy");
                    jsonObject.put("datetime","1533232323");
                    jsonObject.put("type","login_ip_suc");
                    jsonObject.put("system","zzz");
                    jsonObject.put("value","555");
                    jsonStr.add(JSON.toJSONString(jsonObject));
                }
                break;
            case "login_memi_suc":
                int d=100;
                for(int i=0;i<d;i++){
                    //组装数据  5分钟内同一个手机出现3个不同设备
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("userId","33333");
                    //同一手机号  不同设备  IP也会不同
                    jsonObject.put("ip",getIps().get(i));
                    //手机随机生成
                    jsonObject.put("phone","13125181235");
                    //设备随机生成
                    jsonObject.put("miei",getMemis().get(i));
                    jsonObject.put("sim","xxx");
                    jsonObject.put("did","yyy");
                    jsonObject.put("datetime","1533232323");
                    jsonObject.put("type","login_memi_suc");
                    jsonObject.put("system","zzz");
                    jsonObject.put("value","555");
                    jsonStr.add(JSON.toJSONString(jsonObject));
                }
                break;
        }
        return jsonStr;
    }

    //生产IP地址
    public static List<String> getIps(){
        Random rnd = new Random();
        int size=100;
        for(int i=0;i<size;i++){
           /* if(i<80){
                String key = "192.168.2." + rnd.nextInt(255);
                listIps.add(key);
            }else listIps.add("192.168.2.150");*/
            listIps.add("192.168.2." + rnd.nextInt(255));

        }
        return listIps;

    }

    //生产电话号码
    private static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
    private static String getTel() {
        int index=getNum(0,telFirst.length-1);
        String first=telFirst[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String thrid=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+thrid;
    }
    public static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }
    public static List<String> getPhones(){
        int size=100;
        for(int i=0;i<size;i++){
           /* if(i<50  && i>30)
                listPhones.add("13125181234");
            else {listPhones.add(getTel());}*/
            listPhones.add(getTel());
        }
        return listPhones;
    }
    //生成设备
    public static List<String> getMemis(){
        Random rnd = new Random();
        int size=100;
        for(int i=0;i<size;i++){
           /* if(i>50 && i<80)
                listMemis.add("memi_test"+ rnd.nextInt(255) );
            else listMemis.add("memi_testA");*/
            listMemis.add("memi_test"+ rnd.nextInt(255));
        }
        return listMemis;
    }

}
