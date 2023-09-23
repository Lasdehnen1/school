alter table student
add constraint age_constraint check (age > 16);

alter table student 
alter column name SET NOT NULL;

alter table student
add constraint studentName_unique UNIQUE (name);

alter table faculty 
add constraint facultyColor_unique unique (name, color);

alter table student 
alter column age set default 20;