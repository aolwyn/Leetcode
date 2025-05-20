-- for this one, we want to create a new column. so in the select we use a case then add the from after.
-- this Q uses the triangle inequality theorem
SELECT x, y, z,
CASE
    WHEN ((x + y > z) AND (y + z > x) AND (x + z > y)) THEN 'Yes'
    ELSE 'No'
END AS triangle
FROM Triangle