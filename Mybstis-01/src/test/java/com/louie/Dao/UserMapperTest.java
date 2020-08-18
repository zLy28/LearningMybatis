package com.louie.Dao;

import com.louie.pojo.Student;
import com.louie.pojo.User;
import com.louie.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void testSelect() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void insertUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.insertUser(new User(7,"Rachel","12312453212367434"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(7, "Jack", "000"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(7);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void log4jTest() {
        logger.info("Info~~");
        logger.debug("Debug~~");
        logger.error("error~~");
    }

    @Test
    public void getUserByLimitTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("limitIndex", 0);
        map.put("pageSize",2);
        List<User> userByLimit = mapper.getUserByLimit(map);
        for (User user : userByLimit) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getStudentTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudent();
        for (Student student:students
             ) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
