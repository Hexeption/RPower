package uk.co.hexeption.rpower.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import uk.co.hexeption.rpower.Rpower;

public class RPTags {

    // Tool
    public static final TagKey<Block> INCORRECT_FOR_GREEN_SAPPHIRE_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(Rpower.MODID, "incorrect_for_green_sapphire_tool"));
    public static final TagKey<Block> INCORRECT_FOR_RUBY_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(Rpower.MODID, "incorrect_for_ruby_tool"));
    public static final TagKey<Block> INCORRECT_FOR_SAPPHIRE_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(Rpower.MODID, "incorrect_for_sapphire_tool"));

}
