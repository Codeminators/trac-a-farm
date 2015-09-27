package com.android.tracafarm;

/**
 * Created by raghav on 27/09/15.
 */
public class Wheat {
	private static String SOIL_TYPE = "clay loam or loam texture ";
	private int sowingNormalDayStart = 305;
	private int sowingNormalDayEnd = 315;
	public int dayStart = 1;
	public int dayEnd = 15;
	private int sowingNormalMonth = 11;
	private int sowingLateDayStart = 1;
	private int sowingLateDayEnd = 15;
	private int sowingLateMonth = 12;
	
	private String seedDepth = "5cm";
	
	private int firstFertilizer;
	private int secondFertilizer = 20;

	private int firstIrrigation = 20;
	private int secondIrrigation = 40;
	private int thirdIrrigation = 70; 
	private int fourthIrrigation = 90;
	private int fifthIrrigation = 110;
	
	private int pesticides = 30;

	private int harvest = 130;

	public static String getSoilType() {
		return SOIL_TYPE;
	}

	public static void setSoilType(String soilType) {
		SOIL_TYPE = soilType;
	}

	public int getSowingNormalDayStart() {
		return sowingNormalDayStart;
	}

	public void setSowingNormalDayStart(int sowingNormalDayStart) {
		this.sowingNormalDayStart = sowingNormalDayStart;
	}

	public int getSowingNormalDayEnd() {
		return sowingNormalDayEnd;
	}

	public void setSowingNormalDayEnd(int sowingNormalDayEnd) {
		this.sowingNormalDayEnd = sowingNormalDayEnd;
	}

	public int getSowingNormalMonth() {
		return sowingNormalMonth;
	}

	public void setSowingNormalMonth(int sowingNormalMonth) {
		this.sowingNormalMonth = sowingNormalMonth;
	}

	public int getSowingLateDayStart() {
		return sowingLateDayStart;
	}

	public void setSowingLateDayStart(int sowingLateDayStart) {
		this.sowingLateDayStart = sowingLateDayStart;
	}

	public int getSowingLateDayEnd() {
		return sowingLateDayEnd;
	}

	public void setSowingLateDayEnd(int sowingLateDayEnd) {
		this.sowingLateDayEnd = sowingLateDayEnd;
	}

	public int getSowingLateMonth() {
		return sowingLateMonth;
	}

	public void setSowingLateMonth(int sowingLateMonth) {
		this.sowingLateMonth = sowingLateMonth;
	}

	public String getSeedDepth() {
		return seedDepth;
	}

	public void setSeedDepth(String seedDepth) {
		this.seedDepth = seedDepth;
	}

	public int getFirstFertilizer() {
		return firstFertilizer;
	}

	public void setFirstFertilizer(int firstFertilizer) {
		this.firstFertilizer = firstFertilizer;
	}

	public int getSecondFertilizer() {
		return secondFertilizer;
	}

	public void setSecondFertilizer(int secondFertilizer) {
		this.secondFertilizer = secondFertilizer;
	}

	public int getFirstIrrigation() {
		return firstIrrigation;
	}

	public void setFirstIrrigation(int firstIrrigation) {
		this.firstIrrigation = firstIrrigation;
	}

	public int getSecondIrrigation() {
		return secondIrrigation;
	}

	public void setSecondIrrigation(int secondIrrigation) {
		this.secondIrrigation = secondIrrigation;
	}

	public int getThirdIrrigation() {
		return thirdIrrigation;
	}

	public void setThirdIrrigation(int thirdIrrigation) {
		this.thirdIrrigation = thirdIrrigation;
	}

	public int getFourthIrrigation() {
		return fourthIrrigation;
	}

	public void setFourthIrrigation(int fourthIrrigation) {
		this.fourthIrrigation = fourthIrrigation;
	}

	public int getFifthIrrigation() {
		return fifthIrrigation;
	}

	public void setFifthIrrigation(int fifthIrrigation) {
		this.fifthIrrigation = fifthIrrigation;
	}

	public int getPesticides() {
		return pesticides;
	}

	public void setPesticides(int pesticides) {
		this.pesticides = pesticides;
	}

	public int getHarvest() {
		return harvest;
	}

	public void setHarvest(int harvest) {
		this.harvest = harvest;
	}
}