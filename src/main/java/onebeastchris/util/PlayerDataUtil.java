package onebeastchris.util;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.network.ServerPlayerEntity;
import onebeastchris.event.ServerLeaveEvent;

import java.util.HashMap;

public class PlayerDataUtil {

    public static final HashMap<GameProfile, ServerPlayerEntity> visitorMap = new HashMap<>();

    public static void addFutureVisitor(GameProfile gameProfile){
        visitorMap.put(gameProfile, null);
    }

    public static void addVisitor(GameProfile gameProfile, ServerPlayerEntity player){
        visitorMap.put(gameProfile, player);
    }

    public static void changeStatus(GameProfile gameProfile){
        if (visitorMap.containsKey(gameProfile)) {
            ServerLeaveEvent.onLeave(visitorMap.get(gameProfile), gameProfile);
            visitorMap.remove(gameProfile);
        }
    }
    public static boolean isVisitor(GameProfile gameProfile){
        return visitorMap.containsKey(gameProfile);
    }
    public static void removeVisitor(GameProfile gameProfile){
        visitorMap.remove(gameProfile);
    }

}