package uk.co.hexeption.rpower.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import uk.co.hexeption.rpower.Rpower;
import uk.co.hexeption.rpower.init.RPItems;

import java.util.concurrent.CompletableFuture;

public class RPRecipeProvider extends RecipeProvider {

    public RPRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.GREEN_SAPPHIRE_PICKAXE.get())
                .pattern("XXX").pattern(" # ").pattern(" # ")
                .define('X', RPItems.GREEN_SAPPHIRE.get())
                .define('#', Items.STICK)
                .unlockedBy("has_item", has(RPItems.GREEN_SAPPHIRE.get()))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "green_sapphire_pickaxe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.GREEN_SAPPHIRE_SWORD.get())
                .pattern("X").pattern("X").pattern("#")
                .define('X', RPItems.GREEN_SAPPHIRE.get())
                .define('#', Items.STICK)
                .unlockedBy("has_item", has(RPItems.GREEN_SAPPHIRE.get()))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "green_sapphire_sword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.GREEN_SAPPHIRE_AXE.get())
                .pattern("XX").pattern("X#").pattern(" #")
                .define('X', RPItems.GREEN_SAPPHIRE.get())
                .define('#', Items.STICK)
                .unlockedBy("has_item", has(RPItems.GREEN_SAPPHIRE.get()))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "green_sapphire_axe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.GREEN_SAPPHIRE_HOE.get())
                .pattern("XX").pattern(" #").pattern(" #")
                .define('X', RPItems.GREEN_SAPPHIRE.get())
                .define('#', Items.STICK)
                .unlockedBy("has_item", has(RPItems.GREEN_SAPPHIRE.get()))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "green_sapphire_hoe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.GREEN_SAPPHIRE_SHOVEL.get())
                .pattern("X").pattern("#").pattern("#")
                .define('X', RPItems.GREEN_SAPPHIRE.get())
                .define('#', Items.STICK)
                .unlockedBy("has_item", has(RPItems.GREEN_SAPPHIRE.get()))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "green_sapphire_shovel"));


    }
}
