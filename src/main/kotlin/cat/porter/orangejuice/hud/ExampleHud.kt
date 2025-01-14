package cat.porter.orangejuice.hud

import cat.porter.orangejuice.config.OrangeJuiceConfig
import org.polyfrost.oneconfig.api.hud.v1.TextHud

object ExampleHud : TextHud("", "") {
    override fun category() = Category.PLAYER;
    override fun title() = "SprintHud";
    override fun getText(): String? {
        hidden = !OrangeJuiceConfig.toggleSpringState;
        if(OrangeJuiceConfig.sprintHudText.isBlank()) {
            sb.append("§7Sprint enabled");
            return null;
        }
        sb.append(OrangeJuiceConfig.sprintHudText.replace("&", "§"))
        return null;
    }

     fun reload() {
        if (update()) getBackground()?.recalculate()
    }
}