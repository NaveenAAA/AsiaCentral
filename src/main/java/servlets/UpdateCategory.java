package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import impl.CategoryDAOImpl;
import model.Category;

@WebServlet( urlPatterns="/UpdateCategoryToDB" )
public class UpdateCategory extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cid = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		
		Category c = new Category();
		
		c.setId(cid);
		c.setName(name);
		c.setDescription(description);
		
		CategoryDAO cdao = new CategoryDAOImpl();
		
		cdao.update(c);
		
		resp.sendRedirect( "/" + getServletContext().getServletContextName() + "/ViewCategories.jsp");
		
	}
	
}
