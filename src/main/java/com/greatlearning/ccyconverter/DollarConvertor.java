package com.greatlearning.ccyconverter;

public class DollarConvertor implements CCYConverter {
    @Override
    public double convertToINR(double tamt) {
        return tamt*75;
    }
}
