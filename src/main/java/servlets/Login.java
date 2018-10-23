package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import impl.UserDAOImpl;
import model.User;

@WebServlet(urlPatterns="/Login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		UserDAO udao = new UserDAOImpl();
		
		User u = udao.getUser(name, password);
		
		if( u == null ) {
			req.setAttribute("error", "error");
			req.setAttribute("name", name);
			req.setAttribute("password", password);
			
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
			
			
		}else {
			
			req.getSession().setAttribute("name", name);
			
			req.getSession().setAttribute("loggedInUserEmail", u.getEmail());
			
			req.getSession().setAttribute("role", u.getRole());
			
			resp.sendRedirect("main.jsp");
			
		}
		
	}

	
	
}
