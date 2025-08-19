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
    public static ItemGroup BYSMAL_TOOLS_AND_UTILITIES;
    public static ItemGroup BYSMAL_WOOD_BLOCKS;
    public static ItemGroup BYSMAL_STONE_BLOCKS;
    public static ItemGroup BYSMAL_INGREDIENTS;

    public static void registerItemGroups(){
        BYSMAL_WOOD_BLOCKS = Registry.register(
                Registries.ITEM_GROUP,
                Identifier.of(GrimVeil.MOD_ID, "bysmal_wood_blocks"),
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(ModBlocks.BYSMAL_LOG.asItem()))
                        .displayName(Text.translatable("itemgroup.grimveil.bysmal_wood_blocks"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModBlocks.BYSMAL_LOG);
                            entries.add(ModBlocks.STRIPPED_BYSMAL_LOG);
                            entries.add(ModBlocks.BYSMAL_WOOD);
                            entries.add(ModBlocks.STRIPPED_BYSMAL_WOOD);

                            entries.add(ModBlocks.CHISELED_BYSMAL_WOOD);
                            entries.add(ModBlocks.DIAGONALLY_CHISELED_BYSMAL_WOOD);
                            entries.add(ModBlocks.REFINED_CHISELED_BYSMAL_WOOD);

                            entries.add(ModBlocks.BYSMAL_PLANKS);
                            entries.add(ModBlocks.BYSMAL_STAIRS);
                            entries.add(ModBlocks.BYSMAL_SLAB);

                            entries.add(ModBlocks.BYSMAL_FENCE);
                            entries.add(ModBlocks.BYSMAL_FENCE_GATE);

                            entries.add(ModBlocks.BYSMAL_DOOR);
                            entries.add(ModBlocks.BYSMAL_TRAPDOOR);
                            entries.add(ModBlocks.BYSMAL_PRESSURE_PLATE);
                            entries.add(ModBlocks.BYSMAL_BUTTON);

                            entries.add(ModItems.BYSMAL_SIGN_ITEM);
                            entries.add(ModItems.BYSMAL_HANGING_SIGN_ITEM);

                            entries.add(ModBlocks.BYSMAL_LEAVES);
                            entries.add(ModBlocks.BYSMAL_SAPLING);
                            entries.add(ModBlocks.BYSMAL_LONG_GRASS);
                            entries.add(ModBlocks.BYSMAL_SHORT_GRASS);
                            entries.add(ModBlocks.BYSMAL_GRASS_BLOCK);
                            entries.add(ModBlocks.BYSMAL_DIRT);
                            entries.add(ModBlocks.BYSMAL_MOSS_BLOCK);
                        })
                        .build()
        );
        BYSMAL_STONE_BLOCKS = Registry.register(
                Registries.ITEM_GROUP,
                Identifier.of(GrimVeil.MOD_ID, "bysmal_stone_blocks"),
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(ModBlocks.GRIMSTONE.asItem()))
                        .displayName(Text.translatable("itemgroup.grimveil.bysmal_stone_blocks"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModBlocks.GRIMSTONE);
                            entries.add(ModBlocks.COBBLED_GRIMSTONE);
                            entries.add(ModBlocks.COBBLED_GRIMSTONE_STAIRS);
                            entries.add(ModBlocks.COBBLED_GRIMSTONE_SLAB);
                            entries.add(ModBlocks.COBBLED_GRIMSTONE_WALL);

                        })
                        .build()
        );
        BYSMAL_TOOLS_AND_UTILITIES = Registry.register(
                Registries.ITEM_GROUP,
                Identifier.of(GrimVeil.MOD_ID, "tools_and_utilities"),
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(ModItems.BYSMAL_BRANCH))
                        .displayName(Text.translatable("itemgroup.grimveil.tools_and_utilities"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.BYSMAL_BOAT);
                            entries.add(ModItems.BYSMAL_CHEST_BOAT);
                            entries.add(ModItems.SHADE_SPAWN_EGG);

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
        BYSMAL_INGREDIENTS = Registry.register(
                Registries.ITEM_GROUP,
                Identifier.of(GrimVeil.MOD_ID, "bysmal_ingredients"),
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(ModItems.BYSMAL_BRANCH))
                        .displayName(Text.translatable("itemgroup.grimveil.bysmal_ingredients"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.BYSMAL_BRANCH);
                            entries.add(ModItems.SHADE_FRAGMENT);
                            entries.add(ModItems.VOID_STEEL_INGOT);
                            entries.add(ModItems.SHADE_STEEL_INGOT);
                        })
                        .build()
        );
        GrimVeil.LOGGER.info("Registering Item Groups for " + GrimVeil.MOD_ID);
    }
}
