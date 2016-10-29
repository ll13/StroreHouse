package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import data.ReadFile;
import data.WriteFile;
import vo.AccountAll;
import vo.AccountDetail;


public class AccountModel {

	ArrayList<AccountAll> accountAllList = new ArrayList<AccountAll>();
	ArrayList<AccountDetail> accountDetailList = new ArrayList<AccountDetail>();
	WriteFile writefile = new WriteFile();
	ReadFile readfile = new ReadFile();

	public void read() {
		String[][] set1 = readfile.readData("data/account_all.txt");
		String[][] set2 = readfile.readData("data/account_detail.txt");
		accountAllList = stringToListAll(set1);
		accountDetailList = stringToListDetail(set2);
	}

	public void write() {
		String[][] set1 = listToStringAll(accountAllList);
		String[][] set2 = listToStringDetail(accountDetailList);
		writefile.writeData("data/account_all.txt", set1);
		writefile.writeData("data/account_detail.txt", set2);
	}

	public ArrayList<AccountAll> stringToListAll(String[][] accountAllSet) {
		ArrayList<AccountAll> result = new ArrayList<AccountAll>();
		if (accountAllSet.length > 0)
			for (int i = 0; i < accountAllSet.length; i++) {
				AccountAll accountAll = new AccountAll();
				accountAll.setSum_money(Integer.parseInt(accountAllSet[i][0]));
				accountAll.setSum_should_get_money(Integer.parseInt(accountAllSet[i][1]));
				accountAll.setSum_should_pay_money(Integer.parseInt(accountAllSet[i][2]));

				result.add(accountAll);
				
			}
		return result;
	}

	public String[][] listToStringAll(ArrayList<AccountAll> accountAllList) {
		String[][] result= null;
		if (!accountAllList.isEmpty()) {
			result = new String[accountAllList.size()][3];
			for (int i = 0; i <accountAllList.size(); i++) {

				result[i][0] = accountAllList.get(i).getSum_money() + "";
				result[i][1] = accountAllList.get(i).getSum_should_get_money() + "";
				result[i][2] = accountAllList.get(i).getSum_should_pay_money() + "";

			}
		}

		return result;
	}
	
	public ArrayList<AccountDetail> stringToListDetail(String[][] accountDetailSet) {

		ArrayList<AccountDetail> result = new ArrayList<AccountDetail>();
		if (accountDetailSet.length > 0)
			for (int i = 0; i < accountDetailSet.length; i++) {
				AccountDetail accountDetail = new AccountDetail();
				Calendar c = Calendar.getInstance();
				String time[] = accountDetailSet[i][0].split("/");
				c.set(Integer.parseInt(time[0]), Integer.parseInt(time[1]) - 1, Integer.parseInt(time[2]));
				Date date = c.getTime();
				accountDetail.setDate(date);
				accountDetail.setOperation_type(accountDetailSet[i][1]);
				accountDetail.setCustomer(accountDetailSet[i][2]);
				accountDetail.setMoney(Integer.parseInt(accountDetailSet[i][3]));

				result.add(accountDetail);
			}
		return result;
	}

	public String[][] listToStringDetail(ArrayList<AccountDetail> accountDetailList) {
		String[][] result = null;
		if (!accountDetailList.isEmpty()) {
			result = new String[accountDetailList.size()][4];
			for (int i = 0; i < accountDetailList.size(); i++) {
				SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				result[i][0] = df.format(accountDetailList.get(i).getDate());
				result[i][1] = accountDetailList.get(i).getOperation_type() + "";
				result[i][2] = accountDetailList.get(i).getCustomer() + "";
				result[i][3] = accountDetailList.get(i).getMoney() + "";

			}
		}

		return result;
	}



}
