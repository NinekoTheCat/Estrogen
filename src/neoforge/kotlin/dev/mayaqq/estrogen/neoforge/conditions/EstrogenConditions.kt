package dev.mayaqq.estrogen.neoforge.conditions

import com.mojang.serialization.MapCodec
import dev.mayaqq.estrogen.MOD_ID
import invoke.kitty.kritter.registry.api.Registrar
import invoke.kitty.kritter.registry.api.builder.entry
import invoke.kitty.kritter.registry.api.entry.RegistryEntry
import invoke.kitty.kritter.utils.ExperimentalRegistryApi
import net.neoforged.neoforge.common.conditions.ICondition
import net.neoforged.neoforge.registries.NeoForgeRegistries

object EstrogenConditions : Registrar<MapCodec<out ICondition>> by Registrar(MOD_ID, NeoForgeRegistries.Keys.CONDITION_CODECS) {
    val VeganEnabledCondition = condition("vegan_enabled", VeganEnabledCondition())
}
@OptIn(ExperimentalRegistryApi::class)
private fun EstrogenConditions.condition(name: String, condition: ICondition): RegistryEntry<MapCodec<out ICondition?>> {
    return this.entry(
        name = name,
        factory = {condition.codec()}
    )
}