package com.zipcodeprocessor;

import java.util.ArrayList;
import java.util.List;

public class ZipcodeProcessor {

	public static void main(String[] args) {
	    //define variables
	    List<Zipcode> zipcodeList = new ArrayList<Zipcode>();
	    List<Zipcode> sortedzipcodeList = new ArrayList<Zipcode>();
	    List<Zipcode> mergedZipcodeList = new ArrayList<Zipcode>();
	    //read CSV to fetch Zipcode
	    ZipcodeUtil zipcodeUtil = new ZipcodeUtil();
	    zipcodeList = zipcodeUtil.readInputFile("resources/input2.csv");
	    sortedzipcodeList = zipcodeUtil.sortedZipCodeList(zipcodeList);
	    mergedZipcodeList = zipcodeUtil.mergeZipcodeList(sortedzipcodeList);

	}

}
