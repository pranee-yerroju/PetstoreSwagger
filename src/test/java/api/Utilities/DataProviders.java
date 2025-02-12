package api.Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	String filepath = System.getProperty("user.dir") + "\\testData\\userTestdata.xlsx";

	ExcelUtility xl = new ExcelUtility(filepath);

	@DataProvider(name = "data")
	public String[][] getData() throws IOException {

		int totalrows = xl.getRowCount("Sheet1");
		int totalcols = xl.getCellCount("Sheet1", 1);

		String userdata[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				userdata[i - 1][j] = xl.getCellData("Sheet1", i, j);
			}

		}
		return userdata;
	}

	@DataProvider(name = "usernames")
	public String[] getUsername() throws IOException {
		 int rownum=xl.getRowCount("Sheet1");
		 String username[]=new String[rownum];
		for(int i=1;i<rownum;i++) {
			username[i-1]=xl.getCellData("Sheet1", i, 2);
		}
		return username;
	}
}
