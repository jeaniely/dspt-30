package com.neuedu.dao;

import com.neuedu.bean.User;

import java.util.List;

public interface UserDAO {

    /**
     * 求记录的总条数
     * @param rlevel
     * @return
     */
    int sumCount(int rlevel);

    /**
     * 页面要显示的内容
     * @param rlevel
     * @param offset
     * @param num
     * @return
     */
    List<User> selectLimit(int rlevel,int offset,int num);


    /**
     * 根据等级，进行查找
     * vip ，管理员
     * @param rlevel
     * @return
     */
    List<User> selectByRlevel(int rlevel);

    /**
     * 根据账号进行模糊查找
     * @param uname
     * @return
     */
    List<User> selectByUname(String uname,int rlevel);
    /**
     * 添加管理员
     */
   int insertAdmin(User user);

    /**
     * 根据账号进行删除
     * ifdelete进行修改
     * @param uname
     * @return
     */
    int deleteAdmin(String uname);

    /**
     * 根据账号进行修改
     * @param user
     * @return
     */
    int updateAdmin(User user);

}
