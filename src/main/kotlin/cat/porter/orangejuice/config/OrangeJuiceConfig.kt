package cat.porter.orangejuice.config

import cat.porter.orangejuice.OrangeJuice
import cat.porter.orangejuice.hud.ExampleHud
import org.polyfrost.oneconfig.api.config.v1.Config
import org.polyfrost.oneconfig.api.config.v1.annotations.Keybind
import org.polyfrost.oneconfig.api.config.v1.annotations.Switch
import org.polyfrost.oneconfig.api.config.v1.annotations.Text
import org.polyfrost.oneconfig.api.ui.v1.keybind.KeybindManager.registerKeybind
import org.polyfrost.polyui.input.KeyBinder
import org.polyfrost.polyui.input.KeybindHelper
import org.polyfrost.universal.UKeyboard

/**
 * The main Config entrypoint that extends the Config type and initializes your config options.
 * See [this link](https://docsv1.polyfrost.org/configuration/available-options) for more config options
 */
object OrangeJuiceConfig : Config("${OrangeJuice.ID}.json", OrangeJuice.NAME, Category.QOL) {
    @Switch(title = "Toggle Sprint")
    var toggleSprint = false;
    var toggleSpringState = false;

    @Text(title = "SprintHud Text", placeholder = "Sprint enabled")
    var sprintHudText = "";

    @Keybind(
            title = "Toggle Sprint Keybind"
    )
    var toggleSprintBind: KeyBinder.Bind = KeybindHelper.builder().keys(UKeyboard.KEY_NONE).does {
        if(OrangeJuiceConfig.enabled && toggleSprint) {
            toggleSpringState = !toggleSpringState;
            OrangeJuiceConfig.save()
        }
    }.build()

    init {
        registerKeybind(toggleSprintBind);
        addCallback("sprintHudText") {
            ExampleHud.reload()
        };
    }
}