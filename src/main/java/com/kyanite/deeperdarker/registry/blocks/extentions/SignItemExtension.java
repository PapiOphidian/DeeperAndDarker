package com.kyanite.deeperdarker.registry.blocks.extentions;

import eu.pb4.polymer.api.item.PolymerItem;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class SignItemExtension extends SignItem implements PolymerItem {
    public Block fake;
    public SignItemExtension(Properties properties, Block block, Block block2, Block fake) {
        super(properties, block, block2);
        this.fake = fake;
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayer player) {
        if (this.fake == null) return Items.BEDROCK;
        return this.fake.asItem();
    }
}
