package finance.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Transaction {
    private UUID id;
    private BigDecimal amount;
    private TransactionType type;
    private Category category;
    private String description;
    private LocalDate date;
    private Card card;


    public Transaction(UUID id, BigDecimal amount, TransactionType type, Category category, String description, LocalDate date, Card card){
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.description = description;
        this.date = date;
        this.card = card;
    }

    public TransactionType getType(){
        return type;
    }

    public BigDecimal getAmount(){
        return amount;
    }

    public LocalDate getDate(){
        return date;
    }

    public Card getCard(){
        return card;
    }

    public boolean isCard(){
        return card != null;
    }


}
