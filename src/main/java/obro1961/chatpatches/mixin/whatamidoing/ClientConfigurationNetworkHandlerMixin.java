package obro1961.chatpatches.mixin.whatamidoing;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.network.ClientConfigurationNetworkHandler;
import net.minecraft.registry.DynamicRegistryManager;
import obro1961.chatpatches.chatlog.ChatLog;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ClientConfigurationNetworkHandler.class)
public class ClientConfigurationNetworkHandlerMixin {

    @ModifyExpressionValue(method = "onReady", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientConfigurationNetworkHandler;openClientDataPack(Ljava/util/function/Function;)Ljava/lang/Object;"))
    private Object captureDRM(Object original) {
        if (original instanceof DynamicRegistryManager.Immutable immutable) {
            ChatLog.a = immutable;
        }
        return original;
    }
}
