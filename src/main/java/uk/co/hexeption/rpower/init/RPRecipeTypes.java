package uk.co.hexeption.rpower.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.co.hexeption.rpower.Rpower;
import uk.co.hexeption.rpower.recipe.AlloyFurnaceRecipe;

public final class RPRecipeTypes {

    private RPRecipeTypes() {
    }

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPE = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, Rpower.MODID);

    public static final DeferredHolder<RecipeType<?>, RecipeType<AlloyFurnaceRecipe>> ALLOY_SMELTING = RECIPE_TYPE.register("alloy_smelting", () -> RecipeType.simple(ResourceLocation.fromNamespaceAndPath(Rpower.MODID, "alloy_smelting")));
}
