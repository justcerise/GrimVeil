package net.grimveil.block;

import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import net.grimveil.GrimVeil;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.grimveil.block.custom.BysmalGrassBlock;
import net.grimveil.block.custom.BysmalGrassPlant;
import net.grimveil.block.custom.BysmalSaplingBlock;
import net.grimveil.world.tree.ModSaplingGenerators;

import java.util.function.Function;

public class ModBlocks {
    // * Bysmal Wood types * //

    // * Building Sign things
    public static final Identifier BYSMAL_SIGN_ID = Identifier.of(GrimVeil.MOD_ID,"bysmal_sign");
    public static final Identifier BYSMAL_WALL_SIGN_ID = Identifier.of(GrimVeil.MOD_ID,"bysmal_wall_sign");
    public static final Identifier BYSMAL_HANGING_SIGN_ID = Identifier.of(GrimVeil.MOD_ID,"bysmal_hanging_sign");
    public static final Identifier BYSMAL_WALL_HANGING_SIGN_ID = Identifier.of(GrimVeil.MOD_ID,"bysmal_wall_hanging_sign");

    public static final Identifier SIGN_TEXTURE_ID = Identifier.of(GrimVeil.MOD_ID,"entity/signs/bysmal");
    public static final Identifier HANGING_SIGN_TEXTURE_ID = Identifier.of(GrimVeil.MOD_ID,"entity/signs/hanging/bysmal");
    public static final Identifier HANGING_SIGN_GUI_TEXTURE_ID = Identifier.of(GrimVeil.MOD_ID,"textures/gui/hanging_signs/bysmal");

    public static final Block BYSMAL_SIGN;
    public static final Block BYSMAL_WALL_SIGN;
    public static final Block BYSMAL_HANGING_SIGN;
    public static final Block BYSMAL_WALL_HANGING_SIGN;

    static {
        BYSMAL_SIGN = new TerraformSignBlock(
                SIGN_TEXTURE_ID,
                AbstractBlock.Settings.copy(Blocks.OAK_SIGN)
                        .sounds(BlockSoundGroup.WOOD)
                        .registryKey(RegistryKey.of(RegistryKeys.BLOCK, BYSMAL_SIGN_ID))
        );
        Registry.register(Registries.BLOCK, BYSMAL_SIGN_ID, BYSMAL_SIGN);

        BYSMAL_WALL_SIGN = new TerraformWallSignBlock(
                SIGN_TEXTURE_ID,
                AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN)
                        .sounds(BlockSoundGroup.WOOD)
                        .lootTable(BYSMAL_SIGN.getLootTableKey())
                        .registryKey(RegistryKey.of(RegistryKeys.BLOCK, BYSMAL_WALL_SIGN_ID))
        );
        Registry.register(Registries.BLOCK, BYSMAL_WALL_SIGN_ID, BYSMAL_WALL_SIGN);

