package onebeastchris.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import onebeastchris.visitors;

import java.util.function.Supplier;

import static net.minecraft.server.command.CommandManager.literal;

public class discordCommand {
    public static LiteralCommandNode register(CommandDispatcher<ServerCommandSource> dispatcher) {
        return dispatcher.register(
                literal("discord").executes(context -> discordCommand(context.getSource())));
    }

    public static int discordCommand(ServerCommandSource source) {
        Supplier<Text> initialText = () -> Text.of(visitors.config.getDiscordInviteMessage());
        Supplier<Text> mutableText = () -> {
            Text link = Text.of("[" + visitors.config.getInviteLink() + "]");
            MutableText text = link.copy().styled((style) -> style.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, visitors.config.getInviteLink())));
            return text.setStyle(text.getStyle().withColor(Formatting.GOLD));
        };

        source.sendFeedback(initialText, false);
        source.sendFeedback(mutableText, false);

        return 1;
    }
}