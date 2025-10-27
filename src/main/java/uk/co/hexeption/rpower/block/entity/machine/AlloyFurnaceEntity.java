package uk.co.hexeption.rpower.block.entity.machine;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import uk.co.hexeption.rpower.Rpower;
import uk.co.hexeption.rpower.block.entity.RPBaseBlockEntity;
import uk.co.hexeption.rpower.block.machine.AlloyFurnaceBlock;
import uk.co.hexeption.rpower.init.RPBlockEntities;
import uk.co.hexeption.rpower.init.RPRecipeTypes;
import uk.co.hexeption.rpower.recipe.AlloyFurnaceRecipe;
import uk.co.hexeption.rpower.screen.AlloyFurnaceMenu;

import java.util.List;

public class AlloyFurnaceEntity extends RPBaseBlockEntity implements MenuProvider, CraftingContainer {

    private int currentBurnTime;
    private int currentCookTime;
    private int totalCookTime;
    private boolean isActive;
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(9, ItemStack.EMPTY);
    private ItemStack fuelInput = ItemStack.EMPTY;
    private ItemStack output = ItemStack.EMPTY;
    private AlloyFurnaceRecipe currentRecipe;
    private boolean updatingRecipe = true;

    private static final int DATA_BURN_TIME = 0;
    private static final int DATA_COOK_TIME = 1;
    private static final int DATA_TOTAL_COOK_TIME = 2;
    private static final int DATA_COUNT = 3;

    protected final ContainerData data = new ContainerData() {
        @Override
        public int get(int index) {
            return switch (index) {
                case DATA_BURN_TIME -> currentBurnTime;
                case DATA_COOK_TIME -> currentCookTime;
                case DATA_TOTAL_COOK_TIME -> totalCookTime;
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case DATA_BURN_TIME -> currentBurnTime = value;
                case DATA_COOK_TIME -> currentCookTime = value;
                case DATA_TOTAL_COOK_TIME -> totalCookTime = value;
            }
        }

        @Override
        public int getCount() {
            return DATA_COUNT;
        }
    };

