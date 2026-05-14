package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.entity.Student;


@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentDao studentDao;
    public AddStudentServlet() {
        super();
    }
    @Override
    public void init() throws ServletException {
    	studentDao=new StudentDaoImpl();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		double marks=Double.parseDouble(request.getParameter("marks"));
		Student student=new Student();
		student.setName(name);
		student.setMarks(marks);
		
		studentDao.addStudent(student);
		response.sendRedirect(request.getContextPath() + "/readStudent");
		
	}

}
