package net.xg787.xgsmi.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import static net.xg787.xgsmi.Xgsmi.MOD_ID;
import static net.xg787.xgsmi.registry.XgsmiItems.*;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ICON.get());
        basicItem(BLANK_UPGRADE_SMITHING_TEMPLATE.get());
        basicItem(TITANIUM_UPGRADE_SMITHING_TEMPLATE.get());
        basicItem(ROMEUM_UPGRADE_SMITHING_TEMPLATE.get());
    }
}
