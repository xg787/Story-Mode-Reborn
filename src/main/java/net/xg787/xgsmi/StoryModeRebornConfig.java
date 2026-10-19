package net.xg787.xgsmi;

import net.neoforged.neoforge.common.ModConfigSpec;

public class StoryModeRebornConfig {
    //private static final ModConfigSpec.Builder CLIENT_BUILDER = new ModConfigSpec.Builder();
    //private static final ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.Builder SERVER_BUILDER = new ModConfigSpec.Builder();
    private static final ModConfigSpec.Builder STARTUP_BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec.BooleanValue CREEPER_SOUNDS = SERVER_BUILDER.define("creeper_sounds", true);
    public static final ModConfigSpec.BooleanValue ENDERMAN_SOUNDS = SERVER_BUILDER.define("enderman_sounds", true);
    public static final ModConfigSpec.BooleanValue BOW_PULLING_SOUND = SERVER_BUILDER.define("bow_pulling_sound", true);
    public static final ModConfigSpec.BooleanValue ENDER_PEARL_SOUND = SERVER_BUILDER.define("ender_pearl_sound", true);
    public static final ModConfigSpec.BooleanValue ADD_ITEMS_TO_VANILLA_TABS = STARTUP_BUILDER.define("add_items_to_vanilla_tabs", true);

    //public static final ModConfigSpec CLIENT_SPEC = CLIENT_BUILDER.build();
    //public static final ModConfigSpec COMMON_SPEC = COMMON_BUILDER.build();
    public static final ModConfigSpec SERVER_SPEC = SERVER_BUILDER.build();
    public static final ModConfigSpec STARTUP_SPEC = STARTUP_BUILDER.build();

}
