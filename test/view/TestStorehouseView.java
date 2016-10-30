package view;

public class TestStorehouseView {
	public static void main(String args[]) {
		StorehouseView t = new StorehouseView();
		t.run();
		System.out.println(t.getMessage()=="");
		t.setMessage("not find");
	}
}
