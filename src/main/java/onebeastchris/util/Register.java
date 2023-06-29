package onebeastchris.util;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import onebeastchris.command.discordCommand;
import onebeastchris.event.ServerJoinEvent;
import onebeastchris.event.ServerLeaveEvent;
import onebeastchris.event.Timer;
import onebeastchris.visitors;

public class Register {

    public static void registerCommand() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> discordCommand.register(dispatcher));
    }

    public static void registerAll() {
        ServerJoinEvent.register();
        ServerLeaveEvent.register();
        Timer.register();
        if (visitors.config.getDiscordCommand()) {
            // if the "inviteLink" value is not default and if "discordCommand" is true
            if (!visitors.config.getInviteLink().equals("https://discord.gg/INVITE_LINK") && visitors.config.getDiscordCommand()) {
                registerCommand();
            }
        }
    }
}