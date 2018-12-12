package com.example.myschool.service;

import java.util.List;

import com.example.myschool.model.Professor;

public interface ProfessorService {
	/**
	 * 교수 목록을 보여준다.
	 */
	public List<Professor> selectProfessorList(Professor professor) throws Exception;

}
