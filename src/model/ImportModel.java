package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import data.ReadFile;
import data.WriteFile;
import vo.Import;
import vo.Package;

public class ImportModel {
	ArrayList<Import> importList = new ArrayList<Import>();
	WriteFile writefile = new WriteFile();
	ReadFile readfile = new ReadFile();

	public void read() {
		String[][] Set = readfile.readData("data/import.txt");
		importList = stringToList(Set);
	}

	public void write() {
		String[][] set = listToString(importList);
		writefile.writeData("data/import.txt", set);
	}

	public ArrayList<Import> stringToList(String[][] importSet) {
		ArrayList<Import> result = new ArrayList<Import>();
		if (importSet.length > 0)
			for (int i = 0; i < importSet.length; i++) {
				Import import1 = new Import();
				Calendar c = Calendar.getInstance();
				String time[] = importSet[i][0].split("/");
				c.set(Integer.parseInt(time[0]), Integer.parseInt(time[1]) - 1, Integer.parseInt(time[2]));
				Date date = c.getTime();
				import1.setDate(date);
				import1.setOperation_type(importSet[i][1]);
				import1.setCustomer(importSet[i][2]);
				import1.setProduct_name(importSet[i][3]);
				import1.setProduct_type(importSet[i][4]);
				import1.setNumber(Integer.parseInt(importSet[i][5]));
				import1.setPrice(Integer.parseInt(importSet[i][6]));
				import1.setAll_price(Integer.parseInt(importSet[i][7]));

				result.add(import1);
			}
		return result;
	}

	public String[][] listToString(ArrayList<Import> importList) {
		String[][] result = null;
		if (!importList.isEmpty()) {
			result = new String[importList.size()][8];
			for (int i = 0; i < importList.size(); i++) {
				SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");

				result[i][0] = df.format(importList.get(i).getDate());
				result[i][1] = importList.get(i).getOperation_type();
				result[i][2] = importList.get(i).getCustomer();
				result[i][3] = importList.get(i).getProduct_name() + "";
				result[i][4] = importList.get(i).getProduct_type() + "";

				result[i][5] = importList.get(i).getNumber() + "";
				result[i][6] = importList.get(i).getPrice() + "";
				result[i][7] = importList.get(i).getAll_price() + "";

			}
		}

		return result;
	}

	public Package addImport(String[] importAdd) {
		Package package1 = new Package();
		ArrayList<Import> result = new ArrayList<Import>();
		read();

		Import import1 = new Import();		
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();				
		import1.setDate(date);
		import1.setOperation_type("ADD");
		import1.setCustomer(importAdd[0]);
		import1.setProduct_name(importAdd[1]);
		import1.setProduct_type(importAdd[2]);
		import1.setNumber(Integer.parseInt(importAdd[3]));
		import1.setPrice(Integer.parseInt(importAdd[4]));
		import1.setAll_price(Integer.parseInt(importAdd[3])*Integer.parseInt(importAdd[4]));

		importList.add(import1);
		write();
		result = importList;
		package1.setImportSet(listToString(result));
		package1.setResult("import add success");

		return package1;
	}

	public Package delImport(String[] importDel) {
		Package package1 = new Package();
		ArrayList<Import> result = new ArrayList<Import>();
		read();

		Import import1 = new Import();
		
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();				
		import1.setDate(date);
		import1.setOperation_type("DEL");
		import1.setCustomer(importDel[0]);
		import1.setProduct_name(importDel[1]);
		import1.setProduct_type(importDel[2]);
		import1.setNumber(Integer.parseInt(importDel[3]));
		import1.setPrice(Integer.parseInt(importDel[4]));
		import1.setAll_price(Integer.parseInt(importDel[3])*Integer.parseInt(importDel[4]));

		importList.add(import1);
		write();
		result = importList;
		package1.setImportSet(listToString(result));
		package1.setResult("import del success");

		return package1;
	}
	
	public Package findImport(String[] importFind) {
		Package package1 = new Package();
		ArrayList<Import> result = new ArrayList<Import>();
		read();
        
		Calendar begin = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		Calendar compare = Calendar.getInstance();
		String begintime[] = importFind[0].split("/");
		String endtime[] = importFind[1].split("/");
		begin.set(Integer.parseInt(begintime[0]), Integer.parseInt(begintime[1]) - 1, Integer.parseInt(begintime[2]));
		end.set(Integer.parseInt(endtime[0]), Integer.parseInt(endtime[1]) - 1, Integer.parseInt(endtime[2]));
		long beginMi=begin.getTimeInMillis();
		long endMi=end.getTimeInMillis();
		for(int i=0;i<importList.size();i++){
			compare.setTime(importList.get(i).getDate());
			long compareMi=compare.getTimeInMillis();
			long bc=0,ec=0;
			bc=((compareMi-beginMi)/(1000*60*60*24));
			ec=((compareMi-endMi)/(1000*60*60*24));
			if(bc>=0){
				if(ec<=0){
					result.add(importList.get(i));
				}
			}
		}
		
		package1.setImportSet(listToString(result));
		package1.setResult("import find success");

		return package1;
	}
	
	public Package showImport(String[] importShow) {
		Package package1 = new Package();
		ArrayList<Import> result = new ArrayList<Import>();
		read();

		result=importList;
		package1.setImportSet(listToString(result));
		package1.setResult("import show  success");

		return package1;
	}

}
