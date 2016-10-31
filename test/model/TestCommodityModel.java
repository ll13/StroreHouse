package model;

import org.junit.Assert;
import org.junit.Test;



public class TestCommodityModel {
	CommodityModel c=new CommodityModel();
	
	//@Test
	public void test1(){		
		String [] commodityFind={"飞利浦日光灯","SR04"};		
		vo.Package p2=c.findCommodity(commodityFind);		
		Assert.assertTrue(p2.getResult().equals("find"));		
	}
	//@Test
	public void test2(){		
		String [] commodityFind={"飞利浦日光灯","SR11"};		
		vo.Package p2=c.findCommodity(commodityFind);		
		Assert.assertTrue(p2.getResult().equals("not find"));		
	}
	@Test
	public void test3(){		
		String [] commodityAdd={"飞利浦日光灯","SR11","50","60"};
		vo.Package p1=c.addCommodity(commodityAdd);
				
		boolean flag=p1.getResult().equals("commodity add success");
		//System.out.println(flag);
		Assert.assertTrue(flag);
	}
	//@Test
	public void test4(){		
		String [] commodityAdd={"飞利浦日光灯","SR11","50","60"};
		vo.Package p1=c.addCommodity(commodityAdd);
				
		Assert.assertTrue(p1.getResult().equals("commodity add exist"));		
	}
	
	//@Test
	public void test5(){		
		String [] commodityDel={"飞利浦日光灯","SR11"};
		vo.Package p1=c.deleteCommodity(commodityDel);
		boolean flag=p1.getResult().equals("commodity delete success");
		//System.out.println(flag);
		Assert.assertTrue(flag);		
	}
	
	//@Test
	public void test6(){		
		String [] commodityDel={"飞利浦日光灯","SR11"};
		vo.Package p1=c.deleteCommodity(commodityDel);
		boolean flag=p1.getResult().equals("commodity delete not find");
		//System.out.println(flag);
		Assert.assertTrue(flag);		
	}
	
}
