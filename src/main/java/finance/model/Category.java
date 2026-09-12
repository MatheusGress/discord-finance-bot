package finance.model;

import java.util.UUID;

public class Category {
    private UUID id;
    private String name;

    private Category(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
