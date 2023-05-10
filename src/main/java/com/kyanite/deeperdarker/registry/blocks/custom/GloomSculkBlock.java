package com.kyanite.deeperdarker.registry.blocks.custom;

import com.kyanite.deeperdarker.registry.blocks.extentions.IFakeableBlock;
import com.kyanite.deeperdarker.registry.world.features.DDConfiguredFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

public class GloomSculkBlock extends SculkBlock implements BonemealableBlock, SculkBehaviour, IFakeableBlock {
    public GloomSculkBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return pLevel.getBlockState(pPos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        DDConfiguredFeatures.GLOOM_SCULK_VEGETATION_COLLECTION.get().place(pLevel, pLevel.getChunkSource().getGenerator(), pRandom, pPos.above());
    }

    public Block fake = Blocks.NETHERRACK;
    @Override
    public Block getPolymerBlock(BlockState state) {
        return fake;
    }
}
