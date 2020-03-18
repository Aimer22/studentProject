package com.cn.util;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class QueryRunnerDemo {


        public  List<Map<String,Object>> selectStuInfo() throws SQLException {
            QueryRunner queryRunner = new QueryRunner();
            String sql = "select * from studentinfo,student where studentinfo.stuNo = student.stuNo";

            List<Map<String,Object>> list = queryRunner.query(JDBCUtil.getConnection(),sql,new MapListHandler());
            for (Map<String,Object> map:list){
               for (String key:map.keySet()){
                   System.out.println(key+"-->"+map.get(key));
               }
                System.out.println();
            }
            return list;
        }

    public static void main(String[] args) throws SQLException{
        QueryRunnerDemo queryRunner = new QueryRunnerDemo();
        queryRunner.selectStuInfo();
    }
}
