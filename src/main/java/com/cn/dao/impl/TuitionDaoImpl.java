package com.cn.dao.impl;

import com.cn.dao.TuitionDao;
import com.cn.domain.Tuition;
import com.cn.util.DateUtil;
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
        String sql="insert into tuition (orderNo,fees,spendOnBook,accommodation,insurance,amount,timeOfPay,stateOfPay,stuNo,payer) values(?,?,?,?,?,?,?,?,?,?)";
        conn= JDBCUtil.getConnection();
        pst=conn.prepareStatement(sql);
        pst.setObject(1, tuition.getOrderNo());
        pst.setObject(2,tuition.getFees());
        pst.setObject(3, tuition.getSpendOnBook());
        pst.setObject(4, tuition.getAccommodation());
        pst.setObject(5, tuition.getInsurance());
        pst.setObject(6, tuition.getAmount());
        pst.setObject(7, tuition.getTimeOfPay());
        pst.setObject(8, tuition.isStateOfPay());
        pst.setObject(9,tuition.getStuNo());
        pst.setObject(10,tuition.getPayer());
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
            String sql="update tuition set timeOfPay=?,stateOfpay=?,fees=?,spendOnBook=?,accommodation=?,insurance=?,amount=?,orderNo=?,payer=? where stuNo=?";
            conn=JDBCUtil.getConnection();
            pst=conn.prepareStatement(sql);
            pst.setObject(1,tuition.getTimeOfPay());
            pst.setObject(2,tuition.isStateOfPay());
            pst.setObject(3,tuition.getFees());
            pst.setObject(4,tuition.getSpendOnBook());
            pst.setObject(5,tuition.getAccommodation());
            pst.setObject(6,tuition.getInsurance());
            pst.setObject(7,tuition.getAmount());
            pst.setObject(8,tuition.getOrderNo());
            pst.setObject(9,tuition.getPayer());
            pst.setObject(10,tuition.getStuNo());


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
            String payer = rs.getString("payer");
            int fees=rs.getInt("fees");
            int spendOnBook=rs.getInt("spendOnBook");
            int accommodation=rs.getInt("accommodation");
            int insurance=rs.getInt("insurance");
            int amount=rs.getInt("amount");
            Timestamp timeOfPay=rs.getTimestamp("timeOfPay");
            boolean stateOfPay=rs.getBoolean("stateOfPay");
            int stuNo = rs.getInt("stuNo");

            Tuition tuition=new Tuition(orderNo,payer,fees,spendOnBook,
                    accommodation,insurance,amount,timeOfPay,stateOfPay,stuNo);
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
            String payer = rs.getString("payer");
            int fees=rs.getInt("fees");
            int spendOnBook=rs.getInt("spendOnBook");
            int accommodation=rs.getInt("accommodation");
            int insurance=rs.getInt("insurance");
            int amount=rs.getInt("amount");
            Timestamp timeOfPay=rs.getTimestamp("timeOfPay");
            boolean stateOfPay=rs.getBoolean("stateOfPay");


            tuition=new Tuition(orderNo,payer,fees,spendOnBook,
                    accommodation,insurance,amount,timeOfPay,stateOfPay,stuNo);

        }
        conn.close();
        pst.close();
        rs.close();
        return tuition;
    }
}
