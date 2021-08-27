package com.zipcodeprocessor;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import junit.framework.TestCase;

public class ZipcodeUtilTest extends TestCase {
	
	@Test
	public void testNonOverlappingRanges() {
		List<Zipcode> inputZipcodeList = new ArrayList<Zipcode>();
		List<Zipcode> sortedInputZipcodeList = new ArrayList<Zipcode>();
		List<Zipcode> MergedInputZipcodeList = new ArrayList<Zipcode>();
		List<Zipcode> outputZipcodeList = new ArrayList<Zipcode>();
		ZipcodeUtil zipcodeUtil = new ZipcodeUtil();
		inputZipcodeList = zipcodeUtil.readInputFile("resources/input1.csv");
		outputZipcodeList = zipcodeUtil.readInputFile("resources/output1.csv");
		sortedInputZipcodeList = zipcodeUtil.sortedZipCodeList(inputZipcodeList);
		MergedInputZipcodeList = zipcodeUtil.mergeZipcodeList(sortedInputZipcodeList);
		assertTrue(outputZipcodeList.equals(MergedInputZipcodeList));
	}
	
	@Test
	public void testOverlappingRanges() {
		List<Zipcode> inputZipcodeList = new ArrayList<Zipcode>();
		List<Zipcode> sortedInputZipcodeList = new ArrayList<Zipcode>();
		List<Zipcode> MergedInputZipcodeList = new ArrayList<Zipcode>();
		List<Zipcode> outputZipcodeList = new ArrayList<Zipcode>();
		ZipcodeUtil zipcodeUtil = new ZipcodeUtil();
		inputZipcodeList = zipcodeUtil.readInputFile("resources/input2.csv");
		outputZipcodeList = zipcodeUtil.readInputFile("resources/output2.csv");
		sortedInputZipcodeList = zipcodeUtil.sortedZipCodeList(inputZipcodeList);
		MergedInputZipcodeList = zipcodeUtil.mergeZipcodeList(sortedInputZipcodeList);
		assertTrue(outputZipcodeList.equals(MergedInputZipcodeList));
	}

}
