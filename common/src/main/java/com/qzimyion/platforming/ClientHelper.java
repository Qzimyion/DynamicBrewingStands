package com.qzimyion.platforming;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Consumer;

public class ClientHelper {

    public interface BlockColorEvent {
        void register(BlockColor color, Block... block);

        int getColor(BlockState block, BlockAndTintGetter level, BlockPos pos, int tint);
    }

    @ExpectPlatform
    public static void addBlockColorsRegistration(Consumer<BlockColorEvent> eventListener){
        throw new AssertionError();
    }

    @ExpectPlatform
    public static Side getPhysicalSide() {
        throw new AssertionError();
    }

    public enum Side {
        CLIENT, SERVER;

        public boolean isClient() {
            return this == CLIENT;
        }

        public boolean isServer() {
            return this == SERVER;
        }

        public void ifClient(Runnable runnable) {
            if (isClient()) runnable.run();
        }

        public void ifServer(Runnable runnable) {
            if (isServer()) runnable.run();
        }
    }

}
