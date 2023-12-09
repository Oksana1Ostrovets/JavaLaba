package la5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class Bank {
    private String name;
    private String location;
    private List<Account> accounts;
    private List<Transaction> transactions;

    public Bank(Builder builder) {
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
    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
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
        private static final int MIN_NAME_LENGTH = 1;
        private static final int MAX_NAME_LENGTH = 100;
        private static final int MIN_LOCATION_LENGTH = 1;
        private static final int MAX_LOCATION_LENGTH = 100;

        private String name;
        private String location;

        public Builder() {
        }

        public Builder setName(String name) {
            if (name == null || name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("Invalid name. Length should be between " +
                        MIN_NAME_LENGTH + " and " + MAX_NAME_LENGTH + " characters.");
            }
            this.name = name;
            return this;
        }

        public Builder setLocation(String location) {
            if (location == null || location.length() < MIN_LOCATION_LENGTH || location.length() > MAX_LOCATION_LENGTH) {
                throw new IllegalArgumentException("Invalid location. Length should be between " +
                        MIN_LOCATION_LENGTH + " and " + MAX_LOCATION_LENGTH + " characters.");
            }
            this.location = location;
            return this;
        }

        public Bank build() {
            if (name == null || location == null) {
                throw new IllegalArgumentException("Name and location are required.");
            }
            return new Bank(this);
        }
    }
}