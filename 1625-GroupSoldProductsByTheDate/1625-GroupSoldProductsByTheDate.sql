-- Last updated: 09/07/2026, 15:07:27
SELECT 
    sell_date,
    COUNT(*) AS num_sold,
    GROUP_CONCAT(product ORDER BY product SEPARATOR ',') AS products
FROM (
    SELECT DISTINCT sell_date, product
    FROM Activities
) AS temp
GROUP BY sell_date
ORDER BY sell_date;