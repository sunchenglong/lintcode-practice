SELECT t.Request_at AS Day, ROUND(SUM(IF(STATUS != 'completed', 1, 0))/COUNT(*), 2) AS 'Cancellation Rate' FROM Trips t
LEFT JOIN Users uc ON t.Client_Id = uc.Users_Id
WHERE uc.Banned = 'No' AND Request_at >= '2013-10-01' AND Request_at <= '2013-10-03' GROUP BY t.Request_at;