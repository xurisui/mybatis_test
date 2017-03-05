package io.cxh.mybatis.mapper;

import io.cxh.mybatis.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/3/4.
 */
public interface UserMapper {
    /**
     * 查询所有用户信息
     * @return 用户列表
     */
    List<User> selectAll();

    /**
     * 根据用户id查找用户信息
     * @param id 用户id
     * @return 用户信息
     */
    User selectById(int id);

    /**
     * 插入用户数据
     * @param user 用户类
     * @return 修改数据的行数
     */
    int insert(User user);

    /**
     * 根据用户id删除用户
     * @param id 用户id
     * @return 删除用户的个数
     */
    int deleteById(int id);

    /**
     * 修改用户所有信息
     * @param user 即将修改成为的用户
     * @return 更新的用户的数量
     */
    int update(User user);

    /**
     * 选择性更新
     * @param user 要更新的用户
     * @return 更新的用户数量
     */
    int updateSelective(User user);


    List<User> selectByNameAndSex(@Param("username") String username,
                                  @Param("sex") String sex);



}
