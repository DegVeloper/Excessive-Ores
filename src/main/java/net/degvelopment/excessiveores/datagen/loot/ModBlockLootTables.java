package net.degvelopment.excessiveores.datagen.loot;

import net.degvelopment.excessiveores.block.ModBlocks;
import net.degvelopment.excessiveores.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // -----------------------------------BRONZE----------------------------------- //
        this.dropSelf(ModBlocks.BRONZE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_BRONZE_BLOCK.get());

        this.add(ModBlocks.BRONZE_ORE.get(),
                block -> createOreDrop(ModBlocks.BRONZE_ORE.get(), ModItems.RAW_BRONZE.get()));
        this.add(ModBlocks.DEEPSLATE_BRONZE_ORE.get(),
                block -> createOreDrop(ModBlocks.BRONZE_ORE.get(), ModItems.RAW_BRONZE.get()));
        // ---------------------------------------------------------------------------- //
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
