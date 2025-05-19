# Write your MySQL query statement below
-- basically we are updating the table with a case for a given column.

UPDATE Salary
SET sex = CASE
    WHEN sex = 'm' THEN 'f'
    WHEN sex = 'f' THEN 'm'
END