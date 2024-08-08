package com.qzimyion.neoforge;

import com.qzimyion.StandTinter;
import net.mehvahdjukaar.moonlight.api.platform.ClientHelper;
import net.minecraft.world.level.block.Blocks;

public class TPClient {

    public static void init(){
        ClientHelper.addBlockColorsRegistration(TPClient::registerBlockColors);
    }

    private static void registerBlockColors(ClientHelper.BlockColorEvent event){
        event.register(new StandTinter(), Blocks.BREWING_STAND);
    }
}
