package com.anjali.testamazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtlis {

	public static Map<String, Double> getExcelData()
			throws FileNotFoundException, IOException, InterruptedException {
		Map<String, Double> priceMap = new HashMap<String, Double>();
		File f = new File("src/main/resources/PhonePrice.xls");
		FileInputStream file = new FileInputStream(f);
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheetAt(0);
		for (int j = 0; j <= sheet.getLastRowNum(); j++) {
			String phoneName = sheet.getRow(j).getCell(0).getStringCellValue();
			Double phonePrice = sheet.getRow(j).getCell(1)
					.getNumericCellValue();

			System.out.println("phone name " + phoneName + " price: "
					+ phonePrice);
			priceMap.put(phoneName, phonePrice);

		}
		file.close();
		return priceMap;
	}
}
