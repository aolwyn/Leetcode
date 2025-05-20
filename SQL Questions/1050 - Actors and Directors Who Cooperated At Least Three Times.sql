-- want the actor + director ID that occurs 2x time (the pairing.) select both from table and group PAIRWISE. then add a having clause for >=3 
SELECT actor_id, director_id
FROM ActorDirector
GROUP BY actor_id, director_id
HAVING COUNT(*) >= 3