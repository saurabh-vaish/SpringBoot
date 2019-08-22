<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:choose>
	<c:when test="${'edit' eq mode }">
		<h3>Welcome to Employee Edit Page</h3>
		<c:set var="eid"  value="${id}" ></c:set>
	</c:when>
	<c:otherwise>
		<h3>Welcome to Employee Registration Page</h3>
	</c:otherwise>
</c:choose>

<pre>
<form:form action="save" method="post" modelAttribute="employee">

<c:if test="${'edit' eq mode }">
Name     : <form:input path="empId"  readOnly="true"/>	
</c:if>

Name     : <form:input path="empName"/>

Sal   	 : <form:input path="empSal"/>

Gender   : <form:radiobutton path="empGen" value="M"/>Male   <form:radiobutton path="empGen" value="F"/>  Female

Dept     : <form:select path="empDept">
			<form:option value="">--Select--</form:option>
			<form:option value="QA">QA</form:option>
			<form:option value="PROD">PROD</form:option>
			<form:option value="DEV">DEV</form:option>
		</form:select>

Projects : <form:checkbox path="empPrjs" value="Local"/> Local <form:checkbox path="empPrjs" value="Outside"/> Outside 

<c:choose>
	<c:when test="${'edit' eq mode }">
		<input type="submit" value="Update Employee">
	</c:when>
	<c:otherwise>
		<input type="submit" value="Register Employee">
	</c:otherwise>
</c:choose>

</form:form>

</pre>

${msg}

<a href="/emp/all">Show All</a>



</body>
</html>