        BYSMAL_HANGING_SIGN = new TerraformHangingSignBlock(
                HANGING_SIGN_TEXTURE_ID,
                HANGING_SIGN_GUI_TEXTURE_ID,
                AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)
                        .sounds(BlockSoundGroup.WOOD)
                        .registryKey(RegistryKey.of(RegistryKeys.BLOCK, BYSMAL_HANGING_SIGN_ID))
        );
        Registry.register(Registries.BLOCK, BYSMAL_HANGING_SIGN_ID, BYSMAL_HANGING_SIGN);

        BYSMAL_WALL_HANGING_SIGN = new TerraformWallHangingSignBlock(
                HANGING_SIGN_TEXTURE_ID,
                HANGING_SIGN_GUI_TEXTURE_ID,
                AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN)
                        .sounds(BlockSoundGroup.WOOD)
                        .lootTable(BYSMAL_HANGING_SIGN.getLootTableKey())
                        .registryKey(RegistryKey.of(RegistryKeys.BLOCK, BYSMAL_WALL_HANGING_SIGN_ID))
        );
        Registry.register(Registries.BLOCK, BYSMAL_WALL_HANGING_SIGN_ID, BYSMAL_WALL_HANGING_SIGN);
    }

    public static final Block BYSMAL_LOG = register(
            "bysmal_log",
            PillarBlock::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(2f).requiresTool(),
            true);
    public static final Block STRIPPED_BYSMAL_LOG = register(
            "stripped_bysmal_log",
            PillarBlock::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(2f).requiresTool(),
            true);
    public static final Block BYSMAL_WOOD = register(
            "bysmal_wood",
            PillarBlock::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(2f).requiresTool(),
            true);
    public static final Block STRIPPED_BYSMAL_WOOD = register(
            "stripped_bysmal_wood",
            PillarBlock::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(2f).requiresTool(),
            true);
    public static final Block BYSMAL_LEAVES = register(
            "bysmal_leaves",
            LeavesBlock::new,
            AbstractBlock.Settings.copy(Blocks.PALE_OAK_LEAVES).nonOpaque(),
            true);
    public static final Block BYSMAL_PLANKS = register(
            "bysmal_planks",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(1f).requiresTool(),
            true);

    // Chiseled Variants
    public static final Block CHISELED_BYSMAL_WOOD = register(
            "chiseled_bysmal_wood",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(1f).requiresTool(),
            true);
    public static final Block DIAGONALLY_CHISELED_BYSMAL_WOOD = register(
            "diagonally_chiseled_bysmal_wood",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(1f).requiresTool(),
            true);
    public static final Block REFINED_CHISELED_BYSMAL_WOOD = register(
            "refined_chiseled_bysmal_wood",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(1f).requiresTool(),
            true);
    //
    public static final Block BYSMAL_STAIRS = register(
            "bysmal_stairs",
            settings -> new StairsBlock(BYSMAL_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(1f).requiresTool(),
            true);
    public static final Block BYSMAL_SLAB = register(
            "bysmal_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(1f).requiresTool(),
            true);
    public static final Block BYSMAL_FENCE = register(
            "bysmal_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).strength(2f).requiresTool(),
            true);

    // Door Blocks
    public static final Block BYSMAL_DOOR = register(
            "bysmal_door",
            settings -> new DoorBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.WOOD)
                    .strength(3f)
                    .nonOpaque()
                    .requiresTool(),
            true);
    public static final Block BYSMAL_TRAPDOOR = register(
            "bysmal_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.WOOD)
                    .strength(3f)
                    .nonOpaque()
                    .requiresTool(),
            true);
    public static final Block BYSMAL_FENCE_GATE = register(
            "bysmal_fence_gate",
            settings -> new FenceGateBlock(WoodType.OAK,settings),
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.WOOD)
                    .strength(2f)
                    .requiresTool(),
            true);

    // Redstone things
    public static final Block BYSMAL_PRESSURE_PLATE = register(
            "bysmal_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.WOOD)
                    .strength(0.5f)
                    .noCollision()
                    .requiresTool(),
            true);
    public static final Block BYSMAL_BUTTON = register(
            "bysmal_button",
            settings -> new ButtonBlock(BlockSetType.OAK, 15, settings),
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.WOOD)
                    .strength(0.5f)
                    .noCollision()
                    .requiresTool(),
            true);

    // * ORES
    public static final Block VOID_STEEL_ORE = register(
            "void_steel_ore",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(5f).hardness(4f).requiresTool(),
            true);
    public static final Block DEEPSLATE_VOID_STEEL_ORE = register(
            "deepslate_void_steel_ore",
            Block::new,
            AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(5f).hardness(4.5f).requiresTool(),
            true);

    // * TREES
    public static final Block BYSMAL_SAPLING = register(
            "bysmal_sapling",
            settings -> new BysmalSaplingBlock(ModSaplingGenerators.BYSMAL, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SAPLING),
            true
    );

    // * FLORA
    public static final Block BYSMAL_DIRT = register(
            "bysmal_dirt",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.DIRT),
            true);
    public static final Block BYSMAL_GRASS_BLOCK = register(
            "bysmal_grass_block",
            BysmalGrassBlock::new,
            AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK),
            true);
    public static final Block BYSMAL_MOSS_BLOCK = register(
            "bysmal_moss_block",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.MOSS_BLOCK),
            true);
    public static final Block BYSMAL_LONG_GRASS = register(
            "bysmal_long_grass",
            BysmalGrassPlant::new,
            AbstractBlock.Settings.copy(Blocks.SHORT_GRASS),
            true);
    public static final Block BYSMAL_SHORT_GRASS = register(
            "bysmal_short_grass",
            BysmalGrassPlant::new,
            AbstractBlock.Settings.copy(Blocks.SHORT_GRASS),
            true);

    // * BYSMAL BIOME STONE BLOCKS AND THINGS
    public static final Block GRIMSTONE = register(
            "grimstone",
            PillarBlock::new,
            AbstractBlock.Settings.copy(Blocks.DEEPSLATE),
            true);
    public static final Block COBBLED_GRIMSTONE = register(
            "cobbled_grimstone",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.COBBLED_DEEPSLATE),
            true);
    public static final Block COBBLED_GRIMSTONE_STAIRS = register(
            "cobbled_grimstone_stairs",
            settings -> new StairsBlock(BYSMAL_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(Blocks.DEEPSLATE_TILE_SLAB),
            true);
    public static final Block COBBLED_GRIMSTONE_SLAB = register(
            "cobbled_grimstone_slab",
            SlabBlock::new,
            AbstractBlock.Settings.copy(Blocks.DEEPSLATE_TILE_STAIRS),
            true);

    public static final Block COBBLED_GRIMSTONE_WALL = register(
            "cobbled_grimstone_wall",
            WallBlock::new,
            AbstractBlock.Settings.copy(Blocks.DEEPSLATE_TILE_WALL),
            true);



    public static final BlockFamily BYSMAL_FAMILY = BlockFamilies.register(ModBlocks.BYSMAL_PLANKS)
            .sign(ModBlocks.BYSMAL_SIGN, ModBlocks.BYSMAL_WALL_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();
    public static final BlockFamily GRIMSTONE_FAMILY = BlockFamilies.register(ModBlocks.COBBLED_GRIMSTONE)
            .group("stone").unlockCriterionName("has_stone").build();


    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.registryKey(blockKey));
        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }
        return Registry.register(Registries.BLOCK, blockKey, block);
    }
    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(GrimVeil.MOD_ID, name));
    }
    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GrimVeil.MOD_ID, name));
    }

    public static void initialize(){
        GrimVeil.LOGGER.info("Faint voices gather blocks and samples...");
        GrimVeil.LOGGER.info("Registering Blocks for " + GrimVeil.MOD_ID);
    }
}
