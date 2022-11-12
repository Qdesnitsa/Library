## Library
***
### Main task
Create a library application that implements CRUD operations for working with the following types of printed products:
books, magazines, newspapers, etc. All printed products should be cataloged by:
publication date (issue), author(s), publisher(s), etc.

The application should consist of three layers:
1. API: this layer is responsible for receiving/sending requests/responses from the user, 
receiving requests can be implemented:
- via the HTTP protocol (not necessary, but preferably), 
- via application arguments (obtained by the main method), 
- via subtraction from a file, or in another possible way.<br>
PS: Answers can simply be printed to a log file or standard output console.
2. Business logic: this layer is responsible for the implementation of operations for working with our
print products:<br>
a. Save<br>
b. Update<br>
c. Get (search by various criteria: date, author, edition, subject, etc.)<br>
d. Delete
3. Data storage: this layer is responsible for persistent (persistent, on disk) storage
data (either in a file or in a database (optional, but preferred)) and
organizing caching (optional, but preferred).

#### Recommendations
- The application must be created using OOP principles (mandatory)
- When creating an application, it is better to use SpringBootFramework (optional)
- To work with HTTP - SpringWebFramework
- To work with the database - SpringDataJDBC
- As a database - embedded H2
