package com.neuedu.dao.impl;

import com.neuedu.bean.User;
import com.neuedu.dao.UserDAO;
import com.neuedu.util.ResultOject;
import com.neuedu.util.UpdateQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public int sumCount(int rlevel) {
        String sql="select count(*) from usertable where rlevel=?";
        List<Object> objectList=UpdateQuery.query(sql, new ResultOject() {
            @Override
            public Object getByResultSet(ResultSet resultSet) throws SQLException {
                return resultSet.getInt(1);
            }
        },rlevel);
        return Integer.valueOf((Integer)(objectList.get(0)));
    }

    @Override
    public List<User> selectLimit(int rlevel, int offset, int num) {
        String sql="select * from usertable where rlevel=? limit ?,?";
        List<Object> objectList=UpdateQuery.query(sql, new ResultOject() {
            @Override
            public Object getByResultSet(ResultSet resultSet) throws SQLException {
                User user=new User();
                user.setUid(resultSet.getInt("uid"));
                user.setUname(resultSet.getString("uname"));
                user.setUpwd(resultSet.getString("upwd"));
                user.setReceiver(resultSet.getString("receiver"));
                user.setRaddress(resultSet.getString("raddress"));
                user.setRtelephone(resultSet.getString("rtelephone"));
                user.setUsex(resultSet.getInt("usex"));

                user.setRlevel(resultSet.getInt("rlevel"));
                return user;
            }
        },rlevel,offset,num);

        List<User> listuser=new ArrayList<>();
        for(int i=0;i<objectList.size();i++){
            listuser.add((User)objectList.get(i));
        }
        return listuser;
    }

    @Override
    public List<User> selectByRlevel(int rlevel) {
        String sql="select * from usertable where rlevel=?";
        List<Object> objectList=UpdateQuery.query(sql, new ResultOject() {
            @Override
            public Object getByResultSet(ResultSet resultSet) throws SQLException {
                User user=new User();
                user.setUid(resultSet.getInt("uid"));
                user.setUname(resultSet.getString("uname"));
                user.setUpwd(resultSet.getString("upwd"));
                user.setReceiver(resultSet.getString("receiver"));
                user.setRaddress(resultSet.getString("raddress"));
                user.setRtelephone(resultSet.getString("rtelephone"));
                user.setUsex(resultSet.getInt("usex"));

                user.setRlevel(resultSet.getInt("rlevel"));
                return user;
            }
        },rlevel);

        List<User> listuser=new ArrayList<>();
        for(int i=0;i<objectList.size();i++){
            listuser.add((User)objectList.get(i));
        }
        return listuser;
    }

    @Override
    public List<User> selectByUname(String uname, int rlevel) {
        String sql="select * from usertable where uname like ? and rlevel=?";
        List<Object> objectList=UpdateQuery.query(sql, new ResultOject() {
            @Override
            public Object getByResultSet(ResultSet resultSet) throws SQLException {
                User user=new User();
                user.setUid(resultSet.getInt("uid"));
                user.setUname(resultSet.getString("uname"));
                user.setUpwd(resultSet.getString("upwd"));
                user.setReceiver(resultSet.getString("receiver"));
                user.setRaddress(resultSet.getString("raddress"));
                user.setRtelephone(resultSet.getString("rtelephone"));
                user.setUsex(resultSet.getInt("usex"));

                user.setRlevel(resultSet.getInt("rlevel"));
                return user;
            }
        },"%"+uname+"%",rlevel);

        List<User> listuser=new ArrayList<>();
        for(int i=0;i<objectList.size();i++){
            listuser.add((User)objectList.get(i));
        }
        return listuser;
    }

    @Override
    public int insertAdmin(User user) {
        String sql="insert into usertable(uname,upwd,usex,ubirthday,receiver,raddress,rtelephone,rlevel) values(?,?,?,?,?,?,?,?)";
        int i=UpdateQuery.update(sql,user.getUname(),user.getUpwd(),user.getUsex(),user.getUbirthday(),user.getReceiver(),user.getRaddress(),user.getRtelephone(),user.getRlevel());
        return i;
    }

    @Override
    public int deleteAdmin(String uname) {
        String sql="update usertable set ifdelete=1 where uname=?";
        return UpdateQuery.update(sql,uname);
    }

    @Override
    public int updateAdmin(User user) {
        String sql="update usertable set upwd=?,usex=?,ubirthday=?,recerver=?,raddress=?,rtelephone=? where uname=?";
        int i=UpdateQuery.update(sql,user.getUpwd(),user.getUsex(),user.getUbirthday(),user.getReceiver(),user.getRaddress(),user.getRtelephone(),user.getUname());
        return i;
    }
}
