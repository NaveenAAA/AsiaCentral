package servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import impl.UserDAOImpl;

@WebServlet(urlPatterns = {"/DeleteUser"})
public class DeleteUser extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int id = Integer.parseInt(req.getParameter("id"));
		
		UserDAO udao = new UserDAOImpl();
		
		udao.delete(id);
		
		 resp.sendRedirect("UserINFO.jsp");
		
	}

}
