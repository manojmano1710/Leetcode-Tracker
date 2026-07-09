-- Last updated: 09/07/2026, 15:07:53
SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(email) > 1;