package com.licslan.stormlearn.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;

import java.util.HashMap;
import java.util.Map;

/**
 * kafka工具类
 *
 * author -----------[licslan]
 * */
public class KafkaUtils {

    private final static String BOOTSTRAPSERVER_KAFKA = "192.168.126.128:9092,192.168.126.129:9092,192.168.126.130:9092";
    private final static String ACKS = "all";
    private final static String RETRIES = "0";
    private final static int BATCH_SIZE = 16384;
    private final static int LINGER_MS = 1;
    private final static int BUFFERMEMORY = 33554432;
    private final static String KEYSERIALIZER = "org.apache.kafka.common.serialization.StringSerializer";
    private final static String VALUESERIALIZER= "org.apache.kafka.common.serialization.StringSerializer";

   private static Map<String,Object> getMapConfig(){
       Map<String,Object> map = new HashMap<>();
       map.put("bootstrap.servers",BOOTSTRAPSERVER_KAFKA);
       map.put("acks",ACKS);
       map.put("retries",RETRIES);
       map.put("batch.size",BATCH_SIZE);
       map.put("linger.ms",LINGER_MS);
       map.put("buffer.memory",BUFFERMEMORY);
       map.put("key.serializer",KEYSERIALIZER);
       map.put("value.serializer",VALUESERIALIZER);
       return  map;
   }

    /** 获取kafka设置为公开的  其他方法改成private */
   public static Producer<String, String> KafkaUtils(){
       return new KafkaProducer<>(getMapConfig());
   }
}
