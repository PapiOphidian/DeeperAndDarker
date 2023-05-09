package com.kyanite.deeperdarker.platform;

import com.kyanite.deeperdarker.fabric.DeeperAndDarkerFabric;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class PortalHelper {
    public static <T extends Block> Supplier<T> getPortalBlock() {
        return () -> (T) DeeperAndDarkerFabric.PORTAL_BLOCK;
    }

    public static <T extends Item> Supplier<T> getHeartItem() {
        return () -> (T) DeeperAndDarkerFabric.HEART;
    }
}
