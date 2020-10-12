# Film Query Project
### Week 7 Homework

## Overview
Create a command-line application that retrieves and displays film data from a SQL database. The application will be menu-based, allowing the user to choose actions and submit query data.

### User Stories
#### User Story 1
The user is presented with a menu in which they can choose to:

Look up a film by its id.
Look up a film by a search keyword.
Exit the application.

#### User Story 2
If the user looks up a film by id, they are prompted to enter the film id. If the film is not found, they see a message saying so. If the film is found, its title, year, rating, and description are displayed.

#### User Story 3
If the user looks up a film by search keyword, they are prompted to enter it. If no matching films are found, they see a message saying so. Otherwise, they see a list of films for which the search term was found anywhere in the title or description, with each film displayed exactly as it is for User Story 2.

#### User Story 4
When a film is displayed, its language (English,Japanese, etc.) is also displayed.

#### User Story 5
When a film is displayed, the list of actors in its cast is displayed along with the title, year, rating, and description.

### Stretch Goals
#### Goal 1
When a film is displayed, the user can choose from a submenu whether to:

Return to the main menu.
View all film details.
If they choose to view all details, they will see all column values of the film record they chose.

#### Goal 2
When viewing film details, the user will see a list of all the film's categories (Family, Comedy, etc.) for the film.

#### Goal 3
When viewing film details, the user will see a list of all copies of the film in inventory, with their condition.

### Topics
* Java Fundamentals
* Java 1
* Java 2
* MAMP
* SQL Queries
  - SELECT
  - Predicates and Functions
  - Joins
* JDBC
  - Dependency Management with Maven
  - Prepared statement
    - Bind variables
  - Statement Parameters
* Working with Entity Relationship Diagrams
* Object Oriented Programming
  - Abstraction
  - Polymorphism
  - Inheritance
  - Encapsulation
* Obtaining user input
* Printing information to the terminal screen
* While loops
* Methods and passing variables between them
* Conditional statement
* Classes
  - building classes in an Object Oriented manner
  - building classes whose fields are Objects
  - static fields
  - private fields
  - getters, setters, toString, and hashCode methods
  - @Override
* Collections
  - List interface
  - ArrayList
* Packaging

### How to Run
The Eclipse plugin - ANSI Escape in Console makes console output more interesting and fun!  http://mihai-nita.net/2013/06/03/eclipse-plugin-ansi-in-console/

Upon running the program, the user is presented with a menu (main menu). The user will enter 1 to look up a film by its id, 2 to look up a film by keyword, or 3 to exit the application.

-------------------- MENU -----------------<br>
---
       Enter a number from the list        <br>
                                           <br>
   1. Lookup a film by its id.             <br>
   2. Lookup a film by a search keyword.   <br>
   3. Exit the application.                <br>
                                           <br>
***  

If 1 is entered from the main menu, the user is asked for a film id. The system then presents the film's title, year of release, rating, language, description, and a list of cast members for the associated film id.

Title: ALASKA PHANTOM
Year Released: 2003
Rating: PG
Language: English
Description: A Fanciful Saga of a Hunter And a Pastry Chef who must Vanquish a Boy in Australia
Cast: Val Bolger, Burt Posey, Sidney Crowe, Sylvester Dern, Albert Johansson, Gene McKellen, Jeff Silverstone

If the film id is not found, the user is presented with a message "Film id not found. Please try again."

The user is then presented with a submenu. The user may enter 1 to return to the main menu or enter 2 to view all the film details.

MENU  |
---
Enter a number from the list

   1. Return to the main menu.
   2. View all film details.

***  

If 1 is entered in the submenu, the user is return to the main menu and may select to view a film by id, keyword, or exit the application.

If 2 is entered in the submenu, along with the previous information about the film, the user will also see the rental duration, rental rate, length of the film, replacement cost, special features, film category, and a list of rental inventory with a condition for each item in inventory.

If 2 is entered from the main menu, the user is asked by a keyword. The system then searches film titles and film descriptions for the keyword. The system then returns the film's title, year of release, rating, language, description, and a list of cast members for each film with a title or description containing the keyword.

Title: ALASKA PHANTOM
Year Released: 2003
Rating: PG
Language: English
Description: A Fanciful Saga of a Hunter And a Pastry Chef who must Vanquish a Boy in Australia
Cast: Val Bolger, Burt Posey, Sidney Crowe, Sylvester Dern, Albert Johansson, Gene McKellen, Jeff Silverstone
Rental Duration: 6
Rental Rate: 0.99
Length: 136 minutes
Replacement Cost: 22.99
Special Features: Commentaries,Deleted Scenes
Category: Music
20 Copies in Inventory: Copy 1 Condition: Unknown, Copy 2 Condition: Used, Copy 3 Condition: Used, Copy 4 Condition: Used, Copy 5 Condition: Used, Copy 6 Condition: Used, Copy 7 Condition: Used, Copy 8 Condition: New, Copy 9 Condition: Used, Copy 10 Condition: Used, Copy 11 Condition: Used, Copy 12 Condition: Used, Copy 13 Condition: Used, Copy 14 Condition: Used, Copy 15 Condition: Used, Copy 16 Condition: Used, Copy 17 Condition: Damaged, Copy 18 Condition: Used, Copy 19 Condition: Used, Copy 20 Condition: Used

The user is then presented with the submenu and can opt to view expanded details for each film or to return back to the main menu.
