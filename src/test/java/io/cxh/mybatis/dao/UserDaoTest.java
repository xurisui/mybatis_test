package io.cxh.mybatis.dao;

import io.cxh.mybatis.po.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/3/4.
 */
public class UserDaoTest {
    @Test
    public void selectAll() throws Exception {

        List<User> users = new UserDao().selectAll();

    }

    @Test
    public void selectById() throws Exception {
        User user = new UserDao().selectById(10);
        System.out.println(user);
    }

}