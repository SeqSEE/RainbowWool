package com.mch.rainbowwool.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RWRecipes {
	
	public static void registerRecipes(FMLPreInitializationEvent preEvent){
		GameRegistry.addShapelessRecipe(new ItemStack(RWBlocks.rainbow_wool),
			new ItemStack(Blocks.WOOL, 1, 1),
			new ItemStack(Blocks.WOOL, 1, 3),
			new ItemStack(Blocks.WOOL, 1, 4),
			new ItemStack(Blocks.WOOL, 1, 5),
			new ItemStack(Blocks.WOOL, 3, 10),
			new ItemStack(Blocks.WOOL, 1, 11),
			new ItemStack(Blocks.WOOL, 1, 14));
	}
}
