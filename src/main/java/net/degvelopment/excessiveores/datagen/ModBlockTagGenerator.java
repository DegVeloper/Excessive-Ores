package net.degvelopment.excessiveores.datagen;

import net.degvelopment.excessiveores.ExcessiveOresMod;
import net.degvelopment.excessiveores.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ExcessiveOresMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // --------------------------------------------------------------------------- //
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BRONZE_BLOCK.get(),
                        ModBlocks.RAW_BRONZE_BLOCK.get(),
                        ModBlocks.BRONZE_ORE.get(),
                        ModBlocks.DEEPSLATE_BRONZE_ORE.get());
        // ---------------------------------------------------------------------------- //
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                // ---------------------------BRONZE--------------------------- //
                .add(ModBlocks.BRONZE_BLOCK.get(),
                        ModBlocks.RAW_BRONZE_BLOCK.get(),
                        ModBlocks.BRONZE_ORE.get(),
                        ModBlocks.DEEPSLATE_BRONZE_ORE.get());
                // ------------------------------------------------------------ //
        // --------------------------------------------------------------------------- //
    }
}