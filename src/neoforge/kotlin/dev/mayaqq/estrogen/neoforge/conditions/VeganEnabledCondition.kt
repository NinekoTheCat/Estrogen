package dev.mayaqq.estrogen.neoforge.conditions

import com.mojang.serialization.MapCodec
import dev.mayaqq.estrogen.config.EstrogenCommonConfig
import net.neoforged.neoforge.common.conditions.ICondition

class VeganEnabledCondition : ICondition {
    override fun test(iContext: ICondition.IContext): Boolean = EstrogenCommonConfig.Experimental.VeganEstrogen.enabled
    override fun codec(): MapCodec<out ICondition?> = MapCodec.unit(::VeganEnabledCondition)
}