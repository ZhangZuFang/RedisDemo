package com.cn.redeis;

import redis.clients.jedis.Jedis;

public class RedisUtils {
    private Jedis jedis = null;


    public Jedis getJedis() {
         if(jedis==null){
             jedis = new Jedis("182.61.17.191");
             jedis.auth("HyyFds002");
         }
        return jedis;
    }


    public static void main(String args[]){


        RedisUtils redisUtils = new RedisUtils();
        Jedis jedis = redisUtils.getJedis();
        System.out.print(jedis.ping());


    }
}
