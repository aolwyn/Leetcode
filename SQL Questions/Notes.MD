# SQL Notes

# Background Information
## What is SQL and DBMS?
- SQL = Structured Query Language. SQL is a standard language for relational database management systems. SQL is good for dealing with data that has entities and relations. 
- DBMS = Database Management System. A collection of programs and compatibilities that enable IT teams. 
- RDBMS (relational dabase maanagement system). RDBMS stores things in the forms of tables. 

## What is a Table?
- a table is a collection of related data entries consisting of columns and rows. 
- Each row is an individually entity that exists in a table. 
- a column holds specific information about every record in a table.
- columns = vertical, row = horizontal
- the columns in tables are also referred to as fields and rows are considered records.

## What is a primary key?
- minimal sety of attributes that can be used to uniquely identify a row.
- when multiple columns are used as a primary key, they are collectively known as composite primary keys.
- when using a composite primary key, you should use as few columns as needed.
- more primary key = more storage 
- primary keys cannot have a null value or duplicates.

## What is a foreign key?
- a foreign key = a key used to link two tables together. Also called a reference key
- combination of column who's value matches primary key in different table
- generally used for creating and maintaining relationship between two relations

## What is cursor?
- Cursor is a temporary workstation, created in memory when an SQL statement is executed.
- a SQL cursor is a set of rows together with points that identify rows.
2 types:
1. implicit cursor
2. explicit cursor
- cursors are used to store database tables.

## SQL Vs. NoSQL
| SQL | NoSQL |
| ----------- | ----------- |
| Structured in tables, rigid relations | Document based, unstructured |
| not good for hierarchical data storage | good for hierarchical data storage |
| Good for complex queries | not as good for complex queries |

# Querying + Var Types
## How to comment
use starred asterisks, i.e.,
`*/ hello world */`

## Standard Structure
### SELECT
This is the first and most important part of an SQL query. It specifies which columns or expressions you want to retrieve from the database.

### FROM
After selecting, you need to specify the table or tables from which you want to retrieve data. You can join multiple tables using JOIN operations if necessary.

### WHERE (Optional)
You can use the WHERE clause to specify conditions that filter the rows retrieved from the table. It is used to narrow down the results based on specific criteria.
- `ifnull` takes two parameters and checks if value is null. parameters: column, default value
- `LIKE` is often used in `WHERE` and `SELECT`.  the `LIKE` operator is used to search for a specified pattern within a column of text data in a database table.
`WHERE column_name LIKE pattern` <-- syntax, use % as regex to identify multiple characters or _ for 1.

### GROUP BY (Optional)
If you want to group the results based on one or more columns, you can use the GROUP BY clause. This is often used with aggregate functions like COUNT, SUM, AVG, etc.

### HAVING (Optional)
The HAVING clause is used in conjunction with the GROUP BY clause to filter grouped results based on conditions. It works similarly to the WHERE clause but operates on grouped data. 

### ORDER BY (Optional)
You can use the ORDER BY clause to sort the results in ascending (ASC) or descending (DESC) order based on one or more columns. 
### LIMIT (Optional)
You can use the ORDER BY clause to sort the results in ascending (ASC) or descending (DESC) order based on one or more columns. 

## Common Aggregate Functions
- `COUNT` counts how many rows are in a particular column.
- `SUM` adds together all the values in a particular column.
- `MIN` and `MAX` return the lowest and highest values in a particular column, respectively.
- `AVG` calculates the average of a group of selected values.

## Dates and Times
### Format
- DATE - format YYYY-MM-DD
- DATETIME - format: YYYY-MM-DD HH:MI:SS
- TIMESTAMP - format: YYYY-MM-DD HH:MI:SS
- YEAR - format YYYY or YY

### Functions to Remember
- DATEDIFF() returns number of days between two given dates
- 

## DELETE Queries
The SQL `DELETE` statement is used to remove rows from a table in a database. It starts with the DELETE FROM clause followed by the name of the table from which you want to delete data. Optionally, you can include a WHERE clause to specify conditions that determine which rows should be deleted. Omitting the WHERE clause will result in the removal of all rows from the specified table. Before executing a DELETE query, it's important to understand the criteria and back up data if needed to prevent accidental data loss. Always exercise caution when using DELETE, especially in production environments.

`DELETE FROM table_name`
`WHERE condition`