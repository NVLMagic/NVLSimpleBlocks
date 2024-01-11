package hu.nvl.nvlsimpleblocks;

import com.mojang.logging.LogUtils;
import hu.nvl.nvlsimpleblocks.Setup.Client_only.ClientRegistration;
import hu.nvl.nvlsimpleblocks.Setup.Registration;
import hu.nvl.nvlsimpleblocks.components.modules.NVLModuleLogger;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NVLSimpleBlocks.MODID)
public class NVLSimpleBlocks
{
    public static final String MODID = "nvlsimpleblocks";
    public static final String TOOLSTAB = "nvl_tools_tab";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static NVLModuleLogger nvlLogger = new NVLModuleLogger(MODID);

    public NVLSimpleBlocks()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the commonSetup method for modloading
        Registration.Init();
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        // Register the items to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        ClientRegistration.AddCreative(event);
    }
}
