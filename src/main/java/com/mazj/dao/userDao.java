package com.mazj.dao;

import com.mazj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class userDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(User user) {
//        jdbcTemplate.update()
    }
}
