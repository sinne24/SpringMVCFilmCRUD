<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Completed</title>
	
</head>
<body>
	<c:choose> 
		<c:when test="${success true }">
			<p>Film Successfully Deleted!</p>
		</c:when>
		<c:otherwise>
			<p>Film Deletion Unsuccessful</p>
		</c:otherwise>
	</c:choose>
	
	<a href=home.do>Return to Home</a><br/>


</body>
</html>