package vo;


import java.util.Date;

public class AccountDetail {

	
Date date;
 String operation_type,customer;
 int money;
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getOperation_type() {
	return operation_type;
}
public void setOperation_type(String operation_type) {
	this.operation_type = operation_type;
}
public String getCustomer() {
	return customer;
}
public void setCustomer(String customer) {
	this.customer = customer;
}
public int getMoney() {
	return money;
}
public void setMoney(int money) {
	this.money = money;
}
 
}
