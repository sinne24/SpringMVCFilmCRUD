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
		<c:when test="${! empty film}">
			<p>Film Successfully Added</p>
			<ul>
				<li>${film.id}</li>
				<li>${film.title}</li>
				<li>${film.description}</li>
				<li>${film.releaseYear}</li>
				<li>${film.languageId}</li>
				<li>${film.rentalDuration}</li>
				<li>${film.rentalRate}</li>
				<li>${film.length}</li>
				<li>${film.replacementCost}</li>
				<li>${film.rating}</li>
				<li>${film.specialFeatures}</li>
			</ul>
		</c:when>
		<c:otherwise>
			<p>Film Not Successfully Added</p>
		</c:otherwise>
	</c:choose>

	<a href=home.do>Return to Home</a>
	<br />


</body>
</html>