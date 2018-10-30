package com.neuedu.Test;

import com.neuedu.bean.User;
import com.neuedu.util.ResultOject;
import com.neuedu.util.UpdateQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtilTest {
    public static void main(String[] args) {
     //insert();
        list();
    }
    public static int insert(){
        User user=new User();
        user.setUname("13618875612");
        user.setUpwd("123456");
        user.setReceiver("张");
        user.setRaddress("东软大厦");
        user.setRtelephone("13618875612");
        user.setRlevel(2);
        String sql="insert into usertable(uname,upwd,receiver,raddress,rtelephone,rlevel) values(?,?,?,?,?,?)";
        int i=UpdateQuery.update(sql,user.getUname(),user.getUpwd(),user.getReceiver(),user.getRaddress(),user.getRtelephone(),user.getRlevel());
        System.out.println(i);
        return i;
    }

    public static void list(){
        String sql="select * from usertable";
        List<Object> list=UpdateQuery.query(sql, new ResultOject() {
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
        });
        System.out.println(list);
        List<User> listuser=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            listuser.add((User)list.get(i));
        }
        System.out.println(listuser);
    }
}
