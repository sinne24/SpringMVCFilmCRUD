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
	<h3>Edit Film</h3>
	
<c:choose>
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
    </c:when>
    <c:otherwise>
      <p>No film found</p>
    </c:otherwise>
  </c:choose>
		Input data for each field regarding the film you'd like to edit:
	
    	<form action="editFilm.do" method="POST">
    	<b>Enter New Title:</b>
		<br>
		<input type="text" name="film.title"/>
		<br>
		<b>Enter New Description:</b>
		<br>
		<input type="text" name="film.description"/> 
		<br>
		<b>Enter New Release Year:</b>
		<br>
		<input type="text" name="film.releaseYear"/> 
		<br>
		<b>Enter New Language ID:</b>
		<br>
		<input type="text" name="film.languageId"/> 
		<br>
		<b>Enter New Rental Duration (in days):</b>
		<br>
		<input type="text" name="film.rentalDuration"/> 
		<br>
		<b>Enter New Rental Rate:</b>
		<br>
		<input type="text" name="film.rentalRate"/> 
		<br>
		<b>Enter New Film length:</b>
		<br>
		<input type="text" name="film.length"/> 
		<br>
		<b>Enter New Film Replacement Cost:</b>
		<br>
		<input type="text" name="film.replacementCost"/> 
		<br>
		<br>
		<b>Enter New Film Rating:</b>
		<input type="text" name="film.rating" />
		<br>
		<!-- <label for="rating">New Film Rating:</label> <br />
          <select class="film.rating" id="film.rating">
            <option value="">--</option>
            <option value="G">G</option>
            <option value="PG">PG</option>
            <option value="PG13">PG13</option>
            <option value="R">R</option>
            <option value="NC17">NC17</option>
          </select> -->
		<br>
		<br>
		<b>Enter New Special Features</b>
		<input type="text" name="film.specialFeatures" />
		<!-- <label for="film.specialFeatures">New Special Features:</label> <br />
          <select class="film.specialFeatures" id="film.specialFeatures">
            <option value="Trailers">Trailers</option>
            <option value="Commentaries">Commentaries</option>
            <option value="Deleted Scenes">Deleted Scenes</option>
            <option value="Behind the Scenes">Behind the Scenes</option>
          </select> -->
		
		<br>
		<br>
		<br>
		Hit the submit button below once you've filled all of the fields.
		<br>
		<input type="submit" value="Edit film" />
	</form>
	<a href=home.do>Return to Home</a><br/>
</body>
</html>