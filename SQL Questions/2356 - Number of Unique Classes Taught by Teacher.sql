SELECT teacher_id, count(DISTINCT subject_id) as cnt
FROM Teacher
GROUP BY 1  /*this line  states to count the distinct subject_id values for each unique teacher_id. */
