package dev.mayaqq.estrogen.recipes.conditions

import com.mojang.serialization.MapCodec
import dev.mayaqq.estrogen.config.EstrogenCommonConfig
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType
import net.minecraft.core.HolderLookup


class VeganEstrogenEnabledCondition : ResourceCondition {
    companion object {
        val CODEC = MapCodec.unit(::VeganEstrogenEnabledCondition)
    }
    override fun getType(): ResourceConditionType<*> = EstrogenResourceConditions.VEGAN_ENABLED_CONDITION

    override fun test(provider: HolderLookup.Provider?): Boolean =
        EstrogenCommonConfig.Experimental.VeganEstrogen.enabled
}
