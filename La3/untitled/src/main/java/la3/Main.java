package la3;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank.Builder()
                .setName("MyBank")
                .setLocation("City Center")
                .build();

        Account account1 = new Account("123456789", 1000.0);
        account1.setBank(bank);
        bank.addAccount(account1);

        Account account2 = new Account("987654321", 2000.0);
        account2.setBank(bank);
        bank.addAccount(account2);

        Transaction transaction1 = new Transaction("T123", "Deposit", 500.0);
        transaction1.setBank(bank);
        bank.addTransaction(transaction1);

        Transaction transaction2 = new Transaction("T456", "Withdrawal", 200.0);
        transaction2.setBank(bank);
        bank.addTransaction(transaction2);

        System.out.println("Bank Info: " + bank.toString());
        System.out.println("Account Info 1: " + account1.toString());
        System.out.println("Account Info 2: " + account2.toString());
        System.out.println("Transaction Info 1: " + transaction1.toString());
        System.out.println("Transaction Info 2: " + transaction2.toString());

        List<Transaction> sortedTransactions = TransactionService.sortByAmount(bank.getTransactions());
        System.out.println("Sorted Transactions: " + sortedTransactions);

        List<Transaction> depositTransactions = TransactionService.filterByDescription(bank.getTransactions(), "Deposit");
        System.out.println("Deposit Transactions: " + depositTransactions);

        double totalAmount = TransactionService.calculateTotalAmount(bank.getTransactions());
        System.out.println("Total Transaction Amount: " + totalAmount);

        List<Bank> sortedBanks = BankService.sortByName(List.of(bank));
        System.out.println("Sorted Banks: " + sortedBanks);

        List<Bank> filteredBanks = BankService.filterByLocation(List.of(bank), "City Center");
        System.out.println("Filtered Banks: " + filteredBanks);

        List<Account> allAccounts = BankService.getAllAccounts(List.of(bank));
        System.out.println("All Accounts: " + allAccounts);

        List<Account> sortedAccounts = AccountService.sortByAccountNumber(allAccounts);
        System.out.println("Sorted Accounts: " + sortedAccounts);

        List<Account> highBalanceAccounts = AccountService.filterByBalance(allAccounts, 1500.0);
        System.out.println("High Balance Accounts: " + highBalanceAccounts);

        double averageBalance = AccountService.calculateAverageBalance(allAccounts);
        System.out.println("Average Balance: " + averageBalance);
    }
}