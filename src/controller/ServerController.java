package controller;
import model.AccountModel;
import model.CommodityModel;
import model.CustomerModel;
import model.ExportModel;
import model.IDModel;
import model.ImportModel;
import model.StockModel;
import remote.Server;
import vo.Package;

public class ServerController {
  Server server=new Server();
  Package getPackage = new Package();
  Package result=new Package();
  
  CommodityModel commodityModel;
  StockModel stockModel;
  ImportModel buyModel;
  ExportModel saleModel;
  CustomerModel customerModel;
  AccountModel accountModel;
  IDModel idModel=new IDModel();
  
  
  
  public Package doOperation(Package operation){
	  Package result=new Package();	  
	  String [] operationCompare=operation.getOperation().split("/");
	  String [] content=operationCompare[1].split(";");
	  if(operationCompare[0].equals("login_in")){		  
		  result=idModel.checkId(content);  
	  }else if(operationCompare[0].equals("login_in")){
		  
	  }else if(operationCompare[0].equals("login_in")){
		  
	  }
	  
	  
	  
	  return result;
	  
  }
  
  
  public static void main(String []args){
	  ServerController s=new ServerController();
	  boolean stop=false;
	  int i=1000;
	     while(!stop){
		  s.getPackage=s.server.getData();
		  System.out.println(s.getPackage.getOperation());
		  s.result=s.doOperation(s.getPackage);		 
		  s.server.sendData(s.result);
		  System.out.println(s.result.getResult());
		  i--;
		  if(i<0){
			  stop=true;
			  
		  }
		  }
	  
	 
	  
	  
  }
}
