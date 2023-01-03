package utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtil {
	XSSFWorkbook wb;
	//Constructor for reading excel path
	public ExcelFileUtil(String excelpath) throws Throwable
	{
		FileInputStream fi = new FileInputStream(excelpath);
		wb= new XSSFWorkbook(fi);
	}
	// Count no of rows in a sheet
	public int rowcount(String sheetname)
	{
		return wb.getSheet(sheetname).getLastRowNum();		
	}
	//get cell type data
	public String getcelldata(String sheetname, int row,int column)
	{
		String data="";
		if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			int celldata= (int)wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
			data= String.valueOf(celldata);
		}
		else
		{
			data=wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		}
		return data;	
	}
	//method for set cell data
	public  void  setcelldata(String sheetname, int row, int column, String status, String writeexcel) throws Throwable
	{
		//get sheet from wb
		XSSFSheet ws = wb.getSheet(sheetname);
		//get row from sheet
		XSSFRow rowNum = ws.getRow(row);
		// Create cell in row
		XSSFCell cell = rowNum.createCell(column);
		//write status
		cell.setCellValue(status);
		if (status.equalsIgnoreCase("pass")) 
		{
			XSSFCellStyle Style = wb.createCellStyle();
			XSSFFont font = wb.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			Style.setFont(font);
			rowNum.getCell(column).setCellStyle(Style);
		} 
		else if(status.equalsIgnoreCase("fail"))
		{
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font = wb.createFont();
			font.setColor(IndexedColors.RED.getIndex());
			font.setBold(true);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);
			rowNum.getCell(column).setCellStyle(style);
		}
		else if(status.equalsIgnoreCase("blocked"))
		{
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font = wb.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBold(true);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);
			rowNum.getCell(column).setCellStyle(style);
		}
		FileOutputStream fo = new FileOutputStream(writeexcel);
		wb.write(fo);
	}
	public static void main(String[] args) throws Throwable {
		ExcelFileUtil xl = new ExcelFileUtil("C:\\Users\\Dell\\OneDrive\\Documents\\demo2.xlsx");
		// count no of rows
		int rc = xl.rowcount("naani");
		System.out.println(rc);
		for(int i=1;i<=rc;i++)
		{
			String fname = xl.getcelldata("naani", i, 0);
			String mname = xl.getcelldata("naani", i, 1);
			String lname = xl.getcelldata("naani", i, 2);
			String eid = xl.getcelldata("naani", i, 3);
			System.out.println(fname+"  "+mname+"  "+lname+"  "+eid);
			xl.setcelldata("naani", i, 4, "pass", "C:\\Users\\Dell\\OneDrive\\Documents\\demo2.xlsx");
			//xl.setcelldata("naani", i, 4, "fail", "C:\\Users\\Dell\\OneDrive\\Documents\\demo2.xlsx");
			//xl.setcelldata("naani", i, 4, "blocked", "C:\\Users\\Dell\\OneDrive\\Documents\\demo2.xlsx");
	}

	}

}
