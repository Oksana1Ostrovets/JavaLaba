package la3;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BankService {

    public static List<Bank> sortByName(List<Bank> banks) {
        return banks.stream()
                .sorted(Comparator.comparing(Bank::getName))
                .collect(Collectors.toList());
    }

    public static List<Bank> filterByLocation(List<Bank> banks, String location) {
        return banks.stream()
                .filter(bank -> bank.getLocation().equals(location))
                .collect(Collectors.toList());
    }

    public static List<Account> getAllAccounts(List<Bank> banks) {
        return banks.stream()
                .flatMap(bank -> bank.getAccounts().stream())
                .collect(Collectors.toList());
    }
}
