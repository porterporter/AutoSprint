package cat.porter.orangejuice.hud

import cat.porter.orangejuice.config.OrangeJuiceConfig
import org.polyfrost.oneconfig.api.hud.v1.TextHud

class ExampleHud : TextHud("", "") {
    public override fun category() = Category.PLAYER;
    public override fun title() = "SprintHud";
    override fun getText(): String? {
        hidden = !OrangeJuiceConfig.toggleSpringState;
        if(OrangeJuiceConfig.sprintHudText.isBlank()) {
            sb.append("§7Sprint enabled");
            return null;
        }
        sb.append(OrangeJuiceConfig.sprintHudText.replace("&", "§"))
        return null;
    }
}