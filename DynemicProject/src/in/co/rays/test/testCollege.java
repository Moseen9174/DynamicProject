package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.CollegeBean;
import in.co.rays.model.CollegeModel;

public class testCollege {
	public static void main(String[] args) throws Exception {
		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		testSearch();
		// testListSearch();
	}

	private static void testAdd() throws Exception {

		CollegeBean bean = new CollegeBean();
		bean.setId(1);
		bean.setName("Aman");
		bean.setAddress("vijay Nagar");
		bean.setState("MP");
		bean.setCity("Indore");
		bean.setPhoneNo("886867876");
		CollegeModel model = new CollegeModel();
		model.add(bean);
	}

	private static void testUpdate() throws Exception {
		CollegeBean bean = new CollegeBean();
		bean.setId(1);
		bean.setName("Rohan");
		bean.setAddress("Gandhi Nagar");
		bean.setState("MP");
		bean.setCity("Indore");
		bean.setPhoneNo("986867876");
		CollegeModel model = new CollegeModel();
		model.update(bean);
	}

	private static void testDelete() throws Exception {
		CollegeModel model = new CollegeModel();
		model.delete(2);

	}

	private static void testFindByPk() throws Exception {
		CollegeModel model = new CollegeModel();
		CollegeBean bean = model.FindByPk(1);
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getState());
			System.out.print("\t" + bean.getCity());
			System.out.println("\t" + bean.getPhoneNo());
		} else {
			System.out.println("number not found");
		}
	}

	private static void testSearch() throws Exception {
		CollegeBean bean = new CollegeBean();
		bean.setName("R");
		CollegeModel model = new CollegeModel();
		List list = model.search(bean, 0, 0);
		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (CollegeBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getState());
			System.out.print("\t" + bean.getCity());
			System.out.print("\t" + bean.getPhoneNo());

		}

	}

	private static void testListSearch() throws Exception {
		CollegeModel model = new CollegeModel();
		List list = model.listSearch();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			CollegeBean bean = (CollegeBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getState());
			System.out.print("\t" + bean.getCity());
			System.out.println("\t" + bean.getPhoneNo());
		}
	}
}
