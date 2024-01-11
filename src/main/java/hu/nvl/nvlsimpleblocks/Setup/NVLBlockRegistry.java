package hu.nvl.nvlsimpleblocks.Setup;

import hu.nvl.nvlsimpleblocks.NVLSimpleBlocks;
import hu.nvl.nvlsimpleblocks.components.interfaces.NVLInterfaceLogger;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.ArrayList;
public class NVLBlockRegistry implements NVLInterfaceLogger {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NVLSimpleBlocks.MODID);
	private static final ArrayList<RegistryObject<Block>> colored = new ArrayList<>();
	private static int registerColoredBlocks(String name, String code, Block source, boolean color) {
		RegistryObject<Block> stair = BLOCKS.register("nvl_block_"+code+"t"+name, () -> new StairBlock(source::defaultBlockState,BlockBehaviour.Properties.copy(source)));
		registerBlockItem("nvl_block_"+code+"t"+name, stair);
		if (color) colored.add(stair);
		RegistryObject<Block> slab = BLOCKS.register("nvl_block_"+code+"l"+name, () -> new SlabBlock(BlockBehaviour.Properties.copy(source)));
		registerBlockItem("nvl_block_"+code+"l"+name, slab);
		if (color) colored.add(slab);
		RegistryObject<Block> wall = BLOCKS.register("nvl_block_"+code+"w"+name, () -> new WallBlock(BlockBehaviour.Properties.copy(source).forceSolidOn()));
		registerBlockItem("nvl_block_"+code+"w"+name, wall);
		if (color) colored.add(wall);
		return 0;
	}
	public static final int NVL_Block_TS = registerColoredBlocks("","ts",Blocks.TERRACOTTA,false);
	public static final int NVL_Block_TB_Black = registerColoredBlocks("_black","ts",Blocks.BLACK_TERRACOTTA, true);
	public static final int NVL_Block_TB_White = registerColoredBlocks("_white","ts",Blocks.WHITE_TERRACOTTA, true);
	public static final int NVL_Block_TB_Brown = registerColoredBlocks("_brown","ts",Blocks.BROWN_TERRACOTTA, true);
	public static final int NVL_Block_TB_LGray = registerColoredBlocks("_light_gray","ts",Blocks.LIGHT_GRAY_TERRACOTTA, true);
	public static final int NVL_Block_TB_Gray = registerColoredBlocks("_gray","ts",Blocks.GRAY_TERRACOTTA, true);
	public static final int NVL_Block_TB_Red = registerColoredBlocks("_red","ts",Blocks.RED_TERRACOTTA, true);
	public static final int NVL_Block_TB_Orange = registerColoredBlocks("_orange","ts",Blocks.ORANGE_TERRACOTTA,true);
	public static final int NVL_Block_TB_Yellow = registerColoredBlocks("_yellow","ts",Blocks.YELLOW_TERRACOTTA,true);
	public static final int NVL_Block_TB_Lime = registerColoredBlocks("_lime","ts",Blocks.LIME_TERRACOTTA,true);
	public static final int NVL_Block_TB_Green = registerColoredBlocks("_green","ts",Blocks.GREEN_TERRACOTTA,true);
	public static final int NVL_Block_TB_Cyan = registerColoredBlocks("_cyan","ts",Blocks.CYAN_TERRACOTTA,true);
	public static final int NVL_Block_TB_LBlue = registerColoredBlocks("_light_blue","ts",Blocks.LIGHT_BLUE_TERRACOTTA,true);
	public static final int NVL_Block_TB_Blue = registerColoredBlocks("_blue","ts",Blocks.BLUE_TERRACOTTA,true);
	public static final int NVL_Block_TB_Purple = registerColoredBlocks("_purple","ts",Blocks.PURPLE_TERRACOTTA,true);
	public static final int NVL_Block_TB_Magenta = registerColoredBlocks("_magenta","ts",Blocks.MAGENTA_TERRACOTTA,true);
	public static final int NVL_Block_TB_Pink = registerColoredBlocks("_pink","ts",Blocks.PINK_TERRACOTTA,true);
	// ---------------- Concrete ----------------
	public static final int NVL_Block_CB_Black = registerColoredBlocks("_black","cs",Blocks.BLACK_CONCRETE, true);
	public static final int NVL_Block_CB_White = registerColoredBlocks("_white","cs",Blocks.WHITE_CONCRETE, true);
	public static final int NVL_Block_CB_Brown = registerColoredBlocks("_brown","cs",Blocks.BROWN_CONCRETE, true);
	public static final int NVL_Block_CB_LGray = registerColoredBlocks("_light_gray","cs",Blocks.LIGHT_GRAY_CONCRETE, true);
	public static final int NVL_Block_CB_Gray = registerColoredBlocks("_gray","cs",Blocks.GRAY_CONCRETE, true);
	public static final int NVL_Block_CB_Red = registerColoredBlocks("_red","cs",Blocks.RED_CONCRETE, true);
	public static final int NVL_Block_CB_Orange = registerColoredBlocks("_orange","cs",Blocks.ORANGE_CONCRETE,true);
	public static final int NVL_Block_CB_Yellow = registerColoredBlocks("_yellow","cs",Blocks.YELLOW_CONCRETE,true);
	public static final int NVL_Block_CB_Lime = registerColoredBlocks("_lime","cs",Blocks.LIME_CONCRETE,true);
	public static final int NVL_Block_CB_Green = registerColoredBlocks("_green","cs",Blocks.GREEN_CONCRETE,true);
	public static final int NVL_Block_CB_Cyan = registerColoredBlocks("_cyan","cs",Blocks.CYAN_CONCRETE,true);
	public static final int NVL_Block_CB_LBlue = registerColoredBlocks("_light_blue","cs",Blocks.LIGHT_BLUE_CONCRETE,true);
	public static final int NVL_Block_CB_Blue = registerColoredBlocks("_blue","cs",Blocks.BLUE_CONCRETE,true);
	public static final int NVL_Block_CB_Purple = registerColoredBlocks("_purple","cs",Blocks.PURPLE_CONCRETE,true);
	public static final int NVL_Block_CB_Magenta = registerColoredBlocks("_magenta","cs",Blocks.MAGENTA_CONCRETE,true);
	public static final int NVL_Block_CB_Pink = registerColoredBlocks("_pink","cs",Blocks.PINK_CONCRETE,true);

	private static void registerBlockItem(String name, RegistryObject<Block> block) {
		NVLItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}
	public static void register(IEventBus bus) {
		BLOCKS.register(bus);
	}
	public static void AddCreative(BuildCreativeModeTabContentsEvent event) {
	//	NVLSimpleBlocks.nvlLogger.logLine("BlockRegistry",event.getTabKey().location().getPath());
		if (event.getTabKey().location().getPath().equals(NVLSimpleBlocks.TOOLSTAB))
			for (RegistryObject<Block> e :BLOCKS.getEntries()) event.accept(e);
		// colored tab
		if (event.getTabKey().location().getPath().equals("colored_blocks"))
			for (RegistryObject<Block> e :colored) event.accept(e);
	}
}
