-- we can break it down into 2 strings - use LEFT to get the n characters from X column val to the left, and set to uppercase. we concat with a substring from same val from 2nd position onward and set to LOWER. then we concat. then add where clause where not null
SELECT 
  user_id, 
  CONCAT(UPPER(LEFT(name, 1)), LOWER(SUBSTRING(name, 2))) AS name
FROM Users
ORDER BY user_id;
