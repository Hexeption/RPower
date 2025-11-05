package uk.co.hexeption.rpower.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import uk.co.hexeption.rpower.init.RPBlocks;

import java.util.Set;

public class RPBlockLoot extends BlockLootSubProvider {

    protected RPBlockLoot(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(RPBlocks.ALLOY_FURNACE.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return RPBlocks.BLOCKS.getEntries().stream().map(holder -> holder.getDelegate().value())::iterator;
    }


}
