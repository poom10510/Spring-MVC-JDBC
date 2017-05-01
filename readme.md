### Spring MVC with JDBC (CRUD)
---

#### Requirements
  1. STS (Spring Tool Suite)
  2. MySql server

#### How to run
1. Run Tomcat server.
2. Create database

  `CREATE TABLE SpringJDBC(
   ID   INT NOT NULL AUTO_INCREMENT,
   NAME VARCHAR(20) NOT NULL,
   AGE  INT NOT NULL,
   PRIMARY KEY (ID));`

#### Routes
  - `/add` : Create new Student.
  - `/update/{id}` : Update student information.
  - `/delete/{id}` : Delete student.
  - `/` : List all students in database.

#### Connecting to database
- You can change database name, username or password in `beans.xml`

**Taweerat Chaiman 5710546259**
