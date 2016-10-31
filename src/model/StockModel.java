package model;

import java.util.ArrayList;

import data.ReadFile;
import data.WriteFile;
import vo.Package;
import vo.Stock;

public class StockModel {
	ArrayList<Stock> stockList = new ArrayList<Stock>();
	WriteFile writefile = new WriteFile();
	ReadFile readfile = new ReadFile();
	int point = 0;

	public void read() {
		String[][] Set = readfile.readData("data/stock.txt");
		stockList = stringToList(Set);
	}

	public void write() {
		String[][] set = listToString(stockList);
		writefile.writeData("data/stock.txt", set);
	}

	public ArrayList<Stock> stringToList(String[][] stockSet) {
		ArrayList<Stock> result = new ArrayList<Stock>();

		if (stockSet.length > 0)
			for (int i = 0; i < stockSet.length; i++) {
				Stock stock = new Stock();
				stock.setName(stockSet[i][0]);
				stock.setType(stockSet[i][1]);
				stock.setImport_number(Integer.parseInt(stockSet[i][2]));
				stock.setImport_MINprice(Integer.parseInt(stockSet[i][3]));
				stock.setImport_Allprice(Integer.parseInt(stockSet[i][4]));

				stock.setExport_number(Integer.parseInt(stockSet[i][5]));
				stock.setExport_MINprice(Integer.parseInt(stockSet[i][6]));
				stock.setExport_Allprice(Integer.parseInt(stockSet[i][7]));

				stock.setStock_number(Integer.parseInt(stockSet[i][8]));
				stock.setStock_MINprice(Integer.parseInt(stockSet[i][9]));
				stock.setStock_Allprice(Integer.parseInt(stockSet[i][10]));
				result.add(stock);
			}
		return result;
	}

	public String[][] listToString(ArrayList<Stock> stockList) {
		String[][] result = null;
		if (!stockList.isEmpty()) {
			result = new String[stockList.size()][11];
			for (int i = 0; i < result.length; i++) {
				result[i][0] = stockList.get(i).getName();
				result[i][1] = stockList.get(i).getType();
				result[i][2] = stockList.get(i).getImport_number() + "";
				result[i][3] = stockList.get(i).getImport_MINprice() + "";
				result[i][4] = stockList.get(i).getImport_Allprice() + "";

				result[i][5] = stockList.get(i).getExport_number() + "";
				result[i][6] = stockList.get(i).getExport_MINprice() + "";
				result[i][7] = stockList.get(i).getExport_Allprice() + "";

				result[i][8] = stockList.get(i).getStock_number() + "";
				result[i][9] = stockList.get(i).getStock_MINprice() + "";
				result[i][10] = stockList.get(i).getStock_Allprice() + "";
			}
		}

		return result;
	}

	public Package findStock(String[] stockFind) {
		Package package1 = new Package();
		ArrayList<Stock> result = new ArrayList<Stock>();
		read();

		if (stockList.size() > 0)
			for (int i = 0; i < stockList.size(); i++) {
				if (stockList.get(i).getName().equals(stockFind[0])) {
					if (stockList.get(i).getType().equals(stockFind[1])) {
						result.add(stockList.get(i));
						point = i;
					}
				}
			}

		if (result.isEmpty()) {
			package1.setResult("not find");
		} else {
			package1.setStockSet(listToString(result));
			package1.setResult("find");
		}
		return package1;
	}

	public Package showStock(String[] stockShow) {
		Package package1 = new Package();
		ArrayList<Stock> result = new ArrayList<Stock>();
		read();

		result = stockList;
		package1.setStockSet(listToString(result));
		package1.setResult("stock show success");

		return package1;
	}

