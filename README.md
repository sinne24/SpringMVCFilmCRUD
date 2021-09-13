## Spring MVC Film C.R.U.D.

#### Week 8 Team Project for Skill Distillery

### Overview
<<<<<<< HEAD
 The The Spring MVC Film C.R.U.D. Application is a full stack application that illustrates the fundamental application of C.R.U.D. in practice. It creates new films that are added to the local film database, reads the films already stored in the database, and can update or delete those existing films.
=======
 The The Spring MVC Film C.R.U.D. Application is a full stack application that illustrates the fundamental application of C.R.U.D. in practice. It creates films that are added to the local film database, reads the films already stored in the database, and can update or delete those existing films.
>>>>>>> 569c5b4e6323556aa4a0ebf13eb4fc848cd92697

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

<<<<<<< HEAD
If the user chooses to retrieve a film they will be presented with a form asking for the film's id number in the database. Once entered they must click the submit button. After the submission the page updates to a results page which presents all of the film's attributes. Each film has eleven attributes; id, title, description, release year, language id, rental duration, rental rate, film length, replacement cost, motion picture content rating, and special features.

If the user chooses to create a film they will be prompted to enter values for ten of the film's attributes, all of the attributes except the film id. The database assigns each new film an id, and thus the user may not choose it. Once all of the fields are entered and the submitted using the forms and submission button on the create film page a confirmation page is presented outlining each of the new film's attributes, including the new id assigned by the database, and a short message letting the user know the film was added successfully to the database.

If edit film is selected the user will be prompted to enter the id of the film they would like to change and all of the changes desired in forms that correspond with each standard film attribute. The user may enter their changes, press submit, and is then met with a confirmation page that lets them know their changes have been implemented.
=======
If the user choose to retrieve a film they will be presented with a form asking for the film's id number in the database. Once entered they must click the submit button. After the submission the page updates to a results page which presents all of the film's attributes. Each film has eleven attributes; id, title, description, release year, language id, rental duration, rental rate, film length, replacement cost, motion picture content rating, and special features.

If the user chooses to create a film they will be prompted to enter values for ten of the film attributes, all of the attributes except the film id. The database assigns each new film an id, and thus the user may not choose it. Once all of the fields are entered and the submitted using the forms and submission button on the create film page a confirmation page is presented outlining each of the new film's attributes, including the new id assigned by the database, and a short message letting the user know the film was added to the database.

If edit film is selected the user will be prompted to enter the id of the film they would like to change. Once submitted, the selected film and all of its attribute is presented to the user with forms corresponding to each attribute that may be changed. The user may enter their changes, press submit, and is then met with a confirmation page that lets them know their changes have been implemented.
>>>>>>> 569c5b4e6323556aa4a0ebf13eb4fc848cd92697

The final option is to delete a film. If selected the user will be asked to provide the film id for the movie they would like to delete. Once submitted, a page populates confirming that the film has been deleted off of the database.

### Lessons Learned
 To accomplish the creation of this project, we, Team 8 of Skill Distillery SD30, used a host of tools new to us. The core logic is written in the java language and was programmed in the Ecplise IDE. The local database accessed by Spring MVC Film is a mysql database, which is accessed using prepared statements and binding variables within the FilmDAOJdbcImpl class. The user interface files are a combination of html and jsp files.
<<<<<<< HEAD

=======
>>>>>>> 569c5b4e6323556aa4a0ebf13eb4fc848cd92697
   * File Interactions: A massive learning curve we had to surmount for this project was becoming comfortable with how files communicate and interact to form a functioning full stack program. All of the mental gaps, both big and small, leftover from the past week's classes had to be filled. Additionally understanding how different file types, each with its own lexical and syntactical nuances, communicate with each other is a skill obtained 'on the job' through practical application. The most difficult part was becoming comfortable with the transitions and catching momentum. Once both partners had more or less filled their mental gaps pertaining to the needs of this particular program, the rest of its creation was relatively smooth.
   * Timing: While momentum may have been caught, and project synthesis may have been relatively smooth, that does not mean the project was not time consuming. The amount of code needed for this project, regardless of how well we worked, took many more hours than we anticipated. Going forward, each of us now has a better understanding of the time commitment one must put forward for projects of this kind.
   * Github: Using Github as a team was a lesson in patience. Probably about 35% of our hang ups were from complications in the terminal pulling or pushing to github, or repairing code that was somehow altered in the process of pulling or pushing. We continuously ran into an issue where when the project was pulled by one of us where the individual's most recently updated files contained lines that looked like this:
      "head >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
                        or
      "savbdgfjkvlrt,jkje4wq5236782901kdmcvfjglk"
                        or
      "========================================"

    and those same files also contained several lines of replicated code, despite neither team member having added any of this to the file.   
   * Cooperation: Given all of the topics already covered in lessons learned, the arguably most important learning aspect of the project was how to cooperate as a team. While we did not experience any large hang-ups in this regard, fleshing out quieter necessities like communication, joint scheduling, and initiative when alone, were heavily reinforced. Both team members have full lives, so practice in compromising on a schedule through necessary communication was positively achieved. Paired with that is the need to be able to work alone and find what needs doing. Both team members found themselves working alone for periods and still contributed significantly during that time.
