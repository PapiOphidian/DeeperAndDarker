package com.kyanite.deeperdarker.registry.items.custom;

import eu.pb4.polymer.api.item.PolymerItem;
import eu.pb4.polymer.api.item.PolymerItemUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.Nullable;

public class CustomHoeItem extends HoeItem implements PolymerItem {
    public CustomHoeItem(Tier tier, int i, float f, Properties properties) {
        super(tier, i, f, properties);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayer player) {
        return Items.DIAMOND_HOE;
    }

    @Override
    public ItemStack getPolymerItemStack(ItemStack itemStack, @Nullable ServerPlayer player) {
        ItemStack out = PolymerItemUtils.createItemStack(itemStack, player);
        CompoundTag compound = new CompoundTag();
        CompoundTag display = new CompoundTag();

        display.putString("Name", "{\"text\":\"Warden Hoe\",\"italic\":false}");
        compound.put("display", display);
        out.setTag(compound);

        return out;
    }
}
