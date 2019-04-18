package com.galaxy_craft.galaxycraftaddons;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.apache.logging.log4j.Level;

import net.minecraftforge.common.config.Configuration;

public class Config {
	private static int requiredMemory = 3072;
    private static boolean enableCredits = true;
    private static boolean enableTokens = true;
    private static Configuration config;

    public static void load (FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());
        syncConfig();
    }
    
    public static void syncConfig () {
        try {
            processConfig(config);
        } catch (Exception e) {
            GalaxyCraftAddons.log(Level.ERROR, "Error processing config! If you see this, let me know and I'll add more debug info.");
        } finally {
            if (config.hasChanged()) {
            	GalaxyCraftAddons.log("Config reloaded successfully.");
            	config.save();
            }
        }
    }
    
    @SubscribeEvent
    public void onConfigChanged (ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(GalaxyCraftAddons.MODID)) {
            GalaxyCraftAddons.log("Config changed. Reloading config.");
            syncConfig();
        }
    }
    
    public static void processConfig (Configuration configuration) {
        requiredMemory = configuration.getInt("requiredMemory", Configuration.CATEGORY_GENERAL, requiredMemory, 512, 8192, "Amount of RAM (in MB) required for the modpack");
        enableCredits = configuration.getBoolean("enableCredits", Configuration.CATEGORY_GENERAL, enableCredits, "");
        enableTokens = configuration.getBoolean("enableTokens", Configuration.CATEGORY_GENERAL, enableTokens, "");
    }
    
    public static int getRequiredMemory() {
    	return requiredMemory;
    }
    
    public static boolean areCreditsEnabled() {
    	return enableCredits;
    }
    
    public static boolean areTokensEnabled() {
    	return enableTokens;
    }
}