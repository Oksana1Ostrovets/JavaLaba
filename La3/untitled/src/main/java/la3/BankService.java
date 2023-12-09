package la3;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BankService {

    public static List<Bank> sortByName(List<Bank> banks) {
        List<Bank> sortedBanks = new LinkedList<>(banks);
        Collections.sort(sortedBanks, Comparator.comparing(Bank::getName));
        return sortedBanks;
    }

    public static List<Bank> filterByLocation(List<Bank> banks, String location) {
        List<Bank> filteredBanks = new LinkedList<>();
        for (Bank bank : banks) {
            if (bank.getLocation().equals(location)) {
                filteredBanks.add(bank);
            }
        }
        return filteredBanks;
    }

    public static List<Account> getAllAccounts(List<Bank> banks) {
        List<Account> allAccounts = new LinkedList<>();
        for (Bank bank : banks) {
            allAccounts.addAll(bank.getAccounts());
        }
        return allAccounts;
    }
}
