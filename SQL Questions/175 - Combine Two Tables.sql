-- we need to use an inner left join because we want all person and report null if not in address
SELECT firstName, lastName, city, state
FROM Person LEFT JOIN Address ON Person.personId = Address.personId