package uk.co.hexeption.rpower.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import uk.co.hexeption.rpower.RPower;
import uk.co.hexeption.rpower.block.machine.AlloyFurnaceBlock;
import uk.co.hexeption.rpower.init.RPBlocks;

public class RPBlockStateProvider extends BlockStateProvider {

    public RPBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RPower.MODID, exFileHelper);
    }

    private void horizontalBlockWithItem(Block block, String name, String side, String front, String top) {
        horizontalBlock(block, models().orientable(
                name,
                modLoc(side),
                modLoc(front),
                modLoc(top)
        ));
        simpleBlockItem(block, models().getBuilder(name));
    }

    private void litHorizontalBlockWithItem(Block block, String name, String side, String front, String frontLit, String top) {
        ModelFile unlitModel = models().orientable(
                name,
                modLoc(side),
                modLoc(front),
                modLoc(top)
        );

        ModelFile litModel = models().orientable(
                name + "_lit",
                modLoc(side),
                modLoc(frontLit),
                modLoc(top)
        );

        getVariantBuilder(block)
                .forAllStates(state -> {
                    boolean lit = state.getValue(AlloyFurnaceBlock.LIT);
                    int yRot = switch (state.getValue(AlloyFurnaceBlock.FACING)) {
                        case NORTH -> 0;
                        case SOUTH -> 180;
                        case WEST -> 270;
                        case EAST -> 90;
                        default -> 0;
                    };

                    return ConfiguredModel.builder()
                            .modelFile(lit ? litModel : unlitModel)
                            .rotationY(yRot)
                            .build();
                });

        simpleBlockItem(block, unlitModel);
    }

    @Override
    protected void registerStatesAndModels() {
        litHorizontalBlockWithItem(
                RPBlocks.ALLOY_FURNACE.get(),
                "alloy_furnace",
                "block/alloy_furnace_side",
                "block/alloy_furnace_front",
                "block/alloy_furnace_front_lit",
                "block/alloy_furnace_top"
        );
    }

}
