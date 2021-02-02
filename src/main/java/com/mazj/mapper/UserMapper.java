package com.mazj.mapper;

import com.mazj.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// 注解表示是一个mybatis的mapper类
@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    List<User> queryUserById(User user);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
