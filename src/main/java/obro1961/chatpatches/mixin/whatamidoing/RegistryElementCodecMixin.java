package obro1961.chatpatches.mixin.whatamidoing;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.registry.entry.RegistryElementCodec;
import obro1961.chatpatches.ChatPatches;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(RegistryElementCodec.class)
public class RegistryElementCodecMixin {

    @ModifyExpressionValue(method = "encode(Lnet/minecraft/registry/entry/RegistryEntry;Lcom/mojang/serialization/DynamicOps;Ljava/lang/Object;)Lcom/mojang/serialization/DataResult;", at = @At(value = "INVOKE", target = "Lnet/minecraft/registry/entry/RegistryEntry;ownerEquals(Lnet/minecraft/registry/entry/RegistryEntryOwner;)Z"))
    private boolean forceSameRegistry(boolean original) {
        return original || ChatPatches.usingUnsafeCodec;
    }
}
