package io.cxh.mybatis;


import com.google.gson.Gson;
import io.cxh.mybatis.mapper.UserMapper;
import io.cxh.mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.sql.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/4.
 */
public class Test {

    private static final Logger logger = Logger.getLogger(Test.class);

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        InputStream is = Test.class.getResourceAsStream("/SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();

        System.out.println(new Gson().toJson(users));


    }
}
