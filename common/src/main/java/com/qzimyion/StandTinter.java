package com.qzimyion;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BrewingStandBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class StandTinter implements BlockColor {

    @Override
    public int getColor(BlockState blockState, @Nullable BlockAndTintGetter blockAndTintGetter, @Nullable BlockPos blockPos, int i) {
        if (i < 1 || i > 3) return -1;
        if (blockAndTintGetter != null && blockPos != null) {
            BlockEntity te = blockAndTintGetter.getBlockEntity(blockPos);
            if (te instanceof BrewingStandBlockEntity br) {
                ItemStack item = br.getItem(i-1);
                if (!item.isEmpty() && item.hasTag()) {
                    return PotionUtils.getColor(item);
                }
                else return -1;
            }
        }
        return 0xffffff;
    }
}
