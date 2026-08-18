package dev.mayaqq.estrogen.datagen.impl.models

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.models.BlockModelGenerators
import net.minecraft.data.models.ItemModelGenerators

class EstrogenModels(output: FabricDataOutput)  : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockModelGenerators: BlockModelGenerators) {
    }

    override fun generateItemModels(itemModelGenerators: ItemModelGenerators?) {
    }
}