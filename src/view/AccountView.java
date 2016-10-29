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

public class AccountView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Box tableBox, operationBox, guidenceBox, contentBox, basebox;
	Box box1, box2, box3;
	JButton login, stock, commodity, Import, export, customer, account;
	JTextField ACCOUNT_CUSTOMER, ACCOUNT_IN_MONEY, ACCOUNT_OUT_CUSTOMER, ACCOUNT_OUT_MONEY, ACCOUNT_INI_MONEY;
	JButton ACCOUNT_IN, ACCOUNT_OUT, ACCOUNT_ALL, ACCOUNT_DET, ACCOUNT_INI;
	String name = "";
	String occuption = "";
	Package Package=new Package();

	public void run(ClientController ActionListener) {
		guidenceBox = Box.createVerticalBox();
		operationBox = Box.createVerticalBox();
		contentBox = Box.createVerticalBox();
		tableBox = Box.createVerticalBox();
		basebox = Box.createHorizontalBox();

		login = new JButton("登录");
		stock = new JButton("库存");
		commodity = new JButton("商品");
		Import = new JButton("进货");
		export = new JButton("销售");
		customer = new JButton("客户");
		account = new JButton("账目");

		login.addActionListener(ActionListener);
		commodity.addActionListener(ActionListener);
		stock.addActionListener(ActionListener);
		Import.addActionListener(ActionListener);
		export.addActionListener(ActionListener);
		customer.addActionListener(ActionListener);
		account.addActionListener(ActionListener);

		guidenceBox.add(Box.createVerticalStrut(8));
		guidenceBox.add(login);
		guidenceBox.add(Box.createVerticalStrut(8));
		guidenceBox.add(commodity);
		guidenceBox.add(Box.createVerticalStrut(8));
		guidenceBox.add(stock);
		guidenceBox.add(Box.createVerticalStrut(8));
		guidenceBox.add(Import);
		guidenceBox.add(Box.createVerticalStrut(8));
		guidenceBox.add(export);
		guidenceBox.add(Box.createVerticalStrut(8));
		guidenceBox.add(customer);
		guidenceBox.add(Box.createVerticalStrut(8));
		guidenceBox.add(account);
		guidenceBox.add(Box.createVerticalStrut(8));

		Object[][] data_all = Package.getAccountAllSet();
		String[] line_all = { "账目总额", "应收总额", "应付总额" };
		JTable table_all = new JTable(data_all, line_all);
		table_all.setPreferredScrollableViewportSize(new Dimension(100, 30));
		JScrollPane scrollPane_all = new JScrollPane(table_all);

		Object[][] data_detail = Package.getAccountDetailSet();
		String[] line_detail = { "日期", "类型", "客户名称", "金额" };
		JTable table_detail = new JTable(data_detail, line_detail);
		table_all.setPreferredScrollableViewportSize(new Dimension(100, 50));
		JScrollPane scrollPane_detail = new JScrollPane(table_detail);

		tableBox.add(Box.createVerticalStrut(8));
		tableBox.add(scrollPane_all);
		tableBox.add(Box.createVerticalStrut(8));
		tableBox.add(scrollPane_detail);
		tableBox.add(Box.createVerticalStrut(8));

		ACCOUNT_IN = new JButton("创建收款单");
		ACCOUNT_OUT = new JButton("创建付款单");
		ACCOUNT_ALL = new JButton("查看总账目");
		ACCOUNT_DET = new JButton("查看具体账目");
		ACCOUNT_INI = new JButton("初始化账目");

		ACCOUNT_IN.addActionListener(ActionListener);
		ACCOUNT_OUT.addActionListener(ActionListener);
		ACCOUNT_ALL.addActionListener(ActionListener);
		ACCOUNT_DET.addActionListener(ActionListener);
		ACCOUNT_INI.addActionListener(ActionListener);

		ACCOUNT_CUSTOMER = new JTextField(15);
		ACCOUNT_IN_MONEY = new JTextField(15);
		ACCOUNT_OUT_CUSTOMER = new JTextField(15);
		ACCOUNT_OUT_MONEY = new JTextField(15);
		ACCOUNT_INI_MONEY = new JTextField(15);

		box1 = Box.createHorizontalBox();
		box2 = Box.createHorizontalBox();
		box3 = Box.createHorizontalBox();

		box1.add(Box.createHorizontalStrut(8));
		box1.add(ACCOUNT_IN);
		box1.add(new JLabel("客户"));
		box1.add(ACCOUNT_CUSTOMER);
		box1.add(new JLabel("金额"));
		box1.add(ACCOUNT_IN_MONEY);
		box1.add(Box.createHorizontalStrut(8));

		box2.add(Box.createHorizontalStrut(8));
		box2.add(ACCOUNT_OUT);
		box2.add(new JLabel("客户"));
		box2.add(ACCOUNT_OUT_CUSTOMER);
		box2.add(new JLabel("金额"));
		box2.add(ACCOUNT_OUT_MONEY);
		box2.add(Box.createHorizontalStrut(8));

		box3.add(Box.createHorizontalStrut(8));
		box3.add(ACCOUNT_ALL);
		box3.add(Box.createHorizontalStrut(8));
		box3.add(ACCOUNT_DET);
		box3.add(Box.createHorizontalStrut(8));
		box3.add(ACCOUNT_INI);
		box3.add(new JLabel("初始化金额"));
		box3.add(ACCOUNT_INI_MONEY);
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

		JLabel welcome=new JLabel("welcome"+" "+name+" "+occuption);
		add(welcome, BorderLayout.NORTH);
		add(basebox, BorderLayout.CENTER);
		this.setSize(600, 400);
		setTitle("账目");
		setVisible(true);
		setLocation(400, 250);
		
	}

	public JButton getLogin() {
		return login;
	}

	public JButton getStock() {
		return stock;
	}

	public JButton getCommodity() {
		return commodity;
	}

	public JButton getImport() {
		return Import;
	}

	public JButton getExport() {
		return export;
	}

	public JButton getCustomer() {
		return customer;
	}

	public JButton getAccount() {
		return account;
	}

	public String getACCOUNT_CUSTOMER() {
		return ACCOUNT_CUSTOMER.getText();
	}

	public String getACCOUNT_IN_MONEY() {
		return ACCOUNT_IN_MONEY.getText();
	}

	public String getACCOUNT_OUT_CUSTOMER() {
		return ACCOUNT_OUT_CUSTOMER.getText();
	}

	public String getACCOUNT_OUT_MONEY() {
		return ACCOUNT_OUT_MONEY.getText();
	}

	public String getACCOUNT_INI_MONEY() {
		return ACCOUNT_INI_MONEY.getText();
	}

	public JButton getACCOUNT_IN() {
		return ACCOUNT_IN;
	}

	public JButton getACCOUNT_OUT() {
		return ACCOUNT_OUT;
	}

	public JButton getACCOUNT_ALL() {
		return ACCOUNT_ALL;
	}

	public JButton getACCOUNT_DET() {
		return ACCOUNT_DET;
	}

	public JButton getACCOUNT_INI() {
		return ACCOUNT_INI;
	}

	public String getName() {
		return name;
	}

	public String getOccuption() {
		return occuption;
	}

	public void setLogin(JButton login) {
		this.login = login;
	}

	public void setStock(JButton stock) {
		this.stock = stock;
	}

	public void setCommodity(JButton commodity) {
		this.commodity = commodity;
	}

	public void setImport(JButton import1) {
		Import = import1;
	}

	public void setExport(JButton export) {
		this.export = export;
	}

	public void setCustomer(JButton customer) {
		this.customer = customer;
	}

	public void setAccount(JButton account) {
		this.account = account;
	}

	public void setACCOUNT_CUSTOMER(JTextField aCCOUNT_CUSTOMER) {
		ACCOUNT_CUSTOMER = aCCOUNT_CUSTOMER;
	}

	public void setACCOUNT_IN_MONEY(JTextField aCCOUNT_IN_MONEY) {
		ACCOUNT_IN_MONEY = aCCOUNT_IN_MONEY;
	}

	public void setACCOUNT_OUT_CUSTOMER(JTextField aCCOUNT_OUT_CUSTOMER) {
		ACCOUNT_OUT_CUSTOMER = aCCOUNT_OUT_CUSTOMER;
	}

	public void setACCOUNT_OUT_MONEY(JTextField aCCOUNT_OUT_MONEY) {
		ACCOUNT_OUT_MONEY = aCCOUNT_OUT_MONEY;
	}

	public void setACCOUNT_INI_MONEY(JTextField aCCOUNT_INI_MONEY) {
		ACCOUNT_INI_MONEY = aCCOUNT_INI_MONEY;
	}

	public void setACCOUNT_IN(JButton aCCOUNT_IN) {
		ACCOUNT_IN = aCCOUNT_IN;
	}

	public void setACCOUNT_OUT(JButton aCCOUNT_OUT) {
		ACCOUNT_OUT = aCCOUNT_OUT;
	}

	public void setACCOUNT_ALL(JButton aCCOUNT_ALL) {
		ACCOUNT_ALL = aCCOUNT_ALL;
	}

	public void setACCOUNT_DET(JButton aCCOUNT_DET) {
		ACCOUNT_DET = aCCOUNT_DET;
	}

	public void setACCOUNT_INI(JButton aCCOUNT_INI) {
		ACCOUNT_INI = aCCOUNT_INI;
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
	
	
	

}
