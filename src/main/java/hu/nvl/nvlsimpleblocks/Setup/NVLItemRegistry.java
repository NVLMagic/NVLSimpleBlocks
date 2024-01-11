package hu.nvl.nvlsimpleblocks.Setup;

import hu.nvl.nvlsimpleblocks.Items.NVLItemLogo;
import hu.nvl.nvlsimpleblocks.NVLSimpleBlocks;
import hu.nvl.nvlsimpleblocks.components.base_classes.NVLItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NVLItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NVLSimpleBlocks.MODID);
    public static final RegistryObject<Item> Item_Logo = ITEMS.register("nvl_item_logo", NVLItemLogo::new);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
    public static void AddCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().location().getPath().equals(NVLSimpleBlocks.TOOLSTAB)) {
            for (RegistryObject<Item> e :ITEMS.getEntries()) {
                if (e.get() instanceof NVLItem && ((NVLItem) e.get()).getRegisterCreativeTab()) event.accept(e);
            }
        }
    }

}
