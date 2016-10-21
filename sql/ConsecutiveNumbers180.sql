select distinct l1.Num as ConsecutiveNums from Logs l1, Logs l2, Logs l3
where l1.Id + 1 = l2.Id and l1.Num = l2.Num
and l1.Id + 2 = l3.Id and l1.Num = l3.Num