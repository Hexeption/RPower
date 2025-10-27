package uk.co.hexeption.rpower.compat.rei;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.forge.REIPluginClient;
import uk.co.hexeption.rpower.init.RPBlocks;
import uk.co.hexeption.rpower.init.RPRecipeTypes;
import uk.co.hexeption.rpower.recipe.AlloyFurnaceRecipe;
import uk.co.hexeption.rpower.screen.AlloyFurnaceScreen;

@REIPluginClient
public class RPowerREIClientPlugin implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new AlloyFurnaceCategory());
        registry.addWorkstations(AlloyFurnaceCategory.ALLOY_FURNACE_CATEGORY, EntryStacks.of(RPBlocks.ALLOY_FURNACE.get()));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(AlloyFurnaceRecipe.class, RPRecipeTypes.ALLOY_SMELTING.get(), AlloyFurnaceDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(screen.getGuiLeft() + 107, screen.getGuiTop() + 35, 24, 17), AlloyFurnaceScreen.class, AlloyFurnaceCategory.ALLOY_FURNACE_CATEGORY);
    }
}
