package net.degvelopment.excessiveores.datagen;

import net.degvelopment.excessiveores.block.ModBlocks;
import net.degvelopment.excessiveores.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    // ------------------------------------BRONZE SMELTABLES------------------------------------- //
    private static final List<ItemLike> BRONZE_SMELTABLES = List.of(ModItems.RAW_BRONZE.get(),
            ModBlocks.BRONZE_ORE.get(), ModBlocks.DEEPSLATE_BRONZE_ORE.get());
    // ------------------------------------------------------------------------------------------ //

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, BRONZE_SMELTABLES, RecipeCategory.MISC, ModItems.BRONZE_INGOT.get(), .25f, 200, "bronze"); // Raw Bronze smelting
        oreBlasting(pWriter, BRONZE_SMELTABLES, RecipeCategory.MISC, ModItems.BRONZE_INGOT.get(), .25f, 100, "bronze"); // Raw Bronze blasting

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BRONZE_BLOCK.get()) // Bronze Block recipe
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.BRONZE_INGOT.get())
                .unlockedBy(getHasName(ModItems.BRONZE_INGOT.get()), has(ModItems.BRONZE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BRONZE_SWORD.get()) // Bronze Sword recipe
                .pattern("#")
                .pattern("#")
                .pattern("$")
                .define('#', ModItems.BRONZE_INGOT.get())
                .define('$', Items.STICK)
                .unlockedBy(getHasName(ModItems.BRONZE_INGOT.get()), has(ModItems.BRONZE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BRONZE_PICKAXE.get()) // Bronze Pickaxe recipe
                .pattern("###")
                .pattern(" $ ")
                .pattern(" $ ")
                .define('#', ModItems.BRONZE_INGOT.get())
                .define('$', Items.STICK)
                .unlockedBy(getHasName(ModItems.BRONZE_INGOT.get()), has(ModItems.BRONZE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BRONZE_AXE.get()) // Bronze Axe recipe
                .pattern("##")
                .pattern("#$")
                .pattern(" $")
                .define('#', ModItems.BRONZE_INGOT.get())
                .define('$', Items.STICK)
                .unlockedBy(getHasName(ModItems.BRONZE_INGOT.get()), has(ModItems.BRONZE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BRONZE_SHOVEL.get()) // Bronze Shovel recipe
                .pattern("#")
                .pattern("$")
                .pattern("$")
                .define('#', ModItems.BRONZE_INGOT.get())
                .define('$', Items.STICK)
                .unlockedBy(getHasName(ModItems.BRONZE_INGOT.get()), has(ModItems.BRONZE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BRONZE_HOE.get()) // Bronze Hoe recipe
                .pattern("##")
                .pattern(" $")
                .pattern(" $")
                .define('#', ModItems.BRONZE_INGOT.get())
                .define('$', Items.STICK)
                .unlockedBy(getHasName(ModItems.BRONZE_INGOT.get()), has(ModItems.BRONZE_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BRONZE_INGOT.get(), 9) // Bronze Ingot recipe
                .requires(ModBlocks.BRONZE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.BRONZE_BLOCK.get()), has(ModBlocks.BRONZE_BLOCK.get()))
                .save(pWriter);

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }
}
