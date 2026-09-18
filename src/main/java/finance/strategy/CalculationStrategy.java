package finance.strategy;

import finance.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface CalculationStrategy {

    BigDecimal calculate(List<Transaction> transactions);

}