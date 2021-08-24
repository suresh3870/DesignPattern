package com.greatlearning.ccyconverter;

public class GBPConverter implements CCYConverter {

    @Override
    public double convertToINR(double tamt) {
        return tamt*90;
    }
}
