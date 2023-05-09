package com.kyanite.deeperdarker.registry.items.custom;

import eu.pb4.polymer.api.item.PolymerItem;
import eu.pb4.polymer.api.item.PolymerItemUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class AncientChestItem extends BlockItem implements IAnimatable, PolymerItem {
    public AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public AncientChestItem(Block block, Properties settings) {
        super(block, settings);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayer player) {
        return Items.CHEST;
    }

    @Override
    public ItemStack getPolymerItemStack(ItemStack itemStack, @Nullable ServerPlayer player) {
        ItemStack out = PolymerItemUtils.createItemStack(itemStack, player);
        CompoundTag compound = new CompoundTag();
        CompoundTag display = new CompoundTag();

        display.putString("Name", "{\"text\":\"Ancient Chest\",\"italic\":false}");
        compound.put("display", display);
        out.setTag(compound);

        return out;
    }
}
