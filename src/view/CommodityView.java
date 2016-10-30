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

public class CommodityView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Box tableBox, operationBox, guidenceBox, contentBox, basebox;
	Box box1, box2, box3, box4;
	JButton login, stock, commodity, Import, export, customer, account;
	JTextField COMMODITY_ADD_NAME, COMMODITY_ADD_TYPE, COMMODITY_ADD_MIP, COMMODITY_ADD_MEP, COMMODITY_DEL_NAME,
			COMMODITY_DEL_TYPE, COMMODITY_UPD_NAME, COMMODITY_UPD_TYPE, COMMODITY_UPD_MIP, COMMODITY_UPD_MEP,
			COMMODITY_FIN_NAME, COMMODITY_FIN_TYPE;

	JButton COMMODITY_ADD, COMMODITY_DEL, COMMODITY_UPD, COMMODITY_FIN, COMMODITY_SHO;
	String name = "";
	String occuption = "";
	JLabel welcome;
	JLabel message;
	Package Package = new Package();

	public CommodityView() {
		login = new JButton("登录");
		stock = new JButton("库存");
		commodity = new JButton("商品");
		Import = new JButton("进货");
		export = new JButton("销售");
		customer = new JButton("客户");
		account = new JButton("账目");

		COMMODITY_ADD = new JButton("增加");
		COMMODITY_DEL = new JButton("删除");
		COMMODITY_UPD = new JButton("更新");
		COMMODITY_FIN = new JButton("查找");
		COMMODITY_SHO = new JButton("显示");

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
		login.addActionListener(ActionListener);
		commodity.addActionListener(ActionListener);
		stock.addActionListener(ActionListener);
		Import.addActionListener(ActionListener);
		export.addActionListener(ActionListener);
		customer.addActionListener(ActionListener);
		account.addActionListener(ActionListener);

		COMMODITY_ADD.addActionListener(ActionListener);
		COMMODITY_DEL.addActionListener(ActionListener);
		COMMODITY_UPD.addActionListener(ActionListener);
		COMMODITY_FIN.addActionListener(ActionListener);
		COMMODITY_SHO.addActionListener(ActionListener);
	}

	public void run() {
		guidenceBox = Box.createVerticalBox();
		operationBox = Box.createVerticalBox();
		contentBox = Box.createVerticalBox();
		tableBox = Box.createVerticalBox();
		basebox = Box.createHorizontalBox();

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

		String[][] data = Package.getCommoditySet();
		String[] line = { "名称", "型号", "数量", "默认进价", "默认售价", "最近进价", "最近售价" };
		JTable table = new JTable(data, line);
		table.setPreferredScrollableViewportSize(new Dimension(200, 200));
		JScrollPane scrollPane = new JScrollPane(table);
		tableBox.add(Box.createVerticalStrut(8));
		tableBox.add(scrollPane);
		tableBox.add(Box.createVerticalStrut(8));

		COMMODITY_ADD_NAME = new JTextField(15);
		COMMODITY_ADD_TYPE = new JTextField(15);
		COMMODITY_ADD_MIP = new JTextField(15);
		COMMODITY_ADD_MEP = new JTextField(15);
		COMMODITY_DEL_NAME = new JTextField(15);
		COMMODITY_DEL_TYPE = new JTextField(15);
		COMMODITY_UPD_NAME = new JTextField(15);
		COMMODITY_UPD_TYPE = new JTextField(15);
		COMMODITY_UPD_MIP = new JTextField(15);
		COMMODITY_UPD_MEP = new JTextField(15);
		COMMODITY_FIN_NAME = new JTextField(15);
		COMMODITY_FIN_TYPE = new JTextField(15);

		box1 = Box.createHorizontalBox();
		box2 = Box.createHorizontalBox();
		box3 = Box.createHorizontalBox();
		box4 = Box.createHorizontalBox();

		box1.add(Box.createHorizontalStrut(8));
		box1.add(COMMODITY_ADD);
		box1.add(new JLabel("名称"));
		box1.add(COMMODITY_ADD_NAME);
		box1.add(new JLabel("型号"));
		box1.add(COMMODITY_ADD_TYPE);
		box1.add(new JLabel("默认进价"));
		box1.add(COMMODITY_ADD_MIP);
		box1.add(new JLabel("默认售价"));
		box1.add(COMMODITY_ADD_MEP);
		box1.add(Box.createHorizontalStrut(8));

		box2.add(Box.createHorizontalStrut(8));
		box2.add(COMMODITY_UPD);
		box2.add(new JLabel("名称"));
		box2.add(COMMODITY_UPD_NAME);
		box2.add(new JLabel("型号"));
		box2.add(COMMODITY_UPD_TYPE);
		box2.add(new JLabel("默认进价"));
		box2.add(COMMODITY_UPD_MIP);
		box2.add(new JLabel("默认售价"));
		box2.add(COMMODITY_UPD_MEP);
		box2.add(Box.createHorizontalStrut(8));

		box3.add(Box.createHorizontalStrut(8));
		box3.add(COMMODITY_DEL);
		box3.add(new JLabel("名称"));
		box3.add(COMMODITY_DEL_NAME);
		box3.add(new JLabel("型号"));
		box3.add(COMMODITY_DEL_TYPE);
		box3.add(Box.createHorizontalStrut(8));
		box3.add(COMMODITY_SHO);
		box3.add(Box.createHorizontalStrut(8));

		box4.add(Box.createHorizontalStrut(8));
		box4.add(COMMODITY_FIN);
		box4.add(new JLabel("名称"));
		box4.add(COMMODITY_FIN_NAME);
		box4.add(new JLabel("型号"));
		box4.add(COMMODITY_FIN_TYPE);
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
		
		this.setSize(650, 400);
		setTitle("商品");
		setVisible(true);
		setLocation(400, 250);

	}

	public JButton getLogin() {
		return login;
	}

	public void setLogin(JButton login) {
		this.login = login;
	}

	public JButton getStock() {
		return stock;
	}

	public void setStock(JButton stock) {
		this.stock = stock;
	}

	public JButton getCommodity() {
		return commodity;
	}

	public void setCommodity(JButton commodity) {
		this.commodity = commodity;
	}

	public JButton getImport() {
		return Import;
	}

	public void setImport(JButton import1) {
		Import = import1;
	}

	public JButton getExport() {
		return export;
	}

	public void setExport(JButton export) {
		this.export = export;
	}

	public JButton getCustomer() {
		return customer;
	}

	public void setCustomer(JButton customer) {
		this.customer = customer;
	}

	public JButton getAccount() {
		return account;
	}

	public void setAccount(JButton account) {
		this.account = account;
	}

	public String getCOMMODITY_ADD_NAME() {
		return COMMODITY_ADD_NAME.getText();
	}

	public void setCOMMODITY_ADD_NAME(JTextField cOMMODITY_ADD_NAME) {
		COMMODITY_ADD_NAME = cOMMODITY_ADD_NAME;
	}

	public String getCOMMODITY_ADD_TYPE() {
		return COMMODITY_ADD_TYPE.getText();
	}

	public void setCOMMODITY_ADD_TYPE(JTextField cOMMODITY_ADD_TYPE) {
		COMMODITY_ADD_TYPE = cOMMODITY_ADD_TYPE;
	}

	public String getCOMMODITY_ADD_MIP() {
		return COMMODITY_ADD_MIP.getText();
	}

	public void setCOMMODITY_ADD_MIP(JTextField cOMMODITY_ADD_MIP) {
		COMMODITY_ADD_MIP = cOMMODITY_ADD_MIP;
	}

	public String getCOMMODITY_ADD_MEP() {
		return COMMODITY_ADD_MEP.getText();
	}

	public void setCOMMODITY_ADD_MEP(JTextField cOMMODITY_ADD_MEP) {
		COMMODITY_ADD_MEP = cOMMODITY_ADD_MEP;
	}

	public String getCOMMODITY_DEL_NAME() {
		return COMMODITY_DEL_NAME.getText();
	}

	public void setCOMMODITY_DEL_NAME(JTextField cOMMODITY_DEL_NAME) {
		COMMODITY_DEL_NAME = cOMMODITY_DEL_NAME;
	}

	public String getCOMMODITY_DEL_TYPE() {
		return COMMODITY_DEL_TYPE.getText();
	}

	public void setCOMMODITY_DEL_TYPE(JTextField cOMMODITY_DEL_TYPE) {
		COMMODITY_DEL_TYPE = cOMMODITY_DEL_TYPE;
	}

	public String getCOMMODITY_UPD_NAME() {
		return COMMODITY_UPD_NAME.getText();
	}

	public void setCOMMODITY_UPD_NAME(JTextField cOMMODITY_UPD_NAME) {
		COMMODITY_UPD_NAME = cOMMODITY_UPD_NAME;
	}

	public String getCOMMODITY_UPD_TYPE() {
		return COMMODITY_UPD_TYPE.getText();
	}

	public void setCOMMODITY_UPD_TYPE(JTextField cOMMODITY_UPD_TYPE) {
		COMMODITY_UPD_TYPE = cOMMODITY_UPD_TYPE;
	}

	public String getCOMMODITY_UPD_MIP() {
		return COMMODITY_UPD_MIP.getText();
	}

	public void setCOMMODITY_UPD_MIP(JTextField cOMMODITY_UPD_MIP) {
		COMMODITY_UPD_MIP = cOMMODITY_UPD_MIP;
	}

	public String getCOMMODITY_UPD_MEP() {
		return COMMODITY_UPD_MEP.getText();
	}

	public void setCOMMODITY_UPD_MEP(JTextField cOMMODITY_UPD_MEP) {
		COMMODITY_UPD_MEP = cOMMODITY_UPD_MEP;
	}

	public String getCOMMODITY_FIN_NAME() {
		return COMMODITY_FIN_NAME.getText();
	}

	public void setCOMMODITY_FIN_NAME(JTextField cOMMODITY_FIN_NAME) {
		COMMODITY_FIN_NAME = cOMMODITY_FIN_NAME;
	}

	public String getCOMMODITY_FIN_TYPE() {
		return COMMODITY_FIN_TYPE.getText();
	}

	public void setCOMMODITY_FIN_TYPE(JTextField cOMMODITY_FIN_TYPE) {
		COMMODITY_FIN_TYPE = cOMMODITY_FIN_TYPE;
	}

	public JButton getCOMMODITY_ADD() {
		return COMMODITY_ADD;
	}

	public void setCOMMODITY_ADD(JButton cOMMODITY_ADD) {
		COMMODITY_ADD = cOMMODITY_ADD;
	}

	public JButton getCOMMODITY_DEL() {
		return COMMODITY_DEL;
	}

	public void setCOMMODITY_DEL(JButton cOMMODITY_DEL) {
		COMMODITY_DEL = cOMMODITY_DEL;
	}

	public JButton getCOMMODITY_UPD() {
		return COMMODITY_UPD;
	}

	public void setCOMMODITY_UPD(JButton cOMMODITY_UPD) {
		COMMODITY_UPD = cOMMODITY_UPD;
	}

	public JButton getCOMMODITY_FIN() {
		return COMMODITY_FIN;
	}

	public void setCOMMODITY_FIN(JButton cOMMODITY_FIN) {
		COMMODITY_FIN = cOMMODITY_FIN;
	}

	public JButton getCOMMODITY_SHO() {
		return COMMODITY_SHO;
	}

	public void setCOMMODITY_SHO(JButton cOMMODITY_SHO) {
		COMMODITY_SHO = cOMMODITY_SHO;
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
