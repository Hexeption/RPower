package uk.co.hexeption.rpower.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.co.hexeption.rpower.RPower;
import uk.co.hexeption.rpower.block.machine.AlloyFurnaceBlock;

import java.util.function.Supplier;


public class RPBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(RPower.MODID);

    // Machines
    public static final DeferredBlock<Block> ALLOY_FURNACE = registerBlock("alloy_furnace", () -> new AlloyFurnaceBlock(Block.Properties.of().strength(3.0f).requiresCorrectToolForDrops()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        return registerBlock(name, block, new Item.Properties());
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, Item.Properties itemProperties) {
        DeferredBlock<T> deferredBlock = BLOCKS.register(name, block);
        registerBlockItem(name, deferredBlock, itemProperties);
        return deferredBlock;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block, Item.Properties itemProperties) {
        RPItems.ITEMS.register(name, () -> new BlockItem(block.get(), itemProperties));
    }
}
