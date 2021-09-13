<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Film</title>
</head>
<body>
	<h3>Films</h3>
	<form action="deleteFilm.do" method="POST">
		Film ID:
		<input type="text" name="id"/> 
		<input type="submit" value="delete film" />
	</form>
	<a href=home.do>Return to Home</a><br/>

</body>
</html>