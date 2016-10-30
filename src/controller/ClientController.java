package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import remote.Client;
import view.*;
import vo.Package;

public class ClientController implements ActionListener {
	Client client;
	Package package1;
	String name, occupation;

	StorehouseView storehouseview;
	LoginView loginview;
	CommodityView commodityview;
	StockView stockview;
	ImportView importview;
	ExportView exportview;
	CustomerView customerview;
	AccountView accountview;

	public ClientController() {
		storehouseview = new StorehouseView();
		loginview = new LoginView();
		commodityview = new CommodityView();
		stockview = new StockView();
		importview = new ImportView();
		exportview = new ExportView();
		customerview = new CustomerView();
		accountview = new AccountView();
		client = new Client();
		package1 = new Package();

	}

	public void begin() {
		storehouseview.run();
	}

	public void addListener() {
		storehouseview.addListener(this);
		loginview.addListener(this);
		commodityview.addListener(this);
		stockview.addListener(this);
		importview.addListener(this);
		exportview.addListener(this);
		customerview.addListener(this);
		accountview.addListener(this);

	}

	public void actionPerformed(ActionEvent event) {

		if (event.getSource().equals(storehouseview.getLogin())) {
			loginview.clear();
			loginview.run();

		} else if (event.getSource().equals(loginview.getLogin_in())) {
			login_in();
		} else if (event.getSource().equals(loginview.getLogin_out())) {
			login_out();
		} else if (event.getSource().equals(storehouseview.getCommodity())) {
			if (package1.getCommoditySet() != null) {
				commodityview.clear();
				commodityview.run();
			}
		} else if (event.getSource().equals(commodityview.getCOMMODITY_ADD())) {
			commodity_add();
		} else if (event.getSource().equals(commodityview.getCOMMODITY_DEL())) {
			commodity_del();
		} else if (event.getSource().equals(commodityview.getCOMMODITY_UPD())) {
			commodity_upd();
		} else if (event.getSource().equals(commodityview.getCOMMODITY_FIN())) {
			commodity_fin();
		} else if (event.getSource().equals(commodityview.getCOMMODITY_SHO())) {
			commodity_sho();
		} else if (event.getSource().equals(storehouseview.getStock())) {
			if (package1.getStockSet() != null) {
				stockview.clear();
				stockview.run();
			}

		} else if (event.getSource().equals(stockview.getSTOCK_SHO())) {
			stock_sho();
		} else if (event.getSource().equals(storehouseview.getImport())) {
			if (package1.getImportSet() != null) {
				importview.clear();
				importview.run();
			}

		} else if (event.getSource().equals(importview.getIMPORT_ADD())) {
			import_add();
		} else if (event.getSource().equals(importview.getIMPORT_DEL())) {
			import_del();
		} else if (event.getSource().equals(importview.getIMPORT_SHO())) {
			import_sho();
		} else if (event.getSource().equals(storehouseview.getExport())) {
			if (package1.getExportSet() != null) {
				exportview.clear();
				exportview.run();
			}

		} else if (event.getSource().equals(exportview.getEXPORT_ADD())) {
			export_add();
		} else if (event.getSource().equals(exportview.getEXPORT_DEL())) {
			export_del();
		} else if (event.getSource().equals(exportview.getEXPORT_SHO())) {
			export_sho();
		} else if (event.getSource().equals(storehouseview.getCustomer())) {
			if (package1.getCustomerSet() != null) {
				customerview.clear();
				customerview.run();
			}

		} else if (event.getSource().equals(customerview.getCUSTOMER_ADD())) {
			customer_add();
		} else if (event.getSource().equals(customerview.getCUSTOMER_DEL())) {
			customer_del();
		} else if (event.getSource().equals(customerview.getCUSTOMER_UPD())) {
			customer_upd();
		} else if (event.getSource().equals(customerview.getCUSTOMER_FIN())) {
			customer_fin();
		} else if (event.getSource().equals(customerview.getCUSTOMER_SHO())) {
			customer_sho();
		} else if (event.getSource().equals(storehouseview.getAccount())) {
			if (package1.getAccountAllSet() != null) {
				accountview.clear();
				accountview.run();
			}
		} else if (event.getSource().equals(accountview.getACCOUNT_IN())) {
			account_in();
		} else if (event.getSource().equals(accountview.getACCOUNT_OUT())) {
			account_out();
		} else if (event.getSource().equals(accountview.getACCOUNT_ALL())) {
			account_all();
		} else if (event.getSource().equals(accountview.getACCOUNT_DET())) {
			account_det();
		} else if (event.getSource().equals(accountview.getACCOUNT_INI())) {
			account_ini();
		}

	}

