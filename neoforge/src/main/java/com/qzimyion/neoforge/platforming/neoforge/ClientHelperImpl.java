package com.qzimyion.neoforge.platforming.neoforge;

import com.qzimyion.platforming.ClientHelper;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;

import java.util.function.Consumer;

public class ClientHelperImpl {

    public static ClientHelper.Side getPhysicalSide() {
        return FMLEnvironment.dist == Dist.CLIENT ? ClientHelper.Side.CLIENT : ClientHelper.Side.SERVER;
    }
}
