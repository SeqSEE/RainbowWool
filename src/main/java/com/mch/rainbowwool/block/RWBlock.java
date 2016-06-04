package com.mch.rainbowwool.block;

import com.mch.rainbowwool.Reference;
import com.mch.rainbowwool.init.RWBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

public class RWBlock extends Block{

	public RWBlock(String name){
		super(Material.CLOTH);
		ResourceLocation location = new ResourceLocation(Reference.ID + ":" + name);
		this.setRegistryName(location);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		addToBlocks(this);
		
	}

	private void addToBlocks(Block block) {
		RWBlocks.blocks.add(block);		
	}



}
