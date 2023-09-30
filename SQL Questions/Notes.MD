# SQL Notes

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