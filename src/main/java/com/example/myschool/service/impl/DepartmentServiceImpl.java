package com.example.myschool.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myschool.model.Department;
import com.example.myschool.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	/** MyBatis */
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<Department> selectDepartmentList(Department department) throws Exception {
		List<Department> result = null;
		
		try {
			result = sqlSession.selectList("DepartmentMapper.selectDepartmentList", department);
		} catch (Exception e){
			throw new Exception("학과 목록 조회에 실패했습니다.");
		}
		
		return result;
	}

}
