# Description of the project
The Project is mainly a Todo-List, including an Shopping List, where you can Put your 
# Class Diagram
![img.png](img.png)
# Setup
The Project needs a MySQL Database with name Project
# Technologies Used
# Controllers and Routes structure
The Project haves in Total 7 Controllers, one for every Table/Class

An extra Controller Named Admin: in this Controller a Admin can see all Users and Delete a specific one, additionally can create Roles
Its Accessible functions over /admin /admin/users /admin/users/{id}

/** This Controller is destined for Products
* It can Create and Update a Product
* A delete function here is not needed,it can only be deleted by deleting the Shopping List
*/
  /** This Controller is destined for the Shopping List
* It can Create, Update and Delete a Shopping List
  */
  /** This Controller is destined for Tasks
* It can Create and Update a Task
* A delete function here is not needed,it can only be deleted by deleting the Task List
  */
A Controller is destined for the Task List (show Task List or Update the properties)
  route: /todolist/tasklists
A controller for Show All Lists (Task Lists & Shopping Lists) 
  route: /todolist/

A controller for User where can Register and Update Personal Details Like Name or Birthdate
route: /users/register

# Extra links(Trello, Presentation Slides, etc…)
https://docs.google.com/presentation/d/e/2PACX-1vQ4MyzatYmPyUV9BSf2KgvEEEDE-vI8ai_IJIxei_6VUmRdQDiIjhsbK2XNRACJWk0obLnlB-RuCSJz/pub?start=false&loop=false&delayms=3000