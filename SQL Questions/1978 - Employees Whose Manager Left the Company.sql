-- 2 things here, salary < 30k but also where the manager is no longer an employee (a sub query here).
SELECT employee_id
FROM Employees
WHERE salary < 30000 AND manager_id NOT IN (SELECT employee_id FROM Employees)
ORDER BY employee_id