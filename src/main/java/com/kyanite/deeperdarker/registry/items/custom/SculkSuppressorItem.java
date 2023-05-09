package com.kyanite.deeperdarker.registry.items.custom;

import eu.pb4.polymer.api.item.PolymerItem;
import eu.pb4.polymer.api.item.PolymerItemUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.Nullable;

public class SculkSuppressorItem extends Item implements PolymerItem {
    public SculkSuppressorItem(Item.Properties properties) {
        super(properties);
    }

    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
        if (!(livingEntity instanceof Player)) {
            if (!player.level.isClientSide && livingEntity.isAlive()) {
                livingEntity.setSilent(true);
                if (livingEntity instanceof Mob) {
                    ((Mob)livingEntity).setPersistenceRequired();
                }

                itemStack.shrink(1);
            }

            return InteractionResult.sidedSuccess(player.level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayer player) {
        return Items.IRON_TRAPDOOR;
    }

    @Override
    public ItemStack getPolymerItemStack(ItemStack itemStack, @Nullable ServerPlayer player) {
        ItemStack out = PolymerItemUtils.createItemStack(itemStack, player);
        CompoundTag compound = new CompoundTag();
        CompoundTag display = new CompoundTag();

        display.putString("Name", "{\"text\":\"Sculk Suppressor\",\"italic\":false}");
        compound.put("display", display);
        out.setTag(compound);

        return out;
    }
}