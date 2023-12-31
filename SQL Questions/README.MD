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
Indexes in SQL are used to optimize the retrieval of data from a table. They work similar to book indexes, making data retrieval faster by providing a quick way to access specific rows based on the indexed column. 


1.  Purpose of Indexes:

    -   Improved Query Performance: Indexes speed up the data retrieval process by allowing the database engine to locate rows more quickly.
    -   Faster Sorting and Grouping: Indexes can accelerate the sorting and grouping operations specified in queries.
    -   Enhanced Performance of Joins: Indexes can significantly improve the performance of join operations between tables.
2.  Types of Indexes:

    -   Clustered Index: Determines the physical order of the rows in the table based on the indexed columns. Each table can have only one clustered index.
    -   Non-Clustered Index: Provides a separate structure that maps the indexed columns to the corresponding rows. A table can have multiple non-clustered indexes.
3.  Creating Indexes:

    -   Indexes are created using the `CREATE INDEX` statement in SQL. The syntax varies slightly between different database management systems (DBMS), as SQL implementations may differ.

   Example of creating a non-clustered index on a single column
    `CREATE INDEX index_name ON table_name(column_name);`

4.  Columns Included in Index:

    -   Indexes can be created on one or more columns of a table.
    -   The choice of columns for an index depends on the types of queries run against the table.
5.  Impact on Insert, Update, and Delete Operations:

    -   While indexes improve read performance, they can slightly slow down write operations (insert, update, delete). This is because the indexes need to be maintained whenever the data in the indexed columns is modified.
6.  Dropping Indexes:

    -   Indexes can be dropped (removed) using the `DROP INDEX` statement.



    Example of dropping an index
    `DROP INDEX index_name ON table_name;`

7.  Statistics:

    -   The database engine maintains statistics about the data distribution in the indexed columns to help optimize query execution plans.

# Normalization

In SQL, normalization refers to the process of organizing the data in a database to reduce redundancy and improve data integrity. The goal of normalization is to structure the database in a way that minimizes data redundancy and dependency by dividing the data into related tables. This is achieved through a series of rules called normal forms, with each normal form addressing specific types of issues related to data redundancy and dependency.

Normalization helps maintain data integrity, reduces redundancy, and ensures that updates, inserts, and deletes occur without introducing anomalies. However, it's essential to strike a balance between normalization and performance, as highly normalized databases can lead to more complex queries and potentially slower performance in certain scenarios. The level of normalization applied depends on the specific requirements and characteristics of the data being modeled.

Here are the main normal forms:

1. **First Normal Form (1NF):**
   - Definition: A relation is in 1NF if it contains only atomic (indivisible) values, and there are no repeating groups or arrays.
   - Use Case: Apply 1NF when dealing with simple, flat data structures without nested or repeating elements.

2. **Second Normal Form (2NF):**
   - Definition: A relation is in 2NF if it is in 1NF and all non-key attributes are fully functionally dependent on the primary key.
   - Use Case: Apply 2NF when there are partial dependencies in a table, and you want to eliminate redundancy by breaking the table into smaller, related tables.

3. **Third Normal Form (3NF):**
   - Definition: A relation is in 3NF if it is in 2NF and there are no transitive dependencies between non-key attributes.
   - Use Case: Apply 3NF when there are transitive dependencies between non-key attributes, and you want to eliminate them to achieve a more granular level of normalization.

4. **Boyce-Codd Normal Form (BCNF):**
   - Definition: A relation is in BCNF if it is in 3NF and every determinant is a superkey.
   - Use Case: Apply BCNF when you want to address certain anomalies that may still exist in a 3NF design, particularly in the case of multiple candidate keys.

5. **Fourth Normal Form (4NF):**
   - Definition: A relation is in 4NF if it is in BCNF and has no multi-valued dependencies.
   - Use Case: Apply 4NF when dealing with multi-valued dependencies, and you want to decompose the table to eliminate redundancy.

6. **Fifth Normal Form (5NF):**
   - Definition: A relation is in 5NF if it is in 4NF and all join dependencies are implied by the superkeys.
   - Use Case: Apply 5NF when dealing with join dependencies that are not satisfied by the existing normalization level.




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
