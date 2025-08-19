package net.grimveil.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.grimveil.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator BYSMAL =
            new SaplingGenerator("bysmal", 0.5f,
                    Optional.of(ModConfiguredFeatures.BYSMAL_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());
}

