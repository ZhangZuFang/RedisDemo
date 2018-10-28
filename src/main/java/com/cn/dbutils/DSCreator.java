package com.cn.dbutils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.ResourceBundle;

public class DSCreator {

    public DataSource getDataSource(){
        ResourceBundle resource = ResourceBundle.getBundle("db-config");
        String dbUrl = resource.getString("default.db.url");
        String dbUser = resource.getString("default.db.username");
        String dbPwd = resource.getString("default.db.pwd");
        String  driverClass = resource.getString("default.db.driverclass");
        ComboPooledDataSource combo = new ComboPooledDataSource();
        try {
            combo.setJdbcUrl(dbUrl);
            combo.setUser(dbUser);
            combo.setPassword(dbPwd);

            combo.setDriverClass(driverClass);
        } catch ( PropertyVetoException e) {

            e.printStackTrace();
        }

        return combo;

    }

}
