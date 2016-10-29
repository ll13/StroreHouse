package data;

import java.io.File;
import java.io.IOException;

public class CreateFile {
	String file_path,file_name;
public void makeDir(String path,String name){
	File dir=new File(path+name);
	dir.mkdir();
}
public void makeTxt(String path,String name) {
	File f=new File(path+name+".txt");
	try{
	f.createNewFile();
	}catch(IOException ioe){
		System.out.println("cannot create file"+ioe);
	}
	
}
public void deleteFlie(String path,String name){
	File f=new File(path+name+".txt");
	f.delete();
}

public void init(){
	CreateFile c=new CreateFile();
	c.makeDir("", "data");
	c.makeTxt("data"+File.separator, "commodity");
	c.makeTxt("data"+File.separator, "stock");
	c.makeTxt("data"+File.separator, "import");
	c.makeTxt("data"+File.separator, "export");
	c.makeTxt("data"+File.separator, "customer");
	c.makeTxt("data"+File.separator, "account_all");
	c.makeTxt("data"+File.separator, "account_detail");
	c.makeTxt("data"+File.separator, "id");
}
	

}
