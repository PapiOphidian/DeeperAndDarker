package com.kyanite.deeperdarker.registry.blocks.extentions;

import eu.pb4.polymer.api.item.PolymerItem;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class BlockItemExtension extends BlockItem implements PolymerItem {
    public Block fake;
    public BlockItemExtension(Block block, Properties properties, Block fake) {
        super(block, properties);
        this.fake = fake;
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayer player) {
        if (this.fake == null) return Items.BEDROCK;
        return this.fake.asItem();
    }
}
