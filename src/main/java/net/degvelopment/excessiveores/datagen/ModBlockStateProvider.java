package net.degvelopment.excessiveores.datagen;

import net.degvelopment.excessiveores.ExcessiveOresMod;
import net.degvelopment.excessiveores.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ExcessiveOresMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // ----------------------------------BRONZE----------------------------------- //
        blockWithItem(ModBlocks.BRONZE_BLOCK);
        blockWithItem(ModBlocks.RAW_BRONZE_BLOCK);

        blockWithItem(ModBlocks.BRONZE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_BRONZE_ORE);
        // --------------------------------------------------------------------------- //
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
