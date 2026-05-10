Scrum Waterfall Project

Overview

Scrum Waterfall Project is a web-based project management application developed to demonstrate the concepts of Software Engineering methodologies such as Scrum and Waterfall.

The application provides a simple interface to understand task management, project flow, and software development lifecycle concepts.

This project was developed as an academic full-stack web application using Java technologies.

Features
User-friendly interface
Task and project management
Demonstration of Scrum and Waterfall workflow concepts
Frontend and backend integration
Database connectivity using JDBC
Dynamic data handling
Technologies Used
Frontend
HTML
CSS
JavaScript
Backend
Java
Java Servlets
Apache Tomcat
Database
MySQL
JDBC
Project Architecture

The project follows MVC (Model-View-Controller) architecture:

View → HTML, CSS, JavaScript
Controller → Java Servlets
Model → MySQL Database
Tools & Technologies
VS Code
Apache Tomcat 9
MySQL
Git & GitHub
How It Works
User interacts with the frontend.
JavaScript sends requests to backend servlets.
Servlets process requests and business logic.
JDBC connects the backend with MySQL database.
Data is stored/retrieved from database.
Response is sent back to the frontend.

Setup Instructions
1. Clone Repository
git clone <your-github-repository-link>

2. Configure Apache Tomcat
Install Apache Tomcat 9
Place the project folder inside:
apache-tomcat/webapps/

4. Configure Database

Create MySQL database:

CREATE DATABASE scrum_waterfall_db;

Import required tables and update JDBC credentials in servlet files.

4. Start Tomcat Server

Run:

startup.bat

OR

catalina.bat run

5. Open in Browser
http://localhost:8080/scrum-waterfall-project/
Learning Outcomes

Through this project, I learned:

Full-stack Java web development
Servlet lifecycle
HTTP request and response handling
JDBC database connectivity
MVC architecture
API communication using JavaScript Fetch API
Debugging servlet and database issues
Future Improvements
Add user authentication
Improve UI/UX
Add role-based access
Convert project to Spring Boot
Add REST APIs
Deploy on cloud platform

Author

Prajwal Gowda

License

This project is developed for educational and learning purposes.
