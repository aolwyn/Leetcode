SELECT e1.name AS Employee
FROM Employee as e1 JOIN Employee as e2 ON e1.managerId = e2.id
WHERE e1.salary > e2.salary