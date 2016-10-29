package model;

import java.util.ArrayList;
import data.ReadFile;
import data.WriteFile;
import vo.Commodity;
import vo.Package;

public class CommodityModel {

	ArrayList<Commodity> commodityList = new ArrayList<Commodity>();
	WriteFile writefile = new WriteFile();
	ReadFile readfile = new ReadFile();
	int point=0;

	public void read() {
		String[][] Set = readfile.readData("data/commodity.txt");
		commodityList = stringToList(Set);
	}

	public void write() {
		String[][] set = listToString(commodityList);
		writefile.writeData("data/commodity.txt", set);
	}

	public ArrayList<Commodity> stringToList(String[][] commoditySet) {
		ArrayList<Commodity> result = new ArrayList<Commodity>();
		if (commoditySet.length > 0)
			for (int i = 0; i < commoditySet.length; i++) {
				Commodity commodity = new Commodity();
				commodity.setName(commoditySet[i][0]);
				commodity.setType(commoditySet[i][1]);
				commodity.setNumber(Integer.parseInt(commoditySet[i][2]));
				commodity.setFirst_import_price(Integer.parseInt(commoditySet[i][3]));
				commodity.setFirst_export_price(Integer.parseInt(commoditySet[i][4]));
				commodity.setImport_price(Integer.parseInt(commoditySet[i][5]));
				commodity.setExport_price(Integer.parseInt(commoditySet[i][6]));
				result.add(commodity);
			}
		return result;
	}

	public String[][] listToString(ArrayList<Commodity> commodityList) {
		String[][] result = null;
		if (!commodityList.isEmpty()) {
			result = new String[commodityList.size()][7];
			for (int i = 0; i < result.length; i++) {
				result[i][0] = commodityList.get(i).getName();
				result[i][1] = commodityList.get(i).getType();
				result[i][2] = commodityList.get(i).getNumber() + "";
				result[i][3] = commodityList.get(i).getFirst_import_price() + "";
				result[i][4] = commodityList.get(i).getFirst_export_price() + "";
				result[i][5] = commodityList.get(i).getImport_price() + "";
				result[i][6] = commodityList.get(i).getExport_price() + "";
			}
		}

		return result;
	}

	public Package addCommodity(String[] commodityAdd) {
		Package package1 = new Package();
		ArrayList<Commodity> result = new ArrayList<Commodity>();
		read();

		String[] commodityFind = new String[2];
		commodityFind[0] = commodityAdd[0];
		commodityFind[1] = commodityAdd[1];
		if (findCommodity(commodityFind).getCommoditySet() != null) {
			package1.setResult("commodity add exist");
			return package1;
		}
		Commodity commodityNew = new Commodity();
		if (commodityAdd.length == 4) {
			commodityNew.setName(commodityAdd[0]);
			commodityNew.setType(commodityAdd[1]);
			commodityNew.setNumber(0);
			commodityNew.setFirst_import_price(Integer.parseInt(commodityAdd[2]));
			commodityNew.setFirst_export_price(Integer.parseInt(commodityAdd[3]));
			commodityNew.setImport_price(0);
			commodityNew.setExport_price(0);

			commodityList.add(commodityNew);
			write();
			result = commodityList;
			package1.setCommoditySet(listToString(result));
			package1.setResult("commodity add success");
		}
		return package1;
	}

	public Package deleteCommodity(String[] commodityDelete) {
		Package package1 = new Package();
		ArrayList<Commodity> result = new ArrayList<Commodity>();
		read();

		String[] commodityFind = new String[2];
		commodityFind[0] = commodityDelete[0];
		commodityFind[1] = commodityDelete[1];
		Commodity commodityFindResult = null;
		commodityFindResult = stringToList(findCommodity(commodityFind).getCommoditySet()).get(0);
		if (commodityFindResult == null) {
			package1.setResult("commodity delete not find");
			return package1;
		}
		if (commodityFindResult.getNumber() != 0) {
			package1.setResult("commodity delete cannot delete");
		}
        
		commodityList.remove(point);
		write();
		result = commodityList;
		package1.setResult("commodity delete success");
		package1.setCommoditySet(listToString(result));
		return package1;
	}

	public Package updateCommodity(String[] commodityUpdate) {
		Package package1 = new Package();
		ArrayList<Commodity> result = new ArrayList<Commodity>();
		read();

		String[] commodityFind = new String[2];
		commodityFind[0] = commodityUpdate[0];
		commodityFind[1] = commodityUpdate[1];
		Commodity commodityFindResult = null;
		commodityFindResult = stringToList(findCommodity(commodityFind).getCommoditySet()).get(0);
		if (commodityFindResult == null) {
			package1.setResult("commodity update not find");
			return package1;
		}
		commodityList.remove(point);
		commodityFindResult.setFirst_import_price(Integer.parseInt(commodityUpdate[2]));
		commodityFindResult.setFirst_export_price(Integer.parseInt(commodityUpdate[3]));
		commodityList.add(commodityFindResult);
		write();
		result = commodityList;
		package1.setCommoditySet(listToString(result));
		package1.setResult("commodity update success");

		return package1;
	}

