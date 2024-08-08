package com.qzimyion;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
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
                //int j = potionContents.potion().isPresent() && ((Potion)((Holder<?>)potionContents.potion().get()).value()).hasInstantEffects() ? 2007 : 2002;
                if (!item.isEmpty() && item.has(DataComponents.POTION_CONTENTS)) {
                    return item.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).getColor();
                }
                else return 0xeab676;
            }
        }
        return 0xffffff;
    }
}
