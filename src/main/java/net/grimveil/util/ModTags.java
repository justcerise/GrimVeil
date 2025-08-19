package net.grimveil.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.grimveil.GrimVeil;

public class ModTags {
    public static class Blocks{
        public static TagKey<Block> NEEDS_SHADE_STEEL_TOOL = createTag("needs_shade_steel_tool");
        public static TagKey<Block> INCORRECT_FOR_SHADE_STEEL_TOOL = createTag("incorrect_for_shade_steel_tool");

        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(GrimVeil.MOD_ID));
        }
    }

    public static class Items{
        public static final TagKey<Item> SHADE_STEEL_REPAIR = createTag("shade_steel_repair");


        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(GrimVeil.MOD_ID, name));
        }
    }
}
