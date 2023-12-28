package onebeastchris.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import onebeastchris.visitors;

import java.util.function.Supplier;

import static net.minecraft.server.command.CommandManager.literal;

public class discordCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("discord").executes(context -> run(context.getSource())));
    }

    public static int run(ServerCommandSource source) {
        Supplier<Text> discordInviteMessage = () -> Text.of(visitors.config.getDiscordInviteMessage());
        Supplier<Text> discordLink = () -> {
            Text link = Text.of("[" + visitors.config.getInviteLink() + "]");
            MutableText text = link.copy().styled((style) -> style.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, visitors.config.getInviteLink())));
            return text.setStyle(text.getStyle().withColor(Formatting.GOLD));
        };

        source.sendFeedback(discordInviteMessage, false);
        source.sendFeedback(discordLink, false);

        return 1;
    }
}