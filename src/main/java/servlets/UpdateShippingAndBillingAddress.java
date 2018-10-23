package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import impl.CartDAOImpl;

@WebServlet(urlPatterns="/UpdateShippingAndBillingAddress")
public class UpdateShippingAndBillingAddress extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String shipTo = req.getParameter("shipTo");
		String billTo = req.getParameter("billTo");
		
		CartDAO cdao = new CartDAOImpl();
		
		cdao.update(email, shipTo, billTo);
		
		resp.sendRedirect("ViewInvoice.jsp?email="+email);
	}

	
	
}
