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
        String sql="insert into tuition (orderNo,stuId,payer,fees,spendOnBook,accommodation,insurance,amount,paytime,stateOfPay) values(?,?,?,?,?,?,?,?,?,?)";
        conn= JDBCUtil.getConnection();
        pst=conn.prepareStatement(sql);
        pst.setObject(1, tuition.getOrderNo());
        pst.setObject(2, tuition.getStuId());
        pst.setObject(3, tuition.getPayer());
        pst.setObject(4,tuition.getFees());
        pst.setObject(5, tuition.getSpendOnBook());
        pst.setObject(6, tuition.getAccommodation());
        pst.setObject(7, tuition.getInsurance());
        pst.setObject(8, tuition.getAmount());
        pst.setObject(9, tuition.getPayTime());
        pst.setObject(10, tuition.isStateOfPay());
        int status=pst.executeUpdate();
        conn.close();
        pst.close();

        return status;
    }

    @Override
    public int deleteTuition(String stuId) throws SQLException {
        String sql="delete from tuition where stuId=?";
        conn=JDBCUtil.getConnection();
        pst=conn.prepareStatement(sql);
        pst.setObject(1,stuId);
        int recordNum=pst.executeUpdate();
        conn.close();
        pst.close();
        return recordNum;
    }

    @Override
    public int updateTuition(Tuition tuition) throws SQLException {
        String sql="update tuition set orderNo=?,payer=?,fees=?,spendOnBook=?,accommodation=?,insurance=?,amount=?,paytime=?,stateOfPay=? where stuId=?";
        conn=JDBCUtil.getConnection();
        pst=conn.prepareStatement(sql);
        pst.setObject(1,tuition.getOrderNo());
        pst.setObject(2,tuition.getPayer());
        pst.setObject(3,tuition.getFees());
        pst.setObject(4,tuition.getSpendOnBook());
        pst.setObject(5,tuition.getAccommodation());
        pst.setObject(6,tuition.getInsurance());
        pst.setObject(7,tuition.getAmount());
        pst.setObject(8,tuition.getPayTime());
        pst.setObject(9,tuition.isStateOfPay());
        pst.setObject(10,tuition.getStuId());

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
            String stuId=rs.getString("stuId");
            String payer=rs.getString("payer");
            int fees=rs.getInt("fees");
            int spendOnBook=rs.getInt("spendOnBook");
            int accommodation=rs.getInt("accommodation");
            int insurance=rs.getInt("insurance");
            int amount=rs.getInt("amount");
            Timestamp paytime=rs.getTimestamp("paytime");
            boolean stateOfPay=rs.getBoolean("stateOfPay");

            Tuition tuition=new Tuition(orderNo,stuId,payer,fees,spendOnBook,
                    accommodation,insurance,amount,paytime,stateOfPay);
            tuitionList.add(tuition);
        }
        conn.close();
        pst.close();
        rs.close();
        return tuitionList;
    }

    @Override
    public Tuition getTuitionByStuId(String stuId) throws SQLException {
        String sql="select * from tuition where stuId=?";
        conn=JDBCUtil.getConnection();
        pst=conn.prepareStatement(sql);
        pst.setObject(1,stuId);
        rs=pst.executeQuery();
        Tuition tuition=null;
        while (rs.next()){
            int orderNo=rs.getInt("orderNo");
            String payer=rs.getString("payer");
            int fees=rs.getInt("fees");
            int spendOnBook=rs.getInt("spendOnBook");
            int accommodation=rs.getInt("accommodation");
            int insurance=rs.getInt("insurance");
            int amount=rs.getInt("amount");
            Timestamp paytime=rs.getTimestamp("paytime");
            boolean stateOfPay=rs.getBoolean("stateOfPay");


            tuition=new Tuition(orderNo,stuId,payer,fees,spendOnBook,
                    accommodation,insurance,amount,paytime,stateOfPay);

        }
        conn.close();
        pst.close();
        rs.close();
        return tuition;
    }

    @Override
    public Tuition getTuitionByPayer(String payer) throws SQLException {
        String sql="select * from tuition where payer=?";
        conn=JDBCUtil.getConnection();
        pst=conn.prepareStatement(sql);
        pst.setObject(1,payer);
        rs=pst.executeQuery();
        Tuition tuition=null;
        while (rs.next()){
            int orderNo=rs.getInt("orderNo");
            String stuId=rs.getString("stuId");
            int fees=rs.getInt("fees");
            int spendOnBook=rs.getInt("spendOnBook");
            int accommodation=rs.getInt("accommodation");
            int insurance=rs.getInt("insurance");
            int amount=rs.getInt("amount");
            Timestamp paytime=rs.getTimestamp("paytime");
            boolean stateOfPay=rs.getBoolean("stateOfPay");


            tuition=new Tuition(orderNo,stuId,payer,fees,spendOnBook,
                    accommodation,insurance,amount,paytime,stateOfPay);

        }
        conn.close();
        pst.close();
        rs.close();
        return tuition;
    }
}
