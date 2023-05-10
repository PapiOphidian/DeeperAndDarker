package com.kyanite.deeperdarker.registry.items.extensions;

import eu.pb4.polymer.api.item.PolymerItemUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import org.jetbrains.annotations.Nullable;

public class SpawnEggItemExtension extends SpawnEggItem implements IFakeableItem {
    public Item fake = Items.VILLAGER_SPAWN_EGG;
    public String name;
    public SpawnEggItemExtension(EntityType<? extends Mob> entityType, int i, int j, Properties properties, String name) {
        super(entityType, i, j, properties);
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
