package com.kyanite.deeperdarker.fabric.client.warden_armor;

import com.kyanite.deeperdarker.registry.items.DDItems;
import com.kyanite.deeperdarker.registry.items.extensions.IFakeableItem;
import eu.pb4.polymer.api.item.PolymerItemUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class WardenArmorItem extends ArmorItem implements IAnimatable, IFakeableItem {

    private final AnimationFactory factory = new AnimationFactory(this);
    public Item fake;
    public String name;

    public WardenArmorItem(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties, Item fake, String name) {
        super(pMaterial, pSlot, pProperties);
        this.fake = fake;
        this.name = name;
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean bl) {
        if(entity instanceof Player player) {
            if(!level.isClientSide()) {
                if(player.getInventory().getArmor(EquipmentSlot.HEAD.getIndex()).is(DDItems.WARDEN_HELMET.get())) {
                    if(player.hasEffect(MobEffects.BLINDNESS)) player.removeEffect(MobEffects.BLINDNESS);
                    if(player.hasEffect(MobEffects.DARKNESS)) player.removeEffect(MobEffects.DARKNESS);
                }

                if(player.getInventory().getArmor(EquipmentSlot.LEGS.getIndex()).is(DDItems.WARDEN_LEGGINGS.get())) {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 25, 0, true, false));
                }
            }
        }
        super.inventoryTick(itemStack, level, entity, i, bl);
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 20, this::predicate));
    }

    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
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
