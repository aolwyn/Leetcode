SELECT name
FROM CUSTOMER
WHERE ifnull(referee_id, 0) != 2