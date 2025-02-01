package net.degvelopment.excessiveores.item;

import net.degvelopment.excessiveores.ExcessiveOresMod;
import net.degvelopment.excessiveores.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier BRONZE = TierSortingRegistry.registerTier(
            new ForgeTier(2, 185, 6.0F, 2.0F, 25,
                    ModTags.Blocks.NEEDS_BRONZE_TOOL, () -> Ingredient.of(ModItems.BRONZE_INGOT.get())),
            new ResourceLocation(ExcessiveOresMod.MOD_ID, "bronze"), List.of(Tiers.IRON), List.of());
}