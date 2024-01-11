package hu.nvl.nvlsimpleblocks.Setup.Client_only;

import hu.nvl.nvlsimpleblocks.Setup.NVLBlockRegistry;
import hu.nvl.nvlsimpleblocks.Setup.NVLItemRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

public class ClientRegistration {
    public static void AddCreative(BuildCreativeModeTabContentsEvent event) {
        NVLItemRegistry.AddCreative(event);
        NVLBlockRegistry.AddCreative(event);
    }
}
