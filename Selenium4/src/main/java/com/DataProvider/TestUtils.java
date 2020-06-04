package com.DataProvider;

import java.util.ArrayList;

import com.Parameterization.Xls_Reader;

public class TestUtils {

	static Xls_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel() {
		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		try {
			reader = new Xls_Reader("D:\\Workspace_NRDA\\Selenium4\\src\\java\\resource\\testdata.xlsx");

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int rowNum = 2; rowNum <= reader.getRowCount("Login_Data"); rowNum++) {
			String username = reader.getCellData("Login_Data", "Username", rowNum);
			String password = reader.getCellData("Login_Data", "Password", rowNum);

			Object[] obj = { username, password };
			myData.add(obj);
		}
		return myData;

	}

}
