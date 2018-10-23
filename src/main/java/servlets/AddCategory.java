package servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import validations.CategoryValidation;

import dao.CategoryDAO;
import impl.CategoryDAOImpl;
import model.Category;

@WebServlet(urlPatterns="/AddCategory")
public class AddCategory extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		
		Category c = new Category();
		
		c.setName(name);
		c.setDescription(description);
		
		  CategoryValidation uv = new CategoryValidation(c);
		  
		  
		  Map<String, List<String>> errorMap = uv.getErrorMap();
		  
		  	if( errorMap.keySet().isEmpty() ) {
		
		
		CategoryDAO cdao = new CategoryDAOImpl();
		
		cdao.insert(c);
		
		resp.sendRedirect("/" + getServletContext().getServletContextName() + "/AddProduct.jsp");
		  	}else {
		  		req.setAttribute("errorMap", errorMap);
				
				req.setAttribute("currentCategory", c);
				
				req.getRequestDispatcher("AddCategory.jsp").forward(req, resp);
				
		  	}
	}

	
	
}
