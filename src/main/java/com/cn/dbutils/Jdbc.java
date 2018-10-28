package com.cn.dbutils;

import java.sql.*;

public class Jdbc {

    public Connection getConn(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://182.61.17.191:3306/shool?useSSL=false&useUnicode=true&characterEncoding=utf8","root","root@000");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;

    }


     public static void main(String args[]){
        Jdbc jdbc = new Jdbc();
        Connection conn = jdbc.getConn();
         Statement statement;
         ResultSet rs ;
         try {
             statement = conn.createStatement();
             rs =  statement.executeQuery("select * from student");
            rs.next();
             String sname = rs.getString("Sname");
             System.out.print(sname);
         } catch (SQLException  e) {
             e.printStackTrace();
         }finally{
             try {
                 conn.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
     }

}

