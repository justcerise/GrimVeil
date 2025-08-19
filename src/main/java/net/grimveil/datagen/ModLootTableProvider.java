package net.grimveil.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.grimveil.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BYSMAL_STAIRS);
        addDrop(ModBlocks.BYSMAL_TRAPDOOR);
        addDrop(ModBlocks.BYSMAL_FENCE);
        addDrop(ModBlocks.BYSMAL_FENCE_GATE);
        addDrop(ModBlocks.BYSMAL_BUTTON);
        addDrop(ModBlocks.BYSMAL_PRESSURE_PLATE);

        addDrop(ModBlocks.BYSMAL_DOOR, doorDrops(ModBlocks.BYSMAL_DOOR));
        addDrop(ModBlocks.BYSMAL_SLAB, slabDrops(ModBlocks.BYSMAL_SLAB));
        
        addDrop(ModBlocks.BYSMAL_LOG);
        addDrop(ModBlocks.BYSMAL_WOOD);
        addDrop(ModBlocks.STRIPPED_BYSMAL_LOG);
        addDrop(ModBlocks.STRIPPED_BYSMAL_WOOD);

        addDrop(ModBlocks.BYSMAL_PLANKS);
        addDrop(ModBlocks.DIAGONALLY_CHISELED_BYSMAL_WOOD);
        addDrop(ModBlocks.REFINED_CHISELED_BYSMAL_WOOD);
        addDrop(ModBlocks.CHISELED_BYSMAL_WOOD);

        addDrop(ModBlocks.BYSMAL_SAPLING);

        addDrop(ModBlocks.BYSMAL_LEAVES, leavesDrops(ModBlocks.BYSMAL_LEAVES, ModBlocks.BYSMAL_SAPLING, 0.0025f));

        addDrop(ModBlocks.VOID_STEEL_ORE, oreDrops(ModBlocks.VOID_STEEL_ORE, ModBlocks.VOID_STEEL_ORE.asItem()));
        addDrop(ModBlocks.DEEPSLATE_VOID_STEEL_ORE, oreDrops(ModBlocks.DEEPSLATE_VOID_STEEL_ORE, ModBlocks.DEEPSLATE_VOID_STEEL_ORE.asItem()));
        addDrop(ModBlocks.BYSMAL_GRASS_BLOCK, drops(ModBlocks.BYSMAL_DIRT));
        addDrop(ModBlocks.BYSMAL_DIRT);
        addDrop(ModBlocks.GRIMSTONE, drops(ModBlocks.COBBLED_GRIMSTONE));
        addDrop(ModBlocks.COBBLED_GRIMSTONE);
        addDrop(ModBlocks.COBBLED_GRIMSTONE_STAIRS);
        addDrop(ModBlocks.COBBLED_GRIMSTONE_SLAB, slabDrops(ModBlocks.COBBLED_GRIMSTONE_SLAB));
        addDrop(ModBlocks.COBBLED_GRIMSTONE_WALL);
    }
}