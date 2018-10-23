package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import dao.CategoryDAO;
import dao.ProductDAO;
import impl.CategoryDAOImpl;
import impl.ProductDAOImpl;

@WebServlet(urlPatterns="/DeleteProCat")
public class DeleteEveryProduct extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int category_id = Integer.parseInt(req.getParameter("category_id"));
		
         ProductDAO dkdao = new ProductDAOImpl();
		
		dkdao.deleteCatProducts(category_id);
      
		resp.sendRedirect( "/" + getServletContext().getServletContextName() + "/ConfirmDeleteCat.jsp?category_id=" + category_id);
		
	}	
	
}
