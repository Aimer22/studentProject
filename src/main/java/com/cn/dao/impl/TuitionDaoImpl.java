package com.cn.dao.impl;

import com.cn.dao.TuitionDao;
import com.cn.domain.Tuition;
import com.cn.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TuitionDaoImpl implements TuitionDao {
    private Connection conn=null;
    private PreparedStatement pst=null;
    private ResultSet rs;
    @Override
    public int addTuition(Tuition tuition) throws SQLException {
        String sql="insert into tuition (orderNo,fees,spendOnBook,accommodation,insurance,amount,paytime,stateOfPay,stuNo) values(?,?,?,?,?,?,?,?,?)";
        conn= JDBCUtil.getConnection();
        pst=conn.prepareStatement(sql);
        pst.setObject(1, tuition.getOrderNo());
        pst.setObject(2,tuition.getFees());
        pst.setObject(3, tuition.getSpendOnBook());
        pst.setObject(4, tuition.getAccommodation());
        pst.setObject(5, tuition.getInsurance());
        pst.setObject(6, tuition.getAmount());
        pst.setObject(7, tuition.getPayTime());
        pst.setObject(8, tuition.isStateOfPay());
        pst.setObject(9,tuition.getStuNo());
        int status=pst.executeUpdate();
        conn.close();
        pst.close();

        return status;
    }

    @Override
    public int deleteTuition(int stuNo) throws SQLException {
        String sql="delete from tuition where stuNo=?";
        conn=JDBCUtil.getConnection();
        pst=conn.prepareStatement(sql);
        pst.setObject(1,stuNo);
        int recordNum=pst.executeUpdate();
        conn.close();
        pst.close();
        return recordNum;
    }

    @Override
    public int updateTuition(Tuition tuition) throws SQLException {
        String sql="update tuition set orderNo=?,fees=?,spendOnBook=?,accommodation=?,insurance=?,amount=?,paytime=?,stateOfPay=? where stuNo=?";
        conn=JDBCUtil.getConnection();
        pst=conn.prepareStatement(sql);
        pst.setObject(1,tuition.getOrderNo());
        pst.setObject(2,tuition.getFees());
        pst.setObject(3,tuition.getSpendOnBook());
        pst.setObject(4,tuition.getAccommodation());
        pst.setObject(5,tuition.getInsurance());
        pst.setObject(6,tuition.getAmount());
        pst.setObject(7,tuition.getPayTime());
        pst.setObject(8,tuition.isStateOfPay());
        pst.setObject(9,tuition.getOrderNo());

        int recordNum=pst.executeUpdate();
        conn.close();
        pst.close();
        return recordNum;
    }

    @Override
    public List<Tuition> getAllTuition() throws SQLException {
        String sql="select * from tuition";
        conn=JDBCUtil.getConnection();
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        List<Tuition> tuitionList=new ArrayList<Tuition>();
        while (rs.next()){
            int orderNo=rs.getInt("orderNo");
            int fees=rs.getInt("fees");
            int spendOnBook=rs.getInt("spendOnBook");
            int accommodation=rs.getInt("accommodation");
            int insurance=rs.getInt("insurance");
            int amount=rs.getInt("amount");
            Timestamp paytime=rs.getTimestamp("paytime");
            boolean stateOfPay=rs.getBoolean("stateOfPay");
            int stuNo = rs.getInt("stuNo");

            Tuition tuition=new Tuition(orderNo,fees,spendOnBook,
                    accommodation,insurance,amount,paytime,stateOfPay,stuNo);
            tuitionList.add(tuition);
        }
        conn.close();
        pst.close();
        rs.close();
        return tuitionList;
    }

    @Override
    public Tuition getTuitionByStuNo(int stuNo) throws SQLException {
        String sql="select * from tuition where stuNo=?";
        conn=JDBCUtil.getConnection();
        pst=conn.prepareStatement(sql);
        pst.setObject(1,stuNo);
        rs=pst.executeQuery();
        Tuition tuition=null;
        while (rs.next()){
            int orderNo=rs.getInt("orderNo");
            int fees=rs.getInt("fees");
            int spendOnBook=rs.getInt("spendOnBook");
            int accommodation=rs.getInt("accommodation");
            int insurance=rs.getInt("insurance");
            int amount=rs.getInt("amount");
            Timestamp paytime=rs.getTimestamp("paytime");
            boolean stateOfPay=rs.getBoolean("stateOfPay");


            tuition=new Tuition(orderNo,fees,spendOnBook,
                    accommodation,insurance,amount,paytime,stateOfPay,stuNo);

        }
        conn.close();
        pst.close();
        rs.close();
        return tuition;
    }
}
