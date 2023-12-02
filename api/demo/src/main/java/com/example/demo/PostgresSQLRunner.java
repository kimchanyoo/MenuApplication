//package com.example.demo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.Statement;
//
//@Component
//public class PostgresSQLRunner implements ApplicationRunner {
//	@Autowired
//	DataSource dataSource;
//
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		try (Connection connection = dataSource.getConnection()) {
//			System.out.println(dataSource.getClass());
//			System.out.println(connection.getMetaData().getURL());
//			System.out.println(connection.getMetaData().getUserName());
//
//			Statement statement = connection.createStatement();
////			String sql = "CREATE TABLE BREAKFAST(\n" +
////					"\tID SERIAL PRIMARY KEY,\n" +
////					"\tTDATE DATE NOT NULL,\n" +
////					"\tMENU VARCHAR(255) NOT NULL,\n" +
////					"\tNDATE DATE DEFAULT CURRENT_DATE,\n" +
////					"\tDDATE INTEGER  \n" +
////					")";
////			statement.executeUpdate(sql);
//		}
//		jdbcTemplate.execute("INSERT\n" +
//				"\tINTO\n" +
//				"\tBREAKFAST(TDATE, MENU, DDATE)\n" +
//				"VALUES('2023-11-25','밥',CURRENT_DATE-'2023-11-25')");
//	}
//}
