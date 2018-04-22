package com.sqbika.photonfusion.registry;


import com.sqbika.photonfusion.reference.Reference;
import com.sqbika.photonfusion.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class F2Registry {
    private static List<Item> itemsToRegister;
    private static List<Block> blocksToRegister;
    private static List<SoundEvent> soundsToRegister;
    private static List<Potion> potionsToRegister;
    private static List <Biome> biomesToRegister;
    private static List<Enchantment> enchantmentsToRegister;

    public static List<Item> GetItemsToRegister() {
        if (itemsToRegister == null) itemsToRegister = new ArrayList<>();
        return itemsToRegister;
    }

    public static List<Block> GetBlocksToRegister() {
        if (blocksToRegister == null) blocksToRegister = new ArrayList<>();
        return blocksToRegister;
    }

    public static List<SoundEvent> GetSoundsToRegister() {
        if (soundsToRegister == null) soundsToRegister = new ArrayList<>();
        return soundsToRegister;
    }

    public static List<Potion> GetPotionsToRegister() {
        if (potionsToRegister == null) potionsToRegister = new ArrayList<>();
        return potionsToRegister;
    }

    public static List <Biome> GetBiomesToRegister ( ) {
        if ( biomesToRegister == null ) biomesToRegister = new ArrayList <> ( );
        return biomesToRegister;
    }

    public static List <Enchantment> GetEnchantmentsToRegister ( ) {
        if ( enchantmentsToRegister == null ) enchantmentsToRegister = new ArrayList <> ( );
        return enchantmentsToRegister;
    }

    public static void AddItemToRegistry(Item item) {
        if (itemsToRegister == null) itemsToRegister = new ArrayList<>();
        itemsToRegister.add(item);
    }

    public static void AddBlockToRegistry(Block block) {
        if (blocksToRegister == null) blocksToRegister = new ArrayList<>();
        blocksToRegister.add(block);
    }

    @SubscribeEvent
    public static void registerBlocks ( RegistryEvent.Register <Block> event ) {

        for ( Block block : F2Registry.GetBlocksToRegister ( ) ) {
            LogHelper.info("Registering Block:" + block.getRegistryName() + "/ UnLoc: " + block.getUnlocalizedName());
            event.getRegistry().register(block);
        }
    }

    @SubscribeEvent
    public static void registerItems ( RegistryEvent.Register <Item> event ) {
        LogHelper.info("Registered Items");
        for ( Item item : F2Registry.GetItemsToRegister ( ) ) {
            event.getRegistry().register(item);
        }
    }

    @SubscribeEvent
    public static void registerPotions ( RegistryEvent.Register <Potion> event ) {
        for ( Potion potion : F2Registry.GetPotionsToRegister ( ) )
            event.getRegistry ( ).register ( potion );
    }

    @SubscribeEvent
    public static void registerBiomes ( RegistryEvent.Register <Biome> event ) {
        for ( Biome biome : F2Registry.GetBiomesToRegister ( ) )
            event.getRegistry ( ).register ( biome );
    }

    @SubscribeEvent
    public static void registerSoundEvents ( RegistryEvent.Register <SoundEvent> event ) {
        for ( SoundEvent sound : F2Registry.GetSoundsToRegister ( ) ) {
            event.getRegistry ( ).register ( sound );
        }
    }

    @SubscribeEvent
    public void registerEnchantments ( RegistryEvent.Register <Enchantment> event ) {
        for (Enchantment encha : F2Registry.GetEnchantmentsToRegister())
            event.getRegistry().register(encha);
    }
}
