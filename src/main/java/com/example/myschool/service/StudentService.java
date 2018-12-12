package com.example.myschool.service;

import java.util.List;

import com.example.myschool.model.Student;

public interface StudentService {
	/**
	 *  학생 목록을 보여준다.
	 */
	public List<Student> selectStudentList(Student student) throws Exception;

}
