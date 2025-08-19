package net.grimveil.sound;

import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.grimveil.GrimVeil;

public class ModSounds {
    public static final SoundEvent BYSMAL_BLOCK_BREAK = registerSoundEvent("bysmal_block_break");
    public static final SoundEvent BYSMAL_BLOCK_STEP = registerSoundEvent("bysmal_block_step");
    public static final SoundEvent BYSMAL_BLOCK_PLACE = registerSoundEvent("bysmal_block_place");
    public static final SoundEvent BYSMAL_BLOCK_HIT = registerSoundEvent("bysmal_block_hit");
    public static final SoundEvent BYSMAL_BLOCK_FALL = registerSoundEvent("bysmal_block_fall");

    public static final BlockSoundGroup BYSMAL_BLOCK_SOUNDS = new BlockSoundGroup(1f, 1f,
            BYSMAL_BLOCK_BREAK, BYSMAL_BLOCK_STEP, BYSMAL_BLOCK_PLACE, BYSMAL_BLOCK_HIT, BYSMAL_BLOCK_FALL);

    public static final SoundEvent A_FORESTS_LOST_VOICE = registerSoundEvent("a_forests_lost_voice");
    public static final RegistryKey<JukeboxSong> A_FORESTS_LOST_VOICE_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(GrimVeil.MOD_ID, "a_forests_lost_voice"));
    public static final SoundEvent TRANSMISSION_FROM_THE_FOREST = registerSoundEvent("transmission_from_the_forest");
    public static final RegistryKey<JukeboxSong> TRANSMISSION_FROM_THE_FOREST_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(GrimVeil.MOD_ID, "transmission_from_the_forest"));

    public static final SoundEvent FLUX = registerSoundEvent("flux");
    public static final RegistryKey<JukeboxSong> FLUX_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(GrimVeil.MOD_ID, "flux"));
    public static final SoundEvent STILL_I_DANCED = registerSoundEvent("still_i_danced");
    public static final RegistryKey<JukeboxSong> STILL_I_DANCED_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(GrimVeil.MOD_ID, "still_i_danced"));

    // * SHADE ENTITY
    public static final SoundEvent ENTITY_SHADE_AMBIENT = registerSoundEvent("entity_shade_ambient");
    public static final SoundEvent ENTITY_SHADE_HURT = registerSoundEvent("entity_shade_hurt");
    public static final SoundEvent ENTITY_SHADE_SCREAM = registerSoundEvent("entity_shade_scream");

    private static SoundEvent registerSoundEvent(String name){
        Identifier id = Identifier.of(GrimVeil.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        GrimVeil.LOGGER.info("Registering Sounds for " + GrimVeil.MOD_ID);
    }
}
