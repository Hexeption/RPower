package uk.co.hexeption.rpower.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.co.hexeption.rpower.Rpower;

import java.util.function.Supplier;

public class RPItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Rpower.MODID);

    // Gems
    public static final DeferredHolder<Item, Item> GREEN_SAPPHIRE = ITEMS.register("green_sapphire", () -> new Item(new Item.Properties()));

    // Tool Tier
    public static final Tier GREEN_SAPPHIRE_TIER = new SimpleTier(RPTags.INCORRECT_FOR_GREEN_SAPPHIRE_TOOL, 500, 8f, 3f, 12, () -> Ingredient.of(GREEN_SAPPHIRE.get()));

    // Tools
    public static final Supplier<PickaxeItem> GREEN_SAPPHIRE_PICKAXE = ITEMS.register("green_sapphire_pickaxe", () -> new PickaxeItem(GREEN_SAPPHIRE_TIER, new Item.Properties()));
    public static final Supplier<AxeItem> GREEN_SAPPHIRE_AXE = ITEMS.register("green_sapphire_axe", () -> new AxeItem(GREEN_SAPPHIRE_TIER, new Item.Properties()));
    public static final Supplier<ShovelItem> GREEN_SAPPHIRE_SHOVEL = ITEMS.register("green_sapphire_shovel", () -> new ShovelItem(GREEN_SAPPHIRE_TIER, new Item.Properties()));
    public static final Supplier<HoeItem> GREEN_SAPPHIRE_HOE = ITEMS.register("green_sapphire_hoe", () -> new HoeItem(GREEN_SAPPHIRE_TIER, new Item.Properties()));
    public static final Supplier<SwordItem> GREEN_SAPPHIRE_SWORD = ITEMS.register("green_sapphire_sword", () -> new SwordItem(GREEN_SAPPHIRE_TIER, new Item.Properties()));

}
