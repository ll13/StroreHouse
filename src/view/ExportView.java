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
public class ExportView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Box tableBox, operationBox, guidenceBox,contentBox,basebox;
	Box box1,box2,box3;
	JButton login,stock,commodity,Import,export,customer,account;
	JButton EXPORT_ADD,EXPORT_DEL,EXPORT_SHO;
	JTextField EXPORT_ADD_CUSTOMER,EXPORT_ADD_COMMODITY,EXPORT_ADD_COMTYPE,EXPORT_ADD_NUMBER,
	EXPORT_ADD_PRICE,EXPORT_DEL_CUSTOMER,EXPORT_DEL_COMMODITY,EXPORT_DEL_COMTYPE,
	EXPORT_DEL_NUMBER,EXPORT_DEL_PRICE,EXPORT_SHO_BEGINDATE,EXPORT_SHO_ENDDATE;
	String name="";
	String occuption="";
	Package Package=new Package();
	
	public void run(ClientController ActionListener){
		guidenceBox=Box.createVerticalBox();
		operationBox=Box.createVerticalBox();
		contentBox=Box.createVerticalBox();
		tableBox=Box.createVerticalBox();
		basebox=Box.createHorizontalBox();
		
		login=new JButton("��¼");
		 stock=new JButton("���");
		 commodity=new JButton("��Ʒ");
		 Import=new JButton("����");
		 export=new JButton("����");
		 customer=new JButton("�ͻ�");
		 account=new JButton("��Ŀ");
		 
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
		
		Object[][] data=Package.getExportSet();
          String[] line={"����","���˻�","�ͻ���","��Ʒ","�ͺ�","����","����","�ܼ�"};
        JTable table=new JTable(data,line);
        table.setPreferredScrollableViewportSize(new Dimension(200,200));
        JScrollPane scrollPane=new JScrollPane(table);   
		tableBox.add(Box.createVerticalStrut(8));
		tableBox.add(scrollPane);
		tableBox.add(Box.createVerticalStrut(8));
		
		EXPORT_ADD=new JButton("����������");
		EXPORT_DEL=new JButton("�����˻���");
		EXPORT_SHO=new JButton("�鿴����");
		
		EXPORT_ADD.addActionListener(ActionListener);
		EXPORT_DEL.addActionListener(ActionListener);
		EXPORT_SHO.addActionListener(ActionListener);
		
		EXPORT_ADD_CUSTOMER=new JTextField(15);
		EXPORT_ADD_COMMODITY=new JTextField(15);
		EXPORT_ADD_COMTYPE=new JTextField(15);
		EXPORT_ADD_NUMBER=new JTextField(15);
        EXPORT_ADD_PRICE=new JTextField(15);
        EXPORT_DEL_CUSTOMER=new JTextField(15);
        EXPORT_DEL_COMMODITY=new JTextField(15);
        EXPORT_DEL_COMTYPE=new JTextField(15);
        EXPORT_DEL_NUMBER=new JTextField(15);
        EXPORT_DEL_PRICE=new JTextField(15);
        EXPORT_SHO_BEGINDATE=new JTextField(15);
        EXPORT_SHO_ENDDATE=new JTextField(15);
		
		box1=Box.createHorizontalBox();
		box2=Box.createHorizontalBox();
		box3=Box.createHorizontalBox();
		
		box1.add(Box.createHorizontalStrut(8));
		box1.add(EXPORT_ADD);
		box1.add(new JLabel("�ͻ�"));
		box1.add(EXPORT_ADD_CUSTOMER);
		box1.add(new JLabel("��Ʒ����"));
		box1.add(EXPORT_ADD_COMMODITY);
		box1.add(new JLabel("�ͺ�"));
		box1.add(EXPORT_ADD_COMTYPE);
		box1.add(new JLabel("����"));
		box1.add(EXPORT_ADD_NUMBER);
		box1.add(new JLabel("����"));
		box1.add(EXPORT_ADD_PRICE);
		box1.add(Box.createHorizontalStrut(8));
		
		box2.add(Box.createHorizontalStrut(8));
		box2.add(EXPORT_DEL);
		box2.add(new JLabel("�ͻ�"));
		box2.add(EXPORT_DEL_CUSTOMER);
		box2.add(new JLabel("��Ʒ����"));
		box2.add(EXPORT_DEL_COMMODITY);
		box2.add(new JLabel("�ͺ�"));
		box2.add(EXPORT_DEL_COMTYPE);
		box2.add(new JLabel("����"));
		box2.add(EXPORT_DEL_NUMBER);
		box2.add(new JLabel("����"));
		box2.add(EXPORT_DEL_PRICE);
		box2.add(Box.createHorizontalStrut(8));

				
		box3.add(Box.createHorizontalStrut(8));
		box3.add(EXPORT_SHO);
		box3.add(new JLabel("��ʼ����"));
		box3.add(EXPORT_SHO_BEGINDATE);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(new JLabel("��������"));
		box3.add(EXPORT_SHO_ENDDATE);
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
        this.setSize(750,400);	
		setTitle("����");
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

	public JButton getEXPORT_ADD() {
		return EXPORT_ADD;
	}

	public void setEXPORT_ADD(JButton eXPORT_ADD) {
		EXPORT_ADD = eXPORT_ADD;
	}

	public JButton getEXPORT_DEL() {
		return EXPORT_DEL;
	}

	public void setEXPORT_DEL(JButton eXPORT_DEL) {
		EXPORT_DEL = eXPORT_DEL;
	}

	public JButton getEXPORT_SHO() {
		return EXPORT_SHO;
	}

	public void setEXPORT_SHO(JButton eXPORT_SHO) {
		EXPORT_SHO = eXPORT_SHO;
	}

	public String getEXPORT_ADD_CUSTOMER() {
		return EXPORT_ADD_CUSTOMER.getText();
	}

	public void setEXPORT_ADD_CUSTOMER(JTextField eXPORT_ADD_CUSTOMER) {
		EXPORT_ADD_CUSTOMER = eXPORT_ADD_CUSTOMER;
	}

	public String getEXPORT_ADD_COMMODITY() {
		return EXPORT_ADD_COMMODITY.getText();
	}

	public void setEXPORT_ADD_COMMODITY(JTextField eXPORT_ADD_COMMODITY) {
		EXPORT_ADD_COMMODITY = eXPORT_ADD_COMMODITY;
	}

	public String getEXPORT_ADD_COMTYPE() {
		return EXPORT_ADD_COMTYPE.getText();
	}

	public void setEXPORT_ADD_COMTYPE(JTextField eXPORT_ADD_COMTYPE) {
		EXPORT_ADD_COMTYPE = eXPORT_ADD_COMTYPE;
	}

	public String getEXPORT_ADD_NUMBER() {
		return EXPORT_ADD_NUMBER.getText();
	}

	public void setEXPORT_ADD_NUMBER(JTextField eXPORT_ADD_NUMBER) {
		EXPORT_ADD_NUMBER = eXPORT_ADD_NUMBER;
	}

	public String getEXPORT_ADD_PRICE() {
		return EXPORT_ADD_PRICE.getText();
	}

	public void setEXPORT_ADD_PRICE(JTextField eXPORT_ADD_PRICE) {
		EXPORT_ADD_PRICE = eXPORT_ADD_PRICE;
	}

	public String getEXPORT_DEL_CUSTOMER() {
		return EXPORT_DEL_CUSTOMER.getText();
	}

	public void setEXPORT_DEL_CUSTOMER(JTextField eXPORT_DEL_CUSTOMER) {
		EXPORT_DEL_CUSTOMER = eXPORT_DEL_CUSTOMER;
	}

	public String getEXPORT_DEL_COMMODITY() {
		return EXPORT_DEL_COMMODITY.getText();
	}

	public void setEXPORT_DEL_COMMODITY(JTextField eXPORT_DEL_COMMODITY) {
		EXPORT_DEL_COMMODITY = eXPORT_DEL_COMMODITY;
	}

	public String getEXPORT_DEL_COMTYPE() {
		return EXPORT_DEL_COMTYPE.getText();
	}

	public void setEXPORT_DEL_COMTYPE(JTextField eXPORT_DEL_COMTYPE) {
		EXPORT_DEL_COMTYPE = eXPORT_DEL_COMTYPE;
	}

	public String getEXPORT_DEL_NUMBER() {
		return EXPORT_DEL_NUMBER.getText();
	}

	public void setEXPORT_DEL_NUMBER(JTextField eXPORT_DEL_NUMBER) {
		EXPORT_DEL_NUMBER = eXPORT_DEL_NUMBER;
	}

	public String getEXPORT_DEL_PRICE() {
		return EXPORT_DEL_PRICE.getText();
	}

	public void setEXPORT_DEL_PRICE(JTextField eXPORT_DEL_PRICE) {
		EXPORT_DEL_PRICE = eXPORT_DEL_PRICE;
	}

	public String getEXPORT_SHO_BEGINDATE() {
		return EXPORT_SHO_BEGINDATE.getText();
	}

	public void setEXPORT_SHO_BEGINDATE(JTextField eXPORT_SHO_BEGINDATE) {
		EXPORT_SHO_BEGINDATE = eXPORT_SHO_BEGINDATE;
	}

	public String getEXPORT_SHO_ENDDATE() {
		return EXPORT_SHO_ENDDATE.getText();
	}

	public void setEXPORT_SHO_ENDDATE(JTextField eXPORT_SHO_ENDDATE) {
		EXPORT_SHO_ENDDATE = eXPORT_SHO_ENDDATE;
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
	
	
	
	
	
	
}



