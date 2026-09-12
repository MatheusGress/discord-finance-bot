package finance.model;

import java.util.UUID;

public class User {
    private UUID discordId;
    private String name;

    private User(UUID discordId, String name){
        this.discordId = discordId;
        this.name = name;
    }
}
