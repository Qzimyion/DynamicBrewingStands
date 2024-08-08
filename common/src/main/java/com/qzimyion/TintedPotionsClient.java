package com.qzimyion;

import com.qzimyion.platforming.ClientHelper;
import net.minecraft.world.level.block.Blocks;

public class TintedPotionsClient {

    public static void init() {
        ClientHelper.blockColReg(TintedPotionsClient::registerBlockColors);
    }

    private static void registerBlockColors(ClientHelper.BlockColorImpl event){
        event.register(new StandTinter(), Blocks.BREWING_STAND);
    }
}
