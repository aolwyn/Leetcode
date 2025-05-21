SELECT *
FROM Patients
WHERE conditions LIKE 'DIAB1%' OR conditions like '% DIAB1%'

-- or, using regex,
-- SELECT *
-- FROM Patients
-- WHERE conditions REGEXP '^DIAB1| DIAB1'