package finance.service;

import finance.model.Account;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.function.Predicate.isEqual;

public class AccountService {
    private List<Account> accounts = new ArrayList<>();

    public void registerAccount(Account account){
        accounts.add(account);
    }

    public List<Account> getAccounts(){
        return accounts;
    }

    public BigDecimal calculatePendingAmount(){
        BigDecimal totalPending = BigDecimal.ZERO;
         for (Account account : accounts) {
             if (!account.isPaid()){
                 totalPending = totalPending.add(account.getAmount());
             }
         }
        return totalPending;
    }

    public BigDecimal calculatePaidAmount(){
        BigDecimal totalPaid = BigDecimal.ZERO;
         for (Account account : accounts) {
             if (account.isPaid()){
                 totalPaid = totalPaid.add(account.getAmount());
             }
         }
         return totalPaid;
    }

    public BigDecimal calculateOverdueAccounts(){
        BigDecimal totalOverdue = BigDecimal.ZERO;
        LocalDate currentDate = LocalDate.now();

         for (Account account : accounts){
             if (!account.isPaid() && account.getDueDate().isBefore(currentDate)){
                 totalOverdue = totalOverdue.add(account.getAmount());
             }
         }
        return totalOverdue;
    }

}
