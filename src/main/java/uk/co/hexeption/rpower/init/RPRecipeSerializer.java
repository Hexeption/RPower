package uk.co.hexeption.rpower.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.co.hexeption.rpower.RPower;
import uk.co.hexeption.rpower.recipe.AlloyFurnaceRecipe;
import uk.co.hexeption.rpower.recipe.AlloyFurnaceRecipeSerializer;

public final class RPRecipeSerializer {

    private RPRecipeSerializer() {
    }

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, RPower.MODID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<AlloyFurnaceRecipe>> ALLOY_SMELTING = RECIPE_SERIALIZER.register("alloy_smelting", AlloyFurnaceRecipeSerializer::new);
}
