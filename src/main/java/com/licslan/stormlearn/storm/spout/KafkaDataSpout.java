package com.licslan.stormlearn.storm.spout;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichSpout;
import backtype.storm.topology.OutputFieldsDeclarer;
import com.alibaba.jstorm.client.spout.IAckValueSpout;
import com.alibaba.jstorm.client.spout.IFailValueSpout;

import java.util.List;
import java.util.Map;

/**
 * 从kafka获取数据  数据来源  水龙头 水源
 *
 * author -----------[licslan]
 * */
public class KafkaDataSpout implements IRichSpout, IAckValueSpout, IFailValueSpout {



    /**
     * IRichSpout
     *
     *IAckValueSpout
     *
     * IFailValueSpout
     *
     * */





    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {

    }

    @Override
    public void close() {

    }

    @Override
    public void activate() {

    }

    @Override
    public void deactivate() {

    }

    @Override
    public void nextTuple() {

    }

    @Override
    public void ack(Object o) {

    }

    @Override
    public void fail(Object o) {

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }

    @Override
    public void ack(Object o, List<Object> list) {

    }

    @Override
    public void fail(Object o, List<Object> list) {

    }
}
