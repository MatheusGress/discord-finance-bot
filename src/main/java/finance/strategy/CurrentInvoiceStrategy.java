package finance.strategy;

import finance.model.Card;
import finance.model.Transaction;
import finance.model.TransactionType;

import java.math.BigDecimal;
import java.util.List;

public class CurrentInvoiceStrategy implements CalculationStrategy{

    private Card card;

    public CurrentInvoiceStrategy(Card card) {
        this.card = card;
    }
    @Override
    public BigDecimal calculate(List<Transaction> transactions){
        BigDecimal currentInvoice = BigDecimal.ZERO;

        for (Transaction transaction : transactions){
            if (transaction.getType() == TransactionType.EXPENSE
                    && transaction.isCard()
                    && transaction.getCard().getId().equals(card.getId())) {
                currentInvoice = currentInvoice.add(transaction.getAmount());
            }
        }
        return currentInvoice;
    }
}
