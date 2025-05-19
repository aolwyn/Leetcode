-- want top riders, but in example, see 0's for those that didn't travel so left join and IFNULL clause
SELECT Users.name, IFNULL(SUM(Rides.distance), 0) AS travelled_distance
FROM Users
LEFT JOIN Rides ON Users.id = Rides.user_id
GROUP BY Users.id, Users.name
ORDER BY travelled_distance DESC, Users.name ASC;
