package onebeastchris.util;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;

public class PlayerInfoStorage {
    private final Text name;
    private final ServerWorld world;
    private final int[] position;

    public PlayerInfoStorage(Text name, ServerWorld world, int[] position) {
        this.name = name;
        this.world = world;
        this.position = position;
    }

    public Text getName() {
        return name;
    }

    public ServerWorld getWorld() {
        return world;
    }

    public int[] getPosition() {
        return position;
    }
}