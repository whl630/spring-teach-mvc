作业:以事务化的方式来删除数据
1.设计deptDao
//删除某个部门
deleteDeptById(connection int id);

2.设计EmpDao
//删除所属部门的所有员工
deleteEmpsByDeptId(Connection conn,int deptid)

3.设计一个业务类EmployeeService
deleteDeptWithEmps(Connection conn,int deptid)
注入刚才的2个到,然后让其以事务化的方式运行
两个到的方法

4.建议以今天讲的advisor方式中的环绕通知来完成
切面类也可以注入东西
invoke(){
    connection conn =
    conn.setAutoCommit(false)
    employeeservice.delete(conn,id);
    conn.commit();
    conn.setAutocommit(true);
    
}