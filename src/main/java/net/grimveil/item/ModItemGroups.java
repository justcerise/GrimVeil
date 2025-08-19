package net.grimveil.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.grimveil.GrimVeil;
import net.grimveil.block.ModBlocks;

public class ModItemGroups {
    public static ItemGroup GRIMVEIL_BUILDING;
    public static ItemGroup GRIMVEIL_NATURAL;
    public static ItemGroup GRIMVEIL_DECOR;
    public static ItemGroup GRIMVEIL_FLORA;
    public static ItemGroup GRIMVEIL_GRIMVEIL_GEAR_N_UTILITIES;
    public static ItemGroup GRIMVEIL_INGREDIENTS;

    public static void registerItemGroups(){
        GRIMVEIL_BUILDING = Registry.register(
                Registries.ITEM_GROUP,
                Identifier.of(GrimVeil.MOD_ID, "grimveil_building"),
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(ModBlocks.BYSMAL_LOG.asItem()))
                        .displayName(Text.translatable("itemgroup.grimveil.building"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModBlocks.BYSMAL_LOG);
                            entries.add(ModBlocks.STRIPPED_BYSMAL_LOG);
                            entries.add(ModBlocks.BYSMAL_WOOD);
                            entries.add(ModBlocks.STRIPPED_BYSMAL_WOOD);
                            entries.add(ModBlocks.BYSMAL_PLANKS);
                            entries.add(ModBlocks.DIAGONALLY_CHISELED_BYSMAL_WOOD);
                            entries.add(ModBlocks.REFINED_CHISELED_BYSMAL_WOOD);
                            entries.add(ModBlocks.CHISELED_BYSMAL_WOOD);
                            entries.add(ModBlocks.BYSMAL_STAIRS);
                            entries.add(ModBlocks.BYSMAL_SLAB);
                            entries.add(ModBlocks.BYSMAL_DOOR);
                            entries.add(ModBlocks.BYSMAL_TRAPDOOR);
                            entries.add(ModBlocks.BYSMAL_FENCE);
                            entries.add(ModBlocks.BYSMAL_FENCE_GATE);
                            entries.add(ModBlocks.BYSMAL_PRESSURE_PLATE);
                            entries.add(ModBlocks.BYSMAL_BUTTON);

                            entries.add(ModBlocks.GRIMSTONE);
                            entries.add(ModBlocks.COBBLED_GRIMSTONE);
                            entries.add(ModBlocks.COBBLED_GRIMSTONE_STAIRS);
                            entries.add(ModBlocks.COBBLED_GRIMSTONE_SLAB);
                            entries.add(ModBlocks.COBBLED_GRIMSTONE_WALL);
                            entries.add(ModBlocks.GRIMSTONE_BRICKS);
                            entries.add(ModBlocks.GRIMSTONE_BRICK_STAIRS);
                            entries.add(ModBlocks.GRIMSTONE_BRICK_SLAB);
                            entries.add(ModBlocks.GRIMSTONE_BRICK_WALL);
                            entries.add(ModBlocks.GRIMSTONE_TILES);
                            entries.add(ModBlocks.GRIMSTONE_TILE_STAIRS);
                            entries.add(ModBlocks.GRIMSTONE_TILE_SLAB);
                            entries.add(ModBlocks.GRIMSTONE_TILE_WALL);
                            entries.add(ModBlocks.GRIMSTONE_SQUARE_TILES);
                            entries.add(ModBlocks.GRIMSTONE_SQUARE_TILE_STAIRS);
                            entries.add(ModBlocks.GRIMSTONE_SQUARE_TILE_SLAB);
                            entries.add(ModBlocks.GRIMSTONE_SQUARE_TILE_WALL);
                        })
                        .build()
        );
        GRIMVEIL_NATURAL = Registry.register(
                Registries.ITEM_GROUP,
                Identifier.of(GrimVeil.MOD_ID, "grimveil_natural"),
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(ModBlocks.BYSMAL_GRASS_BLOCK.asItem()))
                        .displayName(Text.translatable("itemgroup.grimveil.natural"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModBlocks.BYSMAL_GRASS_BLOCK);
                            entries.add(ModBlocks.BYSMAL_DIRT);
                            entries.add(ModBlocks.GRIMSTONE);
                            entries.add(ModBlocks.BYSMAL_LOG);
                            entries.add(ModBlocks.BYSMAL_SAPLING);
                            entries.add(ModBlocks.BYSMAL_LEAVES);
                            entries.add(ModBlocks.BYSMAL_LONG_GRASS);
                            entries.add(ModBlocks.BYSMAL_SHORT_GRASS);
                        })
                        .build()
        );
        GRIMVEIL_DECOR = Registry.register(
                Registries.ITEM_GROUP,
                Identifier.of(GrimVeil.MOD_ID, "grimveil_decor"),
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(ModBlocks.DIAGONALLY_CHISELED_BYSMAL_WOOD.asItem()))
                        .displayName(Text.translatable("itemgroup.grimveil.decor"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModBlocks.DIAGONALLY_CHISELED_BYSMAL_WOOD);
                            entries.add(ModBlocks.REFINED_CHISELED_BYSMAL_WOOD);
                            entries.add(ModBlocks.CHISELED_BYSMAL_WOOD);
                            entries.add(ModBlocks.BYSMAL_STAIRS);
                            entries.add(ModBlocks.BYSMAL_SLAB);
                            entries.add(ModBlocks.BYSMAL_DOOR);
                            entries.add(ModBlocks.BYSMAL_TRAPDOOR);
                            entries.add(ModBlocks.BYSMAL_PRESSURE_PLATE);
                            entries.add(ModBlocks.BYSMAL_BUTTON);
                            entries.add(ModBlocks.BYSMAL_FENCE);
                            entries.add(ModBlocks.BYSMAL_FENCE_GATE);
                            entries.add(ModBlocks.BYSMAL_SIGN);
                            entries.add(ModBlocks.BYSMAL_HANGING_SIGN);

                            entries.add(ModBlocks.COBBLED_GRIMSTONE);
                            entries.add(ModBlocks.COBBLED_GRIMSTONE_STAIRS);
                            entries.add(ModBlocks.COBBLED_GRIMSTONE_SLAB);
                            entries.add(ModBlocks.COBBLED_GRIMSTONE_WALL);
                            entries.add(ModBlocks.GRIMSTONE_BRICKS);
                            entries.add(ModBlocks.GRIMSTONE_BRICK_STAIRS);
                            entries.add(ModBlocks.GRIMSTONE_BRICK_SLAB);
                            entries.add(ModBlocks.GRIMSTONE_BRICK_WALL);
                            entries.add(ModBlocks.GRIMSTONE_TILES);
                            entries.add(ModBlocks.GRIMSTONE_TILE_STAIRS);
                            entries.add(ModBlocks.GRIMSTONE_TILE_SLAB);
                            entries.add(ModBlocks.GRIMSTONE_TILE_WALL);
                            entries.add(ModBlocks.GRIMSTONE_SQUARE_TILES);
                            entries.add(ModBlocks.GRIMSTONE_SQUARE_TILE_STAIRS);
                            entries.add(ModBlocks.GRIMSTONE_SQUARE_TILE_SLAB);
                            entries.add(ModBlocks.GRIMSTONE_SQUARE_TILE_WALL);

                        })
                        .build()
        );
        GRIMVEIL_FLORA = Registry.register(
                Registries.ITEM_GROUP,
                Identifier.of(GrimVeil.MOD_ID, "grimveil_flora"),
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(ModBlocks.BYSMAL_LEAVES.asItem()))
                        .displayName(Text.translatable("itemgroup.grimveil.flora"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModBlocks.BYSMAL_GRASS_BLOCK);
                            entries.add(ModBlocks.BYSMAL_DIRT);
                            entries.add(ModBlocks.BYSMAL_SAPLING);
                            entries.add(ModBlocks.BYSMAL_LEAVES);
                            entries.add(ModBlocks.BYSMAL_LONG_GRASS);
                            entries.add(ModBlocks.BYSMAL_SHORT_GRASS);
                        })
                        .build()
        );
        GRIMVEIL_GRIMVEIL_GEAR_N_UTILITIES = Registry.register(
                Registries.ITEM_GROUP,
                Identifier.of(GrimVeil.MOD_ID, "grimveil_gear_n_utilities"),
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(ModItems.SHADE_STEEL_PICKAXE))
                        .displayName(Text.translatable("itemgroup.grimveil.gear_n_utilities"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.SHADE_STEEL_SWORD);
                            entries.add(ModItems.SHADE_STEEL_SHOVEL);
                            entries.add(ModItems.SHADE_STEEL_PICKAXE);
                            entries.add(ModItems.SHADE_STEEL_AXE);
                            entries.add(ModItems.SHADE_STEEL_HOE);
                            entries.add(ModItems.SHADE_STEEL_HAMMER);

                            entries.add(ModItems.A_FORESTS_LOST_VOICE_MUSIC_DISC);
                            entries.add(ModItems.TRANSMISSION_FROM_THE_FOREST_MUSIC_DISC);
                            entries.add(ModItems.STILL_I_DANCED_MUSIC_DISC);
                            entries.add(ModItems.FLUX_MUSIC_DISC);
                        })
                        .build()
        );
        GRIMVEIL_INGREDIENTS = Registry.register(
                Registries.ITEM_GROUP,
                Identifier.of(GrimVeil.MOD_ID, "grimveil_ingredients"),
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(ModItems.SHADE_STEEL_INGOT))
                        .displayName(Text.translatable("itemgroup.grimveil.ingredients"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.BYSMAL_BRANCH);
                            entries.add(ModItems.VOID_STEEL_INGOT);
                            entries.add(ModItems.SHADE_FRAGMENT);
                            entries.add(ModItems.SHADE_STEEL_INGOT);
                        })
                        .build()
        );
        GrimVeil.LOGGER.info("Registering Item Groups for " + GrimVeil.MOD_ID);
    }
}
