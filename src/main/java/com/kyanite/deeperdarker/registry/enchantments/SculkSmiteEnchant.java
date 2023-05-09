package com.kyanite.deeperdarker.registry.enchantments;

import com.kyanite.deeperdarker.miscellaneous.DDTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class SculkSmiteEnchant extends Enchantment {
    public SculkSmiteEnchant(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot[] pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public float getDamageBonus(int i, MobType mobType) {
        return mobType == DDTypes.SCULK ? (float)i * 2.5F : 0.0F;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }
}
