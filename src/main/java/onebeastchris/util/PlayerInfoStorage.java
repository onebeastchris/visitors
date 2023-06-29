package onebeastchris.util;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;

public record PlayerInfoStorage(Text name, ServerWorld world, int[] position) {
}