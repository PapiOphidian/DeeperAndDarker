package com.kyanite.deeperdarker.registry.world.features;

import com.google.common.base.Suppliers;
import com.kyanite.deeperdarker.registry.blocks.DDBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

import java.util.List;
import java.util.function.Supplier;

public class DDTargetLists {
    public static final Supplier<List<OreConfiguration.TargetBlockState>> SCULK_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), Blocks.SCULK.defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ECHO_SAND_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(Blocks.SCULK), DDBlocks.ECHO_SOIL.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> INFESTED_SCULK_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(Blocks.SCULK), DDBlocks.INFESTED_SCULK.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> SCULK_JAW_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(Blocks.SCULK), DDBlocks.SCULK_JAW.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_COAL_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_COAL_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_IRON_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_IRON_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_COPPER_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_COPPER_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_GOLD_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_GOLD_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_REDSTONE_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_REDSTONE_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_EMERALD_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_EMERALD_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_LAPIS_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_LAPIS_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_DIAMOND_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.SCULK_STONE.get()), DDBlocks.SCULK_STONE_DIAMOND_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> GEYSER_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(new BlockMatchTest(DDBlocks.GLOOM_SCULK.get()), DDBlocks.GEYSER.get().defaultBlockState())));
}
