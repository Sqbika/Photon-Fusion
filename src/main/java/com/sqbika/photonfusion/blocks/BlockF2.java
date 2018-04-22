package com.sqbika.photonfusion.blocks;

import com.sqbika.photonfusion.creativetab.CreativeTabF2;
import com.sqbika.photonfusion.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import com.sqbika.photonfusion.utility.ForgeDirection;
import com.sqbika.photonfusion.tileentity.*;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockF2 extends Block {

    private static String name;

	public BlockF2(Material materialIn, String name) {
		super(materialIn);
		this.name = name;
	}
	
	public BlockF2(String name)
	{
		super(Material.ROCK);
        this.name = name;
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
        this.setCreativeTab(CreativeTabF2.F2_TAB);
	}

    public String getName()
    {
        return name;
    }


	protected ForgeDirection orientation;

    @SideOnly(Side.CLIENT)
    public void registerRender(Block block) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getUnlocalizedName().substring(5), "inventory"));
    }

	
	
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entityLiving, ItemStack itemStack)
    {
        if (world.getTileEntity(pos) instanceof TileEntityF2)
        {
            int direction = 0;
            int facing = MathHelper.floor(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

            if (facing == 0)
            {
                direction = ForgeDirection.NORTH.ordinal();
            }
            else if (facing == 1)
            {
                direction = ForgeDirection.EAST.ordinal();
            }
            else if (facing == 2)
            {
                direction = ForgeDirection.SOUTH.ordinal();
            }
            else if (facing == 3)
            {
                direction = ForgeDirection.WEST.ordinal();
            }

            if (itemStack.hasDisplayName())
            {
                ((TileEntityF2) world.getTileEntity(pos)).setCustomName(itemStack.getDisplayName());
            }

            ((TileEntityF2) world.getTileEntity(pos)).setOrientation(direction);
        }
        super.onBlockPlacedBy(world, pos, state, entityLiving, itemStack);
    }
	
}
