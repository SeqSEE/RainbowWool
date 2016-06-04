package com.mch.rainbowwool.proxy;

import com.mch.rainbowwool.init.RWBlocks;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent preEvent) {
		register();
	}

	public void init(FMLInitializationEvent event) {
		registerRender();
	}
	
	public void postInit(FMLPostInitializationEvent postEvent) {
		
	}
	
	public void register(){
		RWBlocks.register();
	}

	public void registerRender() {
		// DO NOT REGISTER RENDERS HERE!!
	}

	

}
