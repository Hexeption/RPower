package uk.co.hexeption.rpower;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;
import uk.co.hexeption.rpower.init.RPItems;

@Mod(Rpower.MODID)
public class Rpower {
    public static final String MODID = "rpower";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.rpower")).withTabsBefore(CreativeModeTabs.COMBAT).icon(() -> RPItems.GREEN_SAPPHIRE_PICKAXE.get().getDefaultInstance()).displayItems((parameters, output) -> {
        output.accept(RPItems.GREEN_SAPPHIRE.get());
        output.accept(RPItems.GREEN_SAPPHIRE_PICKAXE.get());
        output.accept(RPItems.GREEN_SAPPHIRE_SHOVEL.get());
        output.accept(RPItems.GREEN_SAPPHIRE_AXE.get());
        output.accept(RPItems.GREEN_SAPPHIRE_HOE.get());
        output.accept(RPItems.GREEN_SAPPHIRE_SWORD.get());
        output.accept(RPItems.RUBY.get());
        output.accept(RPItems.RUBY_PICKAXE.get());
        output.accept(RPItems.RUBY_SHOVEL.get());
        output.accept(RPItems.RUBY_AXE.get());
        output.accept(RPItems.RUBY_HOE.get());
        output.accept(RPItems.RUBY_SWORD.get());
    }).build());

    public Rpower(IEventBus modEventBus, ModContainer modContainer) {

        RPItems.ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

    }

}
