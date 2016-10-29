package vo;

import java.io.Serializable;

public class Package implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 String [][]commoditySet ;
	 String [][]stockSet;
	 String [][] exportSet;
	 String [][] importSet;
	 String [][] customerSet;
	 String [][] accountAllSet;
	 String [][] accountDetailSet;
	 String [][] idSet;
	 String operation;
	 String result;
	 
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String[][] getCommoditySet() {
		return commoditySet;
	}
	public void setCommoditySet(String[][] commoditySet) {
		this.commoditySet = commoditySet;
	}
	public String[][] getStockSet() {
		return stockSet;
	}
	public void setStockSet(String[][] stockSet) {
		this.stockSet = stockSet;
	}
	
	
	public String[][] getExportSet() {
		return exportSet;
	}
	public void setExportSet(String[][] exportSet) {
		this.exportSet = exportSet;
	}
	public String[][] getImportSet() {
		return importSet;
	}
	public void setImportSet(String[][] importSet) {
		this.importSet = importSet;
	}
	public String[][] getCustomerSet() {
		return customerSet;
	}
	public void setCustomerSet(String[][] customerSet) {
		this.customerSet = customerSet;
	}
	public String[][] getAccountAllSet() {
		return accountAllSet;
	}
	public void setAccountAllSet(String[][] accountAllSet) {
		this.accountAllSet = accountAllSet;
	}
	public String[][] getAccountDetailSet() {
		return accountDetailSet;
	}
	public void setAccountDetailSet(String[][] accountDetailSet) {
		this.accountDetailSet = accountDetailSet;
	}
	public String[][] getIdSet() {
		return idSet;
	}
	public void setIdSet(String[][] idSet) {
		this.idSet = idSet;
	}
	 
	
	 
}
