package com.kyanite.deeperdarker.registry.items;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.miscellaneous.DDArmorMaterials;
import com.kyanite.deeperdarker.miscellaneous.DDCreativeModeTab;
import com.kyanite.deeperdarker.miscellaneous.DDTiers;
import com.kyanite.deeperdarker.platform.ClientHelper;
import com.kyanite.deeperdarker.platform.PortalHelper;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.registry.entities.custom.DDBoat;
import com.kyanite.deeperdarker.registry.items.custom.*;
import com.kyanite.deeperdarker.registry.items.extensions.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;

import java.util.function.Supplier;

import static com.kyanite.deeperdarker.platform.RegistryHelper.registerItem;

public class DDItems {

    public static final Supplier<Item> HEART_OF_THE_DEEP = registerItem("heart_of_the_deep", PortalHelper.getHeartItem());
    public static final Supplier<Item> REINFORCED_ECHO_SHARD = registerItem("reinforced_echo_shard", () -> new ItemExtension(new Item.Properties().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC).fireResistant(), Items.ECHO_SHARD, "Reinforced Echo Shard"));
  //  public static final Supplier<Item> ANCIENT_CHEST = registerItem("ancient_chest", () -> new AncientChestItem(DDBlocks.ANCIENT_CHEST.get(), new Item.Properties().tab(DDCreativeModeTab.DD_TAB).stacksTo(1)));
    //public static final Supplier<Item> DEEPSLATE_CHEST = registerItem("deepslate_chest", () -> new AncientChestItem(DDBlocks.DEEPSLATE_CHEST.get(), new Item.Properties().tab(DDCreativeModeTab.DD_TAB).stacksTo(1)));
    public static final Supplier<Item> WARDEN_CARAPACE = registerItem("warden_carapace", () -> new ItemExtension(new Item.Properties().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC).fireResistant(), Items.GLOW_INK_SAC, "Warden Carapace"));
    public static final Supplier<Item> SOUL_ELYTRA = registerItem("soul_elytra", ClientHelper.getElytraItem());
    public static final Supplier<Item> SOUL_DUST = registerItem("soul_dust", () -> new ItemExtension(new Item.Properties().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC).fireResistant(), Items.SUGAR, "Soul Dust"));
    public static final Supplier<Item> GRIME_BALL = registerItem("sculk_grime_ball", () -> new ItemExtension(new Item.Properties().tab(DDCreativeModeTab.DD_TAB).fireResistant(), Items.COAL, "Sculk Grime Ball"));
    public static final Supplier<Item> GRIME_BRICK = registerItem("sculk_grime_brick", () -> new ItemExtension(new Item.Properties().tab(DDCreativeModeTab.DD_TAB).fireResistant(), Items.BRICK, "Sculk Grime Brick"));
    public static final Supplier<Item> SCULK_BONE = registerItem("sculk_bone", () -> new ItemExtension(new Item.Properties().tab(DDCreativeModeTab.DD_TAB).fireResistant(), Items.BONE, "Sculk Bone"));
    public static final Supplier<Item> SOUL_CRYSTAL = registerItem("soul_crystal", () -> new ItemExtension(new Item.Properties().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC).fireResistant(), Items.AMETHYST_CLUSTER, "Soul Crystal"));
    public static final Supplier<Item> SCULK_TRANSMITTER = registerItem("sculk_transmitter", () -> new SculkTransmitterItem(new Item.Properties().tab(DDCreativeModeTab.DD_TAB).stacksTo(1).rarity(Rarity.EPIC).fireResistant()));

    public static final Supplier<Item> WARDEN_HELMET = registerItem("warden_helmet", ClientHelper.createArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.HEAD, new Item.Properties().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC).fireResistant(), Items.DIAMOND_HELMET, "Warden Helmet"));
    public static final Supplier<Item> WARDEN_CHESTPLATE = registerItem("warden_chestplate", ClientHelper.createArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.CHEST, new Item.Properties().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC).fireResistant(), Items.DIAMOND_CHESTPLATE, "Warden Chestplate"));
    public static final Supplier<Item> WARDEN_LEGGINGS = registerItem("warden_leggings", ClientHelper.createArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.LEGS, new Item.Properties().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC).fireResistant(), Items.DIAMOND_LEGGINGS, "Warden Leggings"));
    public static final Supplier<Item> WARDEN_BOOTS = registerItem("warden_boots", ClientHelper.createArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.FEET, new Item.Properties().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC).fireResistant(), Items.DIAMOND_BOOTS, "Warden Boots"));
    public static final Supplier<Item> SHATTERED_SPAWN_EGG = registerItem("shattered_spawn_egg", () -> new SpawnEggItemExtension(DDEntities.SHATTERED.get(), 0x0d1217, 0xD1D6B6, new Item.Properties().tab(DDCreativeModeTab.DD_TAB), "Shattered Spawn Egg"));
    public static final Supplier<Item> SCULK_LEECH_SPAWN_EGG = registerItem("sculk_leech_spawn_egg", () -> new SpawnEggItemExtension(DDEntities.SCULK_LEECH.get(), 0x152B38, 0x00FAFF, new Item.Properties().tab(DDCreativeModeTab.DD_TAB), "Sculk Leech Spawn Egg"));
    public static final Supplier<Item> SCULK_SNAPPER_SPAWN_EGG = registerItem("sculk_snapper_spawn_egg", () -> new SpawnEggItemExtension(DDEntities.SCULK_SNAPPER.get(), 0xD1D6B6, 0x1D726F, new Item.Properties().tab(DDCreativeModeTab.DD_TAB), "Sculk Snapper Spawn Egg"));
    public static final Supplier<Item> SHRIEK_WORM_SPAWN_EGG = registerItem("shriek_worm_spawn_egg", () -> new SpawnEggItemExtension(DDEntities.SCULK_WORM.get(), 0x204C61, 0xF1F7D0, new Item.Properties().tab(DDCreativeModeTab.DD_TAB), "Sculk Worm Spawn Egg"));
    public static final Supplier<Item> SCULK_CENTIPEDE_SPAWN_EGG = registerItem("sculk_centipede_spawn_egg", () -> new SpawnEggItemExtension(DDEntities.SCULK_CENTIPEDE.get(), 0x1a2340, 0xded697, new Item.Properties().tab(DDCreativeModeTab.DD_TAB), "Sculk Centipede Spawn Egg"));
    public static final Supplier<Item> STALKER_SPAWN_EGG = registerItem("stalker_spawn_egg", () -> new SpawnEggItemExtension(DDEntities.STALKER.get(), 0x172226, 0x6abdd9, (new Item.Properties()).tab(DDCreativeModeTab.DD_TAB), "Stalker Spawn Egg"));
    public static final Supplier<Item> ECHOER_SPAWN_EGG = registerItem("echoer_spawn_egg", () -> new SpawnEggItemExtension(DDEntities.ECHOER.get(), 0x1a2340, 0xded697, (new Item.Properties()).tab(DDCreativeModeTab.DD_TAB), "Echoer Spawn Egg"));
    public static final Supplier<Item> ECHO_BOAT = registerItem("echo_boat", () -> new DDBoatItem(false, DDBoat.Type.ECHO, new Item.Properties().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC).fireResistant()));
    public static final Supplier<Item> ECHO_CHEST_BOAT = registerItem("echo_chest_boat", () -> new DDBoatItem(true, DDBoat.Type.ECHO, new Item.Properties().tab(DDCreativeModeTab.DD_TAB).rarity(Rarity.EPIC).fireResistant()));
    public static final Supplier<Item> WARDEN_SWORD = registerItem("warden_sword", () -> new SwordItemExtension(DDTiers.WARDEN, 2, -2.4F, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB), Items.DIAMOND_SWORD, "Warden Sword"));
    public static final Supplier<Item> WARDEN_SHOVEL = registerItem("warden_shovel", () -> new ShovelItemExtension(DDTiers.WARDEN, 1.2F, -3.0F, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB), Items.DIAMOND_SHOVEL, "Warden Shovel"));
    public static final Supplier<Item> WARDEN_PICKAXE = registerItem("warden_pickaxe", () -> new PickaxeItemExtension(DDTiers.WARDEN, 1, -2.8F, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB), Items.DIAMOND_PICKAXE, "Warden Pickaxe"));
    public static final Supplier<Item> WARDEN_AXE = registerItem("warden_axe", () -> new AxeItemExtension(DDTiers.WARDEN, 3.5F, -3.0F, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB), Items.DIAMOND_AXE, "Warden Axe"));
    public static final Supplier<Item> WARDEN_HOE = registerItem("warden_hoe", () -> new CustomHoeItem(DDTiers.WARDEN, -4, 0, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final Supplier<Item> SCULK_SUPPRESSOR = registerItem("sculk_suppressor", () -> new SculkSuppressorItem(new Item.Properties().rarity(Rarity.UNCOMMON).tab(DDCreativeModeTab.DD_TAB)));
    public static final Supplier<Item> SCULK_MEAL = registerItem("sculk_meal", () -> new SculkMealItem(new Item.Properties().tab(DDCreativeModeTab.DD_TAB).fireResistant()));

    public static void registerItems() {
        DeeperAndDarker.LOGGER.info("Deeper and Darker items have been registered");
    }
}
