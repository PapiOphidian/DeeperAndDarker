package com.kyanite.deeperdarker.registry.blocks.extentions;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FenceGateBlockExtension extends FenceGateBlock implements IFakeableBlock {
    public Block fake;

    public FenceGateBlockExtension(Properties properties, Block fake) {
        super(properties);
        this.fake = fake;
    }

    @Override
    public Block getPolymerBlock(BlockState state) {
        return fake;
    }
}
