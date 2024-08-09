package net.github.qzimyion.tintedpotions;

import net.github.qzimyion.tintedpotions.api.Helper;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.common.Mod;


@Mod(TintedPotions.MODID)
public class TintedPotions
{
    public static final String MODID = "tp";

    public TintedPotions()
    {
        if (Helper.getPhysicalSide().isClient()){
            Helper.addBlockColorsRegistration(TintedPotions::registerBlockColors);
        }
    }

    public static void registerBlockColors(Helper.BlockColorEvent event){
        event.register(new StandTinter(), Blocks.BREWING_STAND);
    }
}
