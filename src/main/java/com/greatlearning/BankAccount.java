package com.greatlearning;

import com.greatlearning.ccyconverter.INRConverter;
import com.greatlearning.customer.BankCustomer;
import com.greatlearning.customer.TypeofAccount;
import com.greatlearning.dbconnect.dbConnect;

import java.sql.Connection;
import java.sql.SQLException;

public class BankAccount {
    public static void main(String[] args) throws SQLException {
        BankCustomer customer1= BankCustomer.builder().bankAcNumber(123).branch("T Nagar").typeOfAccount(TypeofAccount.Saving).balance(100).build();
        System.out.println(customer1.toString());
        Connection conn = dbConnect.getConnection();
        customer1.saveCustomer(conn, customer1.getBankAcNumber(), customer1.getTypeOfAccount(),
                customer1.getBranch(),customer1.getBalance());
        double gbpToInr = INRConverter.getCCYToConvert("GBP").convertToINR(500);
        double usdToInr = INRConverter.getCCYToConvert("USD").convertToINR(700);
        customer1.setBalance(gbpToInr+usdToInr+(customer1.getBalance()));
        INRConverter.updateBalance(conn, customer1.getBalance(),customer1.getBankAcNumber());
        System.out.println("Current Balance post update "+customer1.getBalance());
        conn.close();
    }
}
