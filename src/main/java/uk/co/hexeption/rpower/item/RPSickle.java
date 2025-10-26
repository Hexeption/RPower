package uk.co.hexeption.rpower.item;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import uk.co.hexeption.rpower.init.RPTags;

public class RPSickle extends DiggerItem {

    private final int leavesHarvestRange = 1;
    private final int cropsHarvestRange = 2;

    public RPSickle(Tier tier, Properties properties) {
        super(tier, RPTags.MINEABLE_WITH_SICKLE, properties);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity miningEntity) {
        if (!(miningEntity instanceof Player player)) {
            return false;
        }

        if (state.is(BlockTags.LEAVES) || state.getBlock() instanceof LeavesBlock) {
            return harvestInRange(stack, level, pos, player, leavesHarvestRange,
                    blockState -> blockState.is(BlockTags.LEAVES) || blockState.getBlock() instanceof LeavesBlock);
        }

        if (state.is(BlockTags.FLOWERS) || state.is(BlockTags.CROPS) || state.getBlock() instanceof BushBlock) {
            return harvestInRange(stack, level, pos, player, cropsHarvestRange,
                    blockState -> blockState.is(BlockTags.FLOWERS) || blockState.is(BlockTags.CROPS) || blockState.getBlock() instanceof BushBlock);
        }

        return false;
    }

    private boolean harvestInRange(ItemStack stack, Level level, BlockPos center, Player player, int range, java.util.function.Predicate<BlockState> predicate) {
        boolean used = false;

        for (int x = -range; x <= range; x++) {
            for (int y = (range == leavesHarvestRange ? -1 : 0); y <= (range == leavesHarvestRange ? 1 : 0); y++) {
                for (int z = -range; z <= range; z++) {
                    BlockPos pos = center.offset(x, y, z);
                    BlockState state = level.getBlockState(pos);
                    if (predicate.test(state)) {
                        level.destroyBlock(pos, true);
                        used = true;
                    }
                }
            }
        }

        if (used) {
            stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
        }

        return used;
    }
}