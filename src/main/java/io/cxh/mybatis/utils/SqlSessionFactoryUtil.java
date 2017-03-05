package io.cxh.mybatis.utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * 用单例模式生成一个SqlSessionFactory
 *
 * Created by Administrator on 2017/3/4.
 */
public class SqlSessionFactoryUtil {

    //先把该类的构造方法私有化
    private SqlSessionFactoryUtil() {}

    //定义一个私有的静态的sqlSessionFactory成员变量
    private static SqlSessionFactory sqlSessionFactory;

    //静态代码块
    static {
        InputStream is = SqlSessionFactoryUtil.class.getResourceAsStream("/SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    public static SqlSessionFactory getSqlSessionFactory() {

        return sqlSessionFactory;
    }
}
