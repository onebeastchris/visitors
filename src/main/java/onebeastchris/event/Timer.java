package onebeastchris.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import onebeastchris.util.PlayerDataUtil;
import onebeastchris.visitors;

public class Timer {
    private static int ticks = 0;
    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            ticks++;
            if (ticks == (20*5)){
                sendMessageToVisitors(visitors.config.getWelcomeVisitorMessage1());
            } else if (ticks == (20*10)){
                sendMessageToVisitors(visitors.config.getWelcomeVisitorMessage2());
                ticks = 0;
            }
        });
    }
    public static void sendMessageToVisitors(String message){
        for (ServerPlayerEntity player : PlayerDataUtil.visitorMap.values()){
            player.sendMessage(Text.of(message), true);
        }
    }
}