package la5;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            createBankTable(statement);
            createAccountTable(statement);
            createTransactionTable(statement);

            System.out.println("Tables created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createBankTable(Statement statement) throws SQLException {
        String createBankTable = "CREATE TABLE Bank (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(255) NOT NULL," +
                "location VARCHAR(255) NOT NULL" +
                ")";
        statement.executeUpdate(createBankTable);
    }

    private static void createAccountTable(Statement statement) throws SQLException {
        String createAccountTable = "CREATE TABLE Account (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "accountNumber VARCHAR(255) NOT NULL," +
                "balance DOUBLE NOT NULL," +
                "bank_id INT," +
                "FOREIGN KEY (bank_id) REFERENCES Bank(id)" +
                ")";
        statement.executeUpdate(createAccountTable);
    }

    private static void createTransactionTable(Statement statement) throws SQLException {
        String createTransactionTable = "CREATE TABLE Transaction (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "transactionId VARCHAR(255) NOT NULL," +
                "description VARCHAR(255) NOT NULL," +
                "amount DOUBLE NOT NULL," +
                "bank_id INT," +
                "FOREIGN KEY (bank_id) REFERENCES Bank(id)" +
                ")";
        statement.executeUpdate(createTransactionTable);
    }
}
