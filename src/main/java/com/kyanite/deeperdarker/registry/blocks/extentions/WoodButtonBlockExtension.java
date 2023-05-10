package com.kyanite.deeperdarker.registry.blocks.extentions;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class WoodButtonBlockExtension extends WoodButtonBlock implements IFakeableBlock {
    public net.minecraft.world.level.block.Block fake;
    public WoodButtonBlockExtension(BlockBehaviour.Properties like, Block fake) {
        super(like);
        this.fake = fake;
    }

    @Override
    public Block getPolymerBlock(BlockState state) {
        return fake;
    }
}
