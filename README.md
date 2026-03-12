# Java Web Development – Servlet Project (UC1–UC4)

## Project Description

This project demonstrates Java Web Development using **Servlet, Tomcat, JDBC, and MySQL**.
The application supports user registration, database storage, viewing users, and login validation.

Technologies used:

* Java 17
* Apache Tomcat
* Jakarta Servlet API
* MySQL
* JDBC
* IntelliJ IDEA
* Smart Tomcat Plugin

---

## Project Structure

```
HelloServlet
│
├── src
│   ├── HelloServlet.java
│   ├── RegisterServlet.java
│   ├── ViewUsersServlet.java
│   └── LoginServlet.java
│
├── web
│   ├── index.html
│   ├── register.html
│   ├── login.html
│   └── WEB-INF
│       └── web.xml
│
├── sql
│   ├── create_db.sql
│   └── create_table.sql
│
├── .gitignore
└── README.md
```

---

## Database Setup (MySQL)

### Create Database

```sql
CREATE DATABASE userdb;
USE userdb;
```

### Create Table

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(50),
    password VARCHAR(50),
    gender VARCHAR(10),
    country VARCHAR(50)
);
```

---

## UC1 – User Registration Form

Features:

* HTML registration form
* Servlet to read form data
* Display user details

URL:

```
http://localhost:8080/HelloServlet/register.html
```

Files:

* register.html
* RegisterServlet.java
* web.xml

---

## UC2 – Store Data in MySQL using JDBC

Features:

* JDBC connection
* Insert user data into database
* MySQL Connector/J used

Driver:

```
mysql-connector-j
```

Code used:

```
DriverManager.getConnection(
"jdbc:mysql://localhost:3306/userdb",
"root",
"password"
);
```

---

## UC3 – View Users from Database

Features:

* Fetch all users
* Display in HTML table

URL:

```
http://localhost:8080/HelloServlet/view
```

Files:

* ViewUsersServlet.java

---

## UC4 – Login Validation

Features:

* Login form
* Validate email & password
* Check user in database

URL:

```
http://localhost:8080/HelloServlet/login.html
```

Files:

* login.html
* LoginServlet.java

SQL used:

```
select * from users where email=? and password=?
```

---

## How to Run

1. Start Tomcat
2. Run project using Smart Tomcat
3. Open browser

```
http://localhost:8080/HelloServlet/
```
