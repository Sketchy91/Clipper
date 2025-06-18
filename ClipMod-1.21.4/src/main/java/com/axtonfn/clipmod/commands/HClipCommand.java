package com.axtonfn.clipmod.commands;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;

import static net.minecraft.server.command.CommandManager.literal;
import static net.minecraft.server.command.CommandManager.argument;
import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class HClipCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess access, CommandManager.RegistrationEnvironment env) {
        dispatcher.register(literal("hclip")
            .then(argument("blocks", DoubleArgumentType.doubleArg())
                .executes(context -> {
                    ServerPlayerEntity player = context.getSource().getPlayer();
                    double blocks = DoubleArgumentType.getDouble(context, "blocks");

                    Vec3d look = player.getRotationVec(1.0F);
                    double dx = look.x * blocks;
                    double dz = look.z * blocks;

                    player.requestTeleport(player.getX() + dx, player.getY(), player.getZ() + dz);
                    return SINGLE_SUCCESS;
                })
            )
        );
    }
}
