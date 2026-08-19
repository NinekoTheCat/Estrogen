package dev.mayaqq.estrogen.fabric.datagen

import dev.mayaqq.cynosure.utils.json.toGson
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.put
import net.minecraft.resources.ResourceLocation
import java.util.IdentityHashMap

object FabricForgeConditionsMap {
    val forgeConditionsMap = IdentityHashMap<Any, ArrayList<ResourceLocation>>()
    fun addEmptyCondition(recipe: Any,location: ResourceLocation) {
        forgeConditionsMap.getOrPut(recipe) { ArrayList() }.add(location)
    }
    fun consumeEmptyCondition(recipe: Any): ArrayList<ResourceLocation>? {
        return forgeConditionsMap.remove(recipe)
    }
    fun addEmptyConditions(recipe: com.google.gson.JsonObject, conditions: Collection<ResourceLocation>) {
        val conditions = conditions.map { buildJsonObject {
            put("type",it.toString())
        } }
        if (!recipe.has("neoforge:conditions")) {
           recipe.add("neoforge:conditions", com.google.gson.JsonArray())
        }
        conditions.forEach { recipe["neoforge:conditions"].asJsonArray.add(it.toGson()) }
    }
}