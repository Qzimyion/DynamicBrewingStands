package com.qzimyion.api.neoforge;

import com.qzimyion.api.ClientHelper;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import java.util.function.Consumer;

public class ClientHelperImpl {

    public static void addBlockColorsRegistration(Consumer<ClientHelper.BlockColorEvent> eventListener) {
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
        //bus.addListener(eventConsumer);
    }

    public static ClientHelper.Side getPhysicalSide() {
        return FMLEnvironment.dist == Dist.CLIENT ? ClientHelper.Side.CLIENT : ClientHelper.Side.SERVER;
    }
}
