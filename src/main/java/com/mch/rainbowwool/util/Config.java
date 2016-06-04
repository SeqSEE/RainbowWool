package com.mch.rainbowwool.util;

import com.mch.rainbowwool.RainbowWool;

import net.minecraftforge.common.MinecraftForge;

public class Config {

	public static void sync() {
		MinecraftForge.EVENT_BUS.register(RainbowWool.instance);
		if (RainbowWool.config.hasChanged()) {
			RainbowWool.config.save();
		}
	}
}
