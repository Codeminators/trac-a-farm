package com.android.tracafarm;

/**
 * Created by raghav on 27/09/15.
 */
public class Sugarcane {
    private static String SOIL_TYPE = "loamy or clay loamy texture";
    private int sowingNormalDayStart = 1;
    private int sowingNormalDayEnd = 15;
    private int sowingNormalMonthStart = 9;
    private int sowingNormalMonthEnd = 10;

    private String seedDepth = "10cm";

    private int firstIrrigation = 7;
    private int secondIrrigation = 20;
    private int thirdIrrigation = 40;
    private int fourthIrrigation = 67;
    private int fifthIrrigation = 90;

    private int firstFertilizer;
    private int secondFertilizer = firstIrrigation;

    private int pesticides = 30;

    private int harvest = 540;

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

    public int getSowingNormalMonthStart() {
        return sowingNormalMonthStart;
    }

    public void setSowingNormalMonthStart(int sowingNormalMonthStart) {
        this.sowingNormalMonthStart = sowingNormalMonthStart;
    }

    public int getSowingNormalMonthEnd() {
        return sowingNormalMonthEnd;
    }

    public void setSowingNormalMonthEnd(int sowingNormalMonthEnd) {
        this.sowingNormalMonthEnd = sowingNormalMonthEnd;
    }

    public String getSeedDepth() {
        return seedDepth;
    }

    public void setSeedDepth(String seedDepth) {
        this.seedDepth = seedDepth;
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
