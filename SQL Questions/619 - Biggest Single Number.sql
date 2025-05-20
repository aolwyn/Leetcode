-- 2 parts to this question. we want the single highest number that only occurs once, null otherwise.
-- so 2 query parts, a sub query to group all the numbers with a single count and then select the max from this.
SELECT MAX(num) as num
FROM (
    SELECT num
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(*)=1
) AS temp