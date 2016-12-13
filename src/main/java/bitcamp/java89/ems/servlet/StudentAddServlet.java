package bitcamp.java89.ems.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java89.ems.dao.impl.StudentMysqlDao;
import bitcamp.java89.ems.vo.Student;

@WebServlet("/student/add")
public class StudentAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    try {
      StudentMysqlDao studentDao = StudentMysqlDao.getInstance();
    
      // 웹브라우저 쪽으로 출력할 수 있도록 출력 스트림 객체를 얻는다.
      response.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      if (studentDao.existUserId(request.getParameter("userId"))) {
        out.println("이미 해당 아이디의 학생이 있습니다. 등록을 취소하겠습니다.");
        return;
      }
      
      Student student = new Student();
      student.setUserId(request.getParameter("userId"));
      student.setPassword(request.getParameter("password"));
      student.setName(request.getParameter("name"));
      student.setTel(request.getParameter("tel"));
      student.setEmail(request.getParameter("email"));
      student.setWorking(Boolean.parseBoolean(request.getParameter("working")));
      student.setBirthYear(Integer.parseInt(request.getParameter("birthYear")));
      student.setSchool(request.getParameter("school"));
      
      studentDao.insert(student);
      out.println("등록하였습니다.");
      
    } catch (Exception e) {
      throw new ServletException(e);
    }
    
  }
}








