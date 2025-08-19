package net.grimveil.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.grimveil.GrimVeil;
import net.grimveil.block.ModBlocks;
import net.grimveil.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider<Item> {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    public static final TagKey<Item> BYSMAL_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of(GrimVeil.MOD_ID, "bysmal_items"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BYSMAL_ITEMS)
                .add(ModItems.BYSMAL_BRANCH)
                .add(ModItems.A_FORESTS_LOST_VOICE_MUSIC_DISC)
                .setReplace(true);
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.BYSMAL_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.SHADE_STEEL_SWORD);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.SHADE_STEEL_SHOVEL);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.SHADE_STEEL_PICKAXE)
                .add(ModItems.SHADE_STEEL_HAMMER);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.SHADE_STEEL_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.SHADE_STEEL_HOE);
    }
}
