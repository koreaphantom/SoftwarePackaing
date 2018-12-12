package com.example.myschool.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myschool.model.Professor;
import com.example.myschool.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService{
	
	/** MyBatis */
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<Professor> selectProfessorList(Professor professor) throws Exception {
		List<Professor> result = null;
		
		try {
			result = sqlSession.selectList("ProfessorMapper.selectProfessorList", professor);
		} catch (Exception e){
			throw new Exception("교수 목록 조회에 실패했습니다.");
		}
		
		return result;
	}

}
