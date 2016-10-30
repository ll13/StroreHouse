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
		}else if (event.getSource().equals(importview.getIMPORT_DEL())) {
			import_del();
		} else if (event.getSource().equals(importview.getIMPORT_SHO())) {
			import_sho();
		} else if (event.getSource().equals(storehouseview.getExport())) {
			if (package1.getExportSet() != null) {
				exportview.clear();
				exportview.run();
			}

		}else if (event.getSource().equals(exportview.getEXPORT_ADD())) {
			export_add();
		}else if (event.getSource().equals(exportview.getEXPORT_DEL())) {
			export_del();
		} else if (event.getSource().equals(exportview.getEXPORT_SHO())) {
			export_sho();
		}  else if (event.getSource().equals(storehouseview.getCustomer())) {
			if (package1.getCustomerSet() != null) {
				customerview.clear();
				customerview.run();
			}

		}else if (event.getSource().equals(customerview.getCUSTOMER_ADD())) {
			customer_add();
		} else if (event.getSource().equals(customerview.getCUSTOMER_DEL())) {
			customer_del();
		} else if (event.getSource().equals(customerview.getCUSTOMER_UPD())) {
			customer_upd();
		} else if (event.getSource().equals(customerview.getCUSTOMER_FIN())) {
			customer_fin();
		} else if (event.getSource().equals(customerview.getCUSTOMER_SHO())) {
			customer_sho();
		}  else if (event.getSource().equals(storehouseview.getAccount())) {
			if (package1.getAccountAllSet() != null) {
				accountview.clear();
				accountview.run();
			}
		}else if (event.getSource().equals(accountview.getACCOUNT_IN())) {
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
		String operation = "login_in" + "/" + loginview.getName() + ";" + new String(loginview.getPsw()) + ";"
				+ occupation;
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
		String operation = "commodity_add" + "/" + commodityview.getCOMMODITY_ADD_NAME()+ ";" +commodityview.getCOMMODITY_ADD_TYPE() + ";"
				+ commodityview.getCOMMODITY_ADD_MIP()+";"+commodityview.getCOMMODITY_ADD_MEP();
		package1.setOperation(operation);
		client.sendData(package1);
	}

	public void commodity_del() {
	}

	public void commodity_upd() {
	}

	public void commodity_fin() {
	}

	public void commodity_sho() {
	}

	public void stock_sho() {
	}

	public void import_add() {
	}

	public void import_del() {
	}

	public void import_sho() {
	}

	public void export_add() {
	}

	public void export_del() {
	}

	public void export_sho() {
	}

	public void customer_add() {
	}

	public void customer_del() {
	}

	public void customer_upd() {
	}

	public void customer_fin() {
	}

	public void customer_sho() {
	}

	public void account_in() {
	}

	public void account_out() {
	}

	public void account_all() {
	}

	public void account_det() {
	}

	public void account_ini() {
	}

	public static void main(String[] args) {

		ClientController ccon = new ClientController();
		ccon.addListener();
		ccon.begin();
	}

}
