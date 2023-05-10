package com.kyanite.deeperdarker.registry.blocks;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.DDCreativeModeTab;
import com.kyanite.deeperdarker.miscellaneous.DDWoodTypes;
import com.kyanite.deeperdarker.platform.PortalHelper;
import com.kyanite.deeperdarker.platform.RegistryHelper;
import com.kyanite.deeperdarker.registry.blocks.custom.*;
import com.kyanite.deeperdarker.registry.blocks.custom.vegetation.GloomCactusBlock;
import com.kyanite.deeperdarker.registry.blocks.custom.vegetation.GloomGrassBlock;
import com.kyanite.deeperdarker.registry.blocks.custom.vegetation.tendrils.SculkTendrilsBlock;
import com.kyanite.deeperdarker.registry.blocks.custom.vegetation.tendrils.SculkTendrilsPlantBlock;
import com.kyanite.deeperdarker.registry.blocks.custom.vegetation.vines.SculkVinesBlock;
import com.kyanite.deeperdarker.registry.blocks.custom.vegetation.vines.SculkVinesPlantBlock;
import com.kyanite.deeperdarker.registry.blocks.extentions.*;
import com.kyanite.deeperdarker.registry.sounds.DDSounds;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DDBlocks {
    public static final Map<String, Supplier<Block>> BLOCKS = new HashMap<>();

    // Echo Wood
    public static final Supplier<Block> ECHO_PLANKS = registerBlock("echo_planks", true, () -> new BlockExtension(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), Blocks.BIRCH_PLANKS));
    public static final Supplier<RotatedPillarBlock> ECHO_LOG = registerBlock("echo_log", true, () -> log(MaterialColor.WOOD, MaterialColor.PODZOL, Blocks.BIRCH_LOG));
    public static final Supplier<RotatedPillarBlock> STRIPPED_ECHO_LOG = registerBlock("stripped_echo_log", true, () -> log(MaterialColor.WOOD, MaterialColor.PODZOL, Blocks.STRIPPED_BIRCH_LOG));
    public static final Supplier<RotatedPillarBlock> STRIPPED_ECHO_WOOD = registerBlock("stripped_echo_wood", true, () -> log(MaterialColor.WOOD, MaterialColor.PODZOL, Blocks.STRIPPED_BIRCH_WOOD));
    public static final Supplier<RotatedPillarBlock> ECHO_WOOD = registerBlock("echo_wood", true, () -> log(MaterialColor.WOOD, MaterialColor.PODZOL, Blocks.BIRCH_WOOD));
    public static final Supplier<Block> ECHO_LEAVES = registerBlock("echo_leaves", true, () -> new LeavesBlockExtension(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), Blocks.FLOWERING_AZALEA_LEAVES) {
        protected boolean decaying(@NotNull BlockState state) {
            return state.getValue(DISTANCE) == 16;
        }
    });
    public static final Supplier<SlabBlock> ECHO_SLAB = registerBlock("echo_slab", true, () -> new SlabBlockExtension(BlockBehaviour.Properties.copy(ECHO_PLANKS.get()), Blocks.BIRCH_SLAB));
    public static final Supplier<FenceBlock> ECHO_FENCE = registerBlock("echo_fence", true, () -> new FenceBlockExtension(BlockBehaviour.Properties.copy(ECHO_PLANKS.get()), Blocks.BIRCH_FENCE));
    public static final Supplier<StairBlock> ECHO_STAIRS = registerBlock("echo_stairs", true, () -> new StairBlockExtension(ECHO_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(ECHO_PLANKS.get()), Blocks.BIRCH_STAIRS));
    public static final Supplier<ButtonBlock> ECHO_BUTTON = registerBlock("echo_button", true, () -> new WoodButtonBlockExtension(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), Blocks.BIRCH_BUTTON));
    public static final Supplier<PressurePlateBlock> ECHO_PRESSURE_PLATE = registerBlock("echo_pressure_plate", true, () -> new PressurePlateBlockExtension(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), Blocks.BIRCH_PRESSURE_PLATE));
    public static final Supplier<DoorBlock> ECHO_DOOR = registerBlock("echo_door", true, () -> new DoorBlockExtension(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), Blocks.BIRCH_DOOR));
    public static final Supplier<TrapDoorBlock> ECHO_TRAPDOOR = registerBlock("echo_trapdoor", true, () -> new TrapDoorBlockExtension(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), Blocks.BIRCH_TRAPDOOR));
    public static final Supplier<FenceGateBlock> ECHO_FENCE_GATE = registerBlock("echo_fence_gate", true, () -> new FenceGateBlockExtension(BlockBehaviour.Properties.copy(ECHO_PLANKS.get()), Blocks.BIRCH_FENCE_GATE));
    public static final Supplier<WallSignBlock> ECHO_WALL_SIGN = registerBlock("echo_wall_sign", false, () -> new WallSignBlockExtension(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), DDWoodTypes.ECHO, Blocks.BIRCH_WALL_SIGN));
    public static final Supplier<StandingSignBlock> ECHO_SIGN = registerSign("echo_sign", () -> new StandingSignBlockExtension(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), DDWoodTypes.ECHO, Blocks.BIRCH_SIGN), ECHO_WALL_SIGN);
    public static final Supplier<Block> INFESTED_SCULK = registerBlock("infested_sculk", true, () -> new InfestedSculkBlock(BlockBehaviour.Properties.copy(Blocks.SCULK)));
    public static final Supplier<SculkJawBlock> SCULK_JAW = registerBlock("sculk_jaw", true, () -> new SculkJawBlock(BlockBehaviour.Properties.of(Material.SCULK).sound(DDSounds.SCULK_JAW).strength(6f)));

    // Echo Soil/Sculk Grime
    public static final Supplier<Block> ECHO_SOIL = registerBlock("echo_soil", true, () -> new BlockExtension(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.3f), Blocks.SCULK));
    public static final Supplier<Block> SCULK_GRIME = registerBlock("sculk_grime", true, () -> new BlockExtension(BlockBehaviour.Properties.copy(Blocks.SCULK).strength(0.6f), Blocks.DARK_PRISMARINE));
    public static final Supplier<Block> GRIME_BRICKS = registerBlock("sculk_grime_bricks", true, () -> new BlockExtension(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).color(MaterialColor.COLOR_BLACK).sound(DDSounds.SCULK_STONE), Blocks.PRISMARINE_BRICKS));
    public static final Supplier<SlabBlock> GRIME_BRICK_SLAB = registerBlock("sculk_grime_brick_slab", true, () -> new SlabBlockExtension(BlockBehaviour.Properties.copy(DDBlocks.GRIME_BRICKS.get()), Blocks.PRISMARINE_BRICK_SLAB));
    public static final Supplier<StairBlock> GRIME_BRICK_STAIRS = registerBlock("sculk_grime_brick_stairs", true, () -> new StairBlockExtension(GRIME_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(DDBlocks.GRIME_BRICKS.get()), Blocks.PRISMARINE_BRICK_STAIRS));
    public static final Supplier<WallBlock> GRIME_BRICK_WALL = registerBlock("sculk_grime_brick_wall", true, () -> new WallBlockExtension(BlockBehaviour.Properties.copy(DDBlocks.GRIME_BRICKS.get()), Blocks.BRICK_WALL));

    // Sculk Stone
    public static final Supplier<Block> SCULK_STONE = registerBlock("sculk_stone", true, () -> new BlockExtension(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops(), Blocks.DEEPSLATE));
    public static final Supplier<SlabBlock> SCULK_STONE_SLAB = registerBlock("sculk_stone_slab", true, () -> new SlabBlockExtension(BlockBehaviour.Properties.copy(SCULK_STONE.get()), Blocks.DEEPSLATE_BRICK_SLAB));
    public static final Supplier<StairBlock> SCULK_STONE_STAIRS = registerBlock("sculk_stone_stairs", true, () -> new StairBlockExtension(SCULK_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_STONE.get()), Blocks.DEEPSLATE_BRICK_STAIRS));
    public static final Supplier<WallBlock> SCULK_STONE_WALL = registerBlock("sculk_stone_wall", true, () -> new WallBlockExtension(BlockBehaviour.Properties.copy(SCULK_STONE.get()), Blocks.DEEPSLATE_BRICK_WALL));

    public static final Supplier<Block> COBBLED_SCULK_STONE = registerBlock("cobbled_sculk_stone", true, () -> new BlockExtension(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops(), Blocks.COBBLED_DEEPSLATE));
    public static final Supplier<SlabBlock> COBBLED_SCULK_STONE_SLAB = registerBlock("cobbled_sculk_stone_slab", true, () -> new SlabBlockExtension(BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE.get()), Blocks.COBBLED_DEEPSLATE_SLAB));
    public static final Supplier<StairBlock> COBBLED_SCULK_STONE_STAIRS = registerBlock("cobbled_sculk_stone_stairs", true, () -> new StairBlockExtension(COBBLED_SCULK_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE.get()), Blocks.COBBLED_DEEPSLATE_STAIRS));
    public static final Supplier<WallBlock> COBBLED_SCULK_STONE_WALL = registerBlock("cobbled_sculk_stone_wall", true, () -> new WallBlockExtension(BlockBehaviour.Properties.copy(COBBLED_SCULK_STONE.get()), Blocks.COBBLED_DEEPSLATE_WALL));

    public static final Supplier<Block> POLISHED_SCULK_STONE = registerBlock("polished_sculk_stone", true, () -> new BlockExtension(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops(), Blocks.POLISHED_DEEPSLATE));
    public static final Supplier<SlabBlock> POLISHED_SCULK_STONE_SLAB = registerBlock("polished_sculk_stone_slab", true, () -> new SlabBlockExtension(BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE.get()), Blocks.POLISHED_DEEPSLATE_SLAB));
    public static final Supplier<StairBlock> POLISHED_SCULK_STONE_STAIRS = registerBlock("polished_sculk_stone_stairs", true, () -> new StairBlockExtension(POLISHED_SCULK_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE.get()), Blocks.POLISHED_DEEPSLATE_STAIRS));
    public static final Supplier<WallBlock> POLISHED_SCULK_STONE_WALL = registerBlock("polished_sculk_stone_wall", true, () -> new WallBlockExtension(BlockBehaviour.Properties.copy(POLISHED_SCULK_STONE.get()), Blocks.POLISHED_DEEPSLATE_WALL));

    public static final Supplier<Block> SCULK_STONE_BRICKS = registerBlock("sculk_stone_bricks", true, () -> new BlockExtension(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops(), Blocks.DEEPSLATE_BRICKS));
    public static final Supplier<SlabBlock> SCULK_STONE_BRICK_SLAB = registerBlock("sculk_stone_brick_slab", true, () -> new SlabBlockExtension(BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS.get()), Blocks.DEEPSLATE_BRICK_SLAB));
    public static final Supplier<StairBlock> SCULK_STONE_BRICK_STAIRS = registerBlock("sculk_stone_brick_stairs", true, () -> new StairBlockExtension(SCULK_STONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS.get()), Blocks.DEEPSLATE_BRICK_STAIRS));
    public static final Supplier<WallBlock> SCULK_STONE_BRICK_WALL = registerBlock("sculk_stone_brick_wall", true, () -> new WallBlockExtension(BlockBehaviour.Properties.copy(SCULK_STONE_BRICKS.get()), Blocks.DEEPSLATE_BRICK_WALL));

    public static final Supplier<Block> SCULK_STONE_TILES = registerBlock("sculk_stone_tiles", true, () -> new BlockExtension(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops(), Blocks.DEEPSLATE_TILES));
    public static final Supplier<SlabBlock> SCULK_STONE_TILE_SLAB = registerBlock("sculk_stone_tile_slab", true, () -> new SlabBlockExtension(BlockBehaviour.Properties.copy(SCULK_STONE_TILES.get()), Blocks.DEEPSLATE_TILE_SLAB));
    public static final Supplier<StairBlock> SCULK_STONE_TILE_STAIRS = registerBlock("sculk_stone_tile_stairs", true, () -> new StairBlockExtension(SCULK_STONE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(SCULK_STONE_TILES.get()), Blocks.DEEPSLATE_TILE_STAIRS));
    public static final Supplier<WallBlock> SCULK_STONE_TILE_WALL = registerBlock("sculk_stone_tile_wall", true, () -> new WallBlockExtension(BlockBehaviour.Properties.copy(SCULK_STONE_TILES.get()), Blocks.DEEPSLATE_TILE_WALL));

    public static final Supplier<Block> SMOOTH_SCULK_STONE = registerBlock("smooth_sculk_stone", true, () -> new BlockExtension(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops(), Blocks.SMOOTH_STONE));
    public static final Supplier<SlabBlock> SMOOTH_SCULK_STONE_SLAB = registerBlock("smooth_sculk_stone_slab", true, () -> new SlabBlockExtension(BlockBehaviour.Properties.copy(SMOOTH_SCULK_STONE.get()), Blocks.SMOOTH_STONE_SLAB));
    public static final Supplier<StairBlock> SMOOTH_SCULK_STONE_STAIRS = registerBlock("smooth_sculk_stone_stairs", true, () -> new StairBlockExtension(SMOOTH_SCULK_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(SMOOTH_SCULK_STONE.get()), Blocks.STONE_STAIRS));
    public static final Supplier<WallBlock> SMOOTH_SCULK_STONE_WALL = registerBlock("smooth_sculk_stone_wall", true, () -> new WallBlockExtension(BlockBehaviour.Properties.copy(SMOOTH_SCULK_STONE.get()), Blocks.POLISHED_DEEPSLATE_WALL));

    public static final Supplier<Block> CUT_SCULK_STONE = registerBlock("cut_sculk_stone", true, () -> new BlockExtension(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops(), Blocks.DEEPSLATE));
    public static final Supplier<SlabBlock> CUT_SCULK_STONE_SLAB = registerBlock("cut_sculk_stone_slab", true, () -> new SlabBlockExtension(BlockBehaviour.Properties.copy(CUT_SCULK_STONE.get()), Blocks.POLISHED_DEEPSLATE_SLAB));
    public static final Supplier<StairBlock> CUT_SCULK_STONE_STAIRS = registerBlock("cut_sculk_stone_stairs", true, () -> new StairBlockExtension(CUT_SCULK_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CUT_SCULK_STONE.get()), Blocks.POLISHED_DEEPSLATE_STAIRS));
    public static final Supplier<WallBlock> CUT_SCULK_STONE_WALL = registerBlock("cut_sculk_stone_wall", true, () -> new WallBlockExtension(BlockBehaviour.Properties.copy(CUT_SCULK_STONE.get()), Blocks.DEEPSLATE_BRICK_WALL));

    public static final Supplier<Block> CHISELED_SCULK_STONE = registerBlock("chiseled_sculk_stone", true, () -> new BlockExtension(BlockBehaviour.Properties.copy(Blocks.STONE).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops(), Blocks.CHISELED_DEEPSLATE));

    // Sculk Stone Ores
    public static final Supplier<Block> SCULK_STONE_COAL_ORE = registerBlock("sculk_stone_coal_ore", true, () -> new DropExperienceBlockExtension(BlockBehaviour.Properties.copy(DDBlocks.SCULK_STONE.get()), UniformInt.of(2, 4), Blocks.DEEPSLATE_COAL_ORE));
    public static final Supplier<Block> SCULK_STONE_IRON_ORE = registerBlock("sculk_stone_iron_ore", true, () -> new DropExperienceBlockExtension(BlockBehaviour.Properties.copy(DDBlocks.SCULK_STONE.get()), UniformInt.of(2, 4), Blocks.DEEPSLATE_IRON_ORE));
    public static final Supplier<Block> SCULK_STONE_COPPER_ORE = registerBlock("sculk_stone_copper_ore", true, () -> new DropExperienceBlockExtension(BlockBehaviour.Properties.copy(DDBlocks.SCULK_STONE.get()), UniformInt.of(2, 4), Blocks.DEEPSLATE_COPPER_ORE));
    public static final Supplier<Block> SCULK_STONE_GOLD_ORE = registerBlock("sculk_stone_gold_ore", true, () -> new DropExperienceBlockExtension(BlockBehaviour.Properties.copy(DDBlocks.SCULK_STONE.get()), UniformInt.of(2, 4), Blocks.DEEPSLATE_GOLD_ORE));
    public static final Supplier<Block> SCULK_STONE_REDSTONE_ORE = registerBlock("sculk_stone_redstone_ore", true, () -> new RedstoneOreBlockExtension(BlockBehaviour.Properties.copy(DDBlocks.SCULK_STONE.get()).randomTicks().lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 9 : 0), Blocks.DEEPSLATE_REDSTONE_ORE));
    public static final Supplier<Block> SCULK_STONE_EMERALD_ORE = registerBlock("sculk_stone_emerald_ore", true, () -> new DropExperienceBlockExtension(BlockBehaviour.Properties.copy(DDBlocks.SCULK_STONE.get()), UniformInt.of(6, 14), Blocks.DEEPSLATE_EMERALD_ORE));
    public static final Supplier<Block> SCULK_STONE_LAPIS_ORE = registerBlock("sculk_stone_lapis_ore", true, () -> new DropExperienceBlockExtension(BlockBehaviour.Properties.copy(DDBlocks.SCULK_STONE.get()), UniformInt.of(4, 10), Blocks.DEEPSLATE_LAPIS_ORE));
    public static final Supplier<Block> SCULK_STONE_DIAMOND_ORE = registerBlock("sculk_stone_diamond_ore", true, () -> new DropExperienceBlockExtension(BlockBehaviour.Properties.copy(DDBlocks.SCULK_STONE.get()), UniformInt.of(6, 14), Blocks.DEEPSLATE_DIAMOND_ORE));

    // Vegetation
    public static final Supplier<Block> SCULK_VINES = registerBlock("sculk_vines", true, () -> new SculkVinesBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SCULK).noCollission().instabreak().randomTicks()));
    public static final Supplier<Block> SCULK_VINES_PLANT = registerBlock("sculk_vines_plant", false, () -> new SculkVinesPlantBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SCULK).noCollission().instabreak()));
    public static final Supplier<SculkTendrilsBlock> SCULK_TENDRILS = registerBlock("sculk_tendrils", true, () -> new SculkTendrilsBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SCULK).randomTicks().noOcclusion().noCollission().instabreak()));
    public static final Supplier<SculkTendrilsPlantBlock> SCULK_TENDRILS_PLANT = registerBlock("sculk_tendrils_plant", false, () -> new SculkTendrilsPlantBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak()));
    public static final Supplier<Block> SCULK_GLEAM = registerBlock("sculk_gleam", true, () -> new DropExperienceBlockExtension(BlockBehaviour.Properties.copy(Blocks.SCULK).lightLevel(state -> 15), Blocks.GLOWSTONE));

    // Overcast Columns
    public static final Supplier<GloomSculkBlock> GLOOM_SCULK = registerBlock("gloom_sculk", true, () -> new GloomSculkBlock(BlockBehaviour.Properties.copy(Blocks.SCULK)));
    public static final Supplier<GeyserBlock> GEYSER = registerBlock("geyser", true, () -> new GeyserBlock(BlockBehaviour.Properties.copy(Blocks.SCULK).lightLevel(state -> 9).requiresCorrectToolForDrops()));
    public static final Supplier<Block> CRYSTALLIZED_AMBER = registerBlock("crystallized_amber", true, () -> new HalfTransparentBlockExtension(BlockBehaviour.Properties.of(Material.GLASS).noOcclusion().lightLevel(state -> 1).sound(SoundType.GLASS), Blocks.SHROOMLIGHT));
    public static final Supplier<Block> GLOOM_CACTUS = registerBlock("gloom_cactus", true, () -> new GloomCactusBlock(BlockBehaviour.Properties.of(Material.CACTUS).strength(0.5f).lightLevel(state -> 6).sound(SoundType.WOOL)));
    public static final Supplier<Block> GLOOMY_GRASS = registerBlock("gloomy_grass", true, () -> new GloomGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).lightLevel(state -> 1)));

    // Gloomslate
    public static final Supplier<Block> GLOOMSLATE = registerBlock("gloomslate", true, () -> new BlockExtension(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2.5f, 4.5f).sound(DDSounds.SCULK_STONE).requiresCorrectToolForDrops(), Blocks.DEEPSLATE));
    public static final Supplier<SlabBlock> GLOOMSLATE_SLAB = registerBlock("gloomslate_slab", true, () -> new SlabBlockExtension(BlockBehaviour.Properties.copy(GLOOMSLATE.get()), Blocks.POLISHED_DEEPSLATE_SLAB));
    public static final Supplier<StairBlock> GLOOMSLATE_STAIRS = registerBlock("gloomslate_stairs", true, () -> new StairBlockExtension(GLOOMSLATE.get().defaultBlockState(), BlockBehaviour.Properties.copy(GLOOMSLATE.get()), Blocks.POLISHED_DEEPSLATE_STAIRS));
    public static final Supplier<WallBlock> GLOOMSLATE_WALL = registerBlock("gloomslate_wall", true, () -> new WallBlockExtension(BlockBehaviour.Properties.copy(GLOOMSLATE.get()), Blocks.POLISHED_DEEPSLATE_WALL));

    public static final Supplier<Block> COBBLED_GLOOMSLATE = registerBlock("cobbled_gloomslate", true, () -> new BlockExtension(BlockBehaviour.Properties.copy(GLOOMSLATE.get()), Blocks.COBBLED_DEEPSLATE));
    public static final Supplier<SlabBlock> COBBLED_GLOOMSLATE_SLAB = registerBlock("cobbled_gloomslate_slab", true, () -> new SlabBlockExtension(BlockBehaviour.Properties.copy(COBBLED_GLOOMSLATE.get()), Blocks.COBBLED_DEEPSLATE_SLAB));
    public static final Supplier<StairBlock> COBBLED_GLOOMSLATE_STAIRS = registerBlock("cobbled_gloomslate_stairs", true, () -> new StairBlockExtension(COBBLED_GLOOMSLATE.get().defaultBlockState(), BlockBehaviour.Properties.copy(COBBLED_GLOOMSLATE.get()), Blocks.COBBLED_DEEPSLATE_STAIRS));
    public static final Supplier<WallBlock> COBBLED_GLOOMSLATE_WALL = registerBlock("cobbled_gloomslate_wall", true, () -> new WallBlockExtension(BlockBehaviour.Properties.copy(COBBLED_GLOOMSLATE.get()), Blocks.COBBLED_DEEPSLATE_WALL));

    public static final Supplier<Block> POLISHED_GLOOMSLATE = registerBlock("polished_gloomslate", true, () -> new BlockExtension(BlockBehaviour.Properties.copy(GLOOMSLATE.get()), Blocks.POLISHED_DEEPSLATE));
    public static final Supplier<SlabBlock> POLISHED_GLOOMSLATE_SLAB = registerBlock("polished_gloomslate_slab", true, () -> new SlabBlockExtension(BlockBehaviour.Properties.copy(POLISHED_GLOOMSLATE.get()), Blocks.POLISHED_DEEPSLATE_SLAB));
    public static final Supplier<StairBlock> POLISHED_GLOOMSLATE_STAIRS = registerBlock("polished_gloomslate_stairs", true, () -> new StairBlockExtension(POLISHED_GLOOMSLATE.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_GLOOMSLATE.get()), Blocks.POLISHED_DEEPSLATE_STAIRS));
    public static final Supplier<WallBlock> POLISHED_GLOOMSLATE_WALL = registerBlock("polished_gloomslate_wall", true, () -> new WallBlockExtension(BlockBehaviour.Properties.copy(POLISHED_GLOOMSLATE.get()), Blocks.POLISHED_DEEPSLATE_WALL));

    public static final Supplier<Block> GLOOMSLATE_BRICKS = registerBlock("gloomslate_bricks", true, () -> new BlockExtension(BlockBehaviour.Properties.copy(GLOOMSLATE.get()), Blocks.DEEPSLATE_BRICKS));
    public static final Supplier<SlabBlock> GLOOMSLATE_BRICK_SLAB = registerBlock("gloomslate_brick_slab", true, () -> new SlabBlockExtension(BlockBehaviour.Properties.copy(GLOOMSLATE_BRICKS.get()), Blocks.DEEPSLATE_BRICK_SLAB));
    public static final Supplier<StairBlock> GLOOMSLATE_BRICK_STAIRS = registerBlock("gloomslate_brick_stairs", true, () -> new StairBlockExtension(GLOOMSLATE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(GLOOMSLATE_BRICKS.get()), Blocks.DEEPSLATE_BRICK_STAIRS));
    public static final Supplier<WallBlock> GLOOMSLATE_BRICK_WALL = registerBlock("gloomslate_brick_wall", true, () -> new WallBlockExtension(BlockBehaviour.Properties.copy(GLOOMSLATE_BRICKS.get()), Blocks.DEEPSLATE_BRICK_WALL));

    public static final Supplier<Block> GLOOMSLATE_TILES = registerBlock("gloomslate_tiles", true, () -> new BlockExtension(BlockBehaviour.Properties.copy(GLOOMSLATE.get()), Blocks.DEEPSLATE_TILES));
    public static final Supplier<SlabBlock> GLOOMSLATE_TILE_SLAB = registerBlock("gloomslate_tile_slab", true, () -> new SlabBlockExtension(BlockBehaviour.Properties.copy(GLOOMSLATE_TILES.get()), Blocks.DEEPSLATE_TILE_SLAB));
    public static final Supplier<StairBlock> GLOOMSLATE_TILE_STAIRS = registerBlock("gloomslate_tile_stairs", true, () -> new StairBlockExtension(GLOOMSLATE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(GLOOMSLATE_TILES.get()), Blocks.DEEPSLATE_TILE_STAIRS));
    public static final Supplier<WallBlock> GLOOMSLATE_TILE_WALL = registerBlock("gloomslate_tile_wall", true, () -> new WallBlockExtension(BlockBehaviour.Properties.copy(GLOOMSLATE_TILES.get()), Blocks.DEEPSLATE_TILE_WALL));

    public static final Supplier<Block> SMOOTH_GLOOMSLATE = registerBlock("smooth_gloomslate", true, () -> new BlockExtension(BlockBehaviour.Properties.copy(GLOOMSLATE.get()), Blocks.SMOOTH_STONE));
    public static final Supplier<SlabBlock> SMOOTH_GLOOMSLATE_SLAB = registerBlock("smooth_gloomslate_slab", true, () -> new SlabBlockExtension(BlockBehaviour.Properties.copy(SMOOTH_GLOOMSLATE.get()), Blocks.SMOOTH_STONE_SLAB));
    public static final Supplier<StairBlock> SMOOTH_GLOOMSLATE_STAIRS = registerBlock("smooth_gloomslate_stairs", true, () -> new StairBlockExtension(SMOOTH_GLOOMSLATE.get().defaultBlockState(), BlockBehaviour.Properties.copy(SMOOTH_GLOOMSLATE.get()), Blocks.SMOOTH_QUARTZ_STAIRS));
    public static final Supplier<WallBlock> SMOOTH_GLOOMSLATE_WALL = registerBlock("smooth_gloomslate_wall", true, () -> new WallBlockExtension(BlockBehaviour.Properties.copy(SMOOTH_GLOOMSLATE.get()), Blocks.ANDESITE_WALL));

    public static final Supplier<Block> CUT_GLOOMSLATE = registerBlock("cut_gloomslate", true, () -> new BlockExtension(BlockBehaviour.Properties.copy(GLOOMSLATE.get()), Blocks.STONE));
    public static final Supplier<SlabBlock> CUT_GLOOMSLATE_SLAB = registerBlock("cut_gloomslate_slab", true, () -> new SlabBlockExtension(BlockBehaviour.Properties.copy(CUT_GLOOMSLATE.get()), Blocks.STONE_SLAB));
    public static final Supplier<StairBlock> CUT_GLOOMSLATE_STAIRS = registerBlock("cut_gloomslate_stairs", true, () -> new StairBlockExtension(CUT_GLOOMSLATE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CUT_GLOOMSLATE.get()), Blocks.STONE_STAIRS));
    public static final Supplier<WallBlock> CUT_GLOOMSLATE_WALL = registerBlock("cut_gloomslate_wall", true, () -> new WallBlockExtension(BlockBehaviour.Properties.copy(CUT_GLOOMSLATE.get()), Blocks.STONE_BRICK_WALL));

    public static final Supplier<Block> CHISELED_GLOOMSLATE = registerBlock("chiseled_gloomslate", true, () -> new BlockExtension(BlockBehaviour.Properties.copy(GLOOMSLATE.get()), Blocks.CHISELED_DEEPSLATE));

    // Miscellaneous
    public static final Supplier<Block> ANCIENT_VASE = registerBlock("ancient_vase", true, () -> new AncientVaseBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(2f, 6f).sound(DDSounds.VASE).noOcclusion()));
    public static final Supplier<Block> OTHERSIDE_PORTAL = registerBlock("otherside_portal", false, PortalHelper.getPortalBlock());
    //   public static final Supplier<Block> ANCIENT_CHEST = registerBlock("ancient_chest", false, () -> new AncientChestBlock(BlockBehaviour.Properties.of(Material.STONE)
      //      .strength(6.2f).sound(SoundType.DEEPSLATE_TILES).color(MaterialColor.DEEPSLATE).noOcclusion(), false));
  //  public static final Supplier<Block> DEEPSLATE_CHEST = registerBlock("deepslate_chest", false, () -> new AncientChestBlock(BlockBehaviour.Properties.of(Material.STONE)
     //       .strength(6.2f).sound(SoundType.DEEPSLATE_TILES).color(MaterialColor.DEEPSLATE).noOcclusion(), true));

    @SuppressWarnings("unchecked")
    public static <T extends Block> Supplier<T> registerBlock(String name, boolean createItem, Supplier<T> block) {
        Supplier<T> toReturn = RegistryHelper.registerBlock(name, block);
        BLOCKS.put(name, (Supplier<Block>) toReturn);
        if(createItem) {
            Block rt = toReturn.get();
            try {
                IFakeableBlock faked = (IFakeableBlock) rt;
                RegistryHelper.registerItem(name, () -> new BlockItemExtension(rt, new Item.Properties().tab(DDCreativeModeTab.DD_TAB), faked.fake));
            } catch (Exception e) {
                RegistryHelper.registerItem(name, () -> new BlockItem(rt, new Item.Properties().tab(DDCreativeModeTab.DD_TAB)));
            }
        }
        return toReturn;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Block> Supplier<T> registerSign(String name, Supplier<T> block, Supplier<WallSignBlock> wallBlock) {
        Supplier<T> standing = RegistryHelper.registerBlock(name, block);
        BLOCKS.put(name, (Supplier<Block>) standing);
        Block standingBlock = standing.get();
        Block wall = wallBlock.get();
        try {
            IFakeableBlock rt = (IFakeableBlock) block.get();
            RegistryHelper.registerItem(name, () -> new SignItemExtension(new Item.Properties().stacksTo(16).tab(DDCreativeModeTab.DD_TAB), standingBlock, wall, rt.fake));
        } catch (Exception e) {
            RegistryHelper.registerItem(name, () -> new SignItem(new Item.Properties().stacksTo(16).tab(DDCreativeModeTab.DD_TAB), standingBlock, wall));
        }
        return standing;
    }

    public static RotatedPillarBlock log(MaterialColor materialColor, MaterialColor materialColor2, Block fake) {
        return new RotatedPillarBlockExtension(BlockBehaviour.Properties.of(Material.WOOD, (state) -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? materialColor : materialColor2).strength(2.0F).sound(SoundType.WOOD), fake);
    }

    public static void registerBlocks() {
        DeeperAndDarker.LOGGER.info("Deeper and Darker blocks have been registered");
    }
}
