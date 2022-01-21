package com.zmy.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @Author: MengyaoZeng
 * @Telephone: 18573903136
 * @Email: 343722243@qq.com
 * @Description:
 * @Date: Created in 22:12 2022/1/20
 */
@Configuration
@ComponentScan
public class JavaConfig {
    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///test01?serverTimezone=Asia/Shanghai");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        return dataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
