package org;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank.Builder()
                .setName("MyBank")
                .setLocation("City Center")
                .build();

        Account account = new Account("123456789", 1000.0);
        account.setBank(bank);
        bank.addAccount(account);

        Transaction transaction = new Transaction("T123", "Deposit", 500.0);
        transaction.setBank(bank);
        bank.addTransaction(transaction);

        System.out.println("Bank Info: " + bank.toString());
        System.out.println("Account Info: " + account.toString());
        System.out.println("Transaction Info: " + transaction.toString());
        Transaction anotherTransaction = new Transaction("T456", "Withdrawal", 200.0);
        System.out.println("Transaction equals AnotherTransaction: " + transaction.equals(anotherTransaction));
        System.out.println("Bank hashCode: " + bank.hashCode());
        System.out.println("Account hashCode: " + account.hashCode());
        System.out.println("Transaction hashCode: " + transaction.hashCode());
    }
}