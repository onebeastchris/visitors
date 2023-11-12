package onebeastchris.event;

import com.mojang.authlib.GameProfile;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;
import onebeastchris.util.PlayerDataUtil;
import onebeastchris.util.PlayerInfoStorage;
import onebeastchris.visitors;

import java.util.HashMap;

public class ServerJoinEvent {

    public static final HashMap<ServerPlayerEntity, PlayerInfoStorage> tempStorage = new HashMap<>();
    public static void register() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            ServerPlayerEntity player = handler.getPlayer().networkHandler.player;
            GameProfile profile = player.getGameProfile();

            if (PlayerDataUtil.isVisitor(profile)) {
                visitors.LOGGER.info(profile.getName() + " joined the server as a visitor.");
                PlayerDataUtil.addVisitor(profile, player);

                tempStorage.put(player, new PlayerInfoStorage(
                                player.getPlayerListName(),
                                player.getServerWorld(),
                                player.getPos())
                );

                player.changeGameMode(GameMode.SPECTATOR);
                player.setCustomName(Text.of("Visitor: " + player.getGameProfile().getName()));
                player.setCustomNameVisible(true);

                // calling this once to ensure players see... something.
                player.sendMessage(Text.of(visitors.config.getWelcomeVisitorMessage1()), true);
            }
        });
    }
}