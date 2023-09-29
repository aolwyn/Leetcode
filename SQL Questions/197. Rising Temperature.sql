SELECT w1.id AS Id
FROM Weather AS w1 JOIN WEATHER AS w2
WHERE DATEDIFF(w1.recordDate,w2.recordDate) = 1 AND w1.temperature > w2.temperature