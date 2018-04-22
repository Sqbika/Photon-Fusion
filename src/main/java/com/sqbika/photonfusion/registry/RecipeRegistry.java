package com.sqbika.photonfusion.registry;

import com.sqbika.photonfusion.crafting.CraftingHelper;
import com.sqbika.photonfusion.init.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Sqbika on 2016. 01. 15..
 */
public class RecipeRegistry {
    public static void initShapedRecipes(){
        CraftingHelper.RegisterShapedRecipe("photonContainer", new ItemStack(ModItems.photonContainer, 1, 0), new Object[] {
                "AAA",
                "ABA",
                "AAA",
                'A', ModItems.crystalPhoton, 'B', Items.DIAMOND
        });
    }

    public static void initShapelessRecipes(){
        CraftingHelper.RegisterShapelessRecipe("photonContainer", new ItemStack(ModItems.photonContainer, 1, 1), new ItemStack(ModItems.photonContainer, 1, 0));
        CraftingHelper.RegisterShapelessRecipe("photonContainer", new ItemStack(ModItems.photonContainer, 1, 2), new ItemStack(ModItems.photonContainer, 1, 1));
        CraftingHelper.RegisterShapelessRecipe("photonContainer", new ItemStack(ModItems.photonContainer, 1, 3), new ItemStack(ModItems.photonContainer, 1, 2));
        CraftingHelper.RegisterShapelessRecipe("photonContainer", new ItemStack(ModItems.photonContainer, 1, 4), new ItemStack(ModItems.photonContainer, 1, 3));
        CraftingHelper.RegisterShapelessRecipe("photonContainer", new ItemStack(ModItems.photonContainer, 1, 5), new ItemStack(ModItems.photonContainer, 1, 4));
        CraftingHelper.RegisterShapelessRecipe("photonContainer", new ItemStack(ModItems.photonContainer, 1, 6), new ItemStack(ModItems.photonContainer, 1, 5));
    }

    public static void initFurnaceRecipes(){

    }
}
