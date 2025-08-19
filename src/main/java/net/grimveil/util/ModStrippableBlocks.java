package net.grimveil.util;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.grimveil.block.ModBlocks;

public class ModStrippableBlocks {
    public static void registerStrippables(){
        StrippableBlockRegistry.register(ModBlocks.BYSMAL_LOG, ModBlocks.STRIPPED_BYSMAL_LOG);
        StrippableBlockRegistry.register(ModBlocks.BYSMAL_WOOD, ModBlocks.STRIPPED_BYSMAL_WOOD);
    }
}
