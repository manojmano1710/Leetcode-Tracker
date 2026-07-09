-- Last updated: 09/07/2026, 15:07:52
SELECT name AS Customers
FROM Customers
WHERE id NOT IN (
    SELECT customerId
    FROM Orders
);