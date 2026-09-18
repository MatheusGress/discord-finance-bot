package finance.factory;

import finance.model.Card;
import finance.model.Category;
import finance.model.Transaction;
import finance.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class TransactionFactory {

    public static Transaction createTransaction(BigDecimal amount, TransactionType type, Category category, String description, LocalDate date, Card card){
            UUID id = UUID.randomUUID();
       return new Transaction(id,amount, type, category, description, date, card);
    }

}
