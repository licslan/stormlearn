package com.licslan.stormlearn.test;

import com.licslan.stormlearn.zookeeper.ZookeeperUtils;
import org.apache.zookeeper.Watcher;

public class SeachZookeeperNode {

    public static void main(String[] args) throws Exception {
        Watcher watcher = event -> System.out.println("监听到的事件：" + event);
        final byte[] data = ZookeeperUtils.ZookeeperUtils().getData("/zk1", watcher, null);
        System.out.println("读取的值：" + new String(data));
        ZookeeperUtils.ZookeeperUtils().close();
    }
}
