package me.omrih.archbtw.client.mixin;

import me.omrih.archbtw.OSUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.ChatMessageS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class Archbtw {
    @Inject(method = "onChatMessage", at = @At("HEAD"))
    public void messageListener(ChatMessageS2CPacket packet, CallbackInfo ci) {
        if (packet.body().content().toLowerCase().contains("windows") || packet.body().content().toLowerCase().contains("linux") || packet.body().content().toLowerCase().matches("\\bmac\\b") || packet.body().content().toLowerCase().contains("operating system") || packet.body().content().toLowerCase().matches("\\bos\\b")) { // if anyone mentions OS'es...
            flexOS(); // flex your superior operating system.
        }
    }

    @Unique
    public void flexOS() {

        if (OSUtils.IS_UNIX_LIKE) { // check if the user is on BSD/Linux (chances are, it's linux)
            if (OSUtils.fetchOSName().matches("Arch Linux")) {
                assert MinecraftClient.getInstance().player != null;
                MinecraftClient.getInstance().player.networkHandler.sendChatMessage("arch btw"); // if they run arch.
            } else {
                assert MinecraftClient.getInstance().player != null;
                MinecraftClient.getInstance().player.networkHandler.sendChatMessage("I run linux"); // if they run any non-arch distro. (including arch bases.)
            }
        }

    }

}
