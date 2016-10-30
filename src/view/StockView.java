package view;

import javax.swing.Box;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import vo.Package;
import controller.ClientController;

public class StockView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Box tableBox, operationBox, guidenceBox, contentBox, basebox;
	JButton STOCK_SHO;
	String name = "";
	String occuption = "";
	JLabel welcome;
	JLabel message;
	Package Package = new Package();

	public StockView() {

		STOCK_SHO = new JButton("��ʾ");

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
		STOCK_SHO.addActionListener(ActionListener);
	}

	public void run() {
		guidenceBox = Box.createVerticalBox();
		operationBox = Box.createVerticalBox();
		contentBox = Box.createVerticalBox();
		tableBox = Box.createVerticalBox();
		basebox = Box.createHorizontalBox();

		String[][] data = Package.getStockSet();
		String[] line = { "����", "�ͺ�", "��������", "����ƽ������", "�����ܼ�", "��������", "����ƽ������", "�����ܼ�", "�������", "���ƽ������", "����ܼ�" };

		JTable table = new JTable(data, line);
		table.setPreferredScrollableViewportSize(new Dimension(900, 200));
		JScrollPane scrollPane = new JScrollPane(table);
		tableBox.add(Box.createVerticalStrut(8));
		tableBox.add(scrollPane);
		tableBox.add(Box.createVerticalStrut(8));

		operationBox.add(Box.createHorizontalStrut(80));
		operationBox.add(STOCK_SHO);
		operationBox.add(Box.createHorizontalStrut(80));

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

		welcome.setText("welcome" + " " + name + " " + occuption);
		add(welcome, BorderLayout.NORTH);
		add(basebox, BorderLayout.CENTER);
		add(message, BorderLayout.SOUTH);
		this.setSize(800, 350);
		setTitle("���");
		setVisible(true);
		setLocation(400, 250);

	}

	public JButton getSTOCK_SHO() {
		return STOCK_SHO;
	}

	public void setSTOCK_SHO(JButton sTOCK_SHO) {
		STOCK_SHO = sTOCK_SHO;
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
		this.welcome.setText(welcome);
		;
	}

	public String getMessage() {
		return message.getText();
	}

	public void setMessage(String message) {
		this.message.setText(message);
	}

}
