package com.louie.Dao;

import com.louie.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    @Insert("insert into user(id, username, password) values(#{id},#{username},#{password})")
    int insertUser(User user);

    @Update("update user set username = #{username}, password = #{password} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{uid}")
    int deleteUser(@Param("uid") int id);

    List<User> getUserByLimit(Map<String,Object> map);

}
