package cat.porter.orangejuice.mixin;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * An example Mixin using SpongePowered's Mixin library
 *
 * @see Mixin
 * @see Inject
 */
@Mixin(Minecraft.class)
public class MinecraftMixin {

    @Inject(method = "<init>", at = @At(value = "RETURN"))
    private void examplemod$onStartGame(CallbackInfo ci) {
        System.out.println("This is a message from the example mod!");
    }

}