	public Package importAddStock(String[] stockImport) {
		Package package1 = new Package();
		ArrayList<Stock> result = new ArrayList<Stock>();
		read();

		String[] stockFind = new String[2];
		stockFind[0] = stockImport[1];
		stockFind[1] = stockImport[2];
		Stock stockFindResult = null;
		
		if (findStock(stockFind).getStockSet()==null) {
			package1.setResult("stock import add not find");
			return package1;
		}
		stockFindResult = stringToList(findStock(stockFind).getStockSet()).get(0);
		stockList.remove(point);

		int stockAllPrice, importAllPrice, stockMinPrice, stockNumber;
		importAllPrice = Integer.parseInt(stockImport[3]) * Integer.parseInt(stockImport[4]);
		stockAllPrice = importAllPrice + stockFindResult.getStock_Allprice();
		stockNumber = stockFindResult.getStock_number() + Integer.parseInt(stockImport[3]);
		stockMinPrice = stockAllPrice / stockNumber;

		stockFindResult.setImport_number(Integer.parseInt(stockImport[3]));
		stockFindResult.setImport_MINprice(Integer.parseInt(stockImport[4]));
		stockFindResult.setImport_Allprice(importAllPrice);
		stockFindResult.setStock_number(stockNumber);
		stockFindResult.setStock_Allprice(stockAllPrice);
		stockFindResult.setStock_MINprice(stockMinPrice);
		stockList.add(stockFindResult);
		write();
		result = stockList;
		package1.setStockSet(listToString(result));
		package1.setResult("stock import add success");

		return package1;

	}

	public Package importDelStock(String[] stockImport) {
		Package package1 = new Package();
		ArrayList<Stock> result = new ArrayList<Stock>();
		read();

		String[] stockFind = new String[2];
		stockFind[0] = stockImport[1];
		stockFind[1] = stockImport[2];
		Stock stockFindResult = null;
		
		if (findStock(stockFind).getStockSet()==null) {
			package1.setResult("stock import del not find");
			return package1;
		}
		stockFindResult = stringToList(findStock(stockFind).getStockSet()).get(0);
		if (stockFindResult.getImport_number() != Integer.parseInt(stockImport[3])
				|| stockFindResult.getImport_MINprice() != Integer.parseInt(stockImport[4])) {
			package1.setResult("stock import del cannot import del");
			return package1;
		}

		stockList.remove(point);
		int stockAllPrice, importAllPrice, stockMinPrice, stockNumber;
		importAllPrice = Integer.parseInt(stockImport[3]) * Integer.parseInt(stockImport[4]);
		stockAllPrice = stockFindResult.getStock_Allprice() - importAllPrice;
		stockNumber = stockFindResult.getStock_number() - Integer.parseInt(stockImport[3]);
		stockMinPrice = stockAllPrice / stockNumber;

		stockFindResult.setImport_number(Integer.parseInt(stockImport[3]));
		stockFindResult.setImport_MINprice(Integer.parseInt(stockImport[4]));
		stockFindResult.setImport_Allprice(importAllPrice);
		stockFindResult.setStock_number(stockNumber);
		stockFindResult.setStock_Allprice(stockAllPrice);
		stockFindResult.setStock_MINprice(stockMinPrice);
		stockList.add(stockFindResult);
		write();
		result = stockList;
		package1.setStockSet(listToString(result));
		package1.setResult("stock import del success");

		return package1;

	}

	public Package exportAddStock(String[] stockExport) {
		Package package1 = new Package();
		ArrayList<Stock> result = new ArrayList<Stock>();
		read();

		String[] stockFind = new String[2];
		stockFind[0] = stockExport[1];
		stockFind[1] = stockExport[2];
		Stock stockFindResult = null;
		
		if (findStock(stockFind).getStockSet()==null) {
			package1.setResult("stock export add not find");
			return package1;
		}
		stockFindResult = stringToList(findStock(stockFind).getStockSet()).get(0);
		stockList.remove(point);

		int stockAllPrice, stockMinPrice, stockNumber, exportAllPrice;
		exportAllPrice = Integer.parseInt(stockExport[3]) * Integer.parseInt(stockExport[4]);
		stockNumber = stockFindResult.getStock_number() - Integer.parseInt(stockExport[3]);
		stockMinPrice = stockFindResult.getStock_MINprice();
		stockAllPrice = stockMinPrice * stockNumber;

		stockFindResult.setExport_number(Integer.parseInt(stockExport[3]));
		stockFindResult.setExport_MINprice(Integer.parseInt(stockExport[4]));
		stockFindResult.setExport_Allprice(exportAllPrice);
		stockFindResult.setStock_number(stockNumber);
		stockFindResult.setStock_Allprice(stockAllPrice);
		stockFindResult.setStock_MINprice(stockMinPrice);
		stockList.add(stockFindResult);
		write();
		result = stockList;
		package1.setStockSet(listToString(result));
		package1.setResult("stock export add success");

		return package1;

	}

