package uk.co.hexeption.rpower.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.crafting.SizedIngredient;
import uk.co.hexeption.rpower.init.RPBlocks;
import uk.co.hexeption.rpower.init.RPRecipeSerializer;
import uk.co.hexeption.rpower.init.RPRecipeTypes;

public class AlloyFurnaceRecipe implements Recipe<CraftingInput> {

    final String group;
    final ItemStack result;
    final NonNullList<SizedIngredient> ingredients;

    public AlloyFurnaceRecipe(String group, ItemStack result, NonNullList<SizedIngredient> ingredients) {
        this.group = group;
        this.result = result;
        this.ingredients = ingredients;
    }

    @Override
    public boolean matches(CraftingInput input, Level level) {
        for (SizedIngredient ingredient : ingredients) {
            int needed = ingredient.count();
            for (ItemStack stack : input.items()) {
                if (ingredient.ingredient().test(stack)) {
                    needed -= stack.getCount();
                    if (needed <= 0) break;
                }
            }
            if (needed > 0) return false;
        }
        return true;
    }

    public void useItems(CraftingInput input) {
        for (SizedIngredient ingredient : ingredients) {
            int needed = ingredient.count();
            for (int i = 0; i < input.size(); i++) {
                ItemStack stack = input.items().get(i);
                if (ingredient.ingredient().test(stack)) {
                    int consumed = Math.min(stack.getCount(), needed);
                    stack.shrink(consumed);
                    needed -= consumed;
                    if (needed <= 0) break;
                }
            }
        }
    }

    @Override
    public ItemStack assemble(CraftingInput input, HolderLookup.Provider provider) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width <= 3 && height <= 3;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return result;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RPRecipeSerializer.ALLOY_SMELTING.get();
    }

    @Override
    public RecipeType<?> getType() {
        return RPRecipeTypes.ALLOY_SMELTING.get();
    }

    @Override
    public String getGroup() {
        return group;
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(RPBlocks.ALLOY_FURNACE.get());
    }

    public NonNullList<SizedIngredient> getSizedIngredients() {
        return ingredients;
    }
}

