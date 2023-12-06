package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.CollegeBean;
import in.co.rays.model.CollegeModel;

@WebServlet("/CollegeCtl")
public class CollegeCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String Name = req.getParameter("Name");
		String Address = req.getParameter("Address");
		String State = req.getParameter("State");
		String City = req.getParameter("City");
		String PhoneNo = req.getParameter("PhoneNo");

		String op = req.getParameter("operation");

		if(op.equals("Submite")) {
			CollegeBean bean = new CollegeBean();
			bean.setName(Name);
			bean.setAddress(Address);
			bean.setState(State);
			bean.setCity(City);
			bean.setPhoneNo(PhoneNo);

			CollegeModel model = new CollegeModel();
			try {
				model.add(bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("msg", "data inserted");

			RequestDispatcher rd = req.getRequestDispatcher("CollegeView.jsp");

			rd.forward(req, resp);
		}

		if (op.equals("Reset")) {
			RequestDispatcher rd = req.getRequestDispatcher("CollegeView.jsp");
			rd.forward(req, resp);
		}
	}

}
