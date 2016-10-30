package view;

import vo.Package;

public class TestStockView {
	public static void main(String args[]) {
		StockView t = new StockView();
		Package package1 = new Package();
		String[][] stockSet = { 
				{ "∑…¿˚∆÷»’π‚µ∆","SR01","60","10","600","50","15","750","10","10","100" },
				 };
		package1.setStockSet(stockSet);
		t.setPackage(package1);
		t.run();
		System.out.println(t.getMessage() == "");
		t.setMessage("not find");
		t.clear();
		t.run();
	}
}
