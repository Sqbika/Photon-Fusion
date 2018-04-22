package com.sqbika.photonfusion.items;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.sqbika.photonfusion.Main;
import com.sqbika.photonfusion.creativetab.CreativeTabF2;
import com.sqbika.photonfusion.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Mr.Sqbika on 2016.01.12..
 */
public class Photon_Container extends ItemF2 {

    public Photon_Container() {
        super("photoncontainer");
        this.setMaxStackSize(1);
        this.setHasSubtypes(true);
        this.setCreativeTab(CreativeTabF2.F2_TAB);
    }

    @Override
    public void registerRender(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(item, 6, new ModelResourceLocation(Reference.MOD_ID + ":photoncontainer", "inventory"));
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":photonnugget", "inventory"));
        ModelLoader.setCustomModelResourceLocation(item, 1, new ModelResourceLocation(Reference.MOD_ID + ":photongem", "inventory"));
        ModelLoader.setCustomModelResourceLocation(item, 2, new ModelResourceLocation(Reference.MOD_ID + ":photoncircle", "inventory"));
        ModelLoader.setCustomModelResourceLocation(item, 3, new ModelResourceLocation(Reference.MOD_ID + ":photonhollowcircle", "inventory"));
        ModelLoader.setCustomModelResourceLocation(item, 4, new ModelResourceLocation(Reference.MOD_ID + ":photoncross", "inventory"));
        ModelLoader.setCustomModelResourceLocation(item, 5, new ModelResourceLocation(Reference.MOD_ID + ":photoncontainer6", "inventory"));
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item." + Reference.MOD_ID +":"+ getNameByMetadata(stack.getItemDamage());
    }

    private String getNameByMetadata(int damage){
        switch (damage) {
            case 0:
                return "photonnugget";
            case 1:
                return "photongem";
            case 2:
                return "photoncircle";
            case 3:
                return "photonhollowcircle";
            case 4:
                return "photoncross";
            case 5:
                return "photoncontainer6";
            case 6:
                return "photoncontainer_1";
            default:
                return "errorMETADATAnotFOUND"; //IMPOUSSIBLE TO GUT HERE
        }
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!stack.hasTagCompound())
        {
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setDouble("photonStored", 0);
            nbt.setDouble("maxPhoton", getMax(stack.getItemDamage()));
            nbt.setBoolean("PhotonContainer", true);
            stack.setTagCompound(nbt);
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        if (stack.hasTagCompound()){
            if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
            {
                tooltip.add(ChatFormatting.YELLOW + "Energy Stored: " + stack.getTagCompound().getDouble("photonStored") + "/" + getMax(stack.getItemDamage()));
            }
            else
            {
                tooltip.add(ChatFormatting.GRAY + "SHIFT is the key to knowledge.");
            }
        }
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
        if (tab.getTranslatedTabLabel().equals(CreativeTabF2.F2_TAB.getTranslatedTabLabel()))
        for (int x = 0; x < 7; x++)
        {
            items.add(new ItemStack(this, 1, x));
        }
    }

    private float getMax(int damage)
    {
        switch (damage){
            case 0:
                return 1000;
            case 1:
                return 25000;
            case 2:
                return 100000;
            case 3:
                return 250000;
            case 4:
                return 500000;
            case 5:
                return 1000000;
            case 6:
                return Float.MAX_VALUE;
        }
        return -1;
    }



}
