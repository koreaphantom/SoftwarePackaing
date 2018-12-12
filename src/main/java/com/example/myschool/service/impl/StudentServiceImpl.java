package com.example.myschool.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myschool.model.Student;
import com.example.myschool.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	/** MyBatis */
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<Student> selectStudentList(Student student) throws Exception {
		List<Student> result = null;
		
		try {
			result = sqlSession.selectList("StudentMapper.selectStudentList", student);
		} catch (Exception e){
			throw new Exception("학생 목록 조회에 실패했습니다.");
		}
		
		return result;
	}
}
