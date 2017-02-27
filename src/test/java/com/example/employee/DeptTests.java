package com.example.employee;

import java.sql.Connection;
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
public class DeptTests {
	
	@Autowired
	DataSource dataSource;
	DataSource dataSource1;
	@Test
	public void test01_select() throws SQLException{
		
		System.out.println("#############");
		System.out.println("select");
		System.out.println("#############");
		
		System.out.println("dataSource="+dataSource);
		System.out.println("dataSource1="+dataSource1);
		
		/*
		 * 1.connection
		 */
		Connection con= dataSource.getConnection();
		
		/*
		 * 2.execute Query
		 */
		PreparedStatement pstmt = con.prepareStatement("select * from dept");
		ResultSet rs= pstmt.executeQuery(); //이렇게 해야 수행됨. 이게 컨트롤 엔터해서 수행하는 것과 같음. 
		/*
		 * 3.ResultSet print 출력함
		 */
		//출력결과가 몇개올지 몰라서 while씀
		while(rs.next()){
			int deptno =rs.getInt("deptno"); //리절트셋을 가져오는 방법
			String dname=rs.getString("dname");
			String loc=rs.getString("loc");
			System.out.println(deptno+","+dname+","+loc);
		}
		
		
	}
	@Test
	public void test02_insert() throws SQLException{
			
			System.out.println("#############");
			System.out.println("insert");
			System.out.println("#############");
			/*
			 * 1.connection
			 */
			Connection con = dataSource.getConnection(); //체크드익셉션 뜨니까 throws 처리 
			/*
			 * 2.execute Updete
			 */
			PreparedStatement pstmt = con.prepareStatement("insert into dept values (?,?,?)"); //placehold
			pstmt.setInt(1, 50);
			pstmt.setString(2, "총무부");
			pstmt.setString(3, "서울");
			
			/*
			 * 3.result 확인(mybatis를 쓰게되면 이것보다 더 간결해짐
			 */
			
			int rtn=pstmt.executeUpdate(); //토드가 동작하는 원리
			System.out.println("rtn="+rtn); //	변경된 로우의 갯수가 리턴되어 온다
			
			
		}
	@Test
	public void test03_update() throws SQLException{
		
		System.out.println("#############");
		System.out.println("update");
		System.out.println("#############");
		
		/*
		 * 1.connection
		 */
		Connection con = dataSource.getConnection();
		/*
		 * 2. execute update
		 */
		PreparedStatement pstmt = con.prepareStatement("update dept set dname=?, loc=? where deptno=?");
		pstmt.setString(1,  "Lotte");
		pstmt.setString(2,  "Giants");
		pstmt.setInt(3, 50);
		int rtn= pstmt.executeUpdate();
		
		/*
		 * 3. 결과확인
		 */
		System.out.println("update rtn=" +rtn);
		
	}
	@Test
	public void test04_delete() throws SQLException{
		
		System.out.println("#############");
		System.out.println("delete");
		System.out.println("#############");
		/*
		 * 1. Connection 
		 */
		
		Connection con = dataSource.getConnection();
		/*
		 * 2.execute update
		 */
		PreparedStatement pstmt = con.prepareStatement("delete from dept where deptno=?");
		pstmt.setInt(1,50);
		int rtn=pstmt.executeUpdate();
		/*
		 * 3.결과확인
		 */
		System.out.println("delete rtn=" +rtn);
		
	}
	
	
}
