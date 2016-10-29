package data;

import org.junit.Assert;


import data.WriteFile;


public class TestWriteFile {
	WriteFile w = new WriteFile();

	public void test() {		
		ReadFile r=new ReadFile();
		String [][]expect={{"lili","111111","stockmane"},
				{"lifi","222222","salesman"},{"ligi","333333","accountant"}};
		w.writeData("data/id.txt", expect);
		String [][]actuals=r.readData("data/id.txt");
		Assert.assertArrayEquals(expect, actuals);
	}
}
	
