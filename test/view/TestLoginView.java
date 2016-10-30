package view;

public class TestLoginView {

	public static void main(String args[]) {
		LoginView lv = new LoginView();
		lv.run();
		System.out.println(lv.getMessage()=="");
		lv.setMessage("not find");
	}

}
