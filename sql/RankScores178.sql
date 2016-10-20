select  c.Score,cast(rownum as signed) as Rank from Scores c
left join (
select @rd:=@rd+1  as rownum, Score from
(
select @rd:=0, Score from
( select distinct Score from Scores order by Score DESC ) a ) b
) d
on c.Score = d.Score
order by c.Score DESC