package onebeastchris;

import net.fabricmc.api.ModInitializer;
import onebeastchris.util.ConfigUtil;
import onebeastchris.util.Register;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class visitors implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("visitors");

	public static ConfigUtil config = new ConfigUtil();

	@Override
	public void onInitialize() {
		LOGGER.info("Loading visitors");
		Register.registerAll();
	}
}