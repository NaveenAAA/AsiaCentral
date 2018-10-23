package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import dao.UserDAO;
import impl.UserDAOImpl;

@WebServlet(urlPatterns = {"/UpdateUser"})
public class UpdateUser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		
		
		  User u = new User();
          
		  u.setId(id);
         u.setName(name);
         u.setPassword(password);
         u.setEmail(email);
         u.setPhone(phone);
          
          //System.out.println( u );

          UserDAO udao = new UserDAOImpl();

          udao.update(u);

          resp.sendRedirect("UserINFO.jsp");
		
		
	}

}
