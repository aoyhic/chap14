package com.example.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class memberTests {
	
	//DI(Dependency Injection) 의존적인 것이며 주입함.
	@Autowired
	DataSource dataSource;
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	
	
	 @Test
	 public void test01_select() throws SQLException{
		 System.out.println("##############");
		 System.out.println("test01_select");
		 System.out.println("##############");
		 
		 Connection con = dataSource.getConnection();
		 PreparedStatement pstmt = con.prepareStatement("select * from member");
		 ResultSet rs = pstmt.executeQuery();
		 
		 while(rs.next()){
			 int no =rs.getInt("no");
			 String name = rs.getString("name");
			 Date regdate = rs.getDate("regdate");
			 System.out.println(no+","+name+","+format.format(regdate)); //데이트타입을 포맷한다. 저 위에 심플포맷으로 원하는 형식으로 만드는 것.
		 } 
		 con.close();
	 }
	 
	 
	 @Test
	 public void test02_insert() throws SQLException, ParseException{
		 System.out.println("##############");
		 System.out.println("test02_insert");
		 System.out.println("##############");
		 
		 Connection con = dataSource.getConnection();
		 PreparedStatement pstmt = con.prepareStatement("insert into member values(?,?,?)");
		 pstmt.setInt(1, 40);
		 pstmt.setString(2, "zzz");
		 
//		 Date date = format.parse("1999/12/12");
//		 java.sql.Date regdate = new java.sql.Date(date.getTime());
//		 pstmt.setDate(3, regdate);
		 
		 //이 위의 세 줄을 한 줄로 바꾸는 것
		 pstmt.setDate(3, new java.sql.Date(format.parse("2017/02/24").getTime()));
	
		 
		 int rtn = pstmt.executeUpdate();
		 System.out.println("rtn="+rtn);
	 }
}
