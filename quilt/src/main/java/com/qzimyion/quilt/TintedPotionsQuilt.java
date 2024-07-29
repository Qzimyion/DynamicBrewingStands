package com.qzimyion.quilt;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

import com.qzimyion.TintedPotions;

public final class TintedPotionsQuilt implements ModInitializer {

    @Override
    public void onInitialize(ModContainer mod) {
        TintedPotions.init();
    }
}
