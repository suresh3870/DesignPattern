package com.greatlearning.ccyconverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class INRConverter {

    public static CCYConverter getCCYToConvert(String ccy){
        if (ccy=="GBP"){
            return new GBPConverter();
        }
        else if (ccy=="USD"){
            return new DollarConvertor();
        }
        else {
            return null;
        }
    }
    public static void updateBalance(Connection conn, double amt, int acnumber) throws SQLException {
        String str = "update account set balance = ? where acnumber =?";
        PreparedStatement preparedStatement = conn.prepareStatement(str);
        preparedStatement.setDouble(1, amt);
        preparedStatement.setInt(2, acnumber);
        int row = preparedStatement.executeUpdate();
        System.out.println(row+" Record updated successfully");
    }
}
