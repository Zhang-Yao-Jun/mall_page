package com.zr.util;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class DataUtil {

    private static Properties properties =  new Properties();
    static {
        try {
            properties.load(DataUtil.class.getClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        DruidDataSource druidDataSource =  new DruidDataSource();
        druidDataSource.configFromPropety(properties);
        return druidDataSource;
    }

}
