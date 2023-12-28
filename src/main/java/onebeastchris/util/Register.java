package onebeastchris.util;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import onebeastchris.command.discordCommand;
import onebeastchris.event.ServerJoinEvent;
import onebeastchris.event.ServerLeaveEvent;
import onebeastchris.event.Timer;
import onebeastchris.visitors;

public class Register {

    public static MinecraftServer server;

    public static void registerCommand() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> discordCommand.register(dispatcher));
    }

    public static void registerAll() {
        ServerJoinEvent.register();
        ServerLeaveEvent.register();
        Timer.register();
        if (visitors.config.getDiscordCommand() && !visitors.config.getInviteLink().equals("https://discord.gg/INVITE_LINK")) {
            registerCommand();
        }

        ServerLifecycleEvents.SERVER_STARTED.register((minecraftServer) -> server = minecraftServer);
    }
}