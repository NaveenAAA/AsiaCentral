package servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import validations.UserValidations;
import dao.UserDAO;
import impl.UserDAOImpl;

@WebServlet(urlPatterns = { "/AddUser" })
public class AddUser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String Cpassword = req.getParameter("Cpassword");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		

			User u = new User();

			u.setName(name);
			u.setPassword(password);
			u.setCpassword(Cpassword);
			u.setEmail(email);
			u.setPhone(phone);

			UserValidations uv = new UserValidations(u);
			
			Map<String, List<String>> errorMap = uv.getErrorMap();
			
			if( errorMap.keySet().isEmpty() ) {
				UserDAO udao = new UserDAOImpl();

				udao.insert(u);

				resp.sendRedirect("UserINFO.jsp");
			}
			else {
				
				req.setAttribute("errorMap", errorMap);
				
				req.setAttribute("currentUser", u);
				
				req.getRequestDispatcher("signup.jsp").forward(req, resp);
				
			}
			
			
		}
	}


