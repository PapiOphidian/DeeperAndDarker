package com.kyanite.deeperdarker.registry.blocks.custom.vegetation.vines;

import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import eu.pb4.polymer.api.block.PolymerBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SculkVinesPlantBlock extends GrowingPlantBodyBlock implements PolymerBlock {
    public static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public SculkVinesPlantBlock(Properties pProperties) {
        super(pProperties, Direction.DOWN, SHAPE, false);
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) DDBlocks.SCULK_VINES.get();
    }

    @Override
    public Block getPolymerBlock(BlockState state) {
        return Blocks.VINE;
    }
}