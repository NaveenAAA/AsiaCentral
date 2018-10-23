package servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import dao.ProductDAO;
import impl.ProductDAOImpl;

@WebServlet(urlPatterns="/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		ProductDAO pdao = new ProductDAOImpl();
		
		pdao.delete(id);

		resp.sendRedirect( "/" + getServletContext().getServletContextName() + "/ViewProducts.jsp");
		
	}	
	
}
