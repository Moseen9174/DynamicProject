package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserCtl")
public class UserCtl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String id = req.getParameter("id");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		SimpleDateFormat sql = new SimpleDateFormat("yyyy-MM-dd");

		String op = req.getParameter("operation");

		if (op.equals("SignUp")) {

			UserBean bean = null;

			UserModel model = new UserModel();

			try {
				bean = model.findByLogin(loginId);

				if (bean != null) {

					req.setAttribute("msg", "User Already exist");

				} else {

					bean = new UserBean();

					bean.setFirstName(firstName);
					bean.setLastName(lastName);
					bean.setLoginId(loginId);
					bean.setPassword(password);
					bean.setDob(sql.parse(dob));
					bean.setAddress(address);

					model.add1(bean);

					req.setAttribute("msg", "User Register Successfully...!!!");

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("msg", "data inserted");

			RequestDispatcher rd = req.getRequestDispatcher("WelcomeCtl");

			rd.forward(req, resp);
		}
		if (op.equals("Reset")) {
			RequestDispatcher rd = req.getRequestDispatcher("UserRegistration.jsp");
			rd.forward(req, resp);
		}

	}
}



