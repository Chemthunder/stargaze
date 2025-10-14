package silly.chemthunder.stargaze;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import silly.chemthunder.stargaze.index.StargazeItemGroup;
import silly.chemthunder.stargaze.index.StargazeItems;
import silly.chemthunder.stargaze.index.StargazeStatusEffects;

public class Stargaze implements ModInitializer {
	public static final String MOD_ID = "stargaze";
    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        StargazeItems.init();
        StargazeItemGroup.init();
        StargazeStatusEffects.init();

		LOGGER.info("buh");
	}
}