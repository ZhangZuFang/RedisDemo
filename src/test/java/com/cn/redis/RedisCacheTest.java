package com.cn.redis;

import com.cn.redeis.RedisCache;
import com.cn.redeis.RedisUtils;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class RedisCacheTest {

    @Before
    public void init(){
        System.out.print("开始缓存.....");
        //系统初始化时候做缓存操作
        RedisCache redisCache = new RedisCache();
        redisCache.ShoolStuNamesCache();
        System.out.print("结束缓存.....");
    }


    @Test
    public void RedisListTest(){



        //先从缓存中取
        RedisUtils redisUtils = new RedisUtils();
        Jedis jedis =  redisUtils.getJedis();
        String name =  jedis.get("name");

        if(name!=null){
            System.out.print("name from Redis Cache is "+name);
            return ;
        }else {
            //redis没有数据从DB中查找并且放入缓存
            //在这里又会执行类似初始化的操作，查询db..
        }


    }


}
