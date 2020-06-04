package dataDriven.excelDataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvide {
	
	
	@Test(dataProvider="driveTest")
	public void testCaseData(String greeting,String communication,String id){
		System.out.println(greeting +communication + id);
	}
	//multiple sets of data to our tests
	//array  
	//5 sets of data as 5 arrays from data provider to your tests
	//then your test will run 5 times with 5 separate sets of data (arrays)
	
	/*@DataProvider(name="driveTest")
	public Object[][] getData() throws IOException{
		
		Object[][] data={{"hello","text","1"},{"bye","message","143"},{"solo","call","543"}};
		//every row of excel should be sent to 1array
		
		return data;
	}*/
	
	@DataProvider(name="driveTest")
	public Object[][] getDataFromExcel() throws IOException{
		DataFormatter formatter=new DataFormatter();
		
		//every row of excel should be sent to 1array
		FileInputStream fis=new FileInputStream("D:\\Workspace_NRDA\\excelDataProvider\\excelDriven.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int rowCount=sheet.getPhysicalNumberOfRows();
		XSSFRow row=sheet.getRow(0);
		int colcount=row.getLastCellNum();
		Object[][] data=new Object[rowCount-1][colcount];
		for(int i=0;i<rowCount-1;i++){
			row=sheet.getRow(i+1);
			for(int j=0;j<colcount;j++){
				XSSFCell cell=row.getCell(j);
				data[i][j]=formatter.formatCellValue(cell);
				
			}
		}
		return data;
	}

}
