package com.example.myschool;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.myschool.model.Department;
import com.example.myschool.model.Professor;
import com.example.myschool.model.Student;
import com.example.myschool.service.DepartmentService;
import com.example.myschool.service.ProfessorService;
import com.example.myschool.service.StudentService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	DepartmentService departmentService;
	@Autowired
	ProfessorService professorService;
	@Autowired
	StudentService studentService;
		
	@ResponseBody
	@RequestMapping(value = "/")
	public void home(Locale locale, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		
		response.setHeader("Content-Type", "application/json");
		response.setContentType("application/json;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		List<Department> departmentList = null;
		List<Professor> professorList = null;
		List<Student> studentList = null;
		
		Department department = new Department();
		Professor professor = new Professor();
		Student student = new Student();
		
		try {
			departmentList = departmentService.selectDepartmentList(department);
			professorList = professorService.selectProfessorList(professor);
			studentList = studentService.selectStudentList(student);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("rt", "OK");
		data.put("departmentList", departmentList);
		data.put("professorList", professorList);
		data.put("studentList", studentList);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(response.getWriter(), data);
		} catch (JsonGenerationException e) {
			e.getLocalizedMessage();
		} catch (JsonMappingException e) {
			e.getLocalizedMessage();
		} catch (IOException e) {
			e.getLocalizedMessage();
		}
	}	
}
