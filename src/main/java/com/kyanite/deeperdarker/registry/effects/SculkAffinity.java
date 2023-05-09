package com.kyanite.deeperdarker.registry.effects;

import eu.pb4.polymer.api.other.PolymerStatusEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class SculkAffinity extends MobEffect implements PolymerStatusEffect {
    protected SculkAffinity(MobEffectCategory mobEffectCategory, int i) {
        super(mobEffectCategory, i);
    }

    @Override
    public boolean isBeneficial() {
        return true;
    }

    @Override
    public boolean isDurationEffectTick(int i, int j) {
        return true;
    }
}
