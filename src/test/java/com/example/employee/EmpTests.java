package com.example.employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpTests {
	@Autowired
	DataSource dataSource;
	@Test
	public void test05_select() throws SQLException{
		System.out.println("**********");
		System.out.println("select(...)");
		System.out.println("**********");
		System.out.println("////I'm dataSource\\\\"+dataSource);
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from emp");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			int empno = rs.getInt("empno");
			int comm = rs.getInt("comm");
			int deptno = rs.getInt("deptno");
			String ename=rs.getString("ename");
			Date hiredate=rs.getDate("hiredate");
			String job = rs.getString("job");
			int mgr = rs.getInt("mgr");
			int sal = rs.getInt("sal");
			System.out.println(empno+","+ename+","+job+","+mgr+","+hiredate+","+sal+","+comm+","+deptno);
			}
	}
	@Test
	public void test06_insert() throws SQLException{
		System.out.println("**********");
		System.out.println("insert(...)");
		System.out.println("**********");
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into emp values(?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?)");
		
		pstmt.setInt(1,7777);
		pstmt.setString(2,"GIANT");
		pstmt.setString(3,"CLERK");
		pstmt.setInt(4,9999);
		pstmt.setString(5,"24/02/2017");
		pstmt.setInt(6,500);
		pstmt.setInt(7,900);
		pstmt.setInt(8,30);
		
		int rtn=pstmt.executeUpdate();
		System.out.println("rtn="+rtn);
		
	}
	@Test
	public void test07_update() throws SQLException{
		System.out.println("**********");
		System.out.println("update(...)");
		System.out.println("**********");
		
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("update emp set empno=?, ename=?, job=?, mgr=?, hiredate=to_date(?,'dd/mm/yyyy'), sal=?, comm=? where deptno=?");
		pstmt.setInt(1,7777);
		pstmt.setString(2,"AAAAA");
		pstmt.setString(3,"SALESMAN");
		pstmt.setInt(4,6666);
		pstmt.setString(5,"23/02/2017");
		pstmt.setInt(6,1000);
		pstmt.setInt(7,100);
		pstmt.setInt(8,30);
		
		int rtn = pstmt.executeUpdate();
		System.out.println("update rtn=" +rtn);
		
	}
	@Test
	public void test08_delete(){
		System.out.println("**********");
		System.out.println("delete(...)");
		System.out.println("**********");
		
	}
}
