package view;
import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.ClientController;

public class LoginView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	Box box1, box2, box3,box4,basebox;
	JTextField name;
	JPasswordField psw;;
	JRadioButton stockmane;
	JRadioButton salesman;
	JRadioButton accountant;
	ButtonGroup occupation;
	JButton login_in,login_out;
	JLabel message;
	
	
	public LoginView(){
		login_in=new JButton("登录");
		login_out=new JButton("取消");
	    message=new JLabel();
		
	}
	public void addListener(ClientController ActionListener){
		
		login_in.addActionListener(ActionListener);
		login_out.addActionListener(ActionListener);
	}
	public void clear(){
		if(basebox!=null){
			remove(basebox);
			}
		if(message.getText()!=""){
			message.setText("");
		}		
		
	}
	public void run() {
		
		box1 = Box.createHorizontalBox();
		box2=Box.createHorizontalBox();
		box3 = Box.createHorizontalBox();
		box4=Box.createHorizontalBox();
		basebox=Box.createVerticalBox();
		name=new JTextField(15);
		psw=new JPasswordField(15);
		
		box1.add(Box.createHorizontalStrut(8));
		box1.add(new JLabel("姓名:"));
		box1.add(Box.createHorizontalStrut(8));
		box1.add(name);
		box1.add(Box.createHorizontalStrut(8));
		
		box2.add(Box.createHorizontalStrut(8));
		box2.add(new JLabel("密码:"));
		box2.add(Box.createHorizontalStrut(8));
		box2.add(psw);
		box2.add(Box.createHorizontalStrut(8));
		
		box3.add(Box.createHorizontalStrut(8));
		box3.add(new JLabel("职务:"));
		box3.add(Box.createHorizontalStrut(8));
		
		occupation=new ButtonGroup();
		stockmane=new JRadioButton("库存人员",true);
		salesman=new JRadioButton("销售人员");
		accountant=new JRadioButton("财务人员");
		occupation.add(salesman);
		occupation.add(stockmane);
		occupation.add(accountant);		
		box3.add(stockmane);
		box3.add(salesman);
		box3.add(accountant);		
		box3.add(Box.createHorizontalStrut(8));
		
		
		
		
		box4.add(Box.createHorizontalStrut(28));
		box4.add(login_in);
		box4.add(Box.createHorizontalStrut(88));
		box4.add(login_out);
		box4.add(Box.createHorizontalStrut(28));
        
		basebox.add(box1);
		basebox.add(Box.createVerticalStrut(10));
		basebox.add(box2);
		basebox.add(Box.createVerticalStrut(10));
		basebox.add(box3);
		basebox.add(Box.createVerticalStrut(10));
		basebox.add(box4);
		basebox.add(Box.createVerticalStrut(10));
		setTitle("login");
		add(basebox, BorderLayout.CENTER);
		add(message,BorderLayout.SOUTH);
		
		this.setSize(300,220);		
	    setVisible(true);
		setTitle("登录");
        setLocation(400, 250);
		
	}

	public JRadioButton getStockmane() {
		return stockmane;
	}

	public void setStockmane(JRadioButton store) {
		this.stockmane = store;
	}

	public JRadioButton getSalesman() {
		return salesman;
	}

	public void setSalesman(JRadioButton sale) {
		this.salesman = sale;
	}

	public JRadioButton getAccountant() {
		return accountant;
	}

	public void setAccountant(JRadioButton accountant) {
		this.accountant = accountant;
	}

	public String getName() {
		return name.getText();
	}

	public void setName(JTextField name) {
		this.name = name;
	}

	public char[] getPsw() {
		return psw.getPassword();
	}

	public void setPsw(JPasswordField psw) {
		this.psw = psw;
	}

	

	public JButton getLogin_in() {
		return login_in;
	}

	public void setLogin_in(JButton login_in) {
		this.login_in = login_in;
	}

	public JButton getLogin_out() {
		return login_out;
	}

	public void setLogin_out(JButton login_out) {
		this.login_out = login_out;
	}

	public String getMessage() {
		return message.getText();
	}

	public void setMessage(String message) {
		this.message.setText(message);;;
	}
  
	

	
}

