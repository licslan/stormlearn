package com.licslan.stormlearn.test;

import com.licslan.stormlearn.redis.RedisUtils;

/**
 * 测试保存数据到redis服务器
 *
 * author -----------[licslan]
 * */
public class SaveData2Redis {

    public static void main(String[] args) {
        RedisUtils.getJRedis().sadd("licslan","sdaffffffffffffffa");
    }
}
