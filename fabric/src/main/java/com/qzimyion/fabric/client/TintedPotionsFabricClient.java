package com.qzimyion.fabric.client;

import com.qzimyion.TintedPotionsClient;
import net.fabricmc.api.ClientModInitializer;

public final class TintedPotionsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TintedPotionsClient.init();
    }
}
