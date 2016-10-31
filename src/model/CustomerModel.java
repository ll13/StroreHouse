package model;

import java.util.ArrayList;
import data.ReadFile;
import data.WriteFile;
import vo.Customer;
import vo.Package;

public class CustomerModel {

	ArrayList<Customer> customerList = new ArrayList<Customer>();
	WriteFile writefile = new WriteFile();
	ReadFile readfile = new ReadFile();
    int point =0;
    
	public void read() {
		String[][] set = readfile.readData("data/customer.txt");
		customerList = stringToList(set);
	}

	public void write() {
		String[][] set = listToString(customerList);
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

	public Package showCustomer(String[] customerShow) {
		Package package1 = new Package();
		ArrayList<Customer> result = new ArrayList<Customer>();
		read();

		result=customerList;
		package1.setCustomerSet(listToString(result));
		package1.setResult("customer show  success");

		return package1;
	}
	
	public Package findCustomer(String[] customerFind) {
		Package package1 = new Package();
		ArrayList<Customer> result = new ArrayList<Customer>();
		read();

		if (customerList.size() > 0)
			for (int i = 0; i < customerList.size(); i++) {
				if (customerList.get(i).getCustomer_name().equals(customerFind[0])) {
					
						result.add(customerList.get(i));
						point=i;
					
				}
			}

		if (result.isEmpty()) {
			package1.setResult("not find");
		} else {
			package1.setCustomerSet(listToString(result));
			package1.setResult("find");
		}
		return package1;
	}

	public Package addCustomer(String[] customerAdd) {
		Package package1 = new Package();
		ArrayList<Customer> result = new ArrayList<Customer>();
		read();

		String[] customerFind = new String[1];
		customerFind[0] = customerAdd[0];
		if (findCustomer(customerFind).getCustomerSet() != null) {
			package1.setResult("customer add exist");
			return package1;
		}
		Customer customerNew = new Customer();
		if (customerAdd.length == 2) {
			customerNew.setCustomer_name(customerAdd[0]);
			customerNew.setTelephone(customerAdd[1]);
			customerNew.setShould_get(0);
			customerNew.setShould_pay(0);
			customerNew.setAll(0);
			
			customerList.add(customerNew);
			write();
			result = customerList;
			package1.setCustomerSet(listToString(result));
			package1.setResult("customer add success");
		}
		return package1;
	}
	
	public Package deleteCustomer(String[] customerDelete) {
		Package package1 = new Package();
		ArrayList<Customer> result = new ArrayList<Customer>();
		read();

		String[] customerFind = new String[1];
		customerFind[0] = customerDelete[0];
		
		Customer customerFindResult = null;
		
		if (findCustomer(customerFind).getCustomerSet()==null) {
			package1.setResult("customer delete not find");
			return package1;
		}
		customerFindResult = stringToList(findCustomer(customerFind).getCustomerSet()).get(0);
		if (customerFindResult.getAll() != 0) {
			package1.setResult("customer delete cannot delete");
			return package1;
		}
        
		customerList.remove(point);
		write();
		result = customerList;
		package1.setResult("customer delete success");
		package1.setCustomerSet(listToString(result));
		return package1;
	}
	
	public Package updateCustomer(String[] customerUpdate) {
		Package package1 = new Package();
		ArrayList<Customer> result = new ArrayList<Customer>();
		read();

		String[] customerFind = new String[2];
		customerFind[0] = customerUpdate[0];
		customerFind[1] = customerUpdate[1];
		Customer customerFindResult = null;
		
		if (findCustomer(customerFind).getCustomerSet()==null) {
			package1.setResult("customer update not find");
			return package1;
		}
		customerFindResult = stringToList(findCustomer(customerFind).getCustomerSet()).get(0);
		customerList.remove(point);
		customerFindResult.setTelephone(customerUpdate[1]);
		customerList.add(customerFindResult);
		write();
		result = customerList;
		package1.setCustomerSet(listToString(result));
		package1.setResult("customer update success");

		return package1;
	}
	
	public Package accountInCustomer(String[] customerAccount) {
		Package package1 = new Package();
		ArrayList<Customer> result = new ArrayList<Customer>();
		read();

		String[] customerFind = new String[1];
		customerFind[0] = customerAccount[0];
		Customer customerFindResult = null;
		
		if (findCustomer(customerFind).getCustomerSet()==null) {
			package1.setResult("customer account in not find");
			return package1;
		}
		customerFindResult = stringToList(findCustomer(customerFind).getCustomerSet()).get(0);
		customerList.remove(point);
		
		int shouldGet=customerFindResult.getShould_get()-Integer.parseInt(customerAccount[1]);
		customerFindResult.setShould_get(shouldGet);
		int all=customerFindResult.getShould_get()-customerFindResult.getShould_pay();
		customerFindResult.setAll(all);
		customerList.add(customerFindResult);
		write();
		result = customerList;
		package1.setCustomerSet(listToString(result));
		package1.setResult("customer account in success");

		return package1;

	}

	public Package accountOutCustomer(String[] customerAccount) {
		Package package1 = new Package();
		ArrayList<Customer> result = new ArrayList<Customer>();
		read();

		String[] customerFind = new String[1];
		customerFind[0] = customerAccount[0];
		Customer customerFindResult = null;
		
		if (findCustomer(customerFind).getCustomerSet()==null) {
			package1.setResult("customer account out not find");
			return package1;
		}
		customerFindResult = stringToList(findCustomer(customerFind).getCustomerSet()).get(0);
		customerList.remove(point);
		
		int shouldPay=customerFindResult.getShould_pay()-Integer.parseInt(customerAccount[1]);
		customerFindResult.setShould_pay(shouldPay);
		int all=customerFindResult.getShould_get()-customerFindResult.getShould_pay();
		customerFindResult.setAll(all);
		customerList.add(customerFindResult);
		write();
		result = customerList;
		package1.setCustomerSet(listToString(result));
		package1.setResult("customer account out success");

		return package1;

	}

	public Package importAddCustomer(String[] customerImportAdd) {
		Package package1 = new Package();
		ArrayList<Customer> result = new ArrayList<Customer>();
		read();

		String[] customerFind = new String[1];
		customerFind[0] = customerImportAdd[0];
		Customer customerFindResult = null;
		
		if (findCustomer(customerFind).getCustomerSet()==null) {
			package1.setResult("customer import add not find");
			return package1;
		}
		customerFindResult = stringToList(findCustomer(customerFind).getCustomerSet()).get(0);
		customerList.remove(point);
		
		int shouldPay=customerFindResult.getShould_pay()
				+Integer.parseInt(customerImportAdd[3])*Integer.parseInt(customerImportAdd[4]);
		customerFindResult.setShould_pay(shouldPay);
		int all=customerFindResult.getShould_get()-customerFindResult.getShould_pay();
		customerFindResult.setAll(all);
		customerList.add(customerFindResult);
		write();
		result = customerList;
		package1.setCustomerSet(listToString(result));
		package1.setResult("customer import add success");

		return package1;

	}
	
	public Package importDelCustomer(String[] customerImportDel) {
		Package package1 = new Package();
		ArrayList<Customer> result = new ArrayList<Customer>();
		read();

		String[] customerFind = new String[1];
		customerFind[0] = customerImportDel[0];
		Customer customerFindResult = null;
		
		if ( findCustomer(customerFind).getCustomerSet()==null) {
			package1.setResult("customer import del not find");
			return package1;
		}
		customerFindResult = stringToList(findCustomer(customerFind).getCustomerSet()).get(0);
		customerList.remove(point);
		
		int shouldPay=customerFindResult.getShould_pay()
				-Integer.parseInt(customerImportDel[3])*Integer.parseInt(customerImportDel[4]);
		customerFindResult.setShould_pay(shouldPay);
		int all=customerFindResult.getShould_get()-customerFindResult.getShould_pay();
		customerFindResult.setAll(all);
		customerList.add(customerFindResult);
		write();
		result = customerList;
		package1.setCustomerSet(listToString(result));
		package1.setResult("customer import del success");

		return package1;

	   }
	public Package exportAddCustomer(String[] customerExportAdd) {
		Package package1 = new Package();
		ArrayList<Customer> result = new ArrayList<Customer>();
		read();

		String[] customerFind = new String[1];
		customerFind[0] = customerExportAdd[0];
		Customer customerFindResult = null;
		
		if (findCustomer(customerFind).getCustomerSet()==null) {
			package1.setResult("customer export add not find");
			return package1;
		}
		customerFindResult = stringToList(findCustomer(customerFind).getCustomerSet()).get(0);
		customerList.remove(point);
		
		int shouldGet=customerFindResult.getShould_pay()
				+Integer.parseInt(customerExportAdd[3])*Integer.parseInt(customerExportAdd[4]);
		customerFindResult.setShould_get(shouldGet);
		int all=customerFindResult.getShould_get()-customerFindResult.getShould_pay();
		customerFindResult.setAll(all);
		customerList.add(customerFindResult);
		write();
		result = customerList;
		package1.setCustomerSet(listToString(result));
		package1.setResult("customer export add success");

		return package1;

	}
	
	public Package exportDelCustomer(String[] customerExportDel) {
		Package package1 = new Package();
		ArrayList<Customer> result = new ArrayList<Customer>();
		read();

		String[] customerFind = new String[1];
		customerFind[0] = customerExportDel[0];
		Customer customerFindResult = null;
		
		if (findCustomer(customerFind).getCustomerSet()==null) {
			package1.setResult("customer export del not find");
			return package1;
		}
		customerFindResult = stringToList(findCustomer(customerFind).getCustomerSet()).get(0);
		customerList.remove(point);
		
		int shouldGet=customerFindResult.getShould_pay()
				-Integer.parseInt(customerExportDel[3])*Integer.parseInt(customerExportDel[4]);
		customerFindResult.setShould_get(shouldGet);
		int all=customerFindResult.getShould_get()-customerFindResult.getShould_pay();
		customerFindResult.setAll(all);
		customerList.add(customerFindResult);
		write();
		result = customerList;
		package1.setCustomerSet(listToString(result));
		package1.setResult("customer export del success");

		return package1;

	   }
	
	
	}