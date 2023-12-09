package la4;

public class Main {
    public static void main(String[] args) {
        try {
            Transaction transaction = new Transaction.Builder()
                    .setTransactionId("123")
                    .setDescription("Payment")
                    .setAmount(100.0)
                    .build();

            System.out.println("Transaction: " + transaction);
            Account account = new Account.Builder()
                    .setAccountNumber("456")
                    .setBalance(1000.0)
                    .build();

            System.out.println("Account: " + account);
            Bank bank = new Bank.Builder()
                    .setName("MyBank")
                    .setLocation("City")
                    .build();

            System.out.println("Bank: " + bank);
            bank.addAccount(account);
            bank.addTransaction(transaction);
            System.out.println("Bank after adding Account and Transaction: " + bank);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
