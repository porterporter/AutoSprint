package cat.porter.orangejuice.mixin;

import cat.porter.orangejuice.config.OrangeJuiceConfig;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.world.World;
import org.polyfrost.universal.UScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityPlayerSP.class)
public abstract class MixinEntityPlayerSP extends AbstractClientPlayer {

    public MixinEntityPlayerSP(World worldIn, GameProfile playerProfile) {
        super(worldIn, playerProfile);
    }

    @Redirect(
            method = "onLivingUpdate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/settings/KeyBinding;isKeyDown()Z"
            )
    )
    private boolean setSprintState(KeyBinding keyBinding) {
        return keyBinding.isKeyDown() || UScreen.getCurrentScreen() == null && OrangeJuiceConfig.INSTANCE.enabled && OrangeJuiceConfig.INSTANCE.getToggleSprint() && OrangeJuiceConfig.INSTANCE.getToggleSpringState();
    }
}