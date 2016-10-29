package model;

import java.util.ArrayList;
import data.ReadFile;
import data.WriteFile;
import vo.Customer;
import vo.Package;

public class CustomerModel {

	ArrayList<Customer> commodityList = new ArrayList<Customer>();
	WriteFile writefile = new WriteFile();
	ReadFile readfile = new ReadFile();

	public void read() {
		String[][] set = readfile.readData("data/customer.txt");
		commodityList = stringToList(set);
	}

	public void write() {
		String[][] set = listToString(commodityList);
		writefile.writeData("data/customer.txt", set);
	}

	public ArrayList<Customer> stringToList(String[][] customerSet) {
		ArrayList<Customer> result = new ArrayList<Customer>();
		if (customerSet.length > 0)
			for (int i = 0; i < customerSet.length; i++) {
				Customer customer = new Customer();
				customer.setCustomer_name(customerSet[i][0]);
				customer.setTelephone(customerSet[i][1]);
				customer.setShould_get(Integer.parseInt(customerSet[i][2]));
				customer.setShould_pay(Integer.parseInt(customerSet[i][3]));
				customer.setAll(Integer.parseInt(customerSet[i][4]));

				result.add(customer);
			}

	
		return result;
	}

	public String[][] listToString(ArrayList<Customer> customerList) {
		String[][] result = null;
		if (!customerList.isEmpty()) {
			result = new String[customerList.size()][5];
			for (int i = 0; i < customerList.size(); i++) {

				result[i][0] = customerList.get(i).getCustomer_name();
				result[i][1] = customerList.get(i).getTelephone();
				result[i][2] = customerList.get(i).getShould_get() + "";
				result[i][3] = customerList.get(i).getShould_pay() + "";
				result[i][4] = customerList.get(i).getAll() + "";

			}
		}
		return result;
	}

	
}

