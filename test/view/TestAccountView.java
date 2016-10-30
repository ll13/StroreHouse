package view;

import vo.Package;

public class TestAccountView {
	public static void main(String args[]) {
		AccountView t = new AccountView();
		Package package1 = new Package();
		String[][] AccountAllSet = { { "10000", "5000", "3000" } };
		String[][] AccountDetailSet = { { "2014/01/01", "ACCOUNT_IN", "·ÉÀûÆÖ", "100" },
				{ "2014/01/01", "ACCOUNT_OUT", "·ÉÀûÆÖ", "100" } };
		package1.setAccountAllSet(AccountAllSet);
		package1.setAccountDetailSet(AccountDetailSet);
		t.setPackage(package1);
		t.run();
		System.out.println(t.getMessage() == "");
		t.setMessage("not find");
		//t.clear();
		//t.run();
	}
}
