package com.sqbika.photonfusion.creativetab;

import com.sqbika.photonfusion.Main;
import com.sqbika.photonfusion.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabF2 {
	public static final CreativeTabs F2_TAB = new CreativeTabs(Main.MODID)
			{
				@Override
				public String getTranslatedTabLabel()
				{
					return "Photon Fusion";
				}

				@Override
				public ItemStack getTabIconItem() {
					return new ItemStack(ModItems.crystalPhoton, 1);
				}
			};
}
