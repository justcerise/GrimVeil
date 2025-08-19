package net.grimveil.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.grimveil.block.ModBlocks;

public class ModFlammableBlocks {
    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.BYSMAL_LOG,5,5);
        registry.add(ModBlocks.BYSMAL_WOOD,5,5);
        registry.add(ModBlocks.STRIPPED_BYSMAL_LOG,5,5);
        registry.add(ModBlocks.STRIPPED_BYSMAL_WOOD,5,5);
        registry.add(ModBlocks.BYSMAL_LEAVES,30,60);

        registry.add(ModBlocks.BYSMAL_PLANKS,5,20);
        registry.add(ModBlocks.BYSMAL_STAIRS,5,20);
        registry.add(ModBlocks.BYSMAL_SLAB,5,20);
        registry.add(ModBlocks.BYSMAL_FENCE,5,20);
        registry.add(ModBlocks.BYSMAL_FENCE_GATE,5,20);
    }
}
