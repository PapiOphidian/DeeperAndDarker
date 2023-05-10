package com.kyanite.deeperdarker.registry.blocks.extentions;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class PressurePlateBlockExtension extends PressurePlateBlock implements IFakeableBlock {
    public net.minecraft.world.level.block.Block fake;
    public PressurePlateBlockExtension(Sensitivity sensitivity, BlockBehaviour.Properties like, Block fake) {
        super(sensitivity, like);
        this.fake = fake;
    }

    @Override
    public Block getPolymerBlock(BlockState state) {
        return fake;
    }
}
