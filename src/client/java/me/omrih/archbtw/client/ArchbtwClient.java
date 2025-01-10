package me.omrih.archbtw.client;

import me.omrih.archbtw.OSUtils;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.minecraft.client.MinecraftClient;

public class ArchbtwClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientReceiveMessageEvents.GAME.register((message, overlay) -> {
            if (message.getString().toLowerCase().contains("windows") || message.getString().toLowerCase().contains("linux") || message.getString().toLowerCase().matches("\\bmac\\b") || message.getString().toLowerCase().contains("operating system") || message.getString().toLowerCase().matches("\\bos\\b")) { // if anyone mentions OS'es...
                flexOS(); // flex your superior operating system.
            }
        });
        ClientReceiveMessageEvents.CHAT.register((message, signedMessage, sender, params, receptionTimestamp) -> {
            if (message.getString().toLowerCase().contains("windows") || message.getString().toLowerCase().contains("linux") || message.getString().toLowerCase().matches("\\bmac\\b") || message.getString().toLowerCase().contains("operating system") || message.getString().toLowerCase().matches("\\bos\\b")) { // if anyone mentions OS'es...
                flexOS(); // flex your superior operating system.
            }
        });
    }

    public void flexOS() {
        if (OSUtils.IS_UNIX_LIKE) { // check if the user is on BSD/Linux (chances are, it's linux)
            if (OSUtils.fetchOSName().matches("Arch Linux")) {
                MinecraftClient.getInstance().player.networkHandler.sendChatMessage("arch btw"); // if they run arch.
            } else {
                MinecraftClient.getInstance().player.networkHandler.sendChatMessage("I run linux"); // if they run any non-arch distro. (including arch bases.)
            }
        }

    }
}
