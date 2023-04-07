package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Student;
import repository.StudentDAO;

public class StudentModifyService implements IStudentService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int stuNo = Integer.parseInt(request.getParameter("stuNo"));
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		
		double ave = (kor + eng + math) / 3.0;
		String grade;
		switch((int)(ave / 10)) {
		case 10: case 9: grade = "A"; break;
		case 8: grade = "B"; break;
		case 7: grade = "C"; break;
		case 6: grade = "D"; break;
		default: grade = "F";
		}
		
		Student student = Student.builder()
				.stuNo(stuNo)
				.name(name)
				.kor(kor)
				.eng(eng)
				.math(math)
				.ave(ave)
				.grade(grade)
				.build();
		
		int updateResult = StudentDAO.getInstance().updateStudent(student);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if(updateResult == 0) {
			out.println("alert('학생 정보가 수정되었습니다.')");
			out.println("location.href='" + request.getContextPath() + "/detail.do?stuNo=" + stuNo + "'");
		} else {
			out.println("alert('학생 정보 수정이 실패했습니다.')");
			out.println("history.back()");
		}
		out.println("</script>");
		out.flush();
		out.close();
		
		return null;
		
	}

}
