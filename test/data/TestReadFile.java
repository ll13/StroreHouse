package data;

import org.junit.Assert;
import org.junit.Test;

import data.ReadFile;
import data.WriteFile;
import vo.Package;

public class TestReadFile {
     ReadFile r=new ReadFile();
	@Test
	public void test() {		
		String [][]actuals=r.readData("data/id.txt");
		String [][]expect={{"lili","111111","stockmane"},
				{"lifi","222222","salesman"},{"ligi","333333","accountant"}};
		Assert.assertArrayEquals(expect, actuals);
	}

}
