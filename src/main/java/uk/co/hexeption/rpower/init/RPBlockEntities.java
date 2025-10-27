package uk.co.hexeption.rpower.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.co.hexeption.rpower.Rpower;
import uk.co.hexeption.rpower.block.entity.machine.AlloyFurnaceEntity;

import java.util.function.Supplier;

public class RPBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Rpower.MODID);

    public static final Supplier<BlockEntityType<AlloyFurnaceEntity>> ALLOY_FURNACE_ENTITY = BLOCK_ENTITIES.register("alloy_furnace", () -> BlockEntityType.Builder.of(AlloyFurnaceEntity::new, RPBlocks.ALLOY_FURNACE.get()).build(null));
}
