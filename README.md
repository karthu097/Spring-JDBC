uppose we are building a Student Management System.

The user enters:

Id = 101
Name = Karthu

The application creates:

Student student = new Student();

student.setId(101);
student.setName("Akash");

At this moment the data exists only inside Java memory.

Specifically:

JVM
 └── Heap Memory
      └── Student Object

The problem is:

If the application stops,

Heap Memory cleared
Object destroyed
Data lost

Everything disappears.

Therefore applications need permanent storage.

That permanent storage is called a database.

Examples:

MySQL
PostgreSQL
Oracle
SQL Server
New Problem

Java understands:

Student student

Database understands:

Table
Rows
Columns

Java and Database speak different languages.

Example:

Java:

Student {
  id=101,
  name="Akash"
}

Database:

+-----+-------+
| id  | name  |
+-----+-------+
| 101 | Karthu |
+-----+-------+

Same information.

Different representation.

Now we need a translator.

JDBC Enters

JDBC means:

Java Database Connectivity

Its job is:

Java
 ↓
JDBC
 ↓
Database

JDBC acts as a communication bridge.

Saving Data Using JDBC

Suppose we want to save:

Student student

into MySQL.

The steps are:

Step 1

Create database connection.

Connection con =
DriverManager.getConnection(...);

Think of this as:

Java application opens communication channel
with database.

Without a connection Java cannot talk to MySQL.

Step 2

Write SQL.

String sql =
"insert into student values(?,?)";

This is the language database understands.

Step 3

Create PreparedStatement.

PreparedStatement ps =
con.prepareStatement(sql);

PreparedStatement is responsible for executing SQL.

Step 4
---------------

Replace placeholders.

ps.setInt(1,101);
ps.setString(2,"Akash");

Now SQL becomes:

insert into student values(101,'Akash');
Step 5

Execute query.

ps.executeUpdate();

Now the database inserts the row.

Step 6

Close resources.

ps.close();
con.close();

Spring developers looked at JDBC and noticed:

Every developer is writing the same code.

Only the SQL changes.

Everything else stays the same.

Example:

Connection con = ...
PreparedStatement ps = ...
ps.executeUpdate();
ps.close();

This pattern repeats everywhere.

So they asked:

Why should developers manually do these tasks every time?

Birth of JdbcTemplate

Spring created:

JdbcTemplate

The idea was simple:

Developers should focus only on SQL.

Spring should handle the repetitive work.

What JdbcTemplate Actually Does

When you write:

jdbcTemplate.update(
   "insert into student values(?,?)",
   101,
   "Akash"
);

You see only one line.

But internally Spring performs:

Create Connection
Create PreparedStatement
Set Parameters
Execute SQL
Handle Exceptions
Close Resources
Return Result

All automatically.

Why It Is Called Template

Many students misunderstand this.

Template means:

A predefined workflow.

Whenever you perform a database operation:

Get Connection
Execute SQL
Handle Exception
Close Connection

The workflow remains same.

JdbcTemplate provides this workflow.

You only fill the variable parts.

Example:

SQL Query
Parameters

Everything else is already handled.

Final Understanding

JDBC was not bad.

JDBC solved communication with databases.

The problem was:

Too much repetitive code
Resource management
Exception handling

Spring JDBC did not replace JDBC.

It simply wrapped JDBC and automated repetitive tasks.

Architecture:

Application
↓
JdbcTemplate
↓
JDBC
↓
Database Driver
↓
Database
