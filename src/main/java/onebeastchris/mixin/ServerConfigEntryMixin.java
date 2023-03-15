package onebeastchris.mixin;

import net.minecraft.server.ServerConfigEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

public class ServerConfigEntryMixin {
    @Mixin(ServerConfigEntry.class)
    public interface ServerConfigEntryInvoker<T> {
        @Invoker
        T callGetKey();
    }
}