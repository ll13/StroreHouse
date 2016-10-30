package controller;

import model.AccountModel;
import model.CommodityModel;
import model.CustomerModel;
import model.ExportModel;
import model.IDModel;
import model.ImportModel;
import model.StockModel;
import remote.Server;
import vo.Package;

public class ServerController {
	Server server = new Server();
	Package getPackage = new Package();
	Package result = new Package();

	CommodityModel commodityModel;
	StockModel stockModel;
	ImportModel importModel;
	ExportModel exportModel;
	CustomerModel customerModel;
	AccountModel accountModel;
	IDModel idModel = new IDModel();

	public Package doOperation(Package operation) {
		Package result = new Package();
		String[] operationCompare = operation.getOperation().split("/");
		String[] content = operationCompare[1].split(";");
		if (operationCompare[0].equals("login_in")) {
			result = idModel.checkId(content);
		}else if (operationCompare[0].equals("commodity_add")) {
			result=commodityModel.addCommodity(content);
			stockModel.addCommodityStock(content);
		} else if (operationCompare[0].equals("commodity_del")) {
			result=commodityModel.deleteCommodity(content);
		} else if (operationCompare[0].equals("commodity_upd")) {
			result=commodityModel.updateCommodity(content);
		}else if (operationCompare[0].equals("commodity_fin")) {
			result=commodityModel.findCommodity(content);
		}else if (operationCompare[0].equals("commodity_sho")) {
			result=commodityModel.showCommodity(content);
		}else if (operationCompare[0].equals("stock_sho")) {
			result=stockModel.showStock(content);
		}else if (operationCompare[0].equals("import_add")) {
			result=importModel.addImport(content);
			commodityModel.importAddCommodity(content);
			stockModel.importAddStock(content);
			customerModel.importAddCustomer(content);
			accountModel.importAddAccountAll(content);
		}else if (operationCompare[0].equals("import_del")) {
			result=importModel.delImport(content);
			commodityModel.importDelCommodity(content);
			stockModel.importDelStock(content);
			customerModel.importDelCustomer(content);
			accountModel.importDelAccountAll(content);
		}else if (operationCompare[0].equals("import_sho")) {
			result=importModel.showImport(content);
		}else if (operationCompare[0].equals("export_add")) {
			result=exportModel.addExport(content);
			commodityModel.exportAddCommodity(content);
			stockModel.exportAddStock(content);
			customerModel.exportAddCustomer(content);
			accountModel.exportAddAccountAll(content);
		}else if (operationCompare[0].equals("export_del")) {
			result=exportModel.delExport(content);
			commodityModel.exportDelCommodity(content);
			stockModel.exportDelStock(content);
			customerModel.exportDelCustomer(content);
			accountModel.exportDelAccountAll(content);
		}else if (operationCompare[0].equals("export_sho")) {
			result=exportModel.showExport(content);					
		}else if (operationCompare[0].equals("customer_add")) {
			result=customerModel.addCustomer(content);
		}else if (operationCompare[0].equals("customer_del")) {
			result=customerModel.deleteCustomer(content);
		}else if (operationCompare[0].equals("customer_upd")) {
			result=customerModel.updateCustomer(content);
		}else if (operationCompare[0].equals("customer_fin")) {
			result=customerModel.findCustomer(content);
		}else if (operationCompare[0].equals("customer_sho")) {
			result=customerModel.showCustomer(content);
		}else if (operationCompare[0].equals("account_in")) {
			result=accountModel.inAccount(content);
			customerModel.accountInCustomer(content);
		}else if (operationCompare[0].equals("account_out")) {
			result=accountModel.outAccount(content);
			customerModel.accountOutCustomer(content);
		}else if (operationCompare[0].equals("account_all")) {
			result=accountModel.showAccountAll(content);
		}else if (operationCompare[0].equals("account_det")) {
			result=accountModel.showAccountDetail(content);
		}else if (operationCompare[0].equals("account_ini")) {
			result=accountModel.initAccountAll(content);
		}

		return result;

	}

	public static void main(String[] args) {
		ServerController s = new ServerController();
		boolean stop = false;
		int i = 1000;
		while (!stop) {
			s.getPackage = s.server.getData();
			System.out.println(s.getPackage.getOperation());
			s.result = s.doOperation(s.getPackage);
			s.server.sendData(s.result);
			System.out.println(s.result.getResult());
			i--;
			if (i < 0) {
				stop = true;

			}
		}

	}
}
