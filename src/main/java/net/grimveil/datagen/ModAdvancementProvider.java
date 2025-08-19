package net.grimveil.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.grimveil.GrimVeil;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.grimveil.item.ModItems;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry getForestMusicDisc = Advancement.Builder.create()
                .display(
                        ModItems.A_FORESTS_LOST_VOICE_MUSIC_DISC,
                        Text.literal("Lost Voices"),
                        Text.literal("Do you hear the forest sing?"),
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true
                )
                .criterion("got_disc", InventoryChangedCriterion.Conditions.items(ModItems.A_FORESTS_LOST_VOICE_MUSIC_DISC))
                .build(consumer, GrimVeil.MOD_ID + ":got_disc");
    }
}