	public void login_in() {
		// send data
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
		String operation = "login_in" + "/" + loginview.getName() + ";"
				+ new String(loginview.getPsw()) + ";" + occupation;
		package1.setOperation(operation);
		client.sendData(package1);

		// get data
		package1 = client.getData();
		if (package1.getResult().equals("find")) {
			
			name = package1.getIdSet()[0][0];
			this.occupation = package1.getIdSet()[0][2];
			loginview.setVisible(false);

			storehouseview.setName(name);
			storehouseview.setOccuption(this.occupation);
			storehouseview.clear();
			storehouseview.setMessage("login success");
			storehouseview.run();

			if (this.occupation.equals("stockmane")) {
				commodityview.setPackage(package1);
				commodityview.setName(name);
				commodityview.setOccuption(this.occupation);
				stockview.setPackage(package1);
				stockview.setName(name);
				stockview.setOccuption(this.occupation);
			} else if (this.occupation.equals("salesman")) {
				importview.setPackage(package1);
				importview.setName(name);
				importview.setOccuption(this.occupation);
				exportview.setPackage(package1);
				exportview.setName(name);
				exportview.setOccuption(this.occupation);
				customerview.setPackage(package1);
				customerview.setName(name);
				customerview.setOccuption(this.occupation);
			} else if (this.occupation.equals("accountant")) {
				accountview.setPackage(package1);
				accountview.setName(name);
				accountview.setOccuption(this.occupation);
			}

		}

		if (package1.getResult().equals("not find")) {
			loginview.clear();
			loginview.setMessage("not find");
			loginview.run();
		}
	}

	public void login_out() {
		loginview.setVisible(false);
	}

	public void commodity_add() {
		String operation = "commodity_add" + "/"
				+ commodityview.getCOMMODITY_ADD_NAME() + ";"
				+ commodityview.getCOMMODITY_ADD_TYPE() + ";"
				+ commodityview.getCOMMODITY_ADD_MIP() + ";"
				+ commodityview.getCOMMODITY_ADD_MEP();
		package1.setOperation(operation);
		client.sendData(package1);

		package1 = client.getData();
		commodityview.setPackage(package1);
		commodityview.clear();
		commodityview.setMessage(package1.getResult());
		commodityview.run();
	}

	public void commodity_del() {
		String operation = "commodity_del" + "/"
				+ commodityview.getCOMMODITY_DEL_NAME() + ";"
				+ commodityview.getCOMMODITY_DEL_TYPE();
		package1.setOperation(operation);
		client.sendData(package1);

		package1 = client.getData();
		commodityview.setPackage(package1);
		commodityview.clear();
		commodityview.setMessage(package1.getResult());
		commodityview.run();
	}

	public void commodity_upd() {
		String operation = "commodity_upd" + "/"
				+ commodityview.getCOMMODITY_UPD_NAME() + ";"
				+ commodityview.getCOMMODITY_UPD_TYPE() + ";"
				+ commodityview.getCOMMODITY_UPD_MIP() + ";"
				+ commodityview.getCOMMODITY_UPD_MEP();
		package1.setOperation(operation);
		client.sendData(package1);

		package1 = client.getData();
		commodityview.setPackage(package1);
		commodityview.clear();
		commodityview.setMessage(package1.getResult());
		commodityview.run();
	}

