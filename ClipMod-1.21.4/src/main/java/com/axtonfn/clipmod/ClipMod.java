package com.axtonfn.clipmod;

import com.axtonfn.clipmod.commands.HClipCommand;
import com.axtonfn.clipmod.commands.VClipCommand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class ClipMod implements ModInitializer {
    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register(HClipCommand::register);
        CommandRegistrationCallback.EVENT.register(VClipCommand::register);
    }
}
