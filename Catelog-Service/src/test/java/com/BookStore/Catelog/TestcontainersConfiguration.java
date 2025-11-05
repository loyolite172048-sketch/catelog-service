package com.BookStore.Catelog;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MySQLContainer;

@TestConfiguration(proxyBeanMethods = false)
public class TestcontainersConfiguration {

  @Bean
  @ServiceConnection
  MySQLContainer<?> mysqlContainer() {
    return new MySQLContainer<>("mysql:8.0")
        .withUsername("root")
        .withPassword("vicky00950K$")
        .withDatabaseName("catelog-service");
  }
}
