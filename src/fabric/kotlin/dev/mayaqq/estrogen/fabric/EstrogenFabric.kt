@file:JvmName("EstrogenFabric")
package dev.mayaqq.estrogen.fabric

import dev.mayaqq.estrogen.content.EstrogenFluids
import dev.mayaqq.estrogen.content.items.MothElytraItem
import dev.mayaqq.estrogen.recipes.conditions.EstrogenResourceConditions
import invoke.kitty.kritter.events.InitEvent
import invoke.kitty.kritter.events.LateInitEvent
import net.fabricmc.fabric.api.entity.event.v1.EntityElytraEvents
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.ElytraItem.isFlyEnabled

fun init() {
    LateInitEvent.subscribe { EstrogenFluids.fluidRegistry.init() }
    EntityElytraEvents.CUSTOM.register { entity, elytraTick ->
        val stack = entity.getItemBySlot(EquipmentSlot.CHEST)
        if (stack.item is MothElytraItem) isFlyEnabled(stack) else false
    }
    InitEvent.subscribe {
        EstrogenResourceConditions.register()
    }
}