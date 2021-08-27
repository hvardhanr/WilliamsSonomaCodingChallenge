package com.zipcodeprocessor;

public class Zipcode {
	private String start;
	private String end;

	Zipcode() {
		this.start = "0";
		this.end = "0";
	}

	Zipcode(String start, String end) {
		this.start = start;
		this.end = end;
	}

	public String getStart() {
		return this.start;
	}

	public String getEnd() {
		return this.end;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String toString() {
		return this.start + "," + this.end;
	}
}
