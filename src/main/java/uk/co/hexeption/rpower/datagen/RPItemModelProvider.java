package uk.co.hexeption.rpower.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import uk.co.hexeption.rpower.Rpower;
import uk.co.hexeption.rpower.init.RPItems;

public class RPItemModelProvider extends ItemModelProvider {

    public RPItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Rpower.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(RPItems.GREEN_SAPPHIRE.get());
        handheldItem(RPItems.GREEN_SAPPHIRE_PICKAXE.get());
        handheldItem(RPItems.GREEN_SAPPHIRE_AXE.get());
        handheldItem(RPItems.GREEN_SAPPHIRE_SHOVEL.get());
        handheldItem(RPItems.GREEN_SAPPHIRE_HOE.get());
        handheldItem(RPItems.GREEN_SAPPHIRE_SWORD.get());
        basicItem(RPItems.RUBY.get());
        handheldItem(RPItems.RUBY_PICKAXE.get());
        handheldItem(RPItems.RUBY_AXE.get());
        handheldItem(RPItems.RUBY_SHOVEL.get());
        handheldItem(RPItems.RUBY_HOE.get());
        handheldItem(RPItems.RUBY_SWORD.get());
        basicItem(RPItems.SAPPHIRE.get());
        handheldItem(RPItems.SAPPHIRE_PICKAXE.get());
        handheldItem(RPItems.SAPPHIRE_AXE.get());
        handheldItem(RPItems.SAPPHIRE_SHOVEL.get());
        handheldItem(RPItems.SAPPHIRE_HOE.get());
        handheldItem(RPItems.SAPPHIRE_SWORD.get());
        handheldItem(RPItems.WOOD_SICKLE.get());
        handheldItem(RPItems.STONE_SICKLE.get());
        handheldItem(RPItems.IRON_SICKLE.get());
        handheldItem(RPItems.GOLD_SICKLE.get());
        handheldItem(RPItems.DIAMOND_SICKLE.get());
        handheldItem(RPItems.NETHERITE_SICKLE.get());
        handheldItem(RPItems.GREEN_SAPPHIRE_SICKLE.get());
        handheldItem(RPItems.RUBY_SICKLE.get());
        handheldItem(RPItems.SAPPHIRE_SICKLE.get());
        basicItem(RPItems.RED_ALLOY_INGOT.get());
    }
}
