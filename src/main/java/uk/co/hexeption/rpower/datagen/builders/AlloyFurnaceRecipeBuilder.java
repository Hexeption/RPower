package uk.co.hexeption.rpower.datagen.builders;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.crafting.SizedIngredient;
import org.jetbrains.annotations.Nullable;
import uk.co.hexeption.rpower.recipe.AlloyFurnaceRecipe;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class AlloyFurnaceRecipeBuilder implements RecipeBuilder {

    private final List<SizedIngredient> ingredients = new ArrayList<>();
    private final ItemStack result;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    @Nullable
    private String group;

    private AlloyFurnaceRecipeBuilder(ItemStack result) {
        this.result = result;
    }

    public static AlloyFurnaceRecipeBuilder alloy(ItemLike result) {
        return new AlloyFurnaceRecipeBuilder(new ItemStack(result));
    }

    public static AlloyFurnaceRecipeBuilder alloy(ItemLike result, int count) {
        return new AlloyFurnaceRecipeBuilder(new ItemStack(result, count));
    }

    public AlloyFurnaceRecipeBuilder requires(ItemLike item) {
        return requires(item, 1);
    }

    public AlloyFurnaceRecipeBuilder requires(ItemLike item, int count) {
        this.ingredients.add(SizedIngredient.of(item, count));
        return this;
    }

    public AlloyFurnaceRecipeBuilder requires(TagKey<Item> tag) {
        return requires(tag, 1);
    }

    public AlloyFurnaceRecipeBuilder requires(TagKey<Item> tag, int count) {
        this.ingredients.add(SizedIngredient.of(tag, count));
        return this;
    }

    @Override
    public RecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getResult() {
        return this.result.getItem();
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceLocation id) {
        Advancement.Builder advancement = recipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                .rewards(AdvancementRewards.Builder.recipe(id))
                .requirements(AdvancementRequirements.Strategy.OR);

        this.criteria.forEach(advancement::addCriterion);

        NonNullList<SizedIngredient> ingredientList = NonNullList.create();
        ingredientList.addAll(ingredients);

        AlloyFurnaceRecipe recipe = new AlloyFurnaceRecipe(group != null ? group : "", result.copy(), ingredientList);

        recipeOutput.accept(id, recipe, advancement.build(id.withPrefix("recipes/")));
    }
}
