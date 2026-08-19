package dev.mayaqq.estrogen.datagen.impl.recipes.minecraft

import dev.mayaqq.estrogen.content.EstrogenBlocks
import dev.mayaqq.estrogen.content.EstrogenFluids
import dev.mayaqq.estrogen.content.EstrogenItems
import dev.mayaqq.estrogen.content.recipes.DreamCatcherDyeRecipe
import dev.mayaqq.estrogen.content.recipes.ThighHighDyeRecipe
import dev.mayaqq.estrogen.content.recipes.datagen.SpongingRecipeBuilder
import dev.mayaqq.estrogen.datagen.api.platform.Platform
import dev.mayaqq.estrogen.datagen.api.platform.PlatformRecipeHelper
import dev.mayaqq.estrogen.fabric.datagen.FabricForgeConditionsMap
import dev.mayaqq.estrogen.id
import dev.mayaqq.estrogen.recipes.conditions.VeganEstrogenEnabledCondition
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.advancements.Advancement
import net.minecraft.advancements.AdvancementHolder
import net.minecraft.advancements.CriteriaTriggers
import net.minecraft.advancements.critereon.ImpossibleTrigger
import net.minecraft.core.HolderLookup
import net.minecraft.data.recipes.*
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.ItemTags
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.Recipe
import java.util.concurrent.CompletableFuture

