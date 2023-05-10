package com.kyanite.deeperdarker.registry.blocks.custom.vegetation.tendrils;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import com.kyanite.deeperdarker.registry.blocks.extentions.IFakeableBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SculkTendrilsPlantBlock extends GrowingPlantBodyBlock implements IFakeableBlock {
    public static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 16, 12);

    public SculkTendrilsPlantBlock(Properties pProperties) {
        super(pProperties, Direction.UP, SHAPE, false);
    }

    protected GrowingPlantHeadBlock getHeadBlock() {
        return DDBlocks.SCULK_TENDRILS.get();
    }

    public Block fake = Blocks.KELP;
    @Override
    public Block getPolymerBlock(BlockState state) {
        return fake;
    }
}
