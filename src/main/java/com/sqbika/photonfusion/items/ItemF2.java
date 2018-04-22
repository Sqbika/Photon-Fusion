package com.sqbika.photonfusion.items;

import com.sqbika.photonfusion.creativetab.CreativeTabF2;
import com.sqbika.photonfusion.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ItemF2 extends Item {

	public ItemF2(String name)
	{
		this.setUnlocalizedName(new ResourceLocation(Reference.MOD_ID, name).toString());
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		this.setCreativeTab(CreativeTabF2.F2_TAB);
	}

	@SideOnly(Side.CLIENT)
	public void registerRender(Item item){
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}


}