	public void commodity_fin() {
		String operation = "commodity_fin" + "/"
				+ commodityview.getCOMMODITY_FIN_NAME() + ";"
				+ commodityview.getCOMMODITY_FIN_TYPE();
		package1.setOperation(operation);
		client.sendData(package1);

		package1 = client.getData();
		commodityview.setPackage(package1);
		commodityview.clear();
		commodityview.setMessage(package1.getResult());
		commodityview.run();
	}

	public void commodity_sho() {
		String operation = "commodity_sho" + "/" + "commodity show";
		package1.setOperation(operation);
		client.sendData(package1);

		package1 = client.getData();
		commodityview.setPackage(package1);
		commodityview.clear();
		commodityview.setMessage(package1.getResult());
		commodityview.run();
	}

	public void stock_sho() {
		String operation = "stock_sho" + "/" + "stock show";
		package1.setOperation(operation);
		client.sendData(package1);

		package1 = client.getData();
		stockview.setPackage(package1);
		stockview.clear();
		stockview.setMessage(package1.getResult());
		stockview.run();
	}

	public void import_add() {
		String operation = "import_add" + "/"
				+ importview.getIMPORT_ADD_CUSTOMER() + ";"
				+ importview.getIMPORT_ADD_COMMODITY() + ";"
				+ importview.getIMPORT_ADD_COMTYPE() + ";"
				+ importview.getIMPORT_ADD_NUMBER() + ";"
				+ importview.getIMPORT_ADD_PRICE();
		package1.setOperation(operation);
		client.sendData(package1);

		package1 = client.getData();
		importview.setPackage(package1);
		importview.clear();
		importview.setMessage(package1.getResult());
		importview.run();
	}

	public void import_del() {
		String operation = "import_del" + "/"
				+ importview.getIMPORT_DEL_CUSTOMER() + ";"
				+ importview.getIMPORT_DEL_COMMODITY() + ";"
				+ importview.getIMPORT_DEL_COMTYPE() + ";"
				+ importview.getIMPORT_DEL_NUMBER() + ";"
				+ importview.getIMPORT_DEL_PRICE();
		package1.setOperation(operation);
		client.sendData(package1);

		package1 = client.getData();
		importview.setPackage(package1);
		importview.clear();
		importview.setMessage(package1.getResult());
		importview.run();
	}

	public void import_sho() {
		String operation = "import_sho" + "/"+"import show";
		package1.setOperation(operation);
		client.sendData(package1);

		package1 = client.getData();
		importview.setPackage(package1);
		importview.clear();
		importview.setMessage(package1.getResult());
		importview.run();
	}

	public void export_add() {
		String operation = "export_add" + "/"
				+ exportview.getEXPORT_ADD_CUSTOMER() + ";"
				+ exportview.getEXPORT_ADD_COMMODITY() + ";"
				+ exportview.getEXPORT_ADD_COMTYPE() + ";"
				+ exportview.getEXPORT_ADD_NUMBER() + ";"
				+ exportview.getEXPORT_ADD_PRICE();
		package1.setOperation(operation);
		client.sendData(package1);

		package1 = client.getData();
		exportview.setPackage(package1);
		exportview.clear();
		exportview.setMessage(package1.getResult());
		exportview.run();
	}

	public void export_del() {
		String operation = "export_del" + "/"
				+ exportview.getEXPORT_DEL_CUSTOMER() + ";"
				+ exportview.getEXPORT_DEL_COMMODITY() + ";"
				+ exportview.getEXPORT_DEL_COMTYPE() + ";"
				+ exportview.getEXPORT_DEL_NUMBER() + ";"
				+ exportview.getEXPORT_DEL_PRICE();
		package1.setOperation(operation);
		client.sendData(package1);

		package1 = client.getData();
		exportview.setPackage(package1);
		exportview.clear();
		exportview.setMessage(package1.getResult());
		exportview.run();
	}

