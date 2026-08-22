package net.xg787.xgsmi;

import net.neoforged.neoforge.common.ModConfigSpec;

public class StoryModeRebornConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec.BooleanValue ADD_ITEMS_TO_VANILLA_TABS = BUILDER.define("add_items_to_vanilla_tabs", true);
    static final ModConfigSpec SPEC = BUILDER.build();
}
