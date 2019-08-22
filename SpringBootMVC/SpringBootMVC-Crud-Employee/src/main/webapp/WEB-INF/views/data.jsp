
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Welcome To Employee Data Page</h2>

<c:if test="${empty list}">
	<h4>No Data Found</h4>
</c:if>


<c:if test="${!empty list}">
	
	<table border=2>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Salary</th>
		<th>Department</th>
		<th>Operation</th>
	</tr>
	
	<c:forEach items="${list}" var="ob">
		<tr>
		<td> ${ob.empId}</td>
		<td> ${ob.empName}</td>
		<td> ${ob.empSal}</td>
		<td> ${ob.empDept}</td>
		<td>
			<a href="/emp/view?id=${ob.empId}">View</a>
		</td>
		</tr>
	</c:forEach>
	
	</table>

</c:if>

<a href="/emp/reg">Register</a>

${msg}

</body>
</html>