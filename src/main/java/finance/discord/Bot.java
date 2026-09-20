package finance.discord;

import finance.discord.listerner.ReadyListener;
import finance.discord.listerner.SlashCommandListener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.exceptions.InvalidTokenException;

public class Bot {

    private final BotConfig botConfig = new BotConfig();

    public void start() {
        try {
            JDABuilder.createDefault(botConfig.getToken())
                    .addEventListeners(new ReadyListener())
                    .addEventListeners(new SlashCommandListener())
                    .build();

        } catch (InvalidTokenException e) {
            System.out.println("ERROR: Invalid bot token.");
        }
    }


}