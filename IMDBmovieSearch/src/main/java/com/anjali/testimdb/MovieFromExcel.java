package com.anjali.testimdb;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class MovieFromExcel {
	public static List<String> getMovieList() throws Exception {
		List<String> movieList = new ArrayList<String>();
		File f = new File("src/main/resources/movieList.xls");
		FileInputStream file = new FileInputStream(f);
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheetAt(0);

		for (int j = 0; j <= sheet.getLastRowNum(); j++) {
			String MovieNamexls = sheet.getRow(j).getCell(0)
					.getStringCellValue();
			// System.out.println("Movie name from excel is " + MovieNamexls);
			movieList.add(MovieNamexls);
		}
		file.close();
		System.out.println(movieList);
		return movieList;
	}
}
