package com.cn.dbutils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCreatorTest {


public  static  void main(String args[]){

    DSCreator dsCreator = new DSCreator();
    DataSource ds = dsCreator.getDataSource();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    try {
      conn=  ds.getConnection();
        ps =conn.prepareStatement("select * from student");
        ps.executeQuery();
        rs = ps.getResultSet();
        rs.next();
       System.out.print( rs.getString("Sname"));
    } catch (SQLException e) {
        e.printStackTrace();
    }







}

}
