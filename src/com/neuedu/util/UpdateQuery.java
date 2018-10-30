package com.neuedu.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UpdateQuery {
    //单表增，删除，修改
    public static int update(String sql,Object ...objs){
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        int i=-1;
        try {
            conn=SqlUtil.getConn();
            preparedStatement=conn.prepareStatement(sql);
            SqlUtil.insertData(preparedStatement,objs);
           i=preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            SqlUtil.close(preparedStatement,conn);
        }
        return i;
    }
    //单表查找
    public static List<Object> query(String sql,ResultOject result,Object ...objs){
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Object> objectList=new ArrayList<>();
        try {
            conn=SqlUtil.getConn();
            preparedStatement=conn.prepareStatement(sql);
            SqlUtil.insertData(preparedStatement,objs);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Object obj=result.getByResultSet(resultSet);
                objectList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            SqlUtil.close(resultSet,preparedStatement,conn);
        }
        return objectList;
    }

}
