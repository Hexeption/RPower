package uk.co.hexeption.rpower.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import uk.co.hexeption.rpower.Rpower;
import uk.co.hexeption.rpower.datagen.builders.AlloyFurnaceRecipeBuilder;
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

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.RUBY_PICKAXE.get())
                .pattern("XXX").pattern(" # ").pattern(" # ")
                .define('X', RPItems.RUBY.get())
                .define('#', Items.STICK)
                .unlockedBy("has_item", has(RPItems.RUBY.get()))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "ruby_pickaxe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.RUBY_SWORD.get())
                .pattern("X").pattern("X").pattern("#")
                .define('X', RPItems.RUBY.get())
                .define('#', Items.STICK)
                .unlockedBy("has_item", has(RPItems.RUBY.get()))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "ruby_sword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.RUBY_AXE.get())
                .pattern("XX").pattern("X#").pattern(" #")
                .define('X', RPItems.RUBY.get())
                .define('#', Items.STICK)
                .unlockedBy("has_item", has(RPItems.RUBY.get()))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "ruby_axe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.RUBY_HOE.get())
                .pattern("XX").pattern(" #").pattern(" #")
                .define('X', RPItems.RUBY.get())
                .define('#', Items.STICK)
                .unlockedBy("has_item", has(RPItems.RUBY.get()))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "ruby_hoe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.RUBY_SHOVEL.get())
                .pattern("X").pattern("#").pattern("#")
                .define('X', RPItems.RUBY.get())
                .define('#', Items.STICK)
                .unlockedBy("has_item", has(RPItems.RUBY.get()))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "ruby_shovel"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.SAPPHIRE_PICKAXE.get())
                .pattern("XXX").pattern(" # ").pattern(" # ")
                .define('X', RPItems.SAPPHIRE.get())
                .define('#', Items.STICK)
                .unlockedBy("has_item", has(RPItems.SAPPHIRE.get()))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "sapphire_pickaxe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.SAPPHIRE_SWORD.get())
                .pattern("X").pattern("X").pattern("#")
                .define('X', RPItems.SAPPHIRE.get())
                .define('#', Items.STICK)
                .unlockedBy("has_item", has(RPItems.SAPPHIRE.get()))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "sapphire_sword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.SAPPHIRE_AXE.get())
                .pattern("XX").pattern("X#").pattern(" #")
                .define('X', RPItems.SAPPHIRE.get())
                .define('#', Items.STICK)
                .unlockedBy("has_item", has(RPItems.SAPPHIRE.get()))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "sapphire_axe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.SAPPHIRE_HOE.get())
                .pattern("XX").pattern(" #").pattern(" #")
                .define('X', RPItems.SAPPHIRE.get())
                .define('#', Items.STICK)
                .unlockedBy("has_item", has(RPItems.SAPPHIRE.get()))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "sapphire_hoe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.WOOD_SICKLE.get())
                .pattern(" M ").pattern("  M").pattern("SM ")
                .define('M', ItemTags.PLANKS)
                .define('S', Items.STICK)
                .unlockedBy("has_item", has(ItemTags.PLANKS))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "wood_sickle"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.STONE_SICKLE.get())
                .pattern(" M ").pattern("  M").pattern("SM ")
                .define('M', Items.COBBLESTONE)
                .define('S', Items.STICK)
                .unlockedBy("has_item", has(Items.COBBLESTONE))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "stone_sickle"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.IRON_SICKLE.get())
                .pattern(" M ").pattern("  M").pattern("SM ")
                .define('M', Items.IRON_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_item", has(Items.IRON_INGOT))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "iron_sickle"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.GOLD_SICKLE.get())
                .pattern(" M ").pattern("  M").pattern("SM ")
                .define('M', Items.GOLD_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_item", has(Items.GOLD_INGOT))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "gold_sickle"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.DIAMOND_SICKLE.get())
                .pattern(" M ").pattern("  M").pattern("SM ")
                .define('M', Items.DIAMOND)
                .define('S', Items.STICK)
                .unlockedBy("has_item", has(Items.DIAMOND))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "diamond_sickle"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.SAPPHIRE_SICKLE.get())
                .pattern(" M ").pattern("  M").pattern("SM ")
                .define('M', RPItems.SAPPHIRE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_item", has(RPItems.SAPPHIRE.get()))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "sapphire_sickle"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.RUBY_SICKLE.get())
                .pattern(" M ").pattern("  M").pattern("SM ")
                .define('M', RPItems.RUBY.get())
                .define('S', Items.STICK)
                .unlockedBy("has_item", has(RPItems.RUBY.get()))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "ruby_sickle"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RPItems.GREEN_SAPPHIRE_SICKLE.get())
                .pattern(" M ").pattern("  M").pattern("SM ")
                .define('M', RPItems.GREEN_SAPPHIRE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_item", has(RPItems.GREEN_SAPPHIRE.get()))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "green_sapphire_sickle"));

        netheriteSmithing(recipeOutput, RPItems.DIAMOND_SICKLE.get(), RecipeCategory.TOOLS, RPItems.NETHERITE_SICKLE.get());

        // Alloy Furnace Recipes
        AlloyFurnaceRecipeBuilder.alloy(RPItems.RED_ALLOY_INGOT.get())
                .requires(Items.REDSTONE, 4)
                .requires(Items.IRON_INGOT)
                .unlockedBy("has_iron", has(Tags.Items.INGOTS_IRON))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "alloy_furnace/red_alloy_ingot"));

        AlloyFurnaceRecipeBuilder.alloy(RPItems.RED_ALLOY_INGOT.get())
                .requires(Items.REDSTONE, 4)
                .requires(Items.COPPER_INGOT)
                .unlockedBy("has_copper", has(Tags.Items.INGOTS_COPPER))
                .save(recipeOutput, ResourceLocation.tryBuild(Rpower.MODID, "alloy_furnace/red_alloy_ingot_copper"));
    }
}
