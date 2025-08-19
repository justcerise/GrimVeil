package net.grimveil.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.grimveil.item.custom.HammerItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.grimveil.GrimVeil;
import net.grimveil.block.ModBlocks;
import net.grimveil.entity.ModEntities;
import net.grimveil.sound.ModSounds;

import java.util.function.Function;

public class ModItems {
    public static final Identifier BYSMAL = Identifier.of(GrimVeil.MOD_ID, "bysmal");
    public static final SignItem BYSMAL_SIGN_ITEM;
    public static final HangingSignItem BYSMAL_HANGING_SIGN_ITEM;
    public static final Item BYSMAL_BOAT = TerraformBoatItemHelper.registerBoatItem(BYSMAL, false);
    public static final Item BYSMAL_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(BYSMAL, true);


    // * INGREDIENTS
    public static final Item BYSMAL_BRANCH = register("bysmal_branch", Item::new, new Item.Settings());
    public static final Item VOID_STEEL_INGOT = register("void_steel_ingot", Item::new, new Item.Settings());
    public static final Item SHADE_FRAGMENT = register("shade_fragment", Item::new, new Item.Settings());
    public static final Item SHADE_STEEL_INGOT = register("shade_steel_ingot", Item::new, new Item.Settings());

    // * TOOLS & UTILITIES

    // * SHADE STEEL
    public static final Item SHADE_STEEL_SWORD = register("shade_steel_sword",
            settings -> new SwordItem(ModToolMaterials.SHADE_STEEL, 4, -2f, settings), new Item.Settings());
    public static final Item SHADE_STEEL_AXE = register("shade_steel_axe",
            settings -> new AxeItem(ModToolMaterials.SHADE_STEEL, 6, -2.6f, settings), new Item.Settings());
    public static final Item SHADE_STEEL_PICKAXE = register("shade_steel_pickaxe",
            settings -> new PickaxeItem(ModToolMaterials.SHADE_STEEL, 1, -2f, settings), new Item.Settings());
    public static final Item SHADE_STEEL_SHOVEL = register("shade_steel_shovel",
            settings -> new ShovelItem(ModToolMaterials.SHADE_STEEL, 1.5f, -2f, settings), new Item.Settings());
    public static final Item SHADE_STEEL_HOE = register("shade_steel_hoe",
            settings -> new HoeItem(ModToolMaterials.SHADE_STEEL, 0, -2.5f, settings), new Item.Settings());
    public static final Item SHADE_STEEL_HAMMER = register("shade_steel_hammer",
            settings -> new HammerItem(ModToolMaterials.SHADE_STEEL, 8, -3.5f, settings), new Item.Settings());

    static {
        BYSMAL_SIGN_ITEM = new SignItem(
                ModBlocks.BYSMAL_SIGN,
                ModBlocks.BYSMAL_WALL_SIGN,
                new Item.Settings()
                        .maxCount(16)
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, ModBlocks.BYSMAL_SIGN_ID))
        );
        BYSMAL_SIGN_ITEM.appendBlocks(Item.BLOCK_ITEMS, BYSMAL_SIGN_ITEM);
        Registry.register(Registries.ITEM, ModBlocks.BYSMAL_SIGN_ID, BYSMAL_SIGN_ITEM);
        BYSMAL_HANGING_SIGN_ITEM = new HangingSignItem(
                ModBlocks.BYSMAL_HANGING_SIGN,
                ModBlocks.BYSMAL_WALL_HANGING_SIGN,
                new Item.Settings()
                        .maxCount(16)
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, ModBlocks.BYSMAL_HANGING_SIGN_ID))
        );
        BYSMAL_HANGING_SIGN_ITEM.appendBlocks(Item.BLOCK_ITEMS, BYSMAL_HANGING_SIGN_ITEM);
        Registry.register(Registries.ITEM, ModBlocks.BYSMAL_HANGING_SIGN_ID, BYSMAL_HANGING_SIGN_ITEM);
    }





    public static final Item SHADE_SPAWN_EGG = register("shade_spawn_egg",
            settings -> new SpawnEggItem(ModEntities.SHADE, settings),
            new Item.Settings());

    public static final Item A_FORESTS_LOST_VOICE_MUSIC_DISC = register("a_forests_lost_voice_music_disc",
            Item::new, new Item.Settings().jukeboxPlayable(ModSounds.A_FORESTS_LOST_VOICE_KEY).maxCount(1).rarity(Rarity.RARE));
    public static final Item TRANSMISSION_FROM_THE_FOREST_MUSIC_DISC = register("transmission_from_the_forest_music_disc",
            Item::new, new Item.Settings().jukeboxPlayable(ModSounds.TRANSMISSION_FROM_THE_FOREST_KEY).maxCount(1).rarity(Rarity.RARE));
    public static final Item FLUX_MUSIC_DISC = register("flux_music_disc",
            Item::new, new Item.Settings().jukeboxPlayable(ModSounds.FLUX_KEY).maxCount(1).rarity(Rarity.EPIC));
    public static final Item STILL_I_DANCED_MUSIC_DISC = register("still_i_danced_music_disc",
            Item::new, new Item.Settings().jukeboxPlayable(ModSounds.STILL_I_DANCED_KEY).maxCount(1).rarity(Rarity.EPIC));




    public static void initialize(){
        GrimVeil.LOGGER.info("Registering Items for " + GrimVeil.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.BYSMAL_BRANCH));
    }

    //Already existing items, bysmal_log, music_disc
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GrimVeil.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }

    //The fucking sign_item. because hey, that's nice.
    public static Item register(String name, Item item) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GrimVeil.MOD_ID, name));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }
}
