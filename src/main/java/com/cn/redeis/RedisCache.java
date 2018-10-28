package com.cn.redeis;

import com.cn.dbutils.DSCreator;
import redis.clients.jedis.Jedis;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RedisCache {

    DSCreator dsCreator = new DSCreator();
    DataSource ds = dsCreator.getDataSource();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    RedisUtils redisUtils = new RedisUtils();
    Jedis jedis=null;


    public void  ShoolStuNamesCache(){

       try {
                conn=  ds.getConnection();
                ps =conn.prepareStatement("select * from student");
                ps.executeQuery();
                rs = ps.getResultSet();
                while(rs.next()){
                    String name = rs.getString("Sname");
                    jedis = redisUtils.getJedis();
                    jedis.set("name",name);
                    //之后修改为学生名称集合存入 redis

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

    }



}
