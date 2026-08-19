package dev.mayaqq.estrogen.fabric.mixins.datagen;

import com.google.gson.JsonObject;
import dev.mayaqq.estrogen.fabric.datagen.FabricForgeConditionsMap;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.concurrent.CompletableFuture;

@Mixin(targets = "net/fabricmc/fabric/api/datagen/v1/provider/FabricRecipeProvider$2")
public abstract class FabricDataGenHelperMixin {
    @Inject(method = "accept(Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/world/item/crafting/Recipe;Lnet/minecraft/advancements/AdvancementHolder;)V", at = @At(value = "INVOKE", target = "Lnet/fabricmc/fabric/impl/datagen/FabricDataGenHelper;consumeConditions(Ljava/lang/Object;)[Lnet/fabricmc/fabric/api/resource/conditions/v1/ResourceCondition;"), locals = LocalCapture.CAPTURE_FAILHARD)
    public void estrogen_Consume(ResourceLocation location, Recipe<?> recipe, AdvancementHolder advancement, CallbackInfo ci, RegistryOps registryOps, JsonObject recipeJson){
        var consumed = FabricForgeConditionsMap.INSTANCE.consumeEmptyCondition(recipe);
        if (consumed == null) return;
        FabricForgeConditionsMap.INSTANCE.addEmptyConditions(recipeJson,consumed);
    }
}
