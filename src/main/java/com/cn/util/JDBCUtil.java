package com.cn.util;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	private static ComboPooledDataSource dateSource=null;
	
	
	static {				
		try {
			Properties pro=new Properties();

			InputStream is=JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");


			//加载文件
			pro.load(is);
			System.out.println("文件加载成功");
			//获取数据
			url=pro.getProperty("jdbc.url");
			user=pro.getProperty("jdbc.user");
			password=pro.getProperty("jdbc.password");
			driver=pro.getProperty("jdbc.driver");
			System.out.println("成功获取数据");
			
			//配置数据源
			dateSource=new ComboPooledDataSource();
			dateSource.setDriverClass(driver);
			dateSource.setJdbcUrl(url);
			dateSource.setUser(user);
			dateSource.setPassword(password);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	/***
	 * 
	 * 返回数据库连接
	 */
	
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			conn=dateSource.getConnection();
			System.out.println("成功连接数据库");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
	
	
}
