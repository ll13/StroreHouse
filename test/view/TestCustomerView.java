package view;

import vo.Package;

public class TestCustomerView {

	public static void main(String args[]) {
		CustomerView t = new CustomerView();
		Package package1 = new Package();
		String[][] CustomerSet = { 
				{"·ÉÀûÆÖ","13855558888","0","100","-100"},
				{"¶«Ö¥","13855558888","0","100","-100"}	 };
		package1.setCustomerSet(CustomerSet);
		t.setPackage(package1);
		t.run();
		System.out.println(t.getMessage() == "");
		t.setMessage("not find");
		//t.clear();
		//t.run();
	}
}
