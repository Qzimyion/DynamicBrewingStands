package com.qzimyion;

import com.qzimyion.platforming.ClientHelper;

public final class TintedPotions {
    public static final String MOD_ID = "tp";

    public static void init() {
        if (ClientHelper.getPhysicalSide().isClient()){
            TintedPotionsClient.init();
        }
    }
}
