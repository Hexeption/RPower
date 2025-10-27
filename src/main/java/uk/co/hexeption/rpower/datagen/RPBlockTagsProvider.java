package uk.co.hexeption.rpower.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import uk.co.hexeption.rpower.RPower;
import uk.co.hexeption.rpower.init.RPTags;

import java.util.concurrent.CompletableFuture;

public class RPBlockTagsProvider extends BlockTagsProvider {

    public RPBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RPower.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(RPTags.INCORRECT_FOR_GREEN_SAPPHIRE_TOOL).addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);
        tag(RPTags.INCORRECT_FOR_RUBY_TOOL).addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);
        tag(RPTags.INCORRECT_FOR_SAPPHIRE_TOOL).addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);
        tag(RPTags.MINEABLE_WITH_SICKLE).addTag(BlockTags.MINEABLE_WITH_HOE);
    }

    @Override
    public String getName() {
        return RPower.MODID + " Block Tags";
    }
}
