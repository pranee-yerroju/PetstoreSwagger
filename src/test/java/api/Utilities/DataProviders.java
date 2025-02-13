package api.Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	String filepath = System.getProperty("user.dir") + "\\testData\\Book1.xlsx";

	ExcelUtility xl = new ExcelUtility(filepath);

	@DataProvider(name = "data")
	public String[][] getData() throws IOException {

		int totalrows = xl.getRowCount("User");
		int totalcols = xl.getCellCount("User", 1);

		String userdata[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				userdata[i - 1][j] = xl.getCellData("User", i, j);
			}

		}
		return userdata;
	}

	@DataProvider(name = "usernames")
	public String[] getUsername() throws IOException {
		 int rownum=xl.getRowCount("User");
		 String username[]=new String[rownum];
		for(int i=1;i<rownum;i++) {
			username[i-1]=xl.getCellData("User", i, 1);
		}
		return username;
	}
}
