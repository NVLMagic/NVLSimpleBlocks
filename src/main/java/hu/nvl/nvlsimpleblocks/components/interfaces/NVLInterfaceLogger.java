package hu.nvl.nvlsimpleblocks.components.interfaces;
/* ------------------------------------------------------------------------------------------------------------------
 * NVLInterfaceLogger by NVL 2019
 * 
 * v190304: Add getLocalTextBare
 * ------------------------------------------------------------------------------------------------------------------ */

import hu.nvl.nvlsimpleblocks.NVLSimpleBlocks;
import net.minecraft.network.chat.Component;

public interface NVLInterfaceLogger {
	default void logLine(String msg) {
		if (NVLSimpleBlocks.nvlLogger != null) NVLSimpleBlocks.nvlLogger.logLine(this.getClass().getSimpleName(), msg);
		else NVLSimpleBlocks.LOGGER.debug(this.getClass().getSimpleName() + ":" + msg);
	}
	default Component getLocalTextBare(String key) { return Component.translatable(key); }
	default Component getLocalTextNoClass(String key) { return getLocalTextBare(NVLSimpleBlocks.MODID+"."+key); }
	default Component getLocalText(String text) { return getLocalTextNoClass(this.getClass().getSimpleName()+"."+text); }
	default Component mergeComponents(Component ... args) {
		StringBuilder s = new StringBuilder();
		for (Component c : args) s.append(c.getString());
		return Component.literal(s.toString());
	}
}