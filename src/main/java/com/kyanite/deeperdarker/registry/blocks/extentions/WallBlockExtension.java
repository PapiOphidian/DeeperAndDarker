package com.kyanite.deeperdarker.registry.blocks.extentions;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;

public class WallBlockExtension extends WallBlock implements IFakeableBlock {
    public Block fake;
    public WallBlockExtension(Properties properties, Block fake) {
        super(properties);
        this.fake = fake;
    }

    @Override
    public Block getPolymerBlock(BlockState state) {
        return fake;
    }
}
