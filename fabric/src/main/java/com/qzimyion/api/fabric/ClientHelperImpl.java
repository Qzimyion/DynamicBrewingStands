package com.qzimyion.api.fabric;

import com.qzimyion.api.ClientHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.loader.api.FabricLoader;

import java.util.function.Consumer;

public class ClientHelperImpl {

    public static void addBlockColorsRegistration(Consumer<ClientHelper.BlockColorEvent> eventListener) {
        eventListener.accept(ColorProviderRegistry.BLOCK::register);
    }

    public static ClientHelper.Side getPhysicalSide() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT ? ClientHelper.Side.CLIENT : ClientHelper.Side.SERVER;
    }
}
