package com.kyanite.deeperdarker.registry.blocks.extentions;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;

public class TrapDoorBlockExtension extends TrapDoorBlock implements IFakeableBlock {
    public Block fake;
    public TrapDoorBlockExtension(Properties properties, Block fake) {
        super(properties);
        this.fake = fake;
    }

    @Override
    public Block getPolymerBlock(BlockState state) {
        return fake;
    }
}
