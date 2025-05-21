-- 2 parts here, we want project id and then the avg year.
-- so we need to join the 2 tables on the foreign key and then select the avg experience of employee and round to 2.
-- also need the group by. 
SELECT project_id, ROUND(AVG(experience_years),2) AS average_years
FROM Project, Employee
WHERE Project.employee_id = Employee.employee_id
GROUP BY project_id