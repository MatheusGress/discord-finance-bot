package finance.model;

import java.math.BigDecimal;
import java.util.UUID;
import java.time.LocalDate;

public class Account {
    private UUID id;
    private String description;
    private BigDecimal amount;
    private LocalDate dueDate;
    private boolean paid;
    private boolean recurring;

    private Account(UUID id, String description, BigDecimal amount, LocalDate dueDate, boolean paid, boolean recurring){
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.dueDate = dueDate;
        this.paid = paid;
        this.recurring = recurring;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }

    public BigDecimal getAmount(){
        return amount;
    }

    public boolean isPaid(){
        return paid;
    }
}
