package com.kyanite.deeperdarker.registry.blocks.extentions;

import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockState;

public class DropExperienceBlockExtension extends DropExperienceBlock implements IFakeableBlock {
    public Block fake;
    public DropExperienceBlockExtension(Properties properties, IntProvider intProvider, Block fake) {
        super(properties, intProvider);
        this.fake = fake;
    }

    public DropExperienceBlockExtension(Properties properties, Block fake) {
        super(properties);
        this.fake = fake;
    }

    @Override
    public Block getPolymerBlock(BlockState state) {
        return fake;
    }
}
