package view;

import vo.Package;

public class TestCommodityView {

	public static void main(String args[]) {
		CommodityView t = new CommodityView();
		Package package1 = new Package();
		String[][] commoditySet = { 
				{ "�������չ��", "SR01", "100", "50", "60", "50", "70" },
				{ "��֥�չ��", "DZ02", "100", "50", "60", "50", "70" }, 
				{ "�������չ��", "SR02", "0", "50", "60", "0", "0" },
				{ "�������չ��", "SR03", "0", "50", "60", "0", "0" }, 
				{ "�������չ��", "SR04", "0", "50", "60", "0", "0" },
				{ "�������չ��", "SR06", "0", "50", "60", "0", "0" } };
		package1.setCommoditySet(commoditySet);
		t.setPackage(package1);
		t.run();
		System.out.println(t.getMessage() == "");
		t.setMessage("not find");
		t.clear();
		t.run();
	}
}
