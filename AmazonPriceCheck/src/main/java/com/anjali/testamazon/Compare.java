package com.anjali.testamazon;

import java.util.Map;
import java.util.Map.Entry;

public class Compare {

	public static void main(String[] args) throws Exception {

		
		Map<String, Double> priceMap = ExcelUtlis.getExcelData();
		for (Entry<String, Double> entry : priceMap.entrySet()) {
			String phoneName = entry.getKey();
			Double phonePriceXls = entry.getValue();
			Double phonePriceAmazon = AmazonPriceUtlis
					.priceFromAmazon(phoneName);
			if (phonePriceXls > phonePriceAmazon) {
				System.out.println("Amazon price is less");
			} else {
				System.out.println("Amazon price is MORE");
			}
		}

	}
}
