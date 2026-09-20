package finance.discord.listerner;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.List;

public class ReadyListener extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        System.out.println("Bot is online!");

        List<Guild> guilds = event.getJDA().getGuilds();

        Guild guild = guilds.getFirst();

        guild.updateCommands()
                .addCommands(
                        Commands.slash("ping", "Check if the bot is online")
                )
                .queue();
    }
}