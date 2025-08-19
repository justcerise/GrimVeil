package net.grimveil;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.grimveil.entity.custom.ShadeEntity;
import net.grimveil.util.HammerUsageEvent;
import net.minecraft.item.*;
import net.grimveil.block.ModBlocks;
import net.grimveil.entity.ModEntities;
import net.grimveil.item.ModItemGroups;
import net.grimveil.item.ModItems;
import net.grimveil.sound.ModSounds;
import net.grimveil.util.ModFlammableBlocks;
import net.grimveil.util.ModStrippableBlocks;
import net.grimveil.world.gen.ModWorldGeneration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrimVeil implements ModInitializer {
	public static final String MOD_ID = "grimveil";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModBlocks.initialize();
        ModItems.initialize();
        ModSounds.registerSounds();

        ModItemGroups.registerItemGroups();

        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
        ModStrippableBlocks.registerStrippables();
        ModFlammableBlocks.registerFlammableBlocks();

        ModWorldGeneration.generateModWorldGen();

        ModEntities.registerModEntities();
        FabricDefaultAttributeRegistry.register(ModEntities.SHADE, ShadeEntity.createAttributes());

        LOGGER.info("The Archivists watch, your every move...");
	}
}