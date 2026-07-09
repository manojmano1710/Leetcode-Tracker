-- Last updated: 09/07/2026, 15:07:38
SELECT name
FROM Customer
WHERE referee_id != 2
   OR referee_id IS NULL;