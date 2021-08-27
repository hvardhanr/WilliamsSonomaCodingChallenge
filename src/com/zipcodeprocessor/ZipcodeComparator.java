package com.zipcodeprocessor;

import java.util.Comparator;

public class ZipcodeComparator implements Comparator<Zipcode> {
	public int compare(Zipcode range1, Zipcode range2) {
	   return range1.getStart().compareTo(range2.getStart());
	  }
}
