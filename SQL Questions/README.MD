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

## Primary Key Vs. Foreign Key
A primary key is a column or a set of columns that uniquely identifies each record in a table. It ensures that there are no duplicate rows in the table and provides a way to uniquely access specific rows. Typically, the primary key is defined when the table is created and is often an auto-incrementing number or a combination of columns that uniquely identify each row.

A foreign key, on the other hand, is a column (or set of columns) in a table that establishes a relationship between two tables. It refers to the primary key in another table. It enforces referential integrity, ensuring that the values in the foreign key column exist in the referenced table's primary key column.

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

## Alias
In SQL, an alias is a temporary name assigned to a table or a column in a query. Aliases are used to make queries more readable or to shorten lengthy table or column names. They are created using the `AS` keyword. 

## Indexes
Indexes in SQL are used to optimize the retrieval of data from a table. They work similar to book indexes, making data retrieval faster by providing a quick way to access specific rows based on the indexed column. Understanding how to create and use indexes is important for improving query performance.

# Querying + Var Types
## How to comment
use starred asterisks, i.e.,
`*/ hello world */`

## Standard Structure
### SELECT
This is the first and most important part of an SQL query. It specifies which columns or expressions you want to retrieve from the database.

- Can use `DISTINCT` to only get distinct values of x column. i..e, `DISTINCT(name)`

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

## INSERT Queries
The SQL `INSERT` statement is used to add new rows of data to a table. It starts with the `INSERT INTO` clause followed by the name of the table where you want to insert data. You then specify the columns and provide the values you want to insert. If you omit column names, you should provide values for all columns in the same order as they appear in the table.

`INSERT INTO table_name (column1, column2, column3, ...)`
`VALUES (value1, value2, value3, ...);`

## UPDATE Queries
The SQL `UPDATE` statement is used to modify existing data in a table. It starts with the `UPDATE` clause followed by the name of the table you want to update. Then, you set the new values for specific columns, and you can use the WHERE clause to specify the rows that should be updated.

`UPDATE table_name`
`SET column1 = value1, column2 = value2, ...`
`WHERE condition;`

Certainly, let's provide information about SQL joins and their types using markdown format:

## Joins in SQL
Joins are a fundamental feature of SQL that enables you to combine data from multiple tables. They are essential when dealing with relational databases. There are several types of joins in SQL, each serving a specific purpose:

### INNER JOIN
An INNER JOIN returns only the rows where there is a match in both tables. It combines rows from two tables if there is a common value in the specified columns.

**Syntax:**
```sql
SELECT column1, column2
FROM table1
INNER JOIN table2 ON table1.column_name = table2.column_name;
```

**Example:**
```sql
SELECT orders.order_id, customers.customer_name
FROM orders
INNER JOIN customers ON orders.customer_id = customers.customer_id;
```

### LEFT JOIN (or LEFT OUTER JOIN)
A LEFT JOIN returns all the rows from the left table and the matched rows from the right table. If there are no matching rows in the right table, NULL values are included for those columns.

**Syntax:**
```sql
SELECT column1, column2
FROM table1
LEFT JOIN table2 ON table1.column_name = table2.column_name;
```

**Example:**
```sql
SELECT customers.customer_name, orders.order_id
FROM customers
LEFT JOIN orders ON customers.customer_id = orders.customer_id;
```

### RIGHT JOIN (or RIGHT OUTER JOIN)
A RIGHT JOIN is similar to a LEFT JOIN but returns all the rows from the right table and the matched rows from the left table. If there are no matching rows in the left table, NULL values are included for those columns.

**Syntax:**
```sql
SELECT column1, column2
FROM table1
RIGHT JOIN table2 ON table1.column_name = table2.column_name;
```

**Example:**
```sql
SELECT orders.order_id, customers.customer_name
FROM orders
RIGHT JOIN customers ON orders.customer_id = customers.customer_id;
```

### FULL JOIN (or FULL OUTER JOIN)
A FULL JOIN returns all the rows when there is a match in either the left or the right table. If there is no match, NULL values are included for those columns.

**Syntax:**
```sql
SELECT column1, column2
FROM table1
FULL JOIN table2 ON table1.column_name = table2.column_name;
```

**Example:**
```sql
SELECT customers.customer_name, orders.order_id
FROM customers
FULL JOIN orders ON customers.customer_id = orders.customer_id;
```

### SELF JOIN
A SELF JOIN is used to combine rows within the same table, as if you were joining the table with itself. This can be useful for hierarchical or recursive data.

**Syntax:**
```sql
SELECT employee.name, manager.name
FROM employees employee
LEFT JOIN employees manager ON employee.manager_id = manager.employee_id;
```
