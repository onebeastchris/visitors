package onebeastchris.util;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public record PlayerInfoStorage(Text name, ServerWorld world, Vec3d position) {
}