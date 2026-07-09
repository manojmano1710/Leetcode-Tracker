-- Last updated: 09/07/2026, 15:07:33
SELECT name, population, area
FROM World
WHERE area >= 3000000
   OR population >= 25000000;