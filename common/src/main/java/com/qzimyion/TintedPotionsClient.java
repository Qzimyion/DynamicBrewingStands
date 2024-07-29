package com.qzimyion;

import com.qzimyion.api.ClientHelper;
import net.minecraft.world.level.block.Blocks;

public final class TintedPotionsClient {

    public static void init() {
        ClientHelper.addBlockColorsRegistration(TintedPotionsClient::registerBlockColors);
    }

    private static void registerBlockColors(ClientHelper.BlockColorEvent event){
        event.register(new StandTinter(), Blocks.BREWING_STAND);
    }
}
