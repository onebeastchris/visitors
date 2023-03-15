package onebeastchris.event;

import com.mojang.authlib.GameProfile;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;
import onebeastchris.util.PlayerDataUtil;
import onebeastchris.util.PlayerInfoStorage;
import onebeastchris.visitors;


public class ServerLeaveEvent {
    public static void register() {
        ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> {
            ServerPlayerEntity player = handler.getPlayer().networkHandler.player;
            GameProfile profile = player.getGameProfile();

            if (PlayerDataUtil.isVisitor(profile)) {
                    onLeave(player, profile);
            }
        });
    }

    public static void onLeave(ServerPlayerEntity player, GameProfile profile){
        PlayerDataUtil.removeVisitor(profile);
        PlayerInfoStorage storage = ServerJoinEvent.tempStorage.get(player);

        int x = storage.getPosition()[0];
        int y = storage.getPosition()[1];
        int z = storage.getPosition()[2];

        player.teleport(storage.getWorld(), x, y, z, 0, 0);
        player.changeGameMode(GameMode.DEFAULT);
        player.sendMessage(Text.of(visitors.config.getWelcomeMemberMessage()), true);
        player.setCustomName(storage.getName());

        PlayerDataUtil.removeVisitor(profile);
        ServerJoinEvent.tempStorage.remove(player);
    }
}