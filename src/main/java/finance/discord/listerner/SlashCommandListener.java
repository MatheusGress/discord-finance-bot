package finance.discord.listerner;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SlashCommandListener extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){

        switch (event.getName()){
            case "ping":
                event.reply("pong").queue();
                break;
            case "pong":
                event.reply("ping").queue();
                break;
        }
    }
}