    public AlloyFurnaceEntity(BlockPos pos, BlockState blockState) {
        super(RPBlockEntities.ALLOY_FURNACE_ENTITY.get(), pos, blockState);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.rpower.alloy_furnace");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new AlloyFurnaceMenu(i, inventory, this, this.data);
    }


    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);

        CompoundTag inventoryTag = new CompoundTag();
        ContainerHelper.saveAllItems(inventoryTag, inventory, registries);
        tag.put("inventory", inventoryTag);

        if (!fuelInput.isEmpty()) {
            tag.put("fuelInput", fuelInput.saveOptional(registries));
        }

        if (!output.isEmpty()) {
            tag.put("output", output.saveOptional(registries));
        }
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);

        ContainerHelper.loadAllItems(tag.getCompound("inventory"), inventory, registries);
        fuelInput = ItemStack.parseOptional(registries, tag.getCompound("fuelInput"));
        output = ItemStack.parseOptional(registries, tag.getCompound("output"));
    }

    @Override
    public void readFromPacketNBT(CompoundTag tag) {
        super.readFromPacketNBT(tag);

        isActive = tag.getBoolean("isActive");
        currentBurnTime = tag.getInt("currentBurnTime");
        currentCookTime = tag.getInt("currentCookTime");
        totalCookTime = tag.getInt("totalCookTime");

    }

    @Override
    public void writeToPacketNBT(CompoundTag tag) {
        super.writeToPacketNBT(tag);

        tag.putBoolean("isActive", isActive);
        tag.putInt("currentBurnTime", currentBurnTime);
        tag.putInt("currentCookTime", currentCookTime);
        tag.putInt("totalCookTime", totalCookTime);
    }

    @Override
    public int getWidth() {
        return 3;
    }

    @Override
    public int getHeight() {
        return 3;
    }

    @Override
    public List<ItemStack> getItems() {
        return inventory;
    }

    private static final int INVENTORY_SIZE = 9;
    private static final int FUEL_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    private static final int TOTAL_SLOTS = INVENTORY_SIZE + 2;

    @Override
    public int getContainerSize() {
        return TOTAL_SLOTS;
    }

    @Override
    public boolean isEmpty() {
        return inventory.isEmpty();
    }

    @Override
    public ItemStack getItem(int slot) {
        updatingRecipe = true;
        if (slot == FUEL_SLOT) {
            return fuelInput;
        } else if (slot == OUTPUT_SLOT) {
            return output;
        } else if (slot < TOTAL_SLOTS) {
            return inventory.get(slot - 2);
        }
        return ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeItem(int i, int i1) {
        ItemStack itemStack = getItem(i);
        if (!itemStack.isEmpty()) {
            if (itemStack.getCount() <= i1) {
                setItem(i, ItemStack.EMPTY);
            } else {
                itemStack = itemStack.split(i1);
                if (itemStack.getCount() == 0) {
                    setItem(i, ItemStack.EMPTY);
                }
            }
        }
        return itemStack;
    }

    @Override
    public ItemStack removeItemNoUpdate(int i) {
        return getItem(i);
    }

    @Override
    public void setItem(int slot, ItemStack itemStack) {
        if (slot == FUEL_SLOT) {
            fuelInput = itemStack;
        } else if (slot == OUTPUT_SLOT) {
            output = itemStack;
        } else if (slot < TOTAL_SLOTS) {
            inventory.set(slot - 2, itemStack);
        }

        updatingRecipe = true;
    }

    @Override
    public boolean stillValid(Player player) {
        return player.blockPosition().closerThan(this.worldPosition, 4.5D);
    }

    @Override
    public void clearContent() {

    }

    @Override
    public void fillStackedContents(StackedContents stackedContents) {

    }

    @Override
    public boolean canPlaceItem(int slot, ItemStack stack) {
        if (slot == FUEL_SLOT) {
            return FurnaceBlockEntity.isFuel(stack);
        } else if (slot == OUTPUT_SLOT) {
            return false;
        }
        return true;
    }


    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, BlockEntity blockEntity) {
        AlloyFurnaceEntity furnace = (AlloyFurnaceEntity) blockEntity;
        if (level.isClientSide) return;

        furnace.setActive(furnace.currentBurnTime > 0);
        if (furnace.isActive) {
            furnace.currentBurnTime--;
        }

        if (furnace.updatingRecipe) {
            updateCurrentRecipe(level, furnace);
            furnace.updatingRecipe = false;
        }

        if (furnace.currentRecipe != null) {
            // Verify the recipe is still valid with current inventory
            var recipeStillValid = level.getRecipeManager()
                    .getRecipeFor(RPRecipeTypes.ALLOY_SMELTING.get(), furnace.asCraftInput(), level)
                    .isPresent();

            if (!recipeStillValid) {
                furnace.currentRecipe = null;
                furnace.currentCookTime = 0;
                return;
            }

            if (furnace.currentBurnTime <= 0) {
                tryConsumeFuel(furnace);
            }

            if (++furnace.currentCookTime >= 200) {
                craftResult(level, furnace);
                furnace.currentCookTime = 0;
            }
        } else {
            furnace.currentCookTime = 0;
        }
    }

    private static void updateCurrentRecipe(Level level, AlloyFurnaceEntity furnace) {
        var recipeOptional = level.getRecipeManager().getRecipeFor(RPRecipeTypes.ALLOY_SMELTING.get(), furnace.asCraftInput(), level);
        if (recipeOptional.isPresent()) {
            var recipe = recipeOptional.get().value();
            var resultItem = recipe.getResultItem(level.registryAccess());

            if (canAcceptResult(furnace.output, resultItem)) {
                furnace.currentRecipe = recipe;
            } else {
                furnace.currentRecipe = null;
            }
        } else {
            furnace.currentRecipe = null;
        }
    }

    private static boolean canAcceptResult(ItemStack output, ItemStack result) {
        return output.isEmpty() || (
                output.getItem() == result.getItem() &&
                        output.getCount() + result.getCount() <= output.getMaxStackSize()
        );
    }

    private static void tryConsumeFuel(AlloyFurnaceEntity furnace) {
        if (!FurnaceBlockEntity.getFuel().containsKey(furnace.fuelInput.getItem())) {
            furnace.currentCookTime = 0;
            return;
        }

        furnace.currentBurnTime = furnace.totalCookTime = FurnaceBlockEntity.getFuel().get(furnace.fuelInput.getItem());

        if (!furnace.fuelInput.isEmpty()) {
            furnace.fuelInput.shrink(1);
            if (furnace.fuelInput.isEmpty()) {
                furnace.fuelInput = furnace.fuelInput.getItem().getCraftingRemainingItem(furnace.fuelInput);
            }
        }
    }

    private static void craftResult(Level level, AlloyFurnaceEntity furnace) {
        ItemStack result = furnace.currentRecipe.assemble(furnace.asCraftInput(), level.registryAccess());
        if (furnace.output.isEmpty()) {
            furnace.output = result.copy();
        } else {
            furnace.output.grow(result.getCount());
        }
        furnace.currentRecipe.useItems(furnace.asCraftInput());
        furnace.updatingRecipe = true;
    }

    private void setActive(boolean active) {
        if (active != isActive) {
            isActive = active;
            if (level != null) {
                BlockState state = level.getBlockState(worldPosition);
                level.setBlock(worldPosition, state.setValue(AlloyFurnaceBlock.LIT, active), 3);
            }
            setChanged();
        }
    }
}
