package com.sqbika.photonfusion.blocks;

import com.sqbika.photonfusion.reference.Reference;
import com.sqbika.photonfusion.tileentity.TileEntitySolar_Collector;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Mr.Sqbika on 2016.01.12..
 */
public class Solar_Collector extends BlockF2 implements ITileEntityProvider{
    public Solar_Collector(){
        super("solarcollector");
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntitySolar_Collector();
    }

}
