package com.zipcodeprocessor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ZipcodeUtil {
	public List<Zipcode> mergeZipcodeList(List<Zipcode> sortedZipCodeList) {
	    List<Zipcode> mergedZipcodeList = new LinkedList<Zipcode>();
	    Zipcode zipcode = null;
	    for (Zipcode zipcodeRange : sortedZipCodeList) {
	      if (zipcode == null)
	        zipcode = zipcodeRange;
	      else {
	        if (Integer.parseInt(zipcode.getEnd()) >= Integer.parseInt(zipcodeRange.getStart())) {
	          zipcode.setEnd(String.valueOf(Math.max(Integer.parseInt(zipcode.getEnd()), Integer.parseInt(zipcodeRange.getEnd()))));
	        } else {
	          mergedZipcodeList.add(zipcode);
	          zipcode = zipcodeRange;
	        }
	      }
	    }
	    mergedZipcodeList.add(zipcode);
	    System.out.println("Merged Zipcode List");
	    for(Zipcode zip: mergedZipcodeList) {
	    	System.out.println(zip);
	    }
	    return mergedZipcodeList;
	  }

	  public List<Zipcode> sortedZipCodeList(List<Zipcode> zipcodeList) {
	    Collections.sort(zipcodeList, new ZipcodeComparator());
	    return zipcodeList;
	  }

	  public ArrayList<Zipcode> readInputFile(String zipcodeFile) {
			ArrayList<Zipcode> zipcodeList = new ArrayList<Zipcode>();
			BufferedReader br = null;
			String currentLine;
			try {
				br = new BufferedReader(new FileReader(zipcodeFile));
				try {
					while ((currentLine = br.readLine()) != null) {
						String[] zipCodes = currentLine.split(",");
						if (validateInput(zipCodes[0]) && validateInput(zipCodes[1])) {
							Zipcode zipCode = new Zipcode();
							if (Integer.parseInt(zipCodes[0]) <= Integer.parseInt(zipCodes[1]))
								zipCode = new Zipcode(zipCodes[0], zipCodes[1]);
							else
								zipCode = new Zipcode(zipCodes[1], zipCodes[0]);
							zipcodeList.add(zipCode);
						}
					}
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("Initial Zipcode List");
		    for(Zipcode zip: zipcodeList) {
		    	System.out.println(zip);
		    }
			return zipcodeList;
		}
	  
	  public boolean validateInput(String s) {
			if(s.length() == 5 && s.matches("-?(0|[1-9]\\d*)")) {
				return true;
			}
			return false;
		}
}
