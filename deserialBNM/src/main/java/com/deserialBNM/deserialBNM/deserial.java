package com.deserialBNM.deserialBNM;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.thoughtworks.xstream.XStream;

public class deserial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XStream xstream = new XStream();
		xstream.processAnnotations(ValCurs.class);
		xstream.processAnnotations(Valute.class);
		requestClass returnXML = new requestClass();
		ParseCSV returnCSV = new ParseCSV();
		List<String> csvValueList = returnCSV.returnDate();
		Workbook wb = new XSSFWorkbook();
		for(String csvValue : csvValueList) {
			ValCurs valCurs = (ValCurs)xstream.fromXML(returnXML.returnXML(csvValue));
			List<Valute> valuteList = valCurs.getValutes();
			int count = 1;
			Sheet sheet1 = wb.createSheet(csvValue);
			 Row row = sheet1.createRow(0);
			 Cell Date = row.createCell(0);
			 Date.setCellValue("Date");
			 Cell name = row.createCell(1);
			 name.setCellValue("name");
			 Cell ID = row.createCell(2);
			 ID.setCellValue("ID");
			 Cell NumCode = row.createCell(3);
			 NumCode.setCellValue("NumCode");
			 Cell Nominal = row.createCell(4);
			 Nominal.setCellValue("Nominal");
			 Cell Name = row.createCell(5);
			 Name.setCellValue("Name");
			 Cell Value = row.createCell(6);
			 Value.setCellValue("Value");
			for(Valute valute : valuteList) {
				Row row1 = sheet1.createRow(count);
				Cell DateValue = row1.createCell(0);
				DateValue.setCellValue(valCurs.getDate());
				Cell nameValue = row1.createCell(1);
				nameValue.setCellValue(valCurs.getName());
				Cell IDValue = row1.createCell(2);
				IDValue.setCellValue(valute.getId());
				Cell NumCodeValue = row1.createCell(3);
				NumCodeValue.setCellValue(valute.getNumCode());
				Cell NominalValue = row1.createCell(4);
				NominalValue.setCellValue(valute.getNominal());
				Cell NameValue = row1.createCell(5);
				NameValue.setCellValue(valute.getName());
				Cell ValueValue = row1.createCell(6);
				ValueValue.setCellValue(valute.getValue());
				sheet1.autoSizeColumn(0);
				sheet1.autoSizeColumn(count);
				count++;
				
				
				
				 
			}
			
			
		}
		try (OutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
	        wb.write(fileOut);
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
