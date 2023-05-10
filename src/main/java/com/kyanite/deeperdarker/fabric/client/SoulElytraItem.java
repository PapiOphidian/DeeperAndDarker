package com.kyanite.deeperdarker.fabric.client;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.kyanite.deeperdarker.config.DDConfig;
import com.kyanite.deeperdarker.miscellaneous.DDUtils;
import com.kyanite.deeperdarker.registry.items.extensions.IFakeableItem;
import eu.pb4.polymer.api.item.PolymerItemUtils;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class SoulElytraItem extends ElytraItem implements FabricElytraItem, IFakeableItem {
    public final Item fake = Items.ELYTRA;
    public final String name = "Soul Elytra";
    private static final UUID[] ARMOR_MODIFIER_UUID_PER_SLOT = new UUID[]{UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")};
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;
    public SoulElytraItem(Properties properties) {
        super(properties);

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        UUID uuid = ARMOR_MODIFIER_UUID_PER_SLOT[EquipmentSlot.CHEST.getIndex()];
        builder.put(Attributes.ARMOR, new AttributeModifier(uuid, "Armor modifier", DDConfig.SOUL_ELYTRA_ARMOR_MODIFIER.get(), AttributeModifier.Operation.ADDITION));

        this.defaultModifiers = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot arg) {
        return arg == EquipmentSlot.CHEST ? this.defaultModifiers : super.getDefaultAttributeModifiers(arg);
    }

    @Override
    public void doVanillaElytraTick(LivingEntity entity, ItemStack chestStack) {
        FabricElytraItem.super.doVanillaElytraTick(entity, chestStack);
        DDUtils.soulElytraTick(entity);
    }

    public static boolean isUsable(ItemStack stack) {
        return stack.getDamageValue() < stack.getMaxDamage() - 1;
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
