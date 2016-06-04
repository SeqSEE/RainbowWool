package com.mch.rainbowwool.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.mch.rainbowwool.RainbowWool;
import com.mch.rainbowwool.Reference;

import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class VersionChecker implements Runnable{

	private static String latestRev;

    @Override
    public void run(){
        InputStream versionFile = null;
        try{
        	versionFile = new URL("https://raw.githubusercontent.com/SeqSEE/RainbowWool/master/latest").openStream();
        } 
        catch 
        (MalformedURLException e){
            e.printStackTrace();
        } 
        catch (IOException e){
            e.printStackTrace();
        }

        try{
            latestRev = IOUtils.readLines(versionFile).get(0);
        } 
        catch (IOException e){

            e.printStackTrace();
        } 
        finally{
            IOUtils.closeQuietly(versionFile);
        }
        RainbowWool.latest = latestRev;
        System.out.println("Latest " + Reference.NAME + " version:" + latestRev);
        RainbowWool.isLatest = Reference.VER.equals(latestRev);
        String output = RainbowWool.isLatest == true ? "You are running the latest version." : "You are running:" + Reference.VER;
        System.out.println(output);
        System.out.println("This is a different version!");
    }
    
    public boolean isLatestVersion(){
     return RainbowWool.isLatest;
    }
    
    public String getLatestVersion(){
     return latestRev;
    }
    
    public static boolean getWarning(PlayerTickEvent event){
    	boolean warned = RainbowWool.warned;
    	if (!warned && event.player.worldObj.isRemote && RainbowWool.isLatest == false && RainbowWool.getUpdates != false){
            TextComponentString update = new TextComponentString("[Update to " + latestRev + "]");
            Style link = new Style();
            link.setBold(true);
           	link.setUnderlined(true);
           	link.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponentString("Click here to visit the Curse page.")));
           	link.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://mods.curse.com/mc-mods/minecraft/245575-hempfarmer"));
            update.setStyle(link);
            event.player.addChatMessage(new TextComponentString("Your HempFarmer Mod is not the recommended version!"));
            event.player.addChatMessage(update);
            RainbowWool.warned = true;
    	}
    	return warned;
    }

	public static void check(FMLPostInitializationEvent postEvent) {
		if (RainbowWool.getUpdates == true){
			RainbowWool.versionChecker = new VersionChecker();
	    	Thread versionCheckThread = new Thread(RainbowWool.versionChecker, "RainbowWool - VersionChecker");
	    	versionCheckThread.start();
	    }
	}
}

