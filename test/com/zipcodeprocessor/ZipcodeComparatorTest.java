package com.zipcodeprocessor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import junit.framework.TestCase;

public class ZipcodeComparatorTest extends TestCase {
	
	@Test
	public void testPositiveZipCodeComparator() {
		ZipcodeComparator comparator = new ZipcodeComparator();
		Zipcode range1 = new Zipcode("95123","98000");
		Zipcode range2 = new Zipcode("92000","96000");
		assertEquals(comparator.compare(range1, range2), 1);
	}
	
	@Test
	public void testNegativeZipCodeComparator() {
		ZipcodeComparator comparator = new ZipcodeComparator();
		Zipcode range1 = new Zipcode("95123","98000");
		Zipcode range2 = new Zipcode("96000","98000");
		assertEquals(comparator.compare(range1, range2), -1);
	}
}
