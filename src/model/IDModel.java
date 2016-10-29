package model;

import java.util.ArrayList;

import data.ReadFile;
import data.WriteFile;
import vo.ID;
import vo.Package;

public class IDModel {
	ArrayList<ID> idList = new ArrayList<ID>();
    WriteFile writefile=new WriteFile();
    ReadFile readfile=new ReadFile();
    
   public void read(){
	   String[][] Set= readfile.readData("data/id.txt");
	   idList=stringToList(Set);
   }
   public void write(String path){
	   String [][]set=listToString(idList);
	   writefile.writeData("data/id.txt", set);
   }
   public Package checkId(String []content){
	 
	   ArrayList<ID> result=new ArrayList<ID>() ;
	   Package package1=new Package();
	   read();
	   
		 if(idList.size()>0)
		 for(int i=0;i<idList.size();i++){
			 if(idList.get(i).getName().equals(content[0])){
				 if(idList.get(i).getPsw().equals(content[1])){
					if(idList.get(i).getOccuppation().equals(content[2])){
						result.add(idList.get(i));
						
					}
				 }
			 }
		 }
		 
		 
		 if(result.isEmpty()){
			 package1.setResult("not find");
		 }else{
			 package1.setIdSet(listToString(result));
			 package1.setResult("find");
		 }
		
	   return package1;
   }
   
public ArrayList<ID> stringToList(String[][] idSet) {
	ArrayList<ID> result = new ArrayList<ID>();
	
		if (idSet.length > 0)
			for (int i = 0; i < idSet.length; i++) {
				ID id = new ID();
				id.setName(idSet[i][0]);
				id.setPsw( idSet[i][1]);
				id.setOccuppation(idSet[i][2]);
				result.add(id);
			}
		return result;
	}

	public String[][] listToString( ArrayList<ID> idList) {
		String result[][] = null;
		if (!idList.isEmpty()) {
			result = new String[idList.size()][3];
			for (int i = 0; i < result.length; i++) {
				result[i][0] = idList.get(i).getName();
				result[i][1] = idList.get(i).getPsw();
				result[i][2] = idList.get(i).getOccuppation();

			}
		}
		return result;
	}
	
   
}
