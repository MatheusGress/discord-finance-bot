package finance.strategy;

import finance.model.Transaction;
import finance.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class MonthlyExpenseStrategy implements CalculationStrategy{

    @Override
    public BigDecimal calculate(List<Transaction> transactions){
        BigDecimal total = BigDecimal.ZERO;
        LocalDate currentDate = LocalDate.now();

        for (Transaction transaction : transactions){
            LocalDate transactionDate = transaction.getDate();
            if (transaction.getType() == TransactionType.EXPENSE
                    && transactionDate.getMonthValue() == currentDate.getMonthValue()
                    && transactionDate.getYear() == currentDate.getYear()){
                total = total.add(transaction.getAmount());
            }
        }
        return total;
    }
}
