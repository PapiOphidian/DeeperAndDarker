package com.kyanite.deeperdarker.registry.blocks.extentions;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class FenceBlockExtension extends FenceBlock implements IFakeableBlock {
    public net.minecraft.world.level.block.Block fake;
    public FenceBlockExtension(BlockBehaviour.Properties like, Block fake) {
        super(like);
        this.fake = fake;
    }

    @Override
    public Block getPolymerBlock(BlockState state) {
        return fake;
    }
}
