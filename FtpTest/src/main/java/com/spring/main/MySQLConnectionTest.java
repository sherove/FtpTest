package com.spring.main;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class MySQLConnectionTest {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/ftptest?useSSL=false&serverTimezone=UTC";
    private static final String USER = "user1";
    private static final String PW = "1234";
    

    @Test
    public void testConnection() throws Exception {
		/*
		 * Class.forName(DRIVER); try(Connection connection =
		 * DriverManager.getConnection(URL, USER, PW)){ System.out.println(connection);
		 * }catch (Exception e) { e.printStackTrace(); }
		 */
    }
    
}
