package com.axtonfn.clipmod.commands;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;

import static net.minecraft.server.command.CommandManager.literal;
import static net.minecraft.server.command.CommandManager.argument;
import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class VClipCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess access, CommandManager.RegistrationEnvironment env) {
        dispatcher.register(literal("vclip")
            .then(argument("blocks", DoubleArgumentType.doubleArg())
                .executes(context -> {
                    ServerPlayerEntity player = context.getSource().getPlayer();
                    double blocks = DoubleArgumentType.getDouble(context, "blocks");

                    player.requestTeleport(player.getX(), player.getY() + blocks, player.getZ());
                    return SINGLE_SUCCESS;
                })
            )
        );
    }
}