class EstrogenCraftingRecipes(output: FabricDataOutput, lookup: CompletableFuture<HolderLookup.Provider>, val helper: PlatformRecipeHelper) : FabricRecipeProvider(output, lookup) {
    override fun buildRecipes(output: RecipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EstrogenBlocks.ColonThreeBlock.value!!)
            .define('C', EstrogenItems.ColonThree)
            .define('E', Items.EGG)
            .pattern("CCC")
            .pattern("CEC")
            .pattern("CCC")
            .showNotification(false)
            .unlockedBy("never", CriteriaTriggers.IMPOSSIBLE.createCriterion(ImpossibleTrigger.TriggerInstance()))
            .save(output, id("colon_three_manual_only"))
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EstrogenBlocks.EstrogenPillBlock.value!!)
            .requires(EstrogenItems.EstrogenPill, 9)
            .unlockedBy(getHasName(EstrogenItems.EstrogenPill), has(EstrogenItems.EstrogenPill))
            .save(output)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EstrogenItems.EstrogenPill, 9)
            .requires(EstrogenBlocks.EstrogenPillBlock.value!!)
            .unlockedBy(getHasName(EstrogenBlocks.EstrogenPillBlock.value!!), has(EstrogenBlocks.EstrogenPillBlock.value!!))
            .save(output)
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EstrogenBlocks.CookieJar.value!!, 1)
            .define('G', helper.commonTag("glass_panes"))
            .define('Z', helper.commonTag("nuggets/iron"))
            .pattern("GZG")
            .pattern("G G")
            .pattern("GGG")
            .unlockedBy(getHasName(EstrogenItems.EstrogenChipCookie), has(EstrogenItems.EstrogenChipCookie))
            .save(output)
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EstrogenItems.ThighHighs, 1)
            .define('F', EstrogenItems.MothFuzz)
            .pattern("FFF")
            .pattern("F F")
            .pattern("F F")
            .unlockedBy(getHasName(EstrogenItems.MothFuzz), has(EstrogenItems.MothFuzz))
            .save(output)
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EstrogenBlocks.MothWool.value!!, 1)
            .define('F', EstrogenItems.MothFuzz)
            .pattern("FF")
            .pattern("FF")
            .unlockedBy(getHasName(EstrogenItems.MothFuzz), has(EstrogenItems.MothFuzz))
            .save(output)
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EstrogenBlocks.QuiltedMothWool.value!!, 4)
            .define('F', EstrogenBlocks.MothWool.value!!)
            .pattern("FF")
            .pattern("FF")
            .unlockedBy(getHasName(EstrogenBlocks.MothWool.value!!), has(EstrogenBlocks.MothWool.value!!))
            .save(output)
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EstrogenBlocks.MothCarpet.value!!, 3)
            .define('F', EstrogenBlocks.MothWool.value!!)
            .pattern("FF")
            .unlockedBy(getHasName(EstrogenBlocks.MothWool.value!!), has(EstrogenBlocks.MothWool.value!!))
            .save(output)
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EstrogenBlocks.QuiltedMothCarpet.value!!, 3)
            .define('F', EstrogenBlocks.QuiltedMothWool.value!!)
            .pattern("FF")
            .unlockedBy(getHasName(EstrogenBlocks.QuiltedMothWool.value!!), has(EstrogenBlocks.QuiltedMothWool.value!!))
            .save(output)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EstrogenItems.MothFuzz, 4)
            .requires(EstrogenBlocks.MothWool.value!!)
            .unlockedBy(getHasName(EstrogenBlocks.MothWool.value!!), has(EstrogenBlocks.MothWool.value!!))
            .save(output)
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, EstrogenBlocks.MothBed.value!!, 1)
            .define('M', EstrogenBlocks.MothWool.value!!)
            .define('W', ItemTags.PLANKS)
            .pattern("MMM")
            .pattern("WWW")
            .unlockedBy(getHasName(EstrogenBlocks.MothWool.value!!), has(EstrogenBlocks.MothWool.value!!))
            .save(output)
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, EstrogenBlocks.QuiltedMothBed.value!!, 1)
            .define('M', EstrogenBlocks.QuiltedMothWool.value!!)
            .define('W', ItemTags.PLANKS)
            .pattern("MMM")
            .pattern("WWW")
            .unlockedBy(getHasName(EstrogenBlocks.QuiltedMothWool.value!!), has(EstrogenBlocks.QuiltedMothWool.value!!))
            .save(output)
        SpecialRecipeBuilder.special(::ThighHighDyeRecipe)
            .save(output, "estrogen:thigh_high_dye")
        SpecialRecipeBuilder.special(::DreamCatcherDyeRecipe)
            .save(output, "estrogen:dreamcatcher_dye")
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, EstrogenBlocks.DreamCatcher.value!!, 1)
            .define('S', Items.STRING)
            .define('C', Items.COBWEB)
            .define('W', Items.STICK)
            .define('F', Items.FEATHER)
            .pattern("WSW")
            .pattern("WCW")
            .pattern("FFF")
            .unlockedBy(getHasName(Items.COBWEB), has(Items.COBWEB))
            .save(output)
        fun veganConditionAdapter(output: RecipeOutput) : RecipeOutput{
            when(helper.platform) {
                Platform.FABRIC -> {
                    return withConditions(output, VeganEstrogenEnabledCondition())
                }
                Platform.NEOFORGE -> {
                    return object : RecipeOutput {
                        override fun accept(
                            location: ResourceLocation,
                            recipe: Recipe<*>,
                            advancement: AdvancementHolder?
                        ) {
                            FabricForgeConditionsMap.addEmptyCondition(recipe,id("vegan_enabled"))
                            output.accept(location,recipe,advancement)
                        }

                        override fun advancement(): Advancement.Builder = output.advancement()
                    }
                }
                Platform.COMMON -> {}
            }
            return output
        }
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BREWING, EstrogenItems.SugarGoop.value!!,1)
            .requires(Items.SUGAR,1)
            .requires(Items.BEETROOT,2)
            .requires(Items.WHEAT,2)
            .unlockedBy(getHasName(Items.SUGAR),has(Items.SUGAR))
            .unlockedBy(getHasName(Items.BEETROOT),has(Items.BEETROOT))
            .unlockedBy(getHasName(Items.WHEAT),has(Items.WHEAT))
            .save(veganConditionAdapter(output))

        SpongingRecipeBuilder().setInput(EstrogenFluids.SugarySyrup.get())
            .setOutput(EstrogenFluids.FilteredSugarySyrups[0].get())
            .save(veganConditionAdapter(output))

        SpongingRecipeBuilder()
            .setInput(EstrogenFluids.FilteredSugarySyrups[0].get())
            .setOutput(EstrogenFluids.FilteredSugarySyrups[1].get())
            .save(veganConditionAdapter(output))
    }


}