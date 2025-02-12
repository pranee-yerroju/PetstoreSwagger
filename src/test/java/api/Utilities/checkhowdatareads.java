package api.Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class checkhowdatareads {

	public static void main(String[] args) throws IOException {
		
		String filepath = System.getProperty("user.dir") + "\\testData\\userTestdata.xlsx";

		ExcelUtility xl = new ExcelUtility(filepath);
           
			 int rownum=xl.getRowCount("Sheet1");
			 String username[]=new String[rownum];
			for(int i=1;i<rownum;i++) {
				username[i-1]=xl.getCellData("Sheet1", i, 2);
			}
			System.out.println(username);
		
	}
}

