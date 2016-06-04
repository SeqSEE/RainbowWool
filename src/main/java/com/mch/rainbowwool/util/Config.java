package com.mch.rainbowwool.util;

import com.mch.rainbowwool.RainbowWool;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config {

	public static void sync() {
		MinecraftForge.EVENT_BUS.register(RainbowWool.instance);
		if (RainbowWool.config.hasChanged()) {
			RainbowWool.config.save();
		}
	}

	public static void config(FMLPreInitializationEvent preEvent) {
		RainbowWool.config = new Configuration(preEvent.getSuggestedConfigurationFile());
		RainbowWool.config.load();
    	boolean updates = RainbowWool.config.getBoolean("Check for updates:", "Updates", true, "Whether to check for an updated Mod.");
    	RainbowWool.getUpdates = updates;
    	RainbowWool.config.save();
    	MinecraftForge.EVENT_BUS.register(RainbowWool.instance);
		Config.sync();		
	}
}
