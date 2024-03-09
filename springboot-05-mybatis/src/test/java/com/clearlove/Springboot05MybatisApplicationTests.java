package com.clearlove;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot05MybatisApplicationTests {

  @Autowired
  private DataSource dataSource;

  @Test
  void contextLoads() throws SQLException {
    // 查看默认数据源  class com.zaxxer.hikari.HikariDataSource
    System.out.println(dataSource.getClass());

    // 获取数据库连接
    Connection connection = dataSource.getConnection();
    System.out.println(connection);

    // 关闭
    connection.close();

  }

}
