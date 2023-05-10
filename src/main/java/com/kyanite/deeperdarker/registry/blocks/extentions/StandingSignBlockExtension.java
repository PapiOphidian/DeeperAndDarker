package com.kyanite.deeperdarker.registry.blocks.extentions;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class StandingSignBlockExtension extends StandingSignBlock implements IFakeableBlock {
    public Block fake;
    public StandingSignBlockExtension(Properties properties, WoodType woodType, Block fake) {
        super(properties, woodType);
        this.fake = fake;
    }

    @Override
    public Block getPolymerBlock(BlockState state) {
        return fake;
    }
}
