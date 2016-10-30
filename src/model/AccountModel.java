package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import data.ReadFile;
import data.WriteFile;
import vo.AccountAll;
import vo.AccountDetail;
import vo.Package;


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

	public Package showAccountAll(String[] accountAllShow) {
		Package package1 = new Package();
		ArrayList<AccountAll> result = new ArrayList<AccountAll>();
		read();

		result=accountAllList;
		package1.setAccountAllSet(listToStringAll(result));
		package1.setResult("accountAll show  success");

		return package1;
	}
	
	public Package showAccountDetail(String[] accountDetailShow) {
		Package package1 = new Package();
		ArrayList<AccountDetail> result = new ArrayList<AccountDetail>();
		read();

		result=accountDetailList;
		package1.setAccountDetailSet(listToStringDetail(result));
		package1.setResult("AccountDetail show  success");

		return package1;
	}
	
	public Package inAccount(String[] accountIn) {
		Package package1 = new Package();
		ArrayList<AccountAll> resultAll = new ArrayList<AccountAll>();
		ArrayList<AccountDetail> resultDetail = new ArrayList<AccountDetail>();
		read();

		AccountAll accountAll = new AccountAll();
		AccountDetail accountDetail = new AccountDetail();	
		
		int sum_money=accountAllList.get(0).getSum_money()
				+(Integer.parseInt(accountIn[1]));
		int should_get=accountAllList.get(0).getSum_should_get_money()
				-(Integer.parseInt(accountIn[1]));
		
		accountAll.setSum_money(sum_money);
		accountAll.setSum_should_get_money(should_get);
		accountAll.setSum_should_pay_money(accountAllList.get(0).getSum_should_pay_money());
		
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();				
		accountDetail.setDate(date);
		accountDetail.setOperation_type("ACCOUNT_IN");
		accountDetail.setCustomer(accountIn[0]);
		accountDetail.setMoney(Integer.parseInt(accountIn[1]));
		
		accountAllList.remove(0);
		accountAllList.add(accountAll);
		accountDetailList.add(accountDetail);
		
		write();
		resultAll = accountAllList;
		resultDetail = accountDetailList;
		package1.setAccountAllSet(listToStringAll(resultAll));
		package1.setAccountDetailSet(listToStringDetail(resultDetail));
		package1.setResult("account in success");

		return package1;
	}
	
	public Package outAccount(String[] accountOut) {
		Package package1 = new Package();
		ArrayList<AccountAll> resultAll = new ArrayList<AccountAll>();
		ArrayList<AccountDetail> resultDetail = new ArrayList<AccountDetail>();
		read();

		AccountAll accountAll = new AccountAll();
		AccountDetail accountDetail = new AccountDetail();	
		
		int sum_money=accountAllList.get(0).getSum_money()
				-(Integer.parseInt(accountOut[1]));
		int should_pay=accountAllList.get(0).getSum_should_pay_money()
				-(Integer.parseInt(accountOut[1]));
		
		accountAll.setSum_money(sum_money);
		accountAll.setSum_should_get_money(accountAllList.get(0).getSum_should_get_money());
		accountAll.setSum_should_pay_money(should_pay);
		
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();				
		accountDetail.setDate(date);
		accountDetail.setOperation_type("ACCOUNT_OUT");
		accountDetail.setCustomer(accountOut[0]);
		accountDetail.setMoney(Integer.parseInt(accountOut[1]));
		
		accountAllList.remove(0);
		accountAllList.add(accountAll);
		accountDetailList.add(accountDetail);
		
		write();
		resultAll = accountAllList;
		resultDetail = accountDetailList;
		package1.setAccountAllSet(listToStringAll(resultAll));
		package1.setAccountDetailSet(listToStringDetail(resultDetail));
		package1.setResult("account out success");

		return package1;
	}
	
	public Package importAddAccountAll(String accountAllImport[]){
		Package package1 = new Package();
		ArrayList<AccountAll> resultAll = new ArrayList<AccountAll>();		
		read();
		
		AccountAll accountAll = new AccountAll();
		int sum_money=accountAllList.get(0).getSum_money();
		int should_get=accountAllList.get(0).getSum_should_get_money();
		int should_pay=accountAllList.get(0).getSum_should_pay_money()+
		Integer.parseInt(accountAllImport[3])*Integer.parseInt(accountAllImport[4]);
		
		accountAll.setSum_money(sum_money);
		accountAll.setSum_should_get_money(should_get);
		accountAll.setSum_should_pay_money(should_pay);
		
		accountAllList.remove(0);
		accountAllList.add(accountAll);
		write();
		resultAll = accountAllList;
		package1.setAccountAllSet(listToStringAll(resultAll));
		package1.setResult("account import success");
		return package1;
	}
	
	public Package exportAddAccountAll(String accountAllExport[]){
		Package package1 = new Package();
		ArrayList<AccountAll> resultAll = new ArrayList<AccountAll>();		
		read();
		
		AccountAll accountAll = new AccountAll();
		int sum_money=accountAllList.get(0).getSum_money();
		int should_get=accountAllList.get(0).getSum_should_get_money()+
				Integer.parseInt(accountAllExport[3])*Integer.parseInt(accountAllExport[4]);
		int should_pay=accountAllList.get(0).getSum_should_pay_money();
		
		accountAll.setSum_money(sum_money);
		accountAll.setSum_should_get_money(should_get);
		accountAll.setSum_should_pay_money(should_pay);
		
		accountAllList.remove(0);
		accountAllList.add(accountAll);
		write();
		resultAll = accountAllList;
		package1.setAccountAllSet(listToStringAll(resultAll));
		package1.setResult("account export success");
		return package1;
	}
	public Package importDelAccountAll(String accountAllImport[]){
		Package package1 = new Package();
		ArrayList<AccountAll> resultAll = new ArrayList<AccountAll>();		
		read();
		
		AccountAll accountAll = new AccountAll();
		int sum_money=accountAllList.get(0).getSum_money();
		int should_get=accountAllList.get(0).getSum_should_get_money();
		int should_pay=accountAllList.get(0).getSum_should_pay_money()-
		Integer.parseInt(accountAllImport[3])*Integer.parseInt(accountAllImport[4]);
		
		accountAll.setSum_money(sum_money);
		accountAll.setSum_should_get_money(should_get);
		accountAll.setSum_should_pay_money(should_pay);
		
		accountAllList.remove(0);
		accountAllList.add(accountAll);
		write();
		resultAll = accountAllList;
		package1.setAccountAllSet(listToStringAll(resultAll));
		package1.setResult("account import success");
		return package1;
	}
	
	public Package exportDelAccountAll(String accountAllExport[]){
		Package package1 = new Package();
		ArrayList<AccountAll> resultAll = new ArrayList<AccountAll>();		
		read();
		
		AccountAll accountAll = new AccountAll();
		int sum_money=accountAllList.get(0).getSum_money();
		int should_get=accountAllList.get(0).getSum_should_get_money()-
				Integer.parseInt(accountAllExport[3])*Integer.parseInt(accountAllExport[4]);
		int should_pay=accountAllList.get(0).getSum_should_pay_money();
		
		accountAll.setSum_money(sum_money);
		accountAll.setSum_should_get_money(should_get);
		accountAll.setSum_should_pay_money(should_pay);
		
		accountAllList.remove(0);
		accountAllList.add(accountAll);
		write();
		resultAll = accountAllList;
		package1.setAccountAllSet(listToStringAll(resultAll));
		package1.setResult("account export success");
		return package1;
	}
	
	public Package initAccountAll(String accountAllInit[]){
		Package package1 = new Package();
		ArrayList<AccountAll> resultAll = new ArrayList<AccountAll>();		
		read();
		
		AccountAll accountAll = new AccountAll();
		int sum_money=Integer.parseInt(accountAllInit[0]);
		int should_get=0;
		int should_pay=0;
		
		accountAll.setSum_money(sum_money);
		accountAll.setSum_should_get_money(should_get);
		accountAll.setSum_should_pay_money(should_pay);
		
		if(!accountAllList.isEmpty()){
			package1.setResult("account cannot init");
			return package1;
		}
		
		accountAllList.remove(0);
		accountAllList.add(accountAll);
		write();
		
		resultAll = accountAllList;
		package1.setAccountAllSet(listToStringAll(resultAll));
		package1.setResult("account init success");
		return package1;
	}
	
	
}
