package la5;

import java.util.Objects;

public class Account {
    private String accountNumber;
    private double balance;
    private Bank bank;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Bank getBank() {
        return bank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0 && Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, balance);
    }
    public static class Builder {
        private static final int MIN_ACCOUNT_NUMBER_LENGTH = 1;
        private static final int MAX_ACCOUNT_NUMBER_LENGTH = 50;
        private static final double MIN_BALANCE = 0;

        private String accountNumber;
        private double balance;

        public Builder() {
        }

        public Builder setAccountNumber(String accountNumber) {
            if (accountNumber == null || accountNumber.length() < MIN_ACCOUNT_NUMBER_LENGTH || accountNumber.length() > MAX_ACCOUNT_NUMBER_LENGTH) {
                throw new IllegalArgumentException("Invalid account number. Length should be between " +
                        MIN_ACCOUNT_NUMBER_LENGTH + " and " + MAX_ACCOUNT_NUMBER_LENGTH + " characters.");
            }
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder setBalance(double balance) {
            if (balance < MIN_BALANCE) {
                throw new IllegalArgumentException("Invalid balance. Should be greater than or equal to " + MIN_BALANCE);
            }
            this.balance = balance;
            return this;
        }

        public Account build() {
            if (accountNumber == null) {
                throw new IllegalArgumentException("Account number is required.");
            }
            return new Account(this.accountNumber, this.balance);
        }
    }
}