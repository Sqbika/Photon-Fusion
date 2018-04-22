package com.sqbika.photonfusion.crafting;

import com.sqbika.photonfusion.reference.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingHelper {

    private static ResourceLocation ShapedGroup = new ResourceLocation(Reference.MOD_ID, "shaped");
    private static ResourceLocation ShapelessGroup = new ResourceLocation(Reference.MOD_ID, "shapeless");


    public static void RegisterShapedRecipe(String name, ItemStack output,Object[] input) {
        GameRegistry.addShapedRecipe(new ResourceLocation(Reference.MOD_ID, name),  ShapedGroup, output, input);
    }

    public static void RegisterShapelessRecipe(String name, ItemStack output, Object[] input) {
        GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID, name), ShapelessGroup, output, ToIngredient(input));
    }

    public static void RegisterShapelessRecipe(String name, ItemStack output, Object input) {
        GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID, name), ShapelessGroup, output, ToIngredient(input));
    }

    public static Ingredient[] ToIngredient(Object... input) {
        Ingredient[] result = new Ingredient[input.length];
        for (int i = 0; i < input.length; i++) {
                if (input[i] instanceof  String) result[i] = Ingredient.fromItem(ForgeRegistries.ITEMS.getValue(new ResourceLocation((String)input[i])));
                if (input[i] instanceof  ItemStack) result[i] = Ingredient.fromStacks((ItemStack)input[i]);
                if (input[i] instanceof Item) result[i] = Ingredient.fromItem((Item)input[i]);
        }
        return result;
    }
}
