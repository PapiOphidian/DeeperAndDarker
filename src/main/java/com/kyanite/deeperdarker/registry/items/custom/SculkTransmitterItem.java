package com.kyanite.deeperdarker.registry.items.custom;

import com.kyanite.deeperdarker.config.DDConfig;
import com.kyanite.deeperdarker.registry.entities.custom.projectiles.ShriekProjectile;
import eu.pb4.polymer.api.item.PolymerItem;
import eu.pb4.polymer.api.item.PolymerItemUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class SculkTransmitterItem extends Item implements PolymerItem {
    public SculkTransmitterItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        player.getCooldowns().addCooldown(this, DDConfig.TRANSMITTER_COOLDOWN.get());

        if (!level.isClientSide()) {
            ShriekProjectile abstractarrowentity = new ShriekProjectile(level, player);
            abstractarrowentity.shootFromRotation(player, player.getXRot(), player.getYRot(),
                    0.0F, 1.0F * 5.0F, 1.0F);

            abstractarrowentity.tickCount = 35;
            abstractarrowentity.isNoGravity();

            level.addFreshEntity(abstractarrowentity);
            player.playSound(SoundEvents.WARDEN_SONIC_BOOM, 3.0F, 1.0F);
        }
        return InteractionResultHolder.consume(player.getItemInHand(interactionHand));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayer player) {
        return Items.FISHING_ROD;
    }

    @Override
    public ItemStack getPolymerItemStack(ItemStack itemStack, @Nullable ServerPlayer player) {
        ItemStack out = PolymerItemUtils.createItemStack(itemStack, player);
        CompoundTag compound = new CompoundTag();
        CompoundTag display = new CompoundTag();

        display.putString("Name", "{\"text\":\"Sculk Transmitter\",\"italic\":false}");
        compound.put("display", display);
        out.setTag(compound);

        return out;
    }
}
