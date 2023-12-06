package in.co.rays.test;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class testUser {

	public static void main(String[] args) throws Exception {
		// testadd();
		// testupdate();
		// testdelete();
		// testFindByPK();
		// testListSearch();
		//testauthenticate();
	}

	static String date = "1999-11-23";
	static SimpleDateFormat sql = new SimpleDateFormat("yyyy-MM-dd");

	private static void testadd() throws Exception {

		UserBean bean = new UserBean();
		bean.setId(1);
		bean.setFirstName("Abhishek");
		bean.setLastName("tiwari");
		bean.setLoginId("abhishek@gmail");
		bean.setPassword("1234");
		bean.setDob(sql.parse(date));
		bean.setAddress("indore");
		UserModel model = new UserModel();
		model.add1(bean);

	}

	private static void testupdate() throws Exception {
		UserBean bean = new UserBean();
		bean.setId(2);
		bean.setFirstName("Sohan");
		bean.setLastName("sharma");
		bean.setLoginId("Mohan@gmail");
		bean.setPassword("1234");
		bean.setDob(sql.parse(date));
		bean.setAddress("indore");
		UserModel model = new UserModel();
		model.update(bean);
	}

	private static void testFindByPK() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = model.findByPk(1);
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getDob());
			System.out.print("\t" + bean.getAddress());
		} else {
			System.out.println("no number found");
		}
	}

	private static void testListSearch() throws Exception {
		UserModel model = new UserModel();
		List list = model.listSearch();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			UserBean bean = (UserBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getDob());
			System.out.print("\t" + bean.getAddress());
		}
	}

	/*
	 * private static void testauthenticate() throws Exception { UserModel model =
	 * new UserModel(); UserBean bean = model.authenticate("abhishek@gmail", 1234);
	 * if (bean != null) { System.out.print(bean.getId()); System.out.print("\t" +
	 * bean.getFirstName()); System.out.print("\t" + bean.getLastName());
	 * System.out.print("\t" + bean.getLoginId()); System.out.print("\t" +
	 * bean.getPassword()); System.out.println("\t" + bean.getDob());
	 * System.out.print("\t" + bean.getAddress()); } else {
	 * System.out.println("no number found"); } }
	 */
}
