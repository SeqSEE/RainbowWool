package com.mch.rainbowwool.proxy;

import com.mch.rainbowwool.init.RWBlocks;
import com.mch.rainbowwool.util.Config;
import com.mch.rainbowwool.util.VersionChecker;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent preEvent) {
		Config.config(preEvent);
		register();
	}

	public void init(FMLInitializationEvent event) {
		registerRender(event);
	}
	
	public void postInit(FMLPostInitializationEvent postEvent) {
		VersionChecker.check(postEvent);
	}
	
	public void register(){
		RWBlocks.register();
	}

	public void registerRender(FMLInitializationEvent event) {
		// DO NOT REGISTER RENDERS HERE!!
	}

	

}
