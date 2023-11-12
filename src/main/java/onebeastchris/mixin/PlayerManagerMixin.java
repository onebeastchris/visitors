package onebeastchris.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.PlayerManager;
import onebeastchris.util.PlayerDataUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
@Mixin(PlayerManager.class)
public class PlayerManagerMixin {

	@Redirect(method = "checkCanJoin", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/PlayerManager;isWhitelisted(Lcom/mojang/authlib/GameProfile;)Z"))
	private boolean visitors$isWhitelisted(PlayerManager instance, GameProfile profile) {
		if (!instance.isWhitelisted(profile)) {
			PlayerDataUtil.addFutureVisitor(profile);
		}
		return true;
	}
}