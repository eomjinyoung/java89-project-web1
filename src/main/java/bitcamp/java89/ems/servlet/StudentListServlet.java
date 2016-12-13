package bitcamp.java89.ems.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java89.ems.dao.impl.StudentMysqlDao;
import bitcamp.java89.ems.vo.Student;

@WebServlet("/student/list")
public class StudentListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    try {
      StudentMysqlDao studentDao = StudentMysqlDao.getInstance();
    
      // 웹브라우저 쪽으로 출력할 수 있도록 출력 스트림 객체를 얻는다.
      response.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      ArrayList<Student> list = studentDao.getList();
      for (Student student : list) {
        out.printf("%s,%s,%s,%s,%s,%s,%d,%s\n",
          student.getUserId(),
          student.getPassword(),
          student.getName(),
          student.getTel(),
          student.getEmail(),
          ((student.isWorking())?"yes":"no"),
          student.getBirthYear(),
          student.getSchool());
      }
    } catch (Exception e) {
      throw new ServletException(e);
    }
    
  }
}








