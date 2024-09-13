package com.qzimyion;

import com.qzimyion.api.ClientHelper;
import net.minecraft.world.level.block.Blocks;

public final class DyanmicBrewingStandsMod {
    public static final String MOD_ID = "dynamicbrewingstands";

    public static void init(){
        if (ClientHelper.getPhysicalSide().isClient()){
            clientInit();
        }
    }

    public static void clientInit(){
        ClientHelper.addBlockColorsRegistration(DyanmicBrewingStandsMod::registerBlockColors);
    }

    private static void registerBlockColors(ClientHelper.BlockColorEvent event){
        event.register(new StandTinter(), Blocks.BREWING_STAND);
    }
}
