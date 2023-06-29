package onebeastchris.mixin;


import com.mojang.authlib.GameProfile;
import net.minecraft.server.ServerConfigEntry;
import net.minecraft.server.ServerConfigList;
import net.minecraft.server.WhitelistEntry;
import onebeastchris.util.PlayerDataUtil;
import onebeastchris.visitors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerConfigList.class)
public abstract class ServerConfigListMixin {

    @Inject(method = "add", at = @At("TAIL"))
    private void add(ServerConfigEntry<?> entry, CallbackInfo ci) {
            if (entry instanceof WhitelistEntry whitelistEntry) {
                try {
                    GameProfile profile = ((ServerConfigEntryMixin.ServerConfigEntryInvoker<GameProfile>) whitelistEntry).callGetKey();
                    visitors.LOGGER.debug("WhitelistEntry: " + profile.getName());
                    PlayerDataUtil.changeStatus(profile);
                } catch (Exception e) {
                    visitors.LOGGER.error("Error getting GameProfile from WhitelistEntry", e);
                }
            }
    }
}