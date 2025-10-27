package uk.co.hexeption.rpower;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;
import uk.co.hexeption.rpower.init.*;
import uk.co.hexeption.rpower.screen.AlloyFurnaceScreen;

@Mod(Rpower.MODID)
public class Rpower {
    public static final String MODID = "rpower";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.rpower"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> RPItems.GREEN_SAPPHIRE_PICKAXE.get().getDefaultInstance())
                    .displayItems(Rpower::addCreativeTabItems)
                    .build());

    private static void addCreativeTabItems(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
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

    public Rpower(IEventBus modEventBus, ModContainer modContainer) {

        RPBlocks.BLOCKS.register(modEventBus);
        RPItems.ITEMS.register(modEventBus);
        RPBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        RPMenuTypes.MENUS.register(modEventBus);
        RPRecipeSerializer.RECIPE_SERIALIZER.register(modEventBus);
        RPRecipeTypes.RECIPE_TYPE.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

    }

    @EventBusSubscriber(modid = Rpower.MODID, value = Dist.CLIENT)
    public static class RPowerClient {

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(RPMenuTypes.ALLOY_FURNACE_MENU.get(), AlloyFurnaceScreen::new);
        }

    }

}
