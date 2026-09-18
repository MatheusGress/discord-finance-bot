package finance.service;

import finance.model.Card;
import finance.model.TransactionType;
import finance.model.Transaction;
import finance.strategy.BalanceStrategy;
import finance.strategy.CalculationStrategy;
import finance.strategy.CurrentInvoiceStrategy;
import finance.strategy.MonthlyExpenseStrategy;

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
        CalculationStrategy strategy = new BalanceStrategy();
        return strategy.calculate(transactions);
    }

    public BigDecimal calculateMonthlyExpenses(){
        CalculationStrategy strategy = new MonthlyExpenseStrategy();
        return strategy.calculate(transactions);
    }

    public BigDecimal calculateCurrentInvoice(Card card){
        CalculationStrategy strategy = new CurrentInvoiceStrategy(card);
        return strategy.calculate(transactions);
    }
}
