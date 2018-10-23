package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import dao.CartDAO;
import impl.CartDAOImpl;

@WebServlet(urlPatterns="/DeleteCart")
public class DeleteCart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		
		CartDAO kdao = new CartDAOImpl();
		
		kdao.delete(email);

		resp.sendRedirect( "/" + getServletContext().getServletContextName() + "/main.jsp");
		
	}	
	
}
