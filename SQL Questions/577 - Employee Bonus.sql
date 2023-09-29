SELECT name, bonus
FROM Employee LEFT JOIN Bonus ON Employee.empId = Bonus.empId
WHERE ifnull(bonus, 0) < 1000;
