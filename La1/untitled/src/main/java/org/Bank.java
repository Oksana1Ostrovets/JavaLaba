package org;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bank {
    private String name;
    private String location;
    private List<Account> accounts;
    private List<Transaction> transactions;

    private Bank(Builder builder) {
        this.name = builder.name;
        this.location = builder.location;
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.equals(location, bank.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    public static class Builder {
        private String name;
        private String location;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }
        public Bank build() {
            return new Bank(this);
        }
    }
}