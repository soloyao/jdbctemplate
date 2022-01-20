package com.zmy.jdbc;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: MengyaoZeng
 * @Telephone: 18573903136
 * @Email: 343722243@qq.com
 * @Description:
 * @Date: Created in 22:20 2022/1/20
 */
public class JdbcTest {
    JdbcTemplate jdbcTemplate;

    @Before
    public void before() {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = ctx.getBean(JdbcTemplate.class);
    }

    @Test
    public void test1() {
        jdbcTemplate.update("insert into user (username, address, favorites) values (?,?,?);", "zmy", "www.zmy.com", "coding");
    }

    @Test
    public void test2() {
        jdbcTemplate.update("update user set username = ? where id = ?;", "zmy123", 3);
    }

    @Test
    public void test3() {
        jdbcTemplate.update("delete from user where id = ?", 3);
    }

    @Test
    public void test4() {
        List<User> list = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
        System.out.println("list = " + list);
    }
}
