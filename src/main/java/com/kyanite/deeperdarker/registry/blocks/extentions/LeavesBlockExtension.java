package com.kyanite.deeperdarker.registry.blocks.extentions;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class LeavesBlockExtension extends LeavesBlock implements IFakeableBlock {
    public Block fake;
    public LeavesBlockExtension(BlockBehaviour.Properties like, Block fake) {
        super(like);
        this.fake = fake;
    }

    @Override
    public Block getPolymerBlock(BlockState state) {
        return fake;
    }
}
