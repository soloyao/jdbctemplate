package com.zmy.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: MengyaoZeng
 * @Telephone: 18573903136
 * @Email: 343722243@qq.com
 * @Description:
 * @Date: Created in 19:58 2022/1/21
 */
@Service
public class AccountService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    public void updateMoney() {
        jdbcTemplate.update("update account set money = money - 500 where username = ?", "zhangsan");
        int i = 1 / 0;
        jdbcTemplate.update("update account set money = money + 500 where username = ?", "lisi");
    }
}
