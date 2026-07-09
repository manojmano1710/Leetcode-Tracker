-- Last updated: 09/07/2026, 15:07:39
SELECT 
    t.request_at AS Day,
    ROUND(
        SUM(CASE 
                WHEN t.status != 'completed' THEN 1 
                ELSE 0 
            END) / COUNT(*)
    , 2) AS `Cancellation Rate`
FROM Trips t
JOIN Users uc ON t.client_id = uc.users_id
JOIN Users ud ON t.driver_id = ud.users_id
WHERE uc.banned = 'No'
  AND ud.banned = 'No'
  AND t.request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY t.request_at;