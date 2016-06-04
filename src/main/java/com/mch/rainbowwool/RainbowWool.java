package com.mch.rainbowwool;

import com.mch.rainbowwool.proxy.CommonProxy;
import com.mch.rainbowwool.util.Config;
import com.mch.rainbowwool.util.VersionChecker;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

@Mod(modid = Reference.ID, name = Reference.NAME, version = Reference.VER)
public class RainbowWool{
	
	public static Configuration config;
	@Instance(value = "rainbowwool")
    public static RainbowWool instance;
	public static VersionChecker versionChecker;
	public static boolean getUpdates;
	public static String latest;
	public static boolean isLatest = false;
	public static boolean warned = false;
	public static boolean craftingEnabled = true;
	
    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static CommonProxy proxy;
	

    @EventHandler
	public void preInit(FMLPreInitializationEvent preEvent) {
    	proxy.preInit(preEvent);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
    	proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent postEvent){
    	proxy.postInit(postEvent);
    }
    
    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
    public void onEvent(PlayerTickEvent event){
    	VersionChecker.getWarning(event); 
      
    }

    
}