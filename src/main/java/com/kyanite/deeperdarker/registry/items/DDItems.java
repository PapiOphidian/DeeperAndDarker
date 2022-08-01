package com.kyanite.deeperdarker.registry.items;

import com.kyanite.deeperdarker.DeeperAndDarker;
import com.kyanite.deeperdarker.registry.entities.DDEntities;
import com.kyanite.deeperdarker.util.DDArmorMaterials;
import com.kyanite.deeperdarker.util.DDCreativeModeTab;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DeeperAndDarker.MOD_ID);

    public static final RegistryObject<Item> WARDEN_CARAPACE = ITEMS.register("warden_carapace", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> WARDEN_HELMET = ITEMS.register("warden_helmet", () -> new WardenArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.HEAD, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> WARDEN_CHESTPLATE = ITEMS.register("warden_chestplate", () -> new WardenArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.CHEST, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> WARDEN_LEGGINGS = ITEMS.register("warden_leggings", () -> new WardenArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.LEGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));
    public static final RegistryObject<Item> WARDEN_BOOTS = ITEMS.register("warden_boots", () -> new WardenArmorItem(DDArmorMaterials.WARDEN, EquipmentSlot.FEET, new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));

    public static final RegistryObject<Item> HEART_OF_THE_DEEP = ITEMS.register("heart_of_the_deep", () -> new DeepHeartItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).tab(DDCreativeModeTab.DD_TAB)));

    public static final RegistryObject<SpawnEggItem> SHRIEK_WORM_SPAWN_EGG = ITEMS.register("shriek_worm_spawn_egg", () -> new ForgeSpawnEggItem(DDEntities.SCULK_WORM, 1001033, 3790560, (new Item.Properties()).tab(DDCreativeModeTab.DD_TAB)));
}
