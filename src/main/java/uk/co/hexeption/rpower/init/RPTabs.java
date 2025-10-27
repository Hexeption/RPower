package uk.co.hexeption.rpower.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.co.hexeption.rpower.RPower;

public class RPTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RPower.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RPOWER_MISC = CREATIVE_MODE_TABS.register("rpower_misc",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.rpower.rpower_misc"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .icon(() -> RPItems.GREEN_SAPPHIRE_PICKAXE.get().getDefaultInstance())
                    .displayItems(RPTabs::addToRPowerMisc)
                    .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RPOWER_MACHINES = CREATIVE_MODE_TABS.register("rpower_machines",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.rpower.rpower_machines"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .icon(() -> RPBlocks.ALLOY_FURNACE.get().asItem().getDefaultInstance())
                    .displayItems(RPTabs::addToRPowerMachines)
                    .build());

    private static void addToRPowerMisc(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        // Gems
        output.accept(RPItems.GREEN_SAPPHIRE.get());
        output.accept(RPItems.RUBY.get());
        output.accept(RPItems.SAPPHIRE.get());

        // Green Sapphire Tools
        output.accept(RPItems.GREEN_SAPPHIRE_PICKAXE.get());
        output.accept(RPItems.GREEN_SAPPHIRE_SHOVEL.get());
        output.accept(RPItems.GREEN_SAPPHIRE_AXE.get());
        output.accept(RPItems.GREEN_SAPPHIRE_HOE.get());
        output.accept(RPItems.GREEN_SAPPHIRE_SWORD.get());
        output.accept(RPItems.GREEN_SAPPHIRE_SICKLE.get());

        // Ruby Tools
        output.accept(RPItems.RUBY_PICKAXE.get());
        output.accept(RPItems.RUBY_SHOVEL.get());
        output.accept(RPItems.RUBY_AXE.get());
        output.accept(RPItems.RUBY_HOE.get());
        output.accept(RPItems.RUBY_SWORD.get());
        output.accept(RPItems.RUBY_SICKLE.get());

        // Sapphire Tools
        output.accept(RPItems.SAPPHIRE_PICKAXE.get());
        output.accept(RPItems.SAPPHIRE_SHOVEL.get());
        output.accept(RPItems.SAPPHIRE_AXE.get());
        output.accept(RPItems.SAPPHIRE_HOE.get());
        output.accept(RPItems.SAPPHIRE_SWORD.get());
        output.accept(RPItems.SAPPHIRE_SICKLE.get());

        // Vanilla Sickles
        output.accept(RPItems.WOOD_SICKLE.get());
        output.accept(RPItems.STONE_SICKLE.get());
        output.accept(RPItems.IRON_SICKLE.get());
        output.accept(RPItems.GOLD_SICKLE.get());
        output.accept(RPItems.DIAMOND_SICKLE.get());
        output.accept(RPItems.NETHERITE_SICKLE.get());
    }

    private static void addToRPowerMachines(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        output.accept(RPBlocks.ALLOY_FURNACE.get());
    }
}
