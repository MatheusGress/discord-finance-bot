package finance.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Card {
    private UUID id;
    private String name;
    private BigDecimal limit;
    private LocalDate closingDate;
    private LocalDate dueDate;

    private Card(UUID id, String name, BigDecimal limit, LocalDate closingDate, LocalDate dueDate){
        this.id = id;
        this.name = name;
        this.limit = limit;
        this.closingDate = closingDate;
        this.dueDate = dueDate;
    }
}
