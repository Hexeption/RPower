package uk.co.hexeption.rpower.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import uk.co.hexeption.rpower.RPower;
import uk.co.hexeption.rpower.init.RPItems;

import java.util.concurrent.CompletableFuture;

public class RPItemTagsProvider extends ItemTagsProvider {

    public RPItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, RPower.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(Tags.Items.MINING_TOOL_TOOLS).add(
                RPItems.GREEN_SAPPHIRE_PICKAXE.get(), RPItems.GREEN_SAPPHIRE_SHOVEL.get(), RPItems.GREEN_SAPPHIRE_AXE.get(), RPItems.GREEN_SAPPHIRE_HOE.get(),
                RPItems.SAPPHIRE_PICKAXE.get(), RPItems.SAPPHIRE_SHOVEL.get(), RPItems.SAPPHIRE_AXE.get(), RPItems.SAPPHIRE_HOE.get(),
                RPItems.RUBY_PICKAXE.get(), RPItems.RUBY_SHOVEL.get(), RPItems.RUBY_AXE.get(), RPItems.RUBY_HOE.get(),
                RPItems.WOOD_SICKLE.get(), RPItems.STONE_SICKLE.get(), RPItems.IRON_SICKLE.get(), RPItems.GOLD_SICKLE.get(),
                RPItems.DIAMOND_SICKLE.get(), RPItems.NETHERITE_SICKLE.get(), RPItems.SAPPHIRE_SICKLE.get(), RPItems.RUBY_SICKLE.get(), RPItems.GREEN_SAPPHIRE_SICKLE.get()
        );

        tag(ItemTags.PICKAXES).add(RPItems.GREEN_SAPPHIRE_PICKAXE.get(), RPItems.SAPPHIRE_PICKAXE.get(), RPItems.RUBY_PICKAXE.get());
        tag(ItemTags.SHOVELS).add(RPItems.GREEN_SAPPHIRE_SHOVEL.get(), RPItems.SAPPHIRE_SHOVEL.get(), RPItems.RUBY_SHOVEL.get());
        tag(ItemTags.AXES).add(RPItems.GREEN_SAPPHIRE_AXE.get(), RPItems.SAPPHIRE_AXE.get(), RPItems.RUBY_AXE.get());
        tag(ItemTags.HOES).add(RPItems.GREEN_SAPPHIRE_HOE.get(), RPItems.SAPPHIRE_HOE.get(), RPItems.RUBY_HOE.get());
        tag(ItemTags.HOES).add(RPItems.WOOD_SICKLE.get(), RPItems.STONE_SICKLE.get(), RPItems.IRON_SICKLE.get(), RPItems.GOLD_SICKLE.get(), RPItems.DIAMOND_SICKLE.get(), RPItems.NETHERITE_SICKLE.get(), RPItems.SAPPHIRE_SICKLE.get(), RPItems.RUBY_SICKLE.get(), RPItems.GREEN_SAPPHIRE_SICKLE.get());
        tag(ItemTags.SWORDS).add(RPItems.GREEN_SAPPHIRE_SWORD.get(), RPItems.SAPPHIRE_SWORD.get(), RPItems.RUBY_SWORD.get());

        tag(Tags.Items.MELEE_WEAPON_TOOLS).add(
                RPItems.GREEN_SAPPHIRE_SWORD.get(),
                RPItems.SAPPHIRE_SWORD.get(),
                RPItems.RUBY_SWORD.get()
        );
    }

    @Override
    public String getName() {
        return RPower.MODID + " Item Tags";
    }
}
