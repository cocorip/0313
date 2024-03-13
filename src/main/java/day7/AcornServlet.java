package day7;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/acornList")
public class AcornServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//데이타 만들기
		//model -> 서비스,DAO
		AcornService service = new AcornService();
		//ArrayList<Acorn> list = service.getMemberListTmp();
		ArrayList<Acorn> list = service.getMemberListReal();
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/list.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//데이타 만들기
				//model -> 서비스,DAO
				AcornService service = new AcornService();
				//ArrayList<Acorn> list = service.getMemberListTmp();
				ArrayList<Acorn> list = service.getMemberListReal();
				req.setAttribute("list", list);
				req.getRequestDispatcher("WEB-INF/views/list.jsp").forward(req, resp);

	}
	
}
