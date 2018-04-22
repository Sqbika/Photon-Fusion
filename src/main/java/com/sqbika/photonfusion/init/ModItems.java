package com.sqbika.photonfusion.init;

import com.sqbika.photonfusion.items.Crystallised_Photon;

import com.sqbika.photonfusion.items.Photon_Container;
import com.sqbika.photonfusion.registry.F2Registry;
import com.sqbika.photonfusion.utility.ResourceLocationHelper;
import net.minecraft.client.renderer.block.model.ModelBakery;

public class ModItems {

	public static Crystallised_Photon crystalPhoton = new Crystallised_Photon();
	public static Photon_Container photonContainer = new Photon_Container();
	
	public static void init()
	{
		F2Registry.AddItemToRegistry(crystalPhoton);
		F2Registry.AddItemToRegistry(photonContainer);
	}

	public static void register()
	{
		crystalPhoton.registerRender(crystalPhoton);
		photonContainer.registerRender(photonContainer);
		//ModelBakery.registerItemVariants(photonContainer, ResourceLocationHelper.ToResourceLocation("item/photonNugget", "item/photonGem", "item/photonCircle", "item/photonHollowCircle", "item/photonCross", "item/photonContainer6", "item/photonContainer"));

	}
}
