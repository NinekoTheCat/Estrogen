package dev.mayaqq.estrogen.content.recipes.datagen

import dev.mayaqq.estrogen.content.recipes.SpongingRecipe
import invoke.kitty.kritter.utils.Either
import net.minecraft.advancements.*
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger
import net.minecraft.data.recipes.RecipeBuilder
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.material.Fluid

class SpongingRecipeBuilder : RecipeBuilder {
    private var input : Either<Fluid, TagKey<Fluid>>? = null
    private var output: Fluid? = null

    fun setInput(input: Fluid): SpongingRecipeBuilder {
        this.input = Either.Left(input)
        return this
    }
    fun setInput(input: TagKey<Fluid>): SpongingRecipeBuilder {
        this.input = Either.Right(input);
        return this
    }
    fun setOutput(output: Fluid): SpongingRecipeBuilder {
        this.output = output;
        return this
    }

    override fun unlockedBy(
        p0: String,
        p1: Criterion<*>
    ): SpongingRecipeBuilder {
        return this
    }

    override fun group(groupName: String?): SpongingRecipeBuilder {
        return this
    }

    override fun getResult(): Item {
        return output!!.bucket.asItem()
    }

    override fun save(p0: RecipeOutput, p1: ResourceLocation) {
        val advancementBuilder: Advancement.Builder = p0.advancement()
            .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(p1))
            .rewards(AdvancementRewards.Builder.recipe(p1))
            .requirements(AdvancementRequirements.Strategy.OR)
        val input = this.input;
        val output = this.output;
        if (input == null) {
            throw Exception("Input has to be set!")
        }
        if (output == null) {
            throw Exception("Output has to be set!")
        }
        p0.accept(p1, SpongingRecipe(input,output.builtInRegistryHolder().key().location()),
            advancementBuilder.build(p1))
    }
}