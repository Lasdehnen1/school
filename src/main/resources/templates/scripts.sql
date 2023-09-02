select * from student s
where s.age between 20 and 23

select s."name"
from student s

select *
from student s
where s."name" like '%tt%'

select *
from student s
where s.age < s.id

select *
from student s
order by s.age