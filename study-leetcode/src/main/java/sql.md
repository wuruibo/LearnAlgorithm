### partition by部分题型归纳

#### P185. 部门工资前三高的所有员工
https://leetcode-cn.com/problems/department-top-three-salaries/solution/tu-jie-sqlmian-shi-ti-jing-dian-topnwen-ti-by-houz/
~~~text
# topN问题 sql模板
select *
from (
   select *, 
          row_number() over (partition by 要分组的列名
                       order by 要排序的列名 desc) as 排名
   from 表名) as a
where 排名 <= N;
~~~