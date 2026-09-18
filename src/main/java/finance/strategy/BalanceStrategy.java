package finance.strategy;

import finance.model.Transaction;
import finance.model.TransactionType;

import java.math.BigDecimal;
import java.util.List;

public class BalanceStrategy implements CalculationStrategy {

    @Override
    public BigDecimal calculate(List<Transaction> transactions) {
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
}
