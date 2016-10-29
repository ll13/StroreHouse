package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import data.ReadFile;
import data.WriteFile;
import vo.Export;
import vo.Package;

public class ExportModel {
	ArrayList<Export> exportList = new ArrayList<Export>();
	WriteFile writefile = new WriteFile();
	ReadFile readfile = new ReadFile();

	public void read() {
		String[][] Set = readfile.readData("data/export.txt");
		exportList = stringToList(Set);
	}

	public void write() {
		String[][] set = listToString(exportList);
		writefile.writeData("data/export.txt", set);
	}

	public ArrayList<Export> stringToList(String[][] exportSet) {
		ArrayList<Export> result = new ArrayList<Export>();
		if (exportSet.length > 0)
			for (int i = 0; i < exportSet.length; i++) {
				Export export1 = new Export();
				Calendar c = Calendar.getInstance();
				String time[] = exportSet[i][0].split("/");
				c.set(Integer.parseInt(time[0]), Integer.parseInt(time[1]) - 1, Integer.parseInt(time[2]));
				Date date = c.getTime();
				export1.setDate(date);
				export1.setOperation_type(exportSet[i][1]);
				export1.setCustomer(exportSet[i][2]);
				export1.setProduct_name(exportSet[i][3]);
				export1.setProduct_type(exportSet[i][4]);
				export1.setNumber(Integer.parseInt(exportSet[i][5]));
				export1.setPrice(Integer.parseInt(exportSet[i][6]));
				export1.setAll_price(Integer.parseInt(exportSet[i][7]));

				result.add(export1);
			}
		return result;
	}

	public String[][] listToString(ArrayList<Export> exportList) {
		String[][] result = null;
		if (!exportList.isEmpty()) {
			result = new String[exportList.size()][8];
			for (int i = 0; i < exportList.size(); i++) {
				SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");

				result[i][0] = df.format(exportList.get(i).getDate());
				result[i][1] = exportList.get(i).getOperation_type();
				result[i][2] = exportList.get(i).getCustomer();
				result[i][3] = exportList.get(i).getProduct_name() + "";
				result[i][4] = exportList.get(i).getProduct_type() + "";

				result[i][5] = exportList.get(i).getNumber() + "";
				result[i][6] = exportList.get(i).getPrice() + "";
				result[i][7] = exportList.get(i).getAll_price() + "";

			}
		}

		return result;
	}

	public Package addExport(String[] exportAdd) {
		Package package1 = new Package();
		ArrayList<Export> result = new ArrayList<Export>();
		read();

		Export export1 = new Export();		
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();				
		export1.setDate(date);
		export1.setOperation_type("ADD");
		export1.setCustomer(exportAdd[0]);
		export1.setProduct_name(exportAdd[1]);
		export1.setProduct_type(exportAdd[2]);
		export1.setNumber(Integer.parseInt(exportAdd[3]));
		export1.setPrice(Integer.parseInt(exportAdd[4]));
		export1.setAll_price(Integer.parseInt(exportAdd[3])*Integer.parseInt(exportAdd[4]));

		exportList.add(export1);
		write();
		result = exportList;
		package1.setExportSet(listToString(result));
		package1.setResult("export add success");

		return package1;
	}

	public Package delExport(String[] exportDel) {
		Package package1 = new Package();
		ArrayList<Export> result = new ArrayList<Export>();
		read();

		Export export1 = new Export();
		
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();				
		export1.setDate(date);
		export1.setOperation_type("DEL");
		export1.setCustomer(exportDel[0]);
		export1.setProduct_name(exportDel[1]);
		export1.setProduct_type(exportDel[2]);
		export1.setNumber(Integer.parseInt(exportDel[3]));
		export1.setPrice(Integer.parseInt(exportDel[4]));
		export1.setAll_price(Integer.parseInt(exportDel[3])*Integer.parseInt(exportDel[4]));

		exportList.add(export1);
		write();
		result = exportList;
		package1.setExportSet(listToString(result));
		package1.setResult("export del success");

		return package1;
	}
	
	public Package findExport(String[] exportFind) {
		Package package1 = new Package();
		ArrayList<Export> result = new ArrayList<Export>();
		read();
        
		Calendar begin = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		Calendar compare = Calendar.getInstance();
		String begintime[] = exportFind[0].split("/");
		String endtime[] = exportFind[1].split("/");
		begin.set(Integer.parseInt(begintime[0]), Integer.parseInt(begintime[1]) - 1, Integer.parseInt(begintime[2]));
		end.set(Integer.parseInt(endtime[0]), Integer.parseInt(endtime[1]) - 1, Integer.parseInt(endtime[2]));
		long beginMi=begin.getTimeInMillis();
		long endMi=end.getTimeInMillis();
		for(int i=0;i<exportList.size();i++){
			compare.setTime(exportList.get(i).getDate());
			long compareMi=compare.getTimeInMillis();
			long bc=0,ec=0;
			bc=((compareMi-beginMi)/(1000*60*60*24));
			ec=((compareMi-endMi)/(1000*60*60*24));
			if(bc>=0){
				if(ec<=0){
					result.add(exportList.get(i));
				}
			}
		}
		
		package1.setExportSet(listToString(result));
		package1.setResult("export find success");

		return package1;
	}
	
	public Package showExport(String[] exportShow) {
		Package package1 = new Package();
		ArrayList<Export> result = new ArrayList<Export>();
		read();

		result=exportList;
		package1.setExportSet(listToString(result));
		package1.setResult("export show  success");

		return package1;
	}

}
