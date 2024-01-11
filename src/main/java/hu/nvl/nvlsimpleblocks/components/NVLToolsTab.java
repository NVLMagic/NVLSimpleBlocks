package hu.nvl.nvlsimpleblocks.components;

import hu.nvl.nvlsimpleblocks.NVLSimpleBlocks;
import hu.nvl.nvlsimpleblocks.Setup.NVLItemRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.fml.loading.LoadingModList;
import net.minecraftforge.fml.loading.moddiscovery.ModInfo;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class NVLToolsTab {
	public static final String tab_domain = "nvlcommon";
	public static DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "nvlcommon");
	public static RegistryObject<CreativeModeTab> NVL_TOOLS_TAB =
			CREATIVE_MODE_TABS.register(NVLSimpleBlocks.TOOLSTAB,
					() -> CreativeModeTab.builder()
							.icon(() -> new ItemStack(NVLItemRegistry.Item_Logo.get()))
							.title(Component.translatable("creativetabs."+tab_domain+"."+NVLSimpleBlocks.TOOLSTAB))
							.build());

	public static void register(IEventBus bus) {
		boolean found = false;
		boolean register = false;
		LoadingModList m = FMLLoader.getLoadingModList();
		List<ModInfo> l = m.getMods();
		for (ModInfo i: l){
	//		NVLSimpleBlocks.nvlLogger.logLine("TabRegistry", "MODList:"+i.getModId());
			if (i.getModId().startsWith("nvl") && !found) {
				if (!i.getModId().equals(NVLSimpleBlocks.MODID)) {
					NVLSimpleBlocks.nvlLogger.logLine("TabRegistry", "Found:" + i.getModId());
				} else {
					NVLSimpleBlocks.nvlLogger.logLine("TabRegistry", "Found myself");
					register = true;
				}
				found = true;
			}
		}
		if (register) {
			NVLSimpleBlocks.nvlLogger.logLine("TabRegistry", "Registering creative tab");
			CREATIVE_MODE_TABS.register(bus);
		} else {
			NVLSimpleBlocks.nvlLogger.logLine("TabRegistry", "Tab already found. Do not register it again.");
		}
	}
}
