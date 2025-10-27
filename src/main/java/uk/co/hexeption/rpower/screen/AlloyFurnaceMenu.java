package uk.co.hexeption.rpower.screen;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import uk.co.hexeption.rpower.init.RPMenuTypes;
import uk.co.hexeption.rpower.screen.slot.SlotInput;
import uk.co.hexeption.rpower.screen.slot.SlotOutput;

public class AlloyFurnaceMenu extends AbstractContainerMenu {

    private final Level level;
    private final ContainerData data;
    public final Container inventory;

    public AlloyFurnaceMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, new SimpleContainer(11), new SimpleContainerData(3));
    }

    public AlloyFurnaceMenu(int containerId, Inventory playerInv, Container inventory, ContainerData data) {
        super(RPMenuTypes.ALLOY_FURNACE_MENU.get(), containerId);
        this.level = playerInv.player.level();
        this.data = data;
        this.inventory = inventory;


        addSlot(new SlotInput(inventory, 0, 17, 42));
        addSlot(new SlotOutput(inventory, 1, 141, 35));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                addSlot(new Slot(inventory, i * 3 + j + 2, 48 + j * 18, 17 + i * 18));
            }
        }

        addDataSlots(data);
        addPlayerInventory(playerInv);
        addPlayerHotbar(playerInv);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {

        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(i);

        if (slot != null && slot.hasItem()) {
            ItemStack itemStack2 = slot.getItem();
            itemStack = itemStack2.copy();

            if (i < 11) {
                if (!this.moveItemStackTo(itemStack2, 11, 47, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemStack2, 0, 11, false)) {
                return ItemStack.EMPTY;
            }
        }

        return itemStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return inventory.stillValid(player);
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    @OnlyIn(Dist.CLIENT)
    public float getBurnProgress() {
        if (data.get(2) > 0) {
            return (float) data.get(0) / (float) data.get(2);
        } else {
            return 0;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public float getCookProgress() {
        return (float) data.get(1) / 200;
    }
}
