package com.deserialBNM.deserialBNM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseCSV {



		public List<String> returnDate(){ 
			List<String> dateString = null;
		try {
			Scanner scanner = new Scanner(new File("dateBNM.csv"));
			scanner.useDelimiter(",");
			dateString = new ArrayList<String>();
			while(scanner.hasNext()){
				dateString.add(scanner.next());
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateString;
		}
		
		
		
	
}
