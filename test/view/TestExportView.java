package view;

import vo.Package;

public class TestExportView {

	public static void main(String args[]) {
		ExportView t = new ExportView();
		Package package1 = new Package();
		String[][] ExportSet = { 
				{ "2014/05/04","ADD","�ͻ�1","�������չ��","SR01","10","50","500"},	
				{"2014/05/04","DEL","�ͻ�1","�������չ��","SR01","10","50","500"},
				 };
		package1.setExportSet(ExportSet);
		t.setPackage(package1);
		t.run();
		System.out.println(t.getMessage() == "");
		t.setMessage("not find");
		//t.clear();
		//t.run();
	}
}
