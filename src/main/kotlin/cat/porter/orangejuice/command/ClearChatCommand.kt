package cat.porter.orangejuice.command

import cat.porter.orangejuice.OrangeJuice
import net.minecraft.client.Minecraft
import org.polyfrost.oneconfig.api.commands.v1.factories.annotated.Command

/**
 * An example command implementing the Command API of OneConfig.
 * Registered in ExampleMod.kt with `CommandManager.INSTANCE.registerCommand(new ExampleCommand());`
 *
 * @see Command
 * @see OrangeJuice
 */
@Command(value = ["clearchat", "cc"], description = "Clear's the game chat <F3> + D")
class ClearChatCommand {
	@Command
	fun handle() {
		Minecraft.getMinecraft().ingameGUI.chatGUI.clearChatMessages()
	}
}