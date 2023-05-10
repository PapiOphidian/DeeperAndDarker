package com.kyanite.deeperdarker.registry.blocks.extentions;

import eu.pb4.polymer.api.block.PolymerBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public interface IFakeableBlock extends PolymerBlock {
    Block fake = null;

    @Override
    default Block getPolymerBlock(BlockState state) {
        return this.fake;
    }
}
