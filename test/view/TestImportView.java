package view;

import vo.Package;

public class TestImportView {
	public static void main(String args[]) {
		ImportView t = new ImportView();
		Package package1 = new Package();
		String[][] importSet = { 
				{ "2014/04/04","ADD","�ͻ�1","�������չ��","SR01","10","50","500"},	
				{"2014/04/04","DEL","�ͻ�1","�������չ��","SR01","10","50","500"},
				 };
		package1.setImportSet(importSet);
		t.setPackage(package1);
		t.run();
		System.out.println(t.getMessage() == "");
		t.setMessage("not find");
		//t.clear();
		//t.run();
	}
}
