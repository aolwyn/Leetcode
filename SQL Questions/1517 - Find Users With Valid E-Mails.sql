-- we can just use regex here, ^ – start of string, 
-- [a-zA-Z] – first character must be a letter
-- [a-zA-Z0-9._-]* – valid characters after the first
-- @leetcode\\.com$ – ends with this exact domain (\\. escapes the .)
SELECT *
FROM Users
WHERE mail REGEXP '^[a-zA-Z][a-zA-Z0-9._-]*@leetcode\\.com$';