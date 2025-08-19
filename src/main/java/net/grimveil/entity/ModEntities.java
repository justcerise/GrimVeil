package net.grimveil.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.grimveil.GrimVeil;
import net.grimveil.entity.custom.ShadeEntity;

public class ModEntities {
    private static final RegistryKey<EntityType<?>> SHADE_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(GrimVeil.MOD_ID, "shade"));

    public static final EntityType<ShadeEntity> SHADE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(GrimVeil.MOD_ID, "shade"),
            EntityType.Builder.create(ShadeEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.75f, 1.75f).build(SHADE_KEY));


    public static void registerModEntities(){
        GrimVeil.LOGGER.info("Registering Entities for " + GrimVeil.MOD_ID);
    }

}
