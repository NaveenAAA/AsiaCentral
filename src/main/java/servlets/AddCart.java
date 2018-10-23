package servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import impl.CartDAOImpl;
import model.Cart;
import validations.CartValidation;




@WebServlet(urlPatterns="/AddCart")
public class AddCart extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {

			int pid = Integer.parseInt(req.getParameter("pid"));
			String email = req.getParameter("email");
			int qty = Integer.parseInt(req.getParameter("qty"));

			if( qty <= 0 ) throw new NumberFormatException("Invalid Qty Input");
			
			Cart k = new Cart();

			k.setProductId(pid);
			k.setEmail(email);
			k.setQty(qty);

			CartDAO kdao = new CartDAOImpl();

			kdao.insert(k);

			resp.sendRedirect("/" + getServletContext().getServletContextName() + "/ViewCart.jsp?email=" + email);

		} catch (Exception e) {
			e.printStackTrace();

			if( req.getParameter("pid") != null ) {
				req.setAttribute("error", "error");
				int pid = Integer.parseInt(req.getParameter("pid"));
				req.getRequestDispatcher("ViewSingleProduct.jsp?id=" + pid).forward(req, resp);
			}
			
		}

	}
	
}
