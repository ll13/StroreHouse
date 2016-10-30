package view;

import vo.Package;

public class TestCommodityView {

	public static void main(String args[]) {
		CommodityView t = new CommodityView();
		Package package1 = new Package();
		String[][] commoditySet = { 
				{ "飞利浦日光灯", "SR01", "100", "50", "60", "50", "70" },
				{ "东芝日光灯", "DZ02", "100", "50", "60", "50", "70" }, 
				{ "飞利浦日光灯", "SR02", "0", "50", "60", "0", "0" },
				{ "飞利浦日光灯", "SR03", "0", "50", "60", "0", "0" }, 
				{ "飞利浦日光灯", "SR04", "0", "50", "60", "0", "0" },
				{ "飞利浦日光灯", "SR06", "0", "50", "60", "0", "0" } };
		package1.setCommoditySet(commoditySet);
		t.setPackage(package1);
		t.run();
		System.out.println(t.getMessage() == "");
		t.setMessage("not find");
		t.clear();
		t.run();
	}
}
