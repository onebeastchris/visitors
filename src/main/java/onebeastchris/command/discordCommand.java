package onebeastchris.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import onebeastchris.visitors;

import static net.minecraft.server.command.CommandManager.literal;

public class discordCommand {
    public static LiteralCommandNode register(CommandDispatcher<ServerCommandSource> dispatcher) {
        return dispatcher.register(
                literal("discord").executes(context -> {
                    return discordCommand(context.getSource());
                }));
    }

    public static int discordCommand(ServerCommandSource source) {
        Text initialMessage = Text.of(visitors.config.getDiscordInviteMessage());
        Text link = Text.of("[" + visitors.config.getInviteLink() + "]");
        MutableText mutableText = link.copy().styled((style) -> {
            return style.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, visitors.config.getInviteLink()));
        });
        mutableText.setStyle(mutableText.getStyle().withColor(Formatting.GOLD));

        source.sendFeedback(initialMessage, false);
        source.sendFeedback(mutableText, false);

        return 1;
    }
}