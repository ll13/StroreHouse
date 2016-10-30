package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import remote.Client;
import view.*;
import vo.Package;

public class ClientController implements ActionListener {
	Client client = new Client();
	Package package1 = new Package();
	String name, occupation;

	StorehouseView storehouseview = new StorehouseView();
	LoginView loginview = new LoginView();
	CommodityView commodityview = new CommodityView();
	StockView stockview = new StockView();
	ImportView importview = new ImportView();
	ExportView exportview = new ExportView();
	CustomerView customerview = new CustomerView();
	AccountView accountview = new AccountView();

	public void init() {
		storehouseview.addListener(this);
		storehouseview.run();
		loginview.addListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource().equals(storehouseview.getLogin())) {
			
			loginview.run();
			loginview.setVisible(true);

		}
		
		if (event.getSource().equals(loginview.getLogin_in())) {
			
            
		}
		if (event.getSource().equals(loginview.getLogin_out())) {
			loginview.setVisible(false);
		}

	}
    public void login_in(){
    	//send data
    	String occupation = "";
		if (loginview.getAccountant().isSelected()) {
			occupation = "accountant";

		} else {
			if (loginview.getSalesman().isSelected()) {
				occupation = "salesman";

			} else {
				occupation = "stockmane";
			}
		}
		String operation = "login_in" + "/" + loginview.getName() + ";" + new String(loginview.getPsw()) + ";"
				+ occupation;
		package1.setOperation(operation);
		client.sendData(package1);
		
		//get data
		package1=client.getData();
        if(package1.getResult().equals("find")){
        	name=loginview.getName();
        	this.occupation=occupation;
        	
        	loginview.setVisible(false);
        	storehouseview.setName(name);
        	storehouseview.setOccuption(this.occupation);
        	storehouseview.run();       	       	
        }
        if(package1.getResult().equals("not find")){
        	        	
        	loginview.setMessage("not find");      	       	
        }
    }
	public static void main(String[] args) {
		
		ClientController ccon = new ClientController();
        ccon.init();
	}

}
