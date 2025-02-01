package net.degvelopment.excessiveores.datagen;

import net.degvelopment.excessiveores.ExcessiveOresMod;
import net.degvelopment.excessiveores.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ExcessiveOresMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // ----------------------------------BRONZE----------------------------------- //
        simpleItem(ModItems.BRONZE_INGOT);
        simpleItem(ModItems.RAW_BRONZE);

        handHeldItem(ModItems.BRONZE_SWORD);
        handHeldItem(ModItems.BRONZE_PICKAXE);
        handHeldItem(ModItems.BRONZE_AXE);
        handHeldItem(ModItems.BRONZE_SHOVEL);
        handHeldItem(ModItems.BRONZE_HOE);
        // --------------------------------------------------------------------------- //
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ExcessiveOresMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handHeldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(ExcessiveOresMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
