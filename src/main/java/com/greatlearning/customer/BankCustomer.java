package com.greatlearning.customer;

import lombok.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Builder
@ToString
@Getter
@Setter
public class BankCustomer {
    private int bankAcNumber;
    private TypeofAccount typeOfAccount;
    private String branch;
    private double balance;

    public void saveCustomer(Connection conn, int bankAcNumber, TypeofAccount typeOfAccount, String branch, double balance) throws SQLException {
        if (conn != null && !conn.isClosed()) {
            String str = "replace into account values (?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(str);
            preparedStatement.setInt(1, bankAcNumber);
            preparedStatement.setString(2, String.valueOf(typeOfAccount));
            preparedStatement.setString(3, branch);
            preparedStatement.setDouble(4, balance);
            int row = preparedStatement.executeUpdate();
            System.out.println("Row has been inserted successfully");
        }
    }
}
