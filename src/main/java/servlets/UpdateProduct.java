package servlets;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.ProductDAO;
import impl.CategoryDAOImpl;
import impl.ProductDAOImpl;
import model.Category;
import model.Product;

@WebServlet( urlPatterns="/UpdateProductToDB" )
public class UpdateProduct extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		CategoryDAO cdao = new CategoryDAOImpl();
		
		Category c = cdao.getCategory(Integer.parseInt(req.getParameter("cat")));
		
		int pid = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		Double price =  Double.parseDouble( req.getParameter("price"));
		String imagePath = req.getParameter("imagepath");
		Product p = new Product();
		
		p.setId(pid);
		p.setName(name);
		p.setDescription(description);
		p.setCategory(c);
		p.setPrice(price);
		p.setImagePath(imagePath);
		
		ProductDAO pdao = new ProductDAOImpl();
		
		pdao.update(p);
		
		resp.sendRedirect( "/" + getServletContext().getServletContextName() + "/ViewProducts.jsp");
		
	}

	
	

}
