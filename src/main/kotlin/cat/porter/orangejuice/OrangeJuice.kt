package cat.porter.orangejuice

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import cat.porter.orangejuice.command.GuiCommand
import cat.porter.orangejuice.config.OrangeJuiceConfig
import cat.porter.orangejuice.hud.ExampleHud
import cat.porter.orangejuice.hud.HelloHud
import org.polyfrost.oneconfig.api.commands.v1.CommandManager
import org.polyfrost.oneconfig.api.event.v1.events.TickEvent
import org.polyfrost.oneconfig.api.event.v1.invoke.impl.Subscribe
import org.polyfrost.oneconfig.api.hud.v1.HudManager
import org.polyfrost.polyui.PolyUI
import org.polyfrost.universal.UChat
import org.polyfrost.universal.UKeyboard

/**
 * The entrypoint of the Example Mod which initializes it.
 * This is what is run when the game is started and typically how your mod will set up its functionality.
 *
 * @see Mod
 */
@Mod(modid = OrangeJuice.ID, name = OrangeJuice.NAME, version = OrangeJuice.VERSION, modLanguageAdapter = "org.polyfrost.oneconfig.utils.v1.forge.KotlinLanguageAdapter")
object OrangeJuice {

    // Sets the variables from `gradle.properties`. Depends on the `bloom` DGT plugin.
    const val ID = "@MOD_ID@"
    const val NAME = "@MOD_NAME@"
    const val VERSION = "@MOD_VERSION@"

    init {
        OrangeJuiceConfig
    }

    // Register the config and commands.
    @Mod.EventHandler
    fun onInit(event: FMLInitializationEvent) {
//        OrangeJuiceConfig.preload()
        HudManager.register(ExampleHud);
        HudManager.register(HelloHud());
        CommandManager.registerCommand(GuiCommand())
    }

    @Subscribe
    fun onTick(event: TickEvent.Start) {
        if(UKeyboard.isKeyDown((OrangeJuiceConfig.toggleSprintBind.keys?.get(0) ?: UKeyboard.KEY_N) as Int)) {
            UChat.chat("down")
        }
    }
}