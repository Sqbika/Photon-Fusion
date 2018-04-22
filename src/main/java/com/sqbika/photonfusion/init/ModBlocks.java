package com.sqbika.photonfusion.init;

import com.sqbika.photonfusion.blocks.*;

import com.sqbika.photonfusion.registry.F2Registry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static Solar_Collector solarCollector = new Solar_Collector();

	public static void init()
	{
		F2Registry.AddBlockToRegistry(solarCollector);
	}

	public static void register()
	{
		solarCollector.registerRender(solarCollector);
	}
}
