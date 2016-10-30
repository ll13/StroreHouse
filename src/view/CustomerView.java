package view;

import javax.swing.Box;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.ClientController;
import vo.Package;

public class CustomerView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Box tableBox, operationBox, guidenceBox, contentBox, basebox;
	Box box1, box2, box3, box4;
	JTextField CUSTOMER_ADD_NAME, CUSTOMER_ADD_TEL, CUSTOMER_DEL_NAME, CUSTOMER_UPD_NAME, CUSTOMER_UPD_TEL,
			CUSTOMER_FIN_NAME;
	JButton CUSTOMER_ADD, CUSTOMER_DEL, CUSTOMER_UPD, CUSTOMER_FIN, CUSTOMER_SHO;
	String name = "";
	String occuption = "";
	JLabel welcome;
	JLabel message;
	Package Package = new Package();

	public CustomerView() {
	

		CUSTOMER_ADD = new JButton("增加");
		CUSTOMER_DEL = new JButton("删除");
		CUSTOMER_UPD = new JButton("更新");
		CUSTOMER_FIN = new JButton("查找");
		CUSTOMER_SHO = new JButton("显示");

		welcome = new JLabel();
		message = new JLabel();

	}

	public void clear() {
		if (basebox != null) {
			remove(basebox);
		}
		if (message.getText() != "") {
			message.setText("");
		}
		if (welcome.getText() != "") {
			welcome.setText("");
		}

	}

	public void addListener(ClientController ActionListener) {
		
		CUSTOMER_ADD.addActionListener(ActionListener);
		CUSTOMER_DEL.addActionListener(ActionListener);
		CUSTOMER_UPD.addActionListener(ActionListener);
		CUSTOMER_FIN.addActionListener(ActionListener);
		CUSTOMER_SHO.addActionListener(ActionListener);
	}

	public void run() {
		guidenceBox = Box.createVerticalBox();
		operationBox = Box.createVerticalBox();
		contentBox = Box.createVerticalBox();
		tableBox = Box.createVerticalBox();
		basebox = Box.createHorizontalBox();

		Object[][] data = Package.getCustomerSet();

		String[] line = { "客户名称", "联系方式", "应收金额", "应付金额", "合计" };
		JTable table = new JTable(data, line);
		table.setPreferredScrollableViewportSize(new Dimension(200, 200));
		JScrollPane scrollPane = new JScrollPane(table);
		tableBox.add(Box.createVerticalStrut(8));
		tableBox.add(scrollPane);
		tableBox.add(Box.createVerticalStrut(8));

		CUSTOMER_ADD_NAME = new JTextField(15);
		CUSTOMER_ADD_TEL = new JTextField(15);
		CUSTOMER_DEL_NAME = new JTextField(15);
		CUSTOMER_UPD_NAME = new JTextField(15);
		CUSTOMER_UPD_TEL = new JTextField(15);
		CUSTOMER_FIN_NAME = new JTextField(15);

		box1 = Box.createHorizontalBox();
		box2 = Box.createHorizontalBox();
		box3 = Box.createHorizontalBox();
		box4 = Box.createHorizontalBox();

		box1.add(Box.createHorizontalStrut(8));
		box1.add(CUSTOMER_ADD);
		box1.add(new JLabel("客户名称"));
		box1.add(CUSTOMER_ADD_NAME);
		box1.add(new JLabel("联系方式"));
		box1.add(CUSTOMER_ADD_TEL);
		box1.add(Box.createHorizontalStrut(8));

		box2.add(Box.createHorizontalStrut(8));
		box2.add(CUSTOMER_UPD);
		box2.add(new JLabel("客户名称"));
		box2.add(CUSTOMER_UPD_NAME);
		box2.add(new JLabel("联系方式"));
		box2.add(CUSTOMER_UPD_TEL);
		box2.add(Box.createHorizontalStrut(8));

		box3.add(Box.createHorizontalStrut(8));
		box3.add(CUSTOMER_DEL);
		box3.add(new JLabel("客户名称"));
		box3.add(CUSTOMER_DEL_NAME);
		box3.add(Box.createHorizontalStrut(8));
		box3.add(CUSTOMER_SHO);
		box3.add(Box.createHorizontalStrut(8));

		box4.add(Box.createHorizontalStrut(8));
		box4.add(CUSTOMER_FIN);
		box4.add(new JLabel("客户名称"));
		box4.add(CUSTOMER_FIN_NAME);
		box4.add(Box.createHorizontalStrut(8));

		operationBox.add(box1);
		operationBox.add(box2);
		operationBox.add(box3);
		operationBox.add(box4);

		contentBox.add(Box.createVerticalStrut(8));
		contentBox.add(tableBox);
		contentBox.add(Box.createVerticalStrut(8));
		contentBox.add(operationBox);
		contentBox.add(Box.createVerticalStrut(8));

		basebox.add(Box.createHorizontalStrut(8));
		basebox.add(guidenceBox);
		basebox.add(Box.createHorizontalStrut(8));
		basebox.add(contentBox);
		basebox.add(Box.createHorizontalStrut(8));
		welcome.setText("welcome"+" "+name+" "+occuption);
		add(welcome, BorderLayout.NORTH);
        add(basebox, BorderLayout.CENTER);
        add(message,BorderLayout.SOUTH);
		
		this.setSize(600, 400);
		setTitle("客户");
		setVisible(true);
		setLocation(400, 250);

	}

	
	public String getCUSTOMER_ADD_NAME() {
		return CUSTOMER_ADD_NAME.getText();
	}

	public String getCUSTOMER_ADD_TEL() {
		return CUSTOMER_ADD_TEL.getText();
	}

	public String getCUSTOMER_DEL_NAME() {
		return CUSTOMER_DEL_NAME.getText();
	}

	public String getCUSTOMER_UPD_NAME() {
		return CUSTOMER_UPD_NAME.getText();
	}

	public String getCUSTOMER_UPD_TEL() {
		return CUSTOMER_UPD_TEL.getText();
	}

	public String getCUSTOMER_FIN_NAME() {
		return CUSTOMER_FIN_NAME.getText();
	}

	public JButton getCUSTOMER_ADD() {
		return CUSTOMER_ADD;
	}

	public JButton getCUSTOMER_DEL() {
		return CUSTOMER_DEL;
	}

	public JButton getCUSTOMER_UPD() {
		return CUSTOMER_UPD;
	}

	public JButton getCUSTOMER_FIN() {
		return CUSTOMER_FIN;
	}

	public JButton getCUSTOMER_SHO() {
		return CUSTOMER_SHO;
	}

	public String getName() {
		return name;
	}

	public String getOccuption() {
		return occuption;
	}

	

	public void setCUSTOMER_ADD_NAME(JTextField cUSTOMER_ADD_NAME) {
		CUSTOMER_ADD_NAME = cUSTOMER_ADD_NAME;
	}

	public void setCUSTOMER_ADD_TEL(JTextField cUSTOMER_ADD_TEL) {
		CUSTOMER_ADD_TEL = cUSTOMER_ADD_TEL;
	}

	public void setCUSTOMER_DEL_NAME(JTextField cUSTOMER_DEL_NAME) {
		CUSTOMER_DEL_NAME = cUSTOMER_DEL_NAME;
	}

	public void setCUSTOMER_UPD_NAME(JTextField cUSTOMER_UPD_NAME) {
		CUSTOMER_UPD_NAME = cUSTOMER_UPD_NAME;
	}

	public void setCUSTOMER_UPD_TEL(JTextField cUSTOMER_UPD_TEL) {
		CUSTOMER_UPD_TEL = cUSTOMER_UPD_TEL;
	}

	public void setCUSTOMER_FIN_NAME(JTextField cUSTOMER_FIN_NAME) {
		CUSTOMER_FIN_NAME = cUSTOMER_FIN_NAME;
	}

	public void setCUSTOMER_ADD(JButton cUSTOMER_ADD) {
		CUSTOMER_ADD = cUSTOMER_ADD;
	}

	public void setCUSTOMER_DEL(JButton cUSTOMER_DEL) {
		CUSTOMER_DEL = cUSTOMER_DEL;
	}

	public void setCUSTOMER_UPD(JButton cUSTOMER_UPD) {
		CUSTOMER_UPD = cUSTOMER_UPD;
	}

	public void setCUSTOMER_FIN(JButton cUSTOMER_FIN) {
		CUSTOMER_FIN = cUSTOMER_FIN;
	}

	public void setCUSTOMER_SHO(JButton cUSTOMER_SHO) {
		CUSTOMER_SHO = cUSTOMER_SHO;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOccuption(String occuption) {
		this.occuption = occuption;
	}

	public Package getPackage() {
		return Package;
	}

	public void setPackage(Package package1) {
		Package = package1;
	}
	public String getWelcome() {
		return welcome.getText();
	}

	public void setWelcome(String welcome) {
		this.welcome.setText(welcome);;
	}

	public String getMessage() {
		return message.getText();
	}

	public void setMessage(String message) {
		this.message.setText(message);
	}
}
