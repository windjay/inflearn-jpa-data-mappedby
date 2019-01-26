package com.springdatajpa.jdbcsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootApplication
public class SampleApplication {

  public static void main(String[] args) throws SQLException {
    SpringApplication application = new SpringApplication();
    application.setWebApplicationType(WebApplicationType.NONE);
    application.run(args);
//    SpringApplication.run(SampleApplication.class, args);
  }

}
