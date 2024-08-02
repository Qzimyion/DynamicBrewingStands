package com.qzimyion;

import com.qzimyion.platforming.ClientHelper;
import net.minecraft.world.level.block.Blocks;

public class TintedPotionsClient {

    public static void init() {
        ClientHelper.addBlockColorsRegistration(TintedPotionsClient::registerBlockColors);
    }

    public static void initNeo(){

    }

    private static void registerBlockColors(ClientHelper.BlockColorEvent event){
        event.register(new StandTinter(), Blocks.BREWING_STAND);
    }
}
