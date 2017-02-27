select * from dept;
insert into DEPT
VALUES
(60,'xxx','yyy');

update dept
SET DNAME='개발부',
	LOC='광주'
where DEPTNO=60;

delete from dept
where deptno = 60;

