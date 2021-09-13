## Spring MVC Film C.R.U.D.

#### Week 8 Team Project for Skill Distillery

### Overview
 The The Spring MVC Film C.R.U.D. Application is a full stack application that illustrates the fundamental application of C.R.U.D. in practice. It creates films that are added to the local film database, reads the films already stored in the database, and can update or delete those existing films.

### Technologies Used

* Java
* Eclipse IDE
* Spring MVC
* Gradle
* MySql
* MAMP
* Apache Tomcat

### Description
Spring MVC Film C.R.U.D. when run will populate a web page presenting the user with four options. The user may choose to retrieve a film using its id, create a new film, edit an existing film, or delete an existing film. The user must click one of the on screen links to initiate a selection. From then on at any point in the program the user may choose to return to the home page using the "Return to Home" link at the bottom of each page.

If the user choose to retrieve a film they will be presented with a form asking for the film's id number in the database. Once entered they must click the submit button. After the submission the page updates to a results page which presents all of the film's attributes. Each film has eleven attributes; id, title, description, release year, language id, rental duration, rental rate, film length, replacement cost, motion picture content rating, and special features.

If the user chooses to create a film they will be prompted to enter values for ten of the film attributes, all of the attributes except the film id. The database assigns each new film an id, and thus the user may not choose it. Once all of the fields are entered and the submitted using the forms and submission button on the create film page a confirmation page is presented outlining each of the new film's attributes, including the new id assigned by the database, and a short message letting the user know the film was added to the database.

If edit film is selected the user will be prompted to enter the id of the film they would like to change. Once submitted, the selected film and all of its attribute is presented to the user with forms corresponding to each attribute that may be changed. The user may enter their changes, press submit, and is then met with a confirmation page that lets them know their changes have been implemented.

The final option is to delete a film. If selected the user will be asked to provide the film id for the movie they would like to delete. Once submitted, a page populates confirming that the film has been deleted off of the database. 

### Lessons Learned
 To accomplish the creation of this project, we, team 8 of Skill Distillery SD30, used a host of tools new to us. The core logic is written in the java language and was programmed in the Ecplise IDE. The local database accessed by Spring MVC Film is a mysql database, which is accessed using prepared statements and binding variables within the FilmDAOJdbcImpl class. The user interface files are a combination of html and jsp files.
   * File Interactions:
   * Timing:
   * Github:
   * Cooperation:
