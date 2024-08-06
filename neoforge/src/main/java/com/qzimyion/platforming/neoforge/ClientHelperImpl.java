package com.qzimyion.platforming.neoforge;

import com.qzimyion.platforming.ClientHelper;
import dev.architectury.platform.Platform;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import java.lang.ref.WeakReference;
import java.util.function.Consumer;

public class ClientHelperImpl {

    public static boolean isInitializing() {
        return !ModLoadingContext.get().getActiveNamespace().equals("minecraft");
    }

    public static boolean isDev() {
        return !FMLLoader.isProduction();
    }

    public enum Platform {
        FORGE;
        
        public static Platform getPlatform() {
            return Platform.FORGE;
        }

        public boolean isForge() {
            return this == FORGE;
        }

        public static void assertInitPhase() {
            if (!isInitializing()) {
                if (isDev() && getPlatform().isForge()) {
                    throw new AssertionError("Method has to be called during main mod initialization phase. Client and Server initializer are not valid, you must call in the main one");
                }
            }
        }

        private static WeakReference<IEventBus> currentBus = null;

        public static void startRegistering(IEventBus bus) {
            currentBus = new WeakReference<>(bus);
        }

        public static IEventBus getCurrentBus() {
            var b = currentBus.get();
            if (b == null)
                throw new IllegalStateException("Bus is null. You must call startRegistering before registering events");
            return b;
        }
    }

    public static ClientHelper.Side getPhysicalSide() {
        return FMLEnvironment.dist == Dist.CLIENT ? ClientHelper.Side.CLIENT : ClientHelper.Side.SERVER;
    }

    public static void addBlockColorsRegistration(Consumer<ClientHelper.BlockColorEvent> eventListener) {
        Platform.assertInitPhase();
        Consumer<RegisterColorHandlersEvent.Block> eventConsumer = event -> {
            eventListener.accept(new ClientHelper.BlockColorEvent() {
                @Override
                public void register(BlockColor color, Block... block) {
                    event.register(color, block);
                }

                @Override
                public int getColor(BlockState block, BlockAndTintGetter level, BlockPos pos, int tint) {
                    return event.getBlockColors().getColor(block, level, pos, tint);
                }
            });
        };
        Platform.getCurrentBus().addListener(eventConsumer);
    }
}
