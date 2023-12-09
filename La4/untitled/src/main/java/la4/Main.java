package la4;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            Bank bank = new Bank.Builder()
                    .setName("Sample Bank")
                    .setLocation("Sample Location")
                    .build();

            Account account = new Account("123456789", 1000.0);
            account.setBank(bank);

            Transaction transaction = new Transaction("T123", "Sample Transaction", 500.0);
            transaction.setBank(bank);
            saveBank(connection, bank);
            saveAccount(connection, account);
            saveTransaction(connection, transaction);

            List<Bank> banks = getAllBanks(connection);
            for (Bank b : banks) {
                System.out.println(b);
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void saveBank(Connection connection, Bank bank) throws SQLException {
        String insertBankQuery = "INSERT INTO Bank (name, location) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertBankQuery)) {
            preparedStatement.setString(1, bank.getName());
            preparedStatement.setString(2, bank.getLocation());
            preparedStatement.executeUpdate();
        }
    }

    private static void saveAccount(Connection connection, Account account) throws SQLException {
        String insertAccountQuery = "INSERT INTO Account (accountNumber, balance, bank_id) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertAccountQuery)) {
            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setDouble(2, account.getBalance());
            preparedStatement.setInt(3, getBankId(connection, account.getBank().getName()));
            preparedStatement.executeUpdate();
        }
    }

    private static void saveTransaction(Connection connection, Transaction transaction) throws SQLException {
        String insertTransactionQuery = "INSERT INTO Transaction (transactionId, description, amount, bank_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertTransactionQuery)) {
            preparedStatement.setString(1, transaction.getTransactionId());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setInt(4, getBankId(connection, transaction.getBank().getName()));
            preparedStatement.executeUpdate();
        }
    }

    private static List<Bank> getAllBanks(Connection connection) throws SQLException {
        return null;
    }

    private static int getBankId(Connection connection, String bankName) throws SQLException {
        return 0;
    }
}
