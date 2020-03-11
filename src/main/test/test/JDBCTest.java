package test;

import com.cn.util.JDBCUtil;

import java.sql.Connection;

public class JDBCTest {

	public static void main(String[] args) {
		Connection staus= JDBCUtil.getConnection();
		System.out.println(staus);

	}

}
