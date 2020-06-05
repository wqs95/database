package com.wqs.redis.demo01;

import redis.clients.jedis.Jedis;
public class RedisTest01 {
    public static void main(String[] args) {
        //1、构造Jedis对象，不配置，则默认是localhost:6379
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //2、获取连接
//        jedis.connect();
        System.out.println("连接成功");
        /**
         * 五种数据类型的使用
         */
        System.out.println("============1、写字符串类型String=============");
        String status = jedis.set("testString", "门");
        System.out.println("返回值：" +status + "获取到的值：" + jedis.get("testString"));
        //jedis.del("testString");//删除键

        System.out.println("============2、写哈希类型Hash=============");
        Long status1 = jedis.hset("testHash", "hashKey", "hashValue");
        System.out.println("返回值：" +status1 + "获取到的值：" + jedis.hget("testHash","hashKey"));
        //jedis.hdel("testHash","hashKey");//删除键

        System.out.println("============3、写列表类型list : LinkedList格式。支持重复元素=============");
        jedis.lpush("testList","a");//左添加
        jedis.lpush("testList","b");//左添加
        jedis.rpush("testList","c");//右添加
        System.out.println("范围获取值：" + jedis.lrange("testList",0,1));
        System.out.println("获取所有的值：" + jedis.lrange("testList",0,-1));
        //jedis.lpop("testList");//删除列表最左边的值
        //jedis.rpop("testList");//删除列表最右边的值

        System.out.println("============4、写集合set : 不允许重复元素=============");
        Long status2 = jedis.sadd("testSet","set1","set2","set3");
        System.out.println("返回值：" +status2 + "获取集合中所有元素：" + jedis.smembers("testSet"));
        //jedis.srem("testSet","set1");//删除集合中某个元素

        System.out.println("============5、有序集合类型sortedSet ： 不允许重复元素，且元素有顺序=============");
        jedis.zadd("students",30,"小明");//存储数据及数据对应分数
        jedis.zadd("students",40,"小李");//存储数据及数据对应分数
        jedis.zadd("students",20,"小光");//存储数据及数据对应分数
        System.out.println("获取有序集合类型所有元素：" + jedis.zrange("students",0,-1));
        //jedis.zrem("students","小明");//删除集合中某个元素

        System.out.println("============6、通用命令=============");
        String type = jedis.type("testString");//获取指定键的类型
        //jedis.del("testString");//删除指定键的类型
        //jedis.keys("");//获取所有指定键的set集合。
        System.out.println("数据类型：" + type);
    }

}
