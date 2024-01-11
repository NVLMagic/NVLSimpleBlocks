package hu.nvl.nvlsimpleblocks.Setup;

import hu.nvl.nvlsimpleblocks.components.NVLToolsTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class Registration {
    public static void Init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        NVLItemRegistry.register(bus);
        NVLBlockRegistry.register(bus);
        NVLToolsTab.register(bus);
    }
}
