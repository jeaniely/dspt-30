package com.neuedu.Test;

import com.neuedu.bean.User;
import com.neuedu.dao.UserDAO;
import com.neuedu.dao.impl.UserDAOImpl;

import java.util.List;

public class UserDAOTest {
    private static UserDAO userDAO=new UserDAOImpl();
    public static void main(String[] args) {
     selectByRlevel();
    }

    public static void selectByRlevel(){
        List<User> list=userDAO.selectByRlevel(2);
        System.out.println(list);
    }


}
