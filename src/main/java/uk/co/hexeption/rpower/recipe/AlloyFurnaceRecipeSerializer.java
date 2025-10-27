package uk.co.hexeption.rpower.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.common.crafting.SizedIngredient;

public class AlloyFurnaceRecipeSerializer implements RecipeSerializer<AlloyFurnaceRecipe> {

    public static final MapCodec<AlloyFurnaceRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.STRING.optionalFieldOf("group", "").forGetter(recipe -> recipe.group),
            ExtraCodecs.nonEmptyList(SizedIngredient.FLAT_CODEC.listOf()).fieldOf("ingredients").forGetter(recipe -> recipe.ingredients.stream().toList()),
            ItemStack.STRICT_CODEC.fieldOf("result").forGetter(recipe -> recipe.result)
    ).apply(instance, (group, ingredients, result) -> {
        NonNullList<SizedIngredient> list = NonNullList.create();
        list.addAll(ingredients);
        return new AlloyFurnaceRecipe(group, result, list);
    }));

    public static final StreamCodec<RegistryFriendlyByteBuf, AlloyFurnaceRecipe> STREAM_CODEC = StreamCodec.of(
            AlloyFurnaceRecipeSerializer::encode,
            AlloyFurnaceRecipeSerializer::decode
    );

    private static AlloyFurnaceRecipe decode(RegistryFriendlyByteBuf buffer) {
        String group = buffer.readUtf();
        int size = buffer.readVarInt();
        NonNullList<SizedIngredient> ingredients = NonNullList.withSize(size, new SizedIngredient(Ingredient.EMPTY, 1));
        ingredients.replaceAll(ignored -> SizedIngredient.STREAM_CODEC.decode(buffer));
        ItemStack result = ItemStack.STREAM_CODEC.decode(buffer);
        return new AlloyFurnaceRecipe(group, result, ingredients);
    }

    private static void encode(RegistryFriendlyByteBuf buffer, AlloyFurnaceRecipe recipe) {
        buffer.writeUtf(recipe.group);
        buffer.writeVarInt(recipe.ingredients.size());
        for (SizedIngredient ingredient : recipe.ingredients) {
            SizedIngredient.STREAM_CODEC.encode(buffer, ingredient);
        }
        ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
    }

    @Override
    public MapCodec<AlloyFurnaceRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, AlloyFurnaceRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
