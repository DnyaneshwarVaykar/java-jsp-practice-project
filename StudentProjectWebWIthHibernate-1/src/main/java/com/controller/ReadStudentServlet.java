package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.entity.Student;

@WebServlet("/readStudent")
public class ReadStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentDao studentDao;
    public ReadStudentServlet() {
        
    }

	@Override
	public void init() throws ServletException {
		studentDao=new StudentDaoImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		List<Student> studentList=studentDao.getAllStudent();
		
		request.setAttribute("studentList", studentList);
		
		request.getRequestDispatcher("readStudent.jsp").forward(request, response);
	}

}
