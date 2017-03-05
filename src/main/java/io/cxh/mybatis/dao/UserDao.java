package io.cxh.mybatis.dao;

import io.cxh.mybatis.mapper.UserMapper;
import io.cxh.mybatis.po.User;
import io.cxh.mybatis.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

/**
 * 封装UserDao
 * Created by Administrator on 2017/3/4.
 */
public class UserDao {
    /**
     * 查询所有用户信息
     * @return 用户列表
     */
    public List<User> selectAll() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = userMapper.selectAll();
        sqlSession.close();
        return users;
    }

    /**
     * 根据用户id查找用户信息
     * @param id 用户id
     * @return 用户信息
     */
    public User selectById(int id) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectById(id);
        sqlSession.close();
        return user;
    }

    /**
     * 插入用户数据
     * @param user 用户类
     * @return 修改数据的行数
     */
    public int insert(User user) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int insert = mapper.insert(user);
        sqlSession.commit();
        sqlSession.close();
        return insert;
    }

    /**
     * 根据用户id删除用户
     * @param id 用户id
     * @return 删除用户的个数
     */
    public int deleteById(int id) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int deleteCount = mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
        return deleteCount;
    }

    /**
     * 修改用户所有信息
     * @param user 即将修改成为的用户
     * @return 更新的用户的数量
     */
    public int update(User user) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int updateCount = mapper.update(user);
        sqlSession.commit();
        sqlSession.close();
        return updateCount;
    }

    /**
     * 选择性更新
     * @param user 要更新的用户
     * @return 更新的用户数量
     */
    public int updateSelective(User user) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int updateSelectiveCount = mapper.updateSelective(user);
        sqlSession.commit();
        sqlSession.close();
        return updateSelectiveCount;
    }
}
