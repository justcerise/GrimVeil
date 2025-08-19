package net.grimveil.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.grimveil.block.ModBlocks;
import net.grimveil.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(
                        ModBlocks.VOID_STEEL_ORE,
                        ModBlocks.DEEPSLATE_VOID_STEEL_ORE,
                        ModBlocks.GRIMSTONE,
                        ModBlocks.COBBLED_GRIMSTONE,
                        ModBlocks.COBBLED_GRIMSTONE_STAIRS,
                        ModBlocks.COBBLED_GRIMSTONE_SLAB,
                        ModBlocks.COBBLED_GRIMSTONE_WALL
                );

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(
                        ModBlocks.BYSMAL_LOG,
                        ModBlocks.STRIPPED_BYSMAL_LOG,
                        ModBlocks.BYSMAL_WOOD,
                        ModBlocks.STRIPPED_BYSMAL_WOOD,
                        ModBlocks.BYSMAL_PLANKS,
                        ModBlocks.BYSMAL_STAIRS,
                        ModBlocks.BYSMAL_SLAB,
                        ModBlocks.CHISELED_BYSMAL_WOOD,
                        ModBlocks.REFINED_CHISELED_BYSMAL_WOOD,
                        ModBlocks.DIAGONALLY_CHISELED_BYSMAL_WOOD,
                        ModBlocks.BYSMAL_DOOR,
                        ModBlocks.BYSMAL_TRAPDOOR,
                        ModBlocks.BYSMAL_FENCE,
                        ModBlocks.BYSMAL_FENCE_GATE,
                        ModBlocks.BYSMAL_PRESSURE_PLATE,
                        ModBlocks.BYSMAL_BUTTON,
                        ModBlocks.BYSMAL_SIGN,
                        ModBlocks.BYSMAL_WALL_SIGN,
                        ModBlocks.BYSMAL_HANGING_SIGN,
                        ModBlocks.BYSMAL_WALL_HANGING_SIGN
                );

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(
                        ModBlocks.VOID_STEEL_ORE,
                        ModBlocks.DEEPSLATE_VOID_STEEL_ORE
                );

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        ModBlocks.GRIMSTONE
                );

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(
                        ModBlocks.BYSMAL_LOG,
                        ModBlocks.STRIPPED_BYSMAL_LOG,
                        ModBlocks.BYSMAL_WOOD,
                        ModBlocks.STRIPPED_BYSMAL_WOOD,
                        ModBlocks.BYSMAL_PLANKS,
                        ModBlocks.BYSMAL_STAIRS,
                        ModBlocks.BYSMAL_SLAB,
                        ModBlocks.CHISELED_BYSMAL_WOOD,
                        ModBlocks.REFINED_CHISELED_BYSMAL_WOOD,
                        ModBlocks.DIAGONALLY_CHISELED_BYSMAL_WOOD,
                        ModBlocks.BYSMAL_DOOR,
                        ModBlocks.BYSMAL_TRAPDOOR,
                        ModBlocks.BYSMAL_FENCE,
                        ModBlocks.BYSMAL_FENCE_GATE,
                        ModBlocks.BYSMAL_PRESSURE_PLATE,
                        ModBlocks.BYSMAL_BUTTON,
                        ModBlocks.BYSMAL_SIGN,
                        ModBlocks.BYSMAL_WALL_SIGN,
                        ModBlocks.BYSMAL_HANGING_SIGN,
                        ModBlocks.BYSMAL_WALL_HANGING_SIGN,

                        ModBlocks.BYSMAL_GRASS_BLOCK,
                        ModBlocks.BYSMAL_DIRT,
                        ModBlocks.COBBLED_GRIMSTONE,
                        ModBlocks.COBBLED_GRIMSTONE_STAIRS,
                        ModBlocks.COBBLED_GRIMSTONE_SLAB,
                        ModBlocks.COBBLED_GRIMSTONE_WALL
                );

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.BYSMAL_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.BYSMAL_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(
                        ModBlocks.COBBLED_GRIMSTONE_WALL,
                        ModBlocks.GRIMSTONE_BRICK_WALL,
                        ModBlocks.GRIMSTONE_TILE_WALL,
                        ModBlocks.GRIMSTONE_SQUARE_TILE_WALL
                );

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.BYSMAL_LOG,ModBlocks.BYSMAL_WOOD,ModBlocks.STRIPPED_BYSMAL_LOG,ModBlocks.STRIPPED_BYSMAL_WOOD);
        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ModBlocks.BYSMAL_LOG,ModBlocks.STRIPPED_BYSMAL_LOG,ModBlocks.BYSMAL_WOOD,ModBlocks.STRIPPED_BYSMAL_WOOD);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_SHADE_STEEL_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}