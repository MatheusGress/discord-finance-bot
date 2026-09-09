package finance.service;

import finance.model.TransactionType;
import finance.model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FinanceService {
    private List<Transaction> transactions = new ArrayList<>();

    public void registerTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions(){
        return transactions;
    }

    public BigDecimal calculateBalance(){
        BigDecimal balance = BigDecimal.ZERO;
         for (Transaction transaction : transactions) {
             if (transaction.getType() == TransactionType.INCOME) {
                 balance = balance.add(transaction.getAmount());
             } else if (transaction.getType() == TransactionType.EXPENSE){
                 balance = balance.subtract(transaction.getAmount());
             }
         }
         return balance;
    }

    public BigDecimal calculateMonthlyExpenses(){
        BigDecimal total = BigDecimal.ZERO;
        LocalDate currentDate = LocalDate.now();

        for (Transaction transaction : transactions){
            LocalDate transactionDate = transaction.getDate();
                if (transaction.getType() == TransactionType.EXPENSE && transactionDate.getMonthValue() == currentDate.getMonthValue() && transactionDate.getYear() == currentDate.getYear()){
                total = total.add(transaction.getAmount());
                }
        }
        return total;
    }

    public BigDecimal calculateCurrentInvoice(){
        BigDecimal currentInvoice = BigDecimal.ZERO;
        for (Transaction transaction : transactions){
            if (transaction.getType() == TransactionType.EXPENSE && transaction.isCard()){
                currentInvoice = currentInvoice.add(transaction.getAmount());
            }
        }
        return currentInvoice;
    }
}
