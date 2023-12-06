package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		int pageNo=1;
		int pageSize=5;
		
		UserModel model = new UserModel();

		try {
			List list = model.search(null, pageNo, pageSize);

			req.setAttribute("list", list);
			req.setAttribute("pageNo", pageNo);
			

			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String op = req.getParameter("operation");

		int pageNo = Integer.parseInt(req.getParameter("pageNo"));

		int pageSize = 5;

		UserBean bean = new UserBean();

		UserModel model = new UserModel();

		if (op.equals("search")) {
			
			SimpleDateFormat sql=new SimpleDateFormat("yyyy-MM-dd");

			String firstName = req.getParameter("firstName");
			String dob = req.getParameter("dob");

			bean.setFirstName(firstName);
			try {
				bean.setDob(sql.parse(dob));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (op.equals("next")) {

			pageNo++;

		}
		
		if (op.equals("Delete")) {

			String[] ids = req.getParameterValues("ids");
			
			for (String id : ids ) {
				
				try {
					model.delete(Integer.parseInt(id));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

		}

		if (op.equals("previous")) {

			pageNo--;

		}

		try {
			List list = model.search(bean, pageNo, pageSize);

			req.setAttribute("list", list);
			req.setAttribute("pageNo", pageNo);

			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
