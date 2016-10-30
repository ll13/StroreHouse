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
import vo.Package;
import controller.ClientController;

public class ImportView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Box tableBox, operationBox, guidenceBox, contentBox, basebox;
	Box box1, box2, box3;
	JButton IMPORT_ADD, IMPORT_DEL, IMPORT_SHO;
	JTextField IMPORT_ADD_CUSTOMER, IMPORT_ADD_COMMODITY, IMPORT_ADD_COMTYPE, IMPORT_ADD_NUMBER, IMPORT_ADD_PRICE,
			IMPORT_DEL_CUSTOMER, IMPORT_DEL_COMMODITY, IMPORT_DEL_COMTYPE, IMPORT_DEL_NUMBER, IMPORT_DEL_PRICE,
			IMPORT_SHO_BEGINDATE, IMPORT_SHO_ENDDATE;

	String name = "";
	String occuption = "";
	JLabel welcome;
	JLabel message;
	Package Package = new Package();


	public ImportView() {

		IMPORT_ADD = new JButton("创建进货单");
		IMPORT_DEL = new JButton("创建退货单");
		IMPORT_SHO = new JButton("查看单据");


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
		
	
		IMPORT_ADD.addActionListener(ActionListener);
		IMPORT_DEL.addActionListener(ActionListener);
		IMPORT_SHO.addActionListener(ActionListener);
	}

	public void run() {
		guidenceBox = Box.createVerticalBox();
		operationBox = Box.createVerticalBox();
		contentBox = Box.createVerticalBox();
		tableBox = Box.createVerticalBox();
		basebox = Box.createHorizontalBox();

		Object[][] data = Package.getImportSet();
		String[] line = { "日期", "进退货", "客户名", "商品", "型号", "数量", "单价", "总价" };
		JTable table = new JTable(data, line);
		table.setPreferredScrollableViewportSize(new Dimension(200, 200));
		JScrollPane scrollPane = new JScrollPane(table);
		tableBox.add(Box.createVerticalStrut(8));
		tableBox.add(scrollPane);
		tableBox.add(Box.createVerticalStrut(8));

		IMPORT_ADD_CUSTOMER = new JTextField(15);
		IMPORT_ADD_COMMODITY = new JTextField(15);
		IMPORT_ADD_COMTYPE = new JTextField(15);
		IMPORT_ADD_NUMBER = new JTextField(15);
		IMPORT_ADD_PRICE = new JTextField(15);
		IMPORT_DEL_CUSTOMER = new JTextField(15);
		IMPORT_DEL_COMMODITY = new JTextField(15);
		IMPORT_DEL_COMTYPE = new JTextField(15);
		IMPORT_DEL_NUMBER = new JTextField(15);
		IMPORT_DEL_PRICE = new JTextField(15);
		IMPORT_SHO_BEGINDATE = new JTextField(15);
		IMPORT_SHO_ENDDATE = new JTextField(15);

		box1 = Box.createHorizontalBox();
		box2 = Box.createHorizontalBox();
		box3 = Box.createHorizontalBox();

		box1.add(Box.createHorizontalStrut(8));
		box1.add(IMPORT_ADD);
		box1.add(new JLabel("客户"));
		box1.add(IMPORT_ADD_CUSTOMER);
		box1.add(new JLabel("商品名称"));
		box1.add(IMPORT_ADD_COMMODITY);
		box1.add(new JLabel("型号"));
		box1.add(IMPORT_ADD_COMTYPE);
		box1.add(new JLabel("数量"));
		box1.add(IMPORT_ADD_NUMBER);
		box1.add(new JLabel("单价"));
		box1.add(IMPORT_ADD_PRICE);
		box1.add(Box.createHorizontalStrut(8));

		box2.add(Box.createHorizontalStrut(8));
		box2.add(IMPORT_DEL);
		box2.add(new JLabel("客户"));
		box2.add(IMPORT_DEL_CUSTOMER);
		box2.add(new JLabel("商品名称"));
		box2.add(IMPORT_DEL_COMMODITY);
		box2.add(new JLabel("型号"));
		box2.add(IMPORT_DEL_COMTYPE);
		box2.add(new JLabel("数量"));
		box2.add(IMPORT_DEL_NUMBER);
		box2.add(new JLabel("单价"));
		box2.add(IMPORT_DEL_PRICE);
		box2.add(Box.createHorizontalStrut(8));

		box3.add(Box.createHorizontalStrut(8));
		box3.add(IMPORT_SHO);
		box3.add(new JLabel("开始日期"));
		box3.add(IMPORT_SHO_BEGINDATE);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(new JLabel("结束日期"));
		box3.add(IMPORT_SHO_ENDDATE);
		box3.add(Box.createHorizontalStrut(8));

		operationBox.add(box1);
		operationBox.add(box2);
		operationBox.add(box3);

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
		this.setSize(800, 400);
		setTitle("进货");
		setVisible(true);
		setLocation(400, 250);

	}

	

	public JButton getIMPORT_ADD() {
		return IMPORT_ADD;
	}

	public void setIMPORT_ADD(JButton iMPORT_ADD) {
		IMPORT_ADD = iMPORT_ADD;
	}

	public JButton getIMPORT_DEL() {
		return IMPORT_DEL;
	}

	public void setIMPORT_DEL(JButton iMPORT_DEL) {
		IMPORT_DEL = iMPORT_DEL;
	}

	public JButton getIMPORT_SHO() {
		return IMPORT_SHO;
	}

	public void setIMPORT_SHO(JButton iMPORT_SHO) {
		IMPORT_SHO = iMPORT_SHO;
	}

	public String getIMPORT_ADD_CUSTOMER() {
		return IMPORT_ADD_CUSTOMER.getText();
	}

	public void setIMPORT_ADD_CUSTOMER(JTextField iMPORT_ADD_CUSTOMER) {
		IMPORT_ADD_CUSTOMER = iMPORT_ADD_CUSTOMER;
	}

	public String getIMPORT_ADD_COMMODITY() {
		return IMPORT_ADD_COMMODITY.getText();
	}

	public void setIMPORT_ADD_COMMODITY(JTextField iMPORT_ADD_COMMODITY) {
		IMPORT_ADD_COMMODITY = iMPORT_ADD_COMMODITY;
	}

	public String getIMPORT_ADD_COMTYPE() {
		return IMPORT_ADD_COMTYPE.getText();
	}

	public void setIMPORT_ADD_COMTYPE(JTextField iMPORT_ADD_COMTYPE) {
		IMPORT_ADD_COMTYPE = iMPORT_ADD_COMTYPE;
	}

	public String getIMPORT_ADD_NUMBER() {
		return IMPORT_ADD_NUMBER.getText();
	}

	public void setIMPORT_ADD_NUMBER(JTextField iMPORT_ADD_NUMBER) {
		IMPORT_ADD_NUMBER = iMPORT_ADD_NUMBER;
	}

	public String getIMPORT_ADD_PRICE() {
		return IMPORT_ADD_PRICE.getText();
	}

	public void setIMPORT_ADD_PRICE(JTextField iMPORT_ADD_PRICE) {
		IMPORT_ADD_PRICE = iMPORT_ADD_PRICE;
	}

	public String getIMPORT_DEL_CUSTOMER() {
		return IMPORT_DEL_CUSTOMER.getText();
	}

	public void setIMPORT_DEL_CUSTOMER(JTextField iMPORT_DEL_CUSTOMER) {
		IMPORT_DEL_CUSTOMER = iMPORT_DEL_CUSTOMER;
	}

	public String getIMPORT_DEL_COMMODITY() {
		return IMPORT_DEL_COMMODITY.getText();
	}

	public void setIMPORT_DEL_COMMODITY(JTextField iMPORT_DEL_COMMODITY) {
		IMPORT_DEL_COMMODITY = iMPORT_DEL_COMMODITY;
	}

	public String getIMPORT_DEL_COMTYPE() {
		return IMPORT_DEL_COMTYPE.getText();
	}

	public void setIMPORT_DEL_COMTYPE(JTextField iMPORT_DEL_COMTYPE) {
		IMPORT_DEL_COMTYPE = iMPORT_DEL_COMTYPE;
	}

	public String getIMPORT_DEL_NUMBER() {
		return IMPORT_DEL_NUMBER.getText();
	}

	public void setIMPORT_DEL_NUMBER(JTextField iMPORT_DEL_NUMBER) {
		IMPORT_DEL_NUMBER = iMPORT_DEL_NUMBER;
	}

	public String getIMPORT_DEL_PRICE() {
		return IMPORT_DEL_PRICE.getText();
	}

	public void setIMPORT_DEL_PRICE(JTextField iMPORT_DEL_PRICE) {
		IMPORT_DEL_PRICE = iMPORT_DEL_PRICE;
	}

	public String getIMPORT_SHO_BEGINDATE() {
		return IMPORT_SHO_BEGINDATE.getText();
	}

	public void setIMPORT_SHO_BEGINDATE(JTextField iMPORT_SHO_BEGINDATE) {
		IMPORT_SHO_BEGINDATE = iMPORT_SHO_BEGINDATE;
	}

	public String getIMPORT_SHO_ENDDATE() {
		return IMPORT_SHO_ENDDATE.getText();
	}

	public void setIMPORT_SHO_ENDDATE(JTextField iMPORT_SHO_ENDDATE) {
		IMPORT_SHO_ENDDATE = iMPORT_SHO_ENDDATE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccuption() {
		return occuption;
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
