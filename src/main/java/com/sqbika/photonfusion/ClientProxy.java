package com.sqbika.photonfusion;

import com.sqbika.photonfusion.init.ModBlocks;
import com.sqbika.photonfusion.init.ModItems;
import com.sqbika.photonfusion.registry.F2Registry;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e)
	{
	}

	@Override
	public void init(FMLInitializationEvent e) {
	}

	@Override
    public void postInit(FMLPostInitializationEvent e) {    }

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		ModBlocks.register();
		ModItems.register();
	}


}
