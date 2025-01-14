package cat.porter.orangejuice.command

import cat.porter.orangejuice.OrangeJuice
import cat.porter.orangejuice.config.OrangeJuiceConfig
import org.polyfrost.oneconfig.api.commands.v1.factories.annotated.Command
import org.polyfrost.oneconfig.utils.v1.dsl.openUI

/**
 * An example command implementing the Command API of OneConfig.
 * Registered in ExampleMod.kt with `CommandManager.INSTANCE.registerCommand(new ExampleCommand());`
 *
 * @see Command
 * @see OrangeJuice
 */
@Command(value = [OrangeJuice.ID], description = "Access the ${OrangeJuice.NAME} GUI.")
class GuiCommand {
	@Command
	fun handle() {
		OrangeJuiceConfig.openUI()
	}
}