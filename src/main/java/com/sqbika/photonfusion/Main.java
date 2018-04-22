package com.sqbika.photonfusion;

import com.sqbika.photonfusion.reference.Reference;
import com.sqbika.photonfusion.registry.RecipeRegistry;
import com.sqbika.photonfusion.init.ModBlocks;
import com.sqbika.photonfusion.init.ModItems;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {
	
	public static final String MODID = Reference.MOD_ID;
	public static final String MODNAME = Reference.MOD_NAME;
	public static final String VERSION = Reference.VERSION;

	@Instance(value = MODID)
	public static Main instance;
	
	@SidedProxy(modId = MODID, clientSide="com.sqbika.photonfusion.ClientProxy")
	public static CommonProxy proxy;
	

	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		ModBlocks.init();
		ModItems.init();



		proxy.preInit(e);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		RecipeRegistry.initShapedRecipes();
		RecipeRegistry.initShapelessRecipes();
		RecipeRegistry.initFurnaceRecipes();
		proxy.init(e);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		proxy.postInit(e);
	}
}