	public Package exportDelStock(String[] stockExport) {
		Package package1 = new Package();
		ArrayList<Stock> result = new ArrayList<Stock>();
		read();

		String[] stockFind = new String[2];
		stockFind[0] = stockExport[1];
		stockFind[1] = stockExport[2];
		Stock stockFindResult = null;
		
		if (findStock(stockFind).getStockSet()==null) {
			package1.setResult("stock export del not find");
			return package1;
		}
		stockFindResult = stringToList(findStock(stockFind).getStockSet()).get(0);
		if (stockFindResult.getExport_number() != Integer.parseInt(stockExport[3])
				|| stockFindResult.getExport_MINprice() != Integer.parseInt(stockExport[4])) {
			package1.setResult("stock export del cannot export del");
			return package1;
		}

		stockList.remove(point);
		int stockAllPrice, stockMinPrice, stockNumber, exportAllPrice;
		exportAllPrice = Integer.parseInt(stockExport[3]) * Integer.parseInt(stockExport[4]);
		stockNumber = stockFindResult.getStock_number() + Integer.parseInt(stockExport[3]);
		stockMinPrice = stockFindResult.getStock_MINprice();
		stockAllPrice = stockMinPrice * stockNumber;

		stockFindResult.setExport_number(Integer.parseInt(stockExport[3]));
		stockFindResult.setExport_MINprice(Integer.parseInt(stockExport[4]));
		stockFindResult.setExport_Allprice(exportAllPrice);
		stockFindResult.setStock_number(stockNumber);
		stockFindResult.setStock_Allprice(stockAllPrice);
		stockFindResult.setStock_MINprice(stockMinPrice);
		stockList.add(stockFindResult);

		write();
		result = stockList;
		package1.setStockSet(listToString(result));
		package1.setResult("stock export del success");

		return package1;

	}

	public Package addCommodityStock(String[] commodityAddStock) {
		Package package1 = new Package();
		ArrayList<Stock> result = new ArrayList<Stock>();
		read();

		String[] stockFind = new String[2];
		stockFind[0] = commodityAddStock[0];
		stockFind[1] = commodityAddStock[1];
		
		if (findStock(stockFind).getStockSet()!=null) {
			package1.setResult("stock commodity add exist");
			return package1;
		}
		
		Stock stockNew = new Stock();

		stockNew.setName(commodityAddStock[0]);
		stockNew.setType(commodityAddStock[1]);
		stockNew.setImport_number(0);
		stockNew.setImport_MINprice(0);
		stockNew.setImport_Allprice(0);
		stockNew.setExport_number(0);
		stockNew.setExport_MINprice(0);
		stockNew.setExport_Allprice(0);
		stockNew.setStock_number(0);
		stockNew.setStock_MINprice(0);
		stockNew.setStock_Allprice(0);

		stockList.add(stockNew);
		write();
		result = stockList;
		package1.setStockSet(listToString(result));
		package1.setResult("stock commodity add success");

		return package1;

	}

	public Package delCommodityStock(String[] commodityDelStock) {
		Package package1 = new Package();
		ArrayList<Stock> result = new ArrayList<Stock>();
		read();

		String[] stockFind = new String[2];
		stockFind[0] = commodityDelStock[0];
		stockFind[1] = commodityDelStock[1];
		Stock stockFindResult = null;
		if (findStock(stockFind).getStockSet()==null) {
			package1.setResult("stock commodity not find");
			return package1;
		}
		
		stockFindResult = stringToList(findStock(stockFind).getStockSet()).get(0);
		if (stockFindResult.getStock_number() != 0) {
			package1.setResult("commodity delete cannot delete");
			return package1;
		}

		stockList.remove(point);
		write();
		result = stockList;
		package1.setStockSet(listToString(result));
		package1.setResult("stock commodity delete success");

		return package1;

	}

}
