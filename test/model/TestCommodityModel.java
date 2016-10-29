package model;

import org.junit.Assert;
import org.junit.Test;



public class TestCommodityModel {
	CommodityModel c=new CommodityModel();
	
	@Test
	public void test(){
		String []commodityAdd={"飞利浦日光灯","SR05","50","60"};
		String [] commodityFind={"飞利浦日光灯","SR05"};
		vo.Package p1=c.addCommodity(commodityAdd);
		vo.Package p2=c.findCommodity(commodityFind);
		vo.Package p3=c.deleteCommodity(commodityFind);
		Assert.assertTrue(p1.getResult().equals("commodity add success"));
		Assert.assertTrue(p2.getResult().equals("find"));
		Assert.assertTrue(p3.getResult().equals("commodity delete success"));
		
		
	}

}
