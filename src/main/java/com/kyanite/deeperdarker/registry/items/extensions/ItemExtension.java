package com.kyanite.deeperdarker.registry.items.extensions;

import eu.pb4.polymer.api.item.PolymerItemUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ItemExtension extends Item implements IFakeableItem {
    public Item fake;
    public String name;
    public ItemExtension(Properties properties, Item fake, String name) {
        super(properties);
        this.fake = fake;
        this.name = name;
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayer player) {
        return this.fake;
    }

    @Override
    public ItemStack getPolymerItemStack(ItemStack itemStack, @Nullable ServerPlayer player) {
        ItemStack out = PolymerItemUtils.createItemStack(itemStack, player);
        CompoundTag tag = new CompoundTag();
        CompoundTag display = new CompoundTag();
        display.putString("Name", String.format("{\"text\":\"%s\",\"italic\":false}", this.name));
        tag.put("display", display);
        out.setTag(tag);
        return out;
    }
}
