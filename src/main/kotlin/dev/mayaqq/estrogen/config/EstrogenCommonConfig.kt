package dev.mayaqq.estrogen.config

import dev.mayaqq.estrogen.MOD_ID
import invoke.kitty.kritter.config.api.ConfigCategory
import invoke.kitty.kritter.config.api.SyncedConfig
import invoke.kitty.kritter.config.formats.Json5Format
import invoke.kitty.kritter.config.validation.types.range

object EstrogenCommonConfig : SyncedConfig("$MOD_ID/common", Json5Format.Default) {

    object Dash : ConfigCategory(comment = "Settings for the dash effect") {

        val enabled by field(true) {
            comment = "Enable dash from the Effect of Estrogen"
        }

        val deltaModifier by field(2.0) {
            comment = "The multiplier for the dash delta movement"
            range = 0.0..100.0
        }

    }

    object Recipes : ConfigCategory(comment = "Recipe* Configuration") {
        val cauldronInteractions by field(true) {
            comment = "Enable Cauldron Interactions"
        }
    }

    object Durations : ConfigCategory(comment = "Settings for the durations of effects") {

        val estrogenPillDuration by field(6000) {
            comment = "How long does Girl Power from the Estrogen Pill last in ticks"
        }

        val crystalEstrogenPillDuration by field(6000) {
            comment = "How long does Girl Power from the Crystal Estrogen Pill last in ticks"
        }

        val estrogenChipCookieDuration by field(6000) {
            comment = "How long does Girl Power from the Estrogen Chip Cookie last in ticks"
        }
    }

    object Experimental : ConfigCategory(comment = "Settings which trigger experimental features") {
        object VeganEstrogen : ConfigCategory(comment = "Vegan Estrogen Settings") {
            val enabled: Boolean by field(false) {
                comment = "Enable/Disable vegan estrogen production chain, needs `/reload` to take effect."

//            onChanged {
//                if (lastValue == enableVeganEstrogen) {
//                    return@onChanged
//                }
//                lastValue = enableVeganEstrogen
//
//                serverOnly {
//                    runAfterServerTicks(0) {
//                        if ((reloadingFuture?.isDone ?: true)) {
//                            reloadingFuture = it.reloadResources(listOf("estrogen"))
//                        }
//
//
//                    }
//                }
//                clientOnly {
//                    if ((reloadingFuture?.isDone ?: true)) {
//                        reloadingFuture =
//                            Minecraft.getInstance()?.singleplayerServer?.reloadResources(listOf("estrogen"))
//                    }
//                }
//            }
//
//            }
//        }
                // fix? it bricks the save, the reload I mean
            }
        }

    }
}

//private var lastValue = EstrogenCommonConfig.Experimental.enableVeganEstrogen
//private var reloadingFuture : CompletableFuture<Void>?= null
