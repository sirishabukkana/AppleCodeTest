package com.springschedulardemo.entity;

public class DataFileInfo {

	private double CAD_USD;
	private double FR_USD;

	public DataFileInfo() {

	}

	public DataFileInfo(double cAD_USD, double fR_USD) {
		super();
		CAD_USD = cAD_USD;
		FR_USD = fR_USD;
	}

	public double getCAD_USD() {
		return CAD_USD;
	}

	public void setCAD_USD(double cAD_USD) {
		CAD_USD = cAD_USD;
	}

	public double getFR_USD() {
		return FR_USD;
	}

	public void setFR_USD(double fR_USD) {
		FR_USD = fR_USD;
	}

	@Override
	public String toString() {
		return "DataFileInfo [CAD_USD=" + CAD_USD + ", FR_USD=" + FR_USD + "]";
	}

}
