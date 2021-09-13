<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film Editor</title>
<style>
        .tab1 {
            tab-size: 4;
        }
    </style>
</head>
<body>
<c:choose>
	<h3>Edit Film</h3>
      <c:when test="${! empty film}">
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
      <form action="editFilm.do" method="POST">
      	Input data for each field you'd like to change: <br>
		<br> Title:
		<pre class="tab1">
				<input type="text" name="title" />
			</pre>
		<br> A short description of the film:
		<pre class="tab1">
				<input type="text" name="description" />
			</pre>
		The four digit year the film was released:
		<pre class="tab1">
				<input type="text" name="releaseYear" />
			</pre>
		The language ID:
		<pre class="tab1">
				<input type="text" name="languageId" />
			</pre>
		The rental Duration in total full days:
		<pre class="tab1">
				<input type="text" name="rentalDuration" />
			</pre>
		The rental rate:
		<pre class="tab1">
				<input type="text" name="rentalRate" />
			</pre>
		Film length:
		<pre class="tab1">
				<input type="text" name="length" />
			</pre>
		Film replacement cost:
		<pre class="tab1">
				<input type="text" name="replacementCost" />
			</pre>
		Film Rating:
		<pre class="tab1">
		<input type="text" name="rating" />
		</pre>
		Film Special Features:
		<pre class="tab1">
		<input type="text" name="specialFeatures" />
		</pre>
		
		<br> Hit the submit button below once you've filled all of the
		fields. <br> <br> <input type="submit" value="film" /><br>
		<br>
		</form>
    </c:when>
    <c:otherwise>
      <p>No film found</p>
    </c:otherwise>
	</c:choose>
	<a href=home.do>Return to Home</a><br/>
</body>
</html>