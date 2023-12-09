package la3;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionService {

    public static List<Transaction> sortByAmount(List<Transaction> transactions) {
        return transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount))
                .collect(Collectors.toList());
    }

    public static List<Transaction> filterByDescription(List<Transaction> transactions, String description) {
        return transactions.stream()
                .filter(transaction -> transaction.getDescription().equals(description))
                .collect(Collectors.toList());
    }

    public static double calculateTotalAmount(List<Transaction> transactions) {
        return transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }
}