package com.qzimyion.forge;

import com.qzimyion.TintedPotionsClient;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.qzimyion.TintedPotions;

import static com.qzimyion.TintedPotions.MOD_ID;

@Mod(MOD_ID)
public final class TintedPotionsForge {

    public TintedPotionsForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        // Run our common setup.
        TintedPotions.init();
        //bus.addListener(ClientModEvents::init);
    }
}
