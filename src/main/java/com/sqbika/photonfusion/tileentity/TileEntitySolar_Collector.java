package com.sqbika.photonfusion.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;

/**
 * Created by Mr.Sqbika on 2016.01.12..
 */
public class TileEntitySolar_Collector  extends TileEntityF2 implements IItemHandlerModifiable {

    public static double photonCollected = 0;
    public static final double MAXPHOTON = 1000000;

    public static final int CHARGE_INVENTORY_INDEX = 0;

    public ItemStack chargingSlot;

    public TileEntitySolar_Collector() {

    }

    @Override
    public int getSlots() {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return chargingSlot;
    }

    @Nonnull
    @Override
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
        if (!chargingSlot.isEmpty()) {
          if (chargingSlot.isItemEqual(stack)) {
            if (chargingSlot.isStackable()) {
                int sizes = chargingSlot.getCount() + stack.getCount();
                chargingSlot.setCount(MathHelper.floor(sizes / chargingSlot.getMaxStackSize()));
                stack.setCount(sizes % chargingSlot.getMaxStackSize());
                return stack;
            } else {
                ItemStack output = chargingSlot;
                chargingSlot = stack;
                return output;
            }
        } else {
            ItemStack output = chargingSlot;
            chargingSlot = stack;
            return output;
        }}
        else {
            chargingSlot = stack;
            return ItemStack.EMPTY;
        }
    }

    @Nonnull
    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        if (chargingSlot.isEmpty()) {
            return ItemStack.EMPTY;
        } else {
            if (chargingSlot.getCount() - amount <= 0) {
                ItemStack output = chargingSlot;
                chargingSlot = ItemStack.EMPTY;
                return output;
            } else {
                chargingSlot.setCount(chargingSlot.getCount() - amount);
                ItemStack result = chargingSlot.copy();
                result.setCount(amount);
                return result;
            }
        }
    }

    @Override
    public int getSlotLimit(int slot) {
        return 1;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbtTagCompound){
        super.writeToNBT(nbtTagCompound);
        chargingSlot.writeToNBT(nbtTagCompound);
        nbtTagCompound.setDouble("buffer", photonCollected);
        return nbtTagCompound;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
        photonCollected = nbtTagCompound.getDouble("buffer");
    }

    public String getName() {
        return "photonCollector";
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TextComponentString("Solar Collector");
    }

    @Override
    public void setStackInSlot(int slot, @Nonnull ItemStack stack) {
        chargingSlot = stack;
    }
}
