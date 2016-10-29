package vo;


public class Customer {


	String customer_name,telephone;
    int should_pay,should_get,all;
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getShould_pay() {
		return should_pay;
	}
	public void setShould_pay(int should_pay) {
		this.should_pay = should_pay;
	}
	public int getShould_get() {
		return should_get;
	}
	public void setShould_get(int should_get) {
		this.should_get = should_get;
	}
	public int getAll() {
		return all;
	}
	public void setAll(int all) {
		this.all = all;
	}
    
}
