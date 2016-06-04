package com.mch.rainbowwool.init;

import java.util.ArrayList;
import java.util.List;

import com.mch.rainbowwool.block.RWBlock;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RWBlocks extends Blocks{
	public static List<Block> blocks = new ArrayList();

	public static Block rainbow_wool = new RWBlock("rainbow_wool");
	
	public static List<Block> blockList(){
		return blocks;		
	}
		
	
	public static void register(){
		for (Block block : blockList()){
			GameRegistry.register(block);
			ItemBlock iBlock = new ItemBlock(block);
		    GameRegistry.register(iBlock, block.getRegistryName());
		}
	}
	
	public static void registerRender(){
		for (Block block : blockList()){
		Item item = new Item().getItemFromBlock(block);
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    	renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(block.getRegistryName().toString(), "inventory"));
		}
	}

}
