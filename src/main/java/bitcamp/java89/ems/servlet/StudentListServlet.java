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
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      ArrayList<Student> list = studentDao.getList();
      
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>학생관리-목록</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>학생 정보</h1>");
      out.println("<a href='form.html'>추가</a><br>");
      out.println("<table border='1'>");
      out.println("<tr>");
      out.println("  <th>아이디</th><th>암호</th><th>이름</th><th>이메일</th>");
      out.println("</tr>");
      
      for (Student student : list) {
        out.println("<tr> ");
        out.printf("  <td><a href='view?userId=%s'>%1$s</a></td><td>%s</td><td>%s</td><td>%s</td>\n",
          student.getUserId(),
          student.getPassword(),
          student.getName(),
          student.getEmail());
        out.println("</tr>");
      }
      
      out.println("</table>");
      out.println("</body>");
      out.println("</html>");
      
    } catch (Exception e) {
      throw new ServletException(e);
    }
    
  }
}








