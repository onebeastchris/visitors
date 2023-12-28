package onebeastchris.event;

import com.mojang.authlib.GameProfile;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import onebeastchris.util.PlayerDataUtil;
import onebeastchris.util.PlayerInfoStorage;
import onebeastchris.util.Register;
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
        PlayerInfoStorage storage = ServerJoinEvent.tempStorage.remove(player);

        double x = storage.position().getX();
        double y = storage.position().getY();
        double z = storage.position().getZ();

        player.teleport(storage.world(), x, y, z, 0, 0);
        player.changeGameMode(Register.server.getDefaultGameMode());
        player.sendMessage(Text.of(visitors.config.getWelcomeMemberMessage()), true);
        player.setCustomName(storage.name());
    }
}