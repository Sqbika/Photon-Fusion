package com.sqbika.photonfusion;

import com.sqbika.photonfusion.gui.inventory.F2GuiHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent e)
	{
		
	}
	

	public void init(FMLInitializationEvent e)
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new F2GuiHandler());
	}
	

	public void postInit(FMLPostInitializationEvent e)
	{
		
	}
}
