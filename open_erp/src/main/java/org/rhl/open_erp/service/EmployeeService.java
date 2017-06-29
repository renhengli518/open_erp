package org.rhl.open_erp.service;

import java.util.List;

import org.rhl.open_erp.domain.Employee;
import org.rhl.open_erp.domain.customize.CustomResult;
import org.rhl.open_erp.domain.customize.EUDataGridResult;
import org.rhl.open_erp.domain.vo.EmployeeVO;

public interface EmployeeService {
	
	List<Employee> find() throws Exception;
	
	EUDataGridResult getList(int page, int rows, EmployeeVO employee) throws Exception;
	
	EmployeeVO get(String string) throws Exception;
	
	CustomResult delete(String string) throws Exception;

	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(Employee employee) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Employee employee) throws Exception;
    
    CustomResult update(Employee employee) throws Exception;
    
    List<Employee> searchEmployeeByEmployeeName(String employeeName) throws Exception;

	List<Employee> searchEmployeeByEmployeeId(String employeeId) throws Exception;

	//根据员工id查找员工信息
	EUDataGridResult searchEmployeeByEmployeeId(Integer page, Integer rows,
			String employeeId) throws Exception;

	//根据员工姓名查找员工信息
	EUDataGridResult searchEmployeeByEmployeeName(Integer page, Integer rows,
			String employeeName) throws Exception;

	//根据部门名称查找员工信息
	EUDataGridResult searchEmployeeByDepartmentName(Integer page, Integer rows,
			String departmentName) throws Exception;
}
