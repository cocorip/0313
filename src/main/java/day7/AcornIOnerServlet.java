package day7;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/acorn")
public class AcornIOnerServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		AcornService service = new AcornService();
		Acorn m = service.getMember(id);
		req.setAttribute("acorn", m);
		
		req.getRequestDispatcher("WEB-INF/views/member.jsp").forward(req, res);
	}
}
