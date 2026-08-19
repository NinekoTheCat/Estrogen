package dev.mayaqq.estrogen.recipes.conditions

import com.mojang.serialization.MapCodec
import dev.mayaqq.estrogen.id
import invoke.kitty.kritter.registry.api.Registrar
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions


object EstrogenResourceConditions{
    private fun <T : ResourceCondition?> createResourceConditionType(
        name: String,
        codec: MapCodec<T?>
    ): ResourceConditionType<T?> {
        return ResourceConditionType.create<T?>(id(name), codec)
    }
    val VEGAN_ENABLED_CONDITION = createResourceConditionType("vegan_enabled", VeganEstrogenEnabledCondition.CODEC)
    fun register() {
        ResourceConditions.register(VEGAN_ENABLED_CONDITION)
    }
}