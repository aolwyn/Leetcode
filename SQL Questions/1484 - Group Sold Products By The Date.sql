# Write your MySQL query statement below
-- ok we want the sell dates, the # of distinct product sold on a given day and then we want a list of all he distinct products separated by a comma.
SELECT sell_date, COUNT(DISTINCT product) AS num_sold, GROUP_CONCAT(DISTINCT product ORDER BY product SEPARATOR ',') AS products
FROM Activities
GROUP BY sell_date 
ORDER BY sell_date