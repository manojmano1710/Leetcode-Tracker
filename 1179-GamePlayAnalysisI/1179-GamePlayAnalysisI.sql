-- Last updated: 09/07/2026, 15:07:30
SELECT player_id, event_date AS first_login
FROM (
    SELECT 
        player_id,
        event_date,
        ROW_NUMBER() OVER (PARTITION BY player_id ORDER BY event_date) AS rn
    FROM Activity
) t
WHERE rn = 1;