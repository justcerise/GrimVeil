package net.grimveil.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.DarkOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.grimveil.GrimVeil;
import net.grimveil.block.ModBlocks;
import net.grimveil.world.tree.BysmalTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> VOID_STEEL_ORE_KEY = registerKey("void_steel_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEEPSLATE_VOID_STEEL_ORE_KEY = registerKey("deepslate_void_steel_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> BYSMAL_KEY = registerKey("bysmal");



    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        List<OreFeatureConfig.Target> overworldVoidSteelOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.VOID_STEEL_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_VOID_STEEL_ORE.getDefaultState()));
        register(context, VOID_STEEL_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldVoidSteelOres, 3));

        register(context, BYSMAL_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.BYSMAL_LOG),
                new BysmalTrunkPlacer(6, 2, 0),
                BlockStateProvider.of(ModBlocks.BYSMAL_LEAVES),
                new DarkOakFoliagePlacer(UniformIntProvider.create(0, 0), UniformIntProvider.create(0, 0)),
                new TwoLayersFeatureSize(2, 0, 1))
                .dirtProvider(BlockStateProvider.of(ModBlocks.BYSMAL_DIRT.getDefaultState())).build());
    }



    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(GrimVeil.MOD_ID, name));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
