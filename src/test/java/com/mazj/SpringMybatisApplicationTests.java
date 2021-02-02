package com.mazj;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;

@SpringBootTest
class SpringMybatisApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        System.out.println("数据源" + dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }

    public static void main(String[] args) {
        JwtBuilder builder = Jwts.builder()
                .setId("666")
                .setSubject("小羊驼")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "hello");
        System.out.println(builder.compact());
    }

}
