package com.kyanite.deeperdarker.registry.blocks.extentions;

import eu.pb4.polymer.api.block.PolymerBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

public class RotatedPillarBlockExtension extends RotatedPillarBlock implements IFakeableBlock {
    public Block fake;
    public RotatedPillarBlockExtension(Properties properties, Block fake) {
        super(properties);
        this.fake = fake;
    }

    @Override
    public Block getPolymerBlock(BlockState state) {
        return fake;
    }
}
