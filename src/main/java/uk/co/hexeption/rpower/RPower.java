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

@Mod(RPower.MODID)
public class RPower {
    public static final String MODID = "rpower";
    public static final Logger LOGGER = LogUtils.getLogger();


    public RPower(IEventBus modEventBus, ModContainer modContainer) {

        RPBlocks.BLOCKS.register(modEventBus);
        RPItems.ITEMS.register(modEventBus);
        RPBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        RPMenuTypes.MENUS.register(modEventBus);
        RPRecipeSerializer.RECIPE_SERIALIZER.register(modEventBus);
        RPRecipeTypes.RECIPE_TYPE.register(modEventBus);
        RPTabs.CREATIVE_MODE_TABS.register(modEventBus);

    }

    @EventBusSubscriber(modid = RPower.MODID, value = Dist.CLIENT)
    public static class RPowerClient {

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(RPMenuTypes.ALLOY_FURNACE_MENU.get(), AlloyFurnaceScreen::new);
        }

    }

}
