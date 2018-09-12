package com.licslan.stormlearn.zookeeper;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * zookeeper工具类
 * */
public class ZookeeperUtils {

    private static String connectString = "192.168.126.128:2181,192.168.126.129:2181,192.168.126.130:2181";
    private static int sessionTimeout = 999999;
    public static ZooKeeper ZookeeperUtils()throws Exception{
        Watcher watcher = event -> System.out.println("监听到的事件：" + event);
        final ZooKeeper zookeeper = new ZooKeeper(connectString, sessionTimeout, watcher);
        return zookeeper;
    }
}
