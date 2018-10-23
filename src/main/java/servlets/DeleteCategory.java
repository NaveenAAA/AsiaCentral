package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import dao.CategoryDAO;
import impl.CategoryDAOImpl;

@WebServlet(urlPatterns="/DeleteCategory")
public class DeleteCategory extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		CategoryDAO cdao = new CategoryDAOImpl();
		
		cdao.delete(id);

		resp.sendRedirect( "/" + getServletContext().getServletContextName() + "/ViewCategories.jsp");
		
	}	
	
}