	public Package importAddCommodity(String[] commodityImport) {
		Package package1 = new Package();
		ArrayList<Commodity> result = new ArrayList<Commodity>();
		read();

		String[] commodityFind = new String[2];
		commodityFind[0] = commodityImport[0];
		commodityFind[1] = commodityImport[1];
		Commodity commodityFindResult = null;
		commodityFindResult = stringToList(findCommodity(commodityFind).getCommoditySet()).get(0);
		if (commodityFindResult == null) {
			package1.setResult("commodity import add not find");
			return package1;
		}
		commodityList.remove(point);
		int number = commodityFindResult.getNumber();
		commodityFindResult.setNumber(Integer.parseInt(commodityImport[2]) + number);
		commodityFindResult.setImport_price(Integer.parseInt(commodityImport[3]));
		commodityList.add(commodityFindResult);
		write();
		result = commodityList;
		package1.setCommoditySet(listToString(result));
		package1.setResult("commodity import add success");

		return package1;

	}

	public Package importDelCommodity(String[] commodityImport) {
		Package package1 = new Package();
		ArrayList<Commodity> result = new ArrayList<Commodity>();
		read();

		String[] commodityFind = new String[2];
		commodityFind[0] = commodityImport[0];
		commodityFind[1] = commodityImport[1];
		Commodity commodityFindResult = null;
		commodityFindResult = stringToList(findCommodity(commodityFind).getCommoditySet()).get(0);
		if (commodityFindResult == null) {
			package1.setResult("commodity import del not find");
			return package1;
		}
		commodityList.remove(point);
		int number = commodityFindResult.getNumber();
		commodityFindResult.setNumber(Integer.parseInt(commodityImport[2]) - number);
		commodityFindResult.setImport_price(Integer.parseInt(commodityImport[3]));
		commodityList.add(commodityFindResult);
		
		write();
		result = commodityList;
		package1.setCommoditySet(listToString(result));
		package1.setResult("commodity import del success");

		return package1;

	}

	public Package exportAddCommodity(String[] commodityExport) {
		Package package1 = new Package();
		ArrayList<Commodity> result = new ArrayList<Commodity>();
		read();

		String[] commodityFind = new String[2];
		commodityFind[0] = commodityExport[0];
		commodityFind[1] = commodityExport[1];
		Commodity commodityFindResult = null;
		commodityFindResult = stringToList(findCommodity(commodityFind).getCommoditySet()).get(0);
		if (commodityFindResult == null) {
			package1.setResult("commodity export add not find");
			return package1;
		}
		
		commodityList.remove(point);
		int number = commodityFindResult.getNumber();
		commodityFindResult.setNumber(number - Integer.parseInt(commodityExport[2]));
		commodityFindResult.setExport_price(Integer.parseInt(commodityExport[3]));
		commodityList.add(commodityFindResult);
		
		write();
		result = commodityList;
		package1.setCommoditySet(listToString(result));
		package1.setResult("commodity export add success");

		return package1;
	}

	public Package exportDelCommodity(String[] commodityExport) {
		Package package1 = new Package();
		ArrayList<Commodity> result = new ArrayList<Commodity>();
		read();

		String[] commodityFind = new String[2];
		commodityFind[0] = commodityExport[0];
		commodityFind[1] = commodityExport[1];
		Commodity commodityFindResult = null;
		commodityFindResult = stringToList(findCommodity(commodityFind).getCommoditySet()).get(0);
		if (commodityFindResult == null) {
			package1.setResult("commodity export del not find");
			return package1;
		}
		commodityList.remove(point);
		int number = commodityFindResult.getNumber();
		commodityFindResult.setNumber(number + Integer.parseInt(commodityExport[2]));
		commodityFindResult.setExport_price(Integer.parseInt(commodityExport[3]));
		commodityList.add(commodityFindResult);
		
		write();
		result = commodityList;
		package1.setCommoditySet(listToString(result));
		package1.setResult("commodity export del success");

		return package1;
	}

	public Package findCommodity(String[] commodityFind) {
		Package package1 = new Package();
		ArrayList<Commodity> result = new ArrayList<Commodity>();
		read();

		if (commodityList.size() > 0)
			for (int i = 0; i < commodityList.size(); i++) {
				if (commodityList.get(i).getName().equals(commodityFind[0])) {
					if (commodityList.get(i).getType().equals(commodityFind[1])) {
						result.add(commodityList.get(i));
						point=i;
					}
				}
			}

		if (result.isEmpty()) {
			package1.setResult("not find");
		} else {
			package1.setCommoditySet(listToString(result));
			package1.setResult("find");
		}
		return package1;
	}

	public Package showCommodity(String[] commodityShow) {
		Package package1 = new Package();
		ArrayList<Commodity> result = new ArrayList<Commodity>();
		read();

		result=commodityList;
		package1.setCommoditySet(listToString(result));
		package1.setResult("commodity show  success");

		return package1;
	}
}
