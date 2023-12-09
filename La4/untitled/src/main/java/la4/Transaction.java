package la4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Transaction {
    private String transactionId;
    private String description;
    private double amount;
    private Bank bank;

    public Transaction(String transactionId, String description, double amount) {
        this.transactionId = transactionId;
        this.description = description;
        this.amount = amount;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Bank getBank() {
        return bank;
    }

    public String getTransactionId() {
        return transactionId;
    }
    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(transactionId, that.transactionId) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, description, amount);
    }
    public static class Builder {
        private static final int MIN_TRANSACTION_ID_LENGTH = 1;
        private static final int MAX_TRANSACTION_ID_LENGTH = 50;
        private static final double MIN_AMOUNT = 0;

        private String transactionId;
        private String description;
        private double amount;
        private List<String> errors = new ArrayList<>();

        public Builder() {
        }

        public Builder setTransactionId(String transactionId) {
            if (transactionId == null || transactionId.length() < MIN_TRANSACTION_ID_LENGTH || transactionId.length() > MAX_TRANSACTION_ID_LENGTH) {
                errors.add("Invalid transaction ID. Length should be between " +
                        MIN_TRANSACTION_ID_LENGTH + " and " + MAX_TRANSACTION_ID_LENGTH + " characters.");
            }
            this.transactionId = transactionId;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setAmount(double amount) {
            if (amount < MIN_AMOUNT) {
                errors.add("Invalid amount. Should be greater than or equal to " + MIN_AMOUNT);
            }
            this.amount = amount;
            return this;
        }

        public List<String> getErrors() {
            return errors;
        }

        public Transaction build() {
            if (!errors.isEmpty()) {
                throw new IllegalStateException("Cannot build Transaction due to validation errors: " + errors);
            }

            if (transactionId == null) {
                throw new IllegalArgumentException("Transaction ID is required.");
            }

            return new Transaction(this.transactionId, this.description, this.amount);
        }
    }

}