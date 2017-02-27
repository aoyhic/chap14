<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.domain.Emp"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>listall.jsp</title>
<!-- 1.animate css -->
<link rel="stylesheet" href="/webjars/animate.css/3.5.2/animate.min.css">
<!-- 2.BootStrap -->
<link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.css">
<!-- 3.JQuery -->
<script type="text/javascript" src="/webjars/jquery/1.11.1/jquery.min.js"></script>
<!-- 4.bootstrap.js -->
<script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
<style>
	table{
		border:1px solid black;
			}
	
	th{
	
	background: lightgray;
	}
	
	tr, th, td{
		border: 1px dotted black;
	}
</style>
</head>
<body>
<h1>직원리스트</h1>
		<table class="table table-striped">
		<thead>
		<tr>
		<th>empno</th>
		<th>ename</th>
		<th>job</th>
		<th>mgr</th>
		<th>hiredate</th>
		<th>sal</th>
		<th>comm</th>
		<th>deptno</th>		
		</tr>
		</thead>
	
<%
	List<Emp> list = (List<Emp>)request.getAttribute("emps");
	for (Emp e : list){
%>	
		
		<tbody>
		<tr>
		<td><%= e.getEmpno()%></td>
		 <td><%=e.getEname()%></td>
		 <td><%=e.getJob() %></td>
		 <td><%=e.getMgr() %></td>
		 <td><%=e.getHiredate() %></td>
		 <td><%=e.getSal() %></td>
		 <td><%=e.getComm() %></td>
		 <td><%=e.getDeptno() %></td>
				</tr>
		
		</tbody>
		
<%		
	}
%>
		</table>

<hr>
<table class="table table-hover">
<thead>
<tr>
<th>empno</th>
<th>ename</th>
<th>job</th>
<th>mgr</th>
<th>hiredate</th>
<th>sal</th>
<th>comm</th>
<th>deptno</th>
</tr>
</thead>
<tbody>
<tr>
<c:forEach var="e" items="${emps}">
<td>${e.empno}</td>
<td>${e.ename }</td>
<td>${e.job }</td>
<td>${e.mgr }</td>
<td>${e.hiredate}</td>
<td>${e.sal }</td>
<td>${e.comm }</td>
<td>${e.deptno }</td>
</tbody>
</c:forEach>

</table>

</body>
</html>