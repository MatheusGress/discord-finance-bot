package finance.service;

import finance.model.Account;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReminderService {

    public List<Account> getDueTodayAccounts(List<Account> accounts){
        List<Account> dueTodayAccounts = new ArrayList<>();

        for (Account account : accounts){
            if (!account.isPaid() && account.getDueDate().equals(LocalDate.now())) {
                dueTodayAccounts.add(account);
            }
        }
        return dueTodayAccounts;
    }

    public List<Account> getDueTomorrowAccounts(List<Account> accounts){
        List<Account> dueTomorrowAccounts = new ArrayList<>();
        LocalDate tomorrow = LocalDate.now().plusDays(1);

        for (Account account : accounts){
            if (!account.isPaid() && account.getDueDate().equals(tomorrow)){
                dueTomorrowAccounts.add(account);
            }
        }
        return dueTomorrowAccounts;
    }

    public List<Account> getOverdueAccounts(List<Account> accounts){
        List<Account> overdueAccounts = new ArrayList<>();

        for (Account account : accounts){
            if (!account.isPaid() && account.getDueDate().isBefore(LocalDate.now())){
                overdueAccounts.add(account);
            }
        }
        return overdueAccounts;
    }

}
