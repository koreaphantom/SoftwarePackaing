package com.example.myschool.service;

import java.util.List;

import com.example.myschool.model.Department;

public interface DepartmentService {
	/**
	 * 학과 목록을 보여준다.
	 */
	public List<Department> selectDepartmentList(Department department) throws Exception;

}
