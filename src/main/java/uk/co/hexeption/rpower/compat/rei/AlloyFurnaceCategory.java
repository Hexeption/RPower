package uk.co.hexeption.rpower.compat.rei;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import uk.co.hexeption.rpower.Rpower;
import uk.co.hexeption.rpower.init.RPBlocks;

import java.util.ArrayList;
import java.util.List;

public class AlloyFurnaceCategory implements DisplayCategory<AlloyFurnaceDisplay> {

    public static final CategoryIdentifier<AlloyFurnaceDisplay> ALLOY_FURNACE_CATEGORY =
            CategoryIdentifier.of(ResourceLocation.fromNamespaceAndPath(Rpower.MODID, "alloy_smelting"));

    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Rpower.MODID, "textures/gui/alloy_furnace/alloy_furnace.png");

    @Override
    public CategoryIdentifier<? extends AlloyFurnaceDisplay> getCategoryIdentifier() {
        return ALLOY_FURNACE_CATEGORY;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("container.rpower.alloy_furnace");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(RPBlocks.ALLOY_FURNACE.get());
    }

    @Override
    public int getDisplayWidth(AlloyFurnaceDisplay display) {
        return 150;
    }

    @Override
    public int getDisplayHeight() {
        return 70;
    }

    @Override
    public List<Widget> setupDisplay(AlloyFurnaceDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 58, bounds.getCenterY() - 27);
        List<Widget> widgets = new ArrayList<>();

        // Background
        widgets.add(Widgets.createRecipeBase(bounds));

        // Input slots (3x3 grid)
        int inputStartX = startPoint.x + 1;
        int inputStartY = startPoint.y + 1;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                widgets.add(Widgets.createSlot(new Point(inputStartX + col * 18, inputStartY + row * 18))
                        .markInput());
            }
        }

        // Add actual ingredients to slots
        List<me.shedaniel.rei.api.common.entry.EntryIngredient> inputs = display.getInputEntries();
        for (int i = 0; i < Math.min(inputs.size(), 9); i++) {
            int row = i / 3;
            int col = i % 3;
            widgets.add(Widgets.createSlot(new Point(inputStartX + col * 18, inputStartY + row * 18))
                    .entries(inputs.get(i))
                    .markInput());
        }

        // Animated Arrow
        widgets.add(Widgets.createArrow(new Point(startPoint.x + 60, startPoint.y + 18))
                .animationDurationTicks(200)); // 200 ticks = 10 seconds (same as furnace cook time)


        // Output slot
        widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 95, startPoint.y + 19)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 95, startPoint.y + 19))
                .entries(display.getOutputEntries().get(0))
                .disableBackground()
                .markOutput());

        return widgets;
    }
}
