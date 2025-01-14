package cat.porter.orangejuice.hud

import org.polyfrost.oneconfig.api.hud.v1.TextHud

class HelloHud : TextHud("", "") {
    public override fun category() = Category.INFO;
    public override fun title() = "HelloHud";
    override fun getText(): String? {
       sb.append("Hello World!")
        return null
    }
}