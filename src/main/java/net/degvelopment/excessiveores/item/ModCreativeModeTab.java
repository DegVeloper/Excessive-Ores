package net.degvelopment.excessiveores.item;

import net.degvelopment.excessiveores.ExcessiveOresMod;
import net.degvelopment.excessiveores.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExcessiveOresMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EXCESSIVE_ORES_TAB = CREATIVE_MODE_TABS.register("excessive_ores_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BRONZE_INGOT.get()))
                    .title(Component.translatable("creativetab.excessive_ores_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.RAW_BRONZE.get());
                        pOutput.accept(ModItems.BRONZE_INGOT.get());

                        pOutput.accept(ModBlocks.RAW_BRONZE_BLOCK.get());
                        pOutput.accept(ModBlocks.BRONZE_BLOCK.get());
                        pOutput.accept(ModBlocks.BRONZE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_BRONZE_ORE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
