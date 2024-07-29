package com.qzimyion.api.quilt;

import com.qzimyion.api.ClientHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Consumer;

public class ClientHelperImpl {

    public static void addBlockColorsRegistration(Consumer<ClientHelper.BlockColorEvent> eventListener) {
        eventListener.accept(new com.qzimyion.api.ClientHelper.BlockColorEvent() {
            @Override
            public void register(BlockColor color, Block... block) {
                ColorProviderRegistry.BLOCK.register(color, block);
            }

            @Override
            public int getColor(BlockState block, BlockAndTintGetter level, BlockPos pos, int tint) {
                var c = ColorProviderRegistry.BLOCK.get(block.getBlock());
                return c == null ? -1 : c.getColor(block, level, pos, tint);
            }
        });
    }

    public static ClientHelper.Side getPhysicalSide() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT ? ClientHelper.Side.CLIENT : ClientHelper.Side.SERVER;
    }
}
