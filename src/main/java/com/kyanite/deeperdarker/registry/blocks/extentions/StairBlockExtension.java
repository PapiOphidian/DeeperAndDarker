package com.kyanite.deeperdarker.registry.blocks.extentions;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class StairBlockExtension extends StairBlock implements IFakeableBlock {
    public net.minecraft.world.level.block.Block fake;
    public StairBlockExtension(BlockState state, BlockBehaviour.Properties like, Block fake) {
        super(state, like);
        this.fake = fake;
    }

    @Override
    public Block getPolymerBlock(BlockState state) {
        return fake;
    }
}
