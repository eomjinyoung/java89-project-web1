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

@WebServlet("/student/view")
public class StudentViewServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    try {
      StudentMysqlDao studentDao = StudentMysqlDao.getInstance();
    
      // 웹브라우저 쪽으로 출력할 수 있도록 출력 스트림 객체를 얻는다.
      response.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      if (!studentDao.existUserId(request.getParameter("userId"))) {
        out.println("해당 아이디의 학생이 없습니다.");
        return;
      }
      
      Student student = studentDao.getOne(request.getParameter("userId"));
      out.printf("아이디: %s\n", student.getUserId());
      out.printf("암호: (***)\n");
      out.printf("이름: %s\n", student.getName());
      out.printf("전화: %s\n", student.getTel());
      out.printf("이메일: %s\n", student.getEmail());
      out.printf("재직중: %s\n", (student.isWorking()) ? "Yes" : "No");
      out.printf("태어난 해: %d\n", student.getBirthYear());
      out.printf("학교: %s\n", student.getSchool());
    } catch (Exception e) {
      throw new ServletException(e);
    }
    
  }
}








