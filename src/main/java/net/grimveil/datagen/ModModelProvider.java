package net.grimveil.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.util.Identifier;
import net.grimveil.block.ModBlocks;
import net.grimveil.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool bysmalPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BYSMAL_PLANKS);
        BlockStateModelGenerator.BlockTexturePool grimstonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COBBLED_GRIMSTONE);
        BlockStateModelGenerator.BlockTexturePool grimstoneBricksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GRIMSTONE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool grimstoneTilesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GRIMSTONE_TILES);
        BlockStateModelGenerator.BlockTexturePool grimstoneSquareTilesPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GRIMSTONE_SQUARE_TILES);

        blockStateModelGenerator.registerLog(ModBlocks.BYSMAL_LOG).log(ModBlocks.BYSMAL_LOG).wood(ModBlocks.BYSMAL_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_BYSMAL_LOG).log(ModBlocks.STRIPPED_BYSMAL_LOG).wood(ModBlocks.STRIPPED_BYSMAL_WOOD);
        blockStateModelGenerator.registerSingleton(ModBlocks.BYSMAL_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.BYSMAL_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BYSMAL_DIRT);
        //blockStateModelGenerator.registerLog(ModBlocks.GRIMSTONE);
        //I'll come back to this once I figure out how to actually datagen column blocks, without them being 'logs'
        blockStateModelGenerator.registerTintableCross(ModBlocks.BYSMAL_LONG_GRASS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.BYSMAL_SHORT_GRASS, BlockStateModelGenerator.CrossType.NOT_TINTED);

        //blockStateModelGenerator.registerLog(ModBlocks.REFINED_CHISELED_BYSMAL_WOOD);
        //blockStateModelGenerator.registerLog(ModBlocks.CHISELED_BYSMAL_WOOD);
        //Same thing as the Grimstone, I can't generate Column blocks fully yet.

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIAGONALLY_CHISELED_BYSMAL_WOOD);
        
        bysmalPool.stairs(ModBlocks.BYSMAL_STAIRS);
        bysmalPool.slab(ModBlocks.BYSMAL_SLAB);
        bysmalPool.button(ModBlocks.BYSMAL_BUTTON);
        bysmalPool.pressurePlate(ModBlocks.BYSMAL_PRESSURE_PLATE);
        bysmalPool.fence(ModBlocks.BYSMAL_FENCE);
        bysmalPool.fenceGate(ModBlocks.BYSMAL_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.BYSMAL_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.BYSMAL_TRAPDOOR);

        bysmalPool.family(ModBlocks.BYSMAL_FAMILY);
        blockStateModelGenerator.registerHangingSign(ModBlocks.BYSMAL_PLANKS, ModBlocks.BYSMAL_HANGING_SIGN, ModBlocks.BYSMAL_WALL_HANGING_SIGN);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VOID_STEEL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_VOID_STEEL_ORE);

        grimstonePool.stairs(ModBlocks.COBBLED_GRIMSTONE_STAIRS);
        grimstonePool.slab(ModBlocks.COBBLED_GRIMSTONE_SLAB);
        grimstonePool.wall(ModBlocks.COBBLED_GRIMSTONE_WALL);

        grimstoneBricksPool.stairs(ModBlocks.GRIMSTONE_BRICK_STAIRS);
        grimstoneBricksPool.slab(ModBlocks.GRIMSTONE_BRICK_SLAB);
        grimstoneBricksPool.wall(ModBlocks.GRIMSTONE_BRICK_WALL);

        grimstoneTilesPool.stairs(ModBlocks.GRIMSTONE_TILE_STAIRS);
        grimstoneTilesPool.slab(ModBlocks.GRIMSTONE_TILE_SLAB);
        grimstoneTilesPool.wall(ModBlocks.GRIMSTONE_TILE_WALL);

        grimstoneSquareTilesPool.stairs(ModBlocks.GRIMSTONE_SQUARE_TILE_STAIRS);
        grimstoneSquareTilesPool.slab(ModBlocks.GRIMSTONE_SQUARE_TILE_SLAB);
        grimstoneSquareTilesPool.wall(ModBlocks.GRIMSTONE_SQUARE_TILE_WALL);

        grimstonePool.family(ModBlocks.GRIMSTONE_FAMILY);
        grimstonePool.family(ModBlocks.GRIMSTONE_BRICKS_FAMILY);
        grimstonePool.family(ModBlocks.GRIMSTONE_TILES_FAMILY);
        grimstonePool.family(ModBlocks.GRIMSTONE_SQUARE_TILES_FAMILY);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //* INGREDIENTS
        itemModelGenerator.register(ModItems.BYSMAL_BRANCH, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHADE_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.VOID_STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHADE_STEEL_INGOT, Models.GENERATED);


        itemModelGenerator.register(ModItems.A_FORESTS_LOST_VOICE_MUSIC_DISC, Models.TEMPLATE_MUSIC_DISC);
        itemModelGenerator.register(ModItems.TRANSMISSION_FROM_THE_FOREST_MUSIC_DISC, Models.TEMPLATE_MUSIC_DISC);
        itemModelGenerator.register(ModItems.STILL_I_DANCED_MUSIC_DISC, Models.TEMPLATE_MUSIC_DISC);
        itemModelGenerator.register(ModItems.FLUX_MUSIC_DISC, Models.TEMPLATE_MUSIC_DISC);

        //* TOOLS & UTILITIES

        // SHADE STEEL
        itemModelGenerator.register(ModItems.SHADE_STEEL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHADE_STEEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHADE_STEEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHADE_STEEL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHADE_STEEL_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.BYSMAL_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BYSMAL_CHEST_BOAT, Models.GENERATED);
        //itemModelGenerator.register(ModBlocks.BYSMAL_SIGN.asItem(), Models.GENERATED);
        //itemModelGenerator.register(ModBlocks.BYSMAL_HANGING_SIGN.asItem(), Models.GENERATED);

        itemModelGenerator.register(ModItems.SHADE_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
    }
}