package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.CollegeBean;
import in.co.rays.model.CollegeModel;

@WebServlet("/CollegeListView")
public class CollegeListCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageNo;
		int pageSize;

		CollegeModel model = new CollegeModel();
		try {
			List list = model.search(null, 1, 5);
			req.setAttribute("list", list);

			RequestDispatcher rd = req.getRequestDispatcher("CollegeListView.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
