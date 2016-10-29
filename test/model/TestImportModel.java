package model;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import vo.Package;
public class TestImportModel {

	@Test
	public void test() {
		ImportModel i=new ImportModel();
		String [] content={"2014/04/03","2014/05/01"};
		Package p=i.findImport(content);
		Assert.assertTrue(p.getImportSet().length==2);
	}

}
