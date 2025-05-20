SELECT class
FROM Courses
GROUP BY class
HAVING COUNT(class) >= 5


-- Alt solution:
-- select class
-- from courses
-- group by class
-- having count(distinct student)>=5;