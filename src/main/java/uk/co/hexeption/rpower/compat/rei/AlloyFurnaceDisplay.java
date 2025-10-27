package uk.co.hexeption.rpower.compat.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.neoforged.neoforge.common.crafting.SizedIngredient;
import uk.co.hexeption.rpower.recipe.AlloyFurnaceRecipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlloyFurnaceDisplay implements Display {

    private final List<EntryIngredient> inputs;
    private final List<EntryIngredient> outputs;

    public AlloyFurnaceDisplay(RecipeHolder<? extends AlloyFurnaceRecipe> holder) {
        AlloyFurnaceRecipe recipe = holder.value();
        this.inputs = new ArrayList<>();

        // Convert SizedIngredients to EntryIngredients
        for (SizedIngredient ingredient : recipe.getSizedIngredients()) {
            this.inputs.add(EntryIngredients.ofIngredient(ingredient.ingredient()));
        }

        this.outputs = Collections.singletonList(
                EntryIngredients.of(recipe.getResultItem(null))
        );
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        return inputs;
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return outputs;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return AlloyFurnaceCategory.ALLOY_FURNACE_CATEGORY;
    }
}
