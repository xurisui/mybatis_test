package io.cxh.mybatis.mapper;

import com.google.gson.Gson;
import io.cxh.mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/3/4.
 */
public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void selectAll() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        sqlSession.close();

        assertFalse(users.isEmpty());

    }

    @Test
    public void selectById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.selectById(24);
        assertNotNull(user);
        assertEquals(24, user.getId());
        assertEquals("张三丰", user.getUsername());
        assertEquals("1", user.getSex());
        assertEquals(1388534400000L, user.getBirthday().getTime());
        assertNotNull("河南郑州", user.getAddress());
        assertEquals(89, user.getEnglishScore());

        User user1 = userMapper.selectById(58767768);
        assertNull(user1);

        sqlSession.close();
    }

    @Test
    public void insert() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);


        Random random = new Random();
        int userId = random.nextInt(Integer.MAX_VALUE);


        User user = new User(userId, "1", "adsf", new Date(1388534400000L), "上海", 55);

        int insert = userMapper.insert(user);

        sqlSession.commit();

        assertEquals(1, insert);

        User user1 = userMapper.selectById(userId);

        assertNotNull(user1);
        assertEquals(userId, user1.getId());
        assertEquals("adsf", user1.getUsername());
        assertEquals("1", user1.getSex());
        assertEquals(1388534400000L, user1.getBirthday().getTime());
        assertNotNull("上海", user1.getAddress());
        assertEquals(55, user1.getEnglishScore());

        sqlSession.close();
    }

    @Test
    public void deleteById() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(100, "1", "adsf", new Date(1388534400000L), "上海", 55);
        int insert = mapper.insert(user);

        assertEquals(1, insert);
        User user2 = mapper.selectById(100);

        assertNotNull(user2);

        int deleteCount = mapper.deleteById(100);

        assertEquals(1, deleteCount);

        sqlSession.commit();

        User user1 = mapper.selectById(100);
        assertNull(user1);


        sqlSession.close();


    }

    @Test
    public void update() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int update = mapper.update(new User(1, "1", "王四", new Date(1388534400000L), "深圳", 55));
        sqlSession.commit();

        assertEquals(1, update);
        User user = mapper.selectById(1);
        assertNotNull(user);
        assertEquals(1, user.getId());
        assertEquals("1", user.getSex());
        assertEquals("王四", user.getUsername());
        assertEquals(1388534400000L, user.getBirthday().getTime());
        assertEquals("深圳", user.getAddress());
        assertEquals(55, user.getEnglishScore());


        sqlSession.close();
    }

    @Test
    public void updateSelective() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(10);
        user.setUsername("lisi");
        user.setEnglishScore(88);

        int updateCount = mapper.updateSelective(user);

        sqlSession.commit();
        assertEquals(1, updateCount);
        User user1 = mapper.selectById(10);
        assertNotNull(user1);
        assertEquals("lisi", user1.getUsername());
        assertEquals(88, user1.getEnglishScore());

        sqlSession.close();
    }

    @Before
    public void beforeClass() {

        if (sqlSessionFactory == null) {
            InputStream is = io.cxh.mybatis.Test.class.getResourceAsStream("/SqlMapConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }
    }

}