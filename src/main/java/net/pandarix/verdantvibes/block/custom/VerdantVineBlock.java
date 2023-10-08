package net.pandarix.verdantvibes.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.VineBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VerdantVineBlock extends VineBlock {
    public VerdantVineBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable(this.getTranslationKey() + ".info").formatted(Formatting.DARK_GRAY, Formatting.ITALIC));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
