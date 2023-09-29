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

### GROUP BY (Optional)
If you want to group the results based on one or more columns, you can use the GROUP BY clause. This is often used with aggregate functions like COUNT, SUM, AVG, etc.

### HAVING (Optional)
The HAVING clause is used in conjunction with the GROUP BY clause to filter grouped results based on conditions. It works similarly to the WHERE clause but operates on grouped data. 

### ORDER BY (Optional)
You can use the ORDER BY clause to sort the results in ascending (ASC) or descending (DESC) order based on one or more columns. 
### LIMIT (Optional)
You can use the ORDER BY clause to sort the results in ascending (ASC) or descending (DESC) order based on one or more columns. 

## Dates and Times
### Format
DATE - format YYYY-MM-DD
DATETIME - format: YYYY-MM-DD HH:MI:SS
TIMESTAMP - format: YYYY-MM-DD HH:MI:SS
YEAR - format YYYY or YY

### Functions to Remember
- DATEDIFF() returns number of days between two given dates
- 

