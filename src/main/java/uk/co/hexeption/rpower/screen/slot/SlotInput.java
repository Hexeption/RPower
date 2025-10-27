package uk.co.hexeption.rpower.screen.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class SlotInput extends Slot {

    public SlotInput(Container container, int slot, int x, int y) {
        super(container, slot, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return container.canPlaceItem(this.getSlotIndex(), stack);
    }
}
