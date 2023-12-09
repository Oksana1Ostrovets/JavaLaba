package la3;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AccountService {
    public static List<Account> sortByAccountNumber(List<Account> accounts) {
        if (accounts == null) {
            return Collections.emptyList();
        }

        return accounts.stream()
                .sorted(Comparator.comparing(Account::getAccountNumber))
                .collect(Collectors.toList());
    }

    public static List<Account> filterByBalance(List<Account> accounts, double minBalance) {
        return accounts.stream()
                .filter(account -> account.getBalance() > minBalance)
                .collect(Collectors.toList());
    }

    public static double calculateAverageBalance(List<Account> accounts) {
        return accounts.stream()
                .mapToDouble(Account::getBalance)
                .average()
                .orElse(0.0);
    }
}