	public void export_sho() {
		String operation = "export_sho" + "/"+"export show";
		package1.setOperation(operation);
		client.sendData(package1);

		package1 = client.getData();
		exportview.setPackage(package1);
		exportview.clear();
		exportview.setMessage(package1.getResult());
		exportview.run();
	}

	public void customer_add() {
		String operation = "customer_add" + "/"
				+ customerview.getCUSTOMER_ADD_NAME()+ ";"
				+ customerview.getCUSTOMER_ADD_TEL();
								
		package1.setOperation(operation);
		client.sendData(package1);

		package1 = client.getData();
		customerview.setPackage(package1);
		customerview.clear();
		customerview.setMessage(package1.getResult());
		customerview.run();
	}

	public void customer_del() {
		String operation = "customer_del" + "/"+ customerview.getCUSTOMER_DEL_NAME();
								
		package1.setOperation(operation);
		client.sendData(package1);

		package1 = client.getData();
		customerview.setPackage(package1);
		customerview.clear();
		customerview.setMessage(package1.getResult());
		customerview.run();
	}

	public void customer_upd() {
		String operation = "customer_upd" + "/"
				+ customerview.getCUSTOMER_UPD_NAME()+ ";"
				+ customerview.getCUSTOMER_UPD_TEL();
								
		package1.setOperation(operation);
		client.sendData(package1);

		package1 = client.getData();
		customerview.setPackage(package1);
		customerview.clear();
		customerview.setMessage(package1.getResult());
		customerview.run();
	}

	public void customer_fin() {
		String operation = "customer_fin" + "/"+ customerview.getCUSTOMER_FIN_NAME();
		
		package1.setOperation(operation);
		client.sendData(package1);

		package1 = client.getData();
		customerview.setPackage(package1);
		customerview.clear();
		customerview.setMessage(package1.getResult());
		customerview.run();
	}

	public void customer_sho() {
		String operation = "customer_sho" + "/"+ "customer show";
		
		package1.setOperation(operation);
		client.sendData(package1);

		package1 = client.getData();
		customerview.setPackage(package1);
		customerview.clear();
		customerview.setMessage(package1.getResult());
		customerview.run();
	}

	public void account_in() {
      String operation = "account_in" + "/"+ accountview.getACCOUNT_IN_CUSTOMER()+";"+accountview.getACCOUNT_IN_MONEY();
		
		package1.setOperation(operation);
		client.sendData(package1);

		package1 = client.getData();
		customerview.setPackage(package1);
		customerview.clear();
		customerview.setMessage(package1.getResult());
		customerview.run();
	}

	public void account_out() {
		 String operation = "account_out" + "/"+ accountview.getACCOUNT_OUT_CUSTOMER()+";"+accountview.getACCOUNT_OUT_MONEY();
			
			package1.setOperation(operation);
			client.sendData(package1);

			package1 = client.getData();
			customerview.setPackage(package1);
			customerview.clear();
			customerview.setMessage(package1.getResult());
			customerview.run();
	}

	public void account_all() {
		 String operation = "account_all" +"/" + "account all";
			
			package1.setOperation(operation);
			client.sendData(package1);

			package1 = client.getData();
			customerview.setPackage(package1);
			customerview.clear();
			customerview.setMessage(package1.getResult());
			customerview.run();
	}

	public void account_det() {
		 String operation = "account_det" +"/" +"account det";
			
			package1.setOperation(operation);
			client.sendData(package1);

			package1 = client.getData();
			customerview.setPackage(package1);
			customerview.clear();
			customerview.setMessage(package1.getResult());
			customerview.run();
	}

	public void account_ini() {
		 String operation = "account_ini"  +"/"+accountview.getACCOUNT_INI_MONEY() ;
			
			package1.setOperation(operation);
			client.sendData(package1);

			package1 = client.getData();
			customerview.setPackage(package1);
			customerview.clear();
			customerview.setMessage(package1.getResult());
			customerview.run();
	}

	public static void main(String[] args) {

		ClientController ccon = new ClientController();
		ccon.addListener();
		ccon.begin();
	}

}
