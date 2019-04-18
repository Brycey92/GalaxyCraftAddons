package com.galaxy_craft.galaxycraftaddons;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.lwjgl.opengl.GL11;

import com.galaxy_craft.galaxycraftaddons.items.ModItems;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
//import ic2.api.item.IC2Items;
//import dan200.computer.shared.BlockComputer;

@Mod(modid = GalaxyCraftAddons.MODID, name = GalaxyCraftAddons.NAME, version = GalaxyCraftAddons.VERSION)
public class GalaxyCraftAddons {

	public String why = "Why are you decompiling this?! A plague on all who tamper with my code!";
	
	public static final String MODID = "@MODID@";
    public static final String NAME = "@MODNAME@";
    public static final String VERSION = "@VERSION@";
	
	// The instance of your mod that Forge uses.
    @Instance(value = "@MODID@")
    public static GalaxyCraftAddons instance;
    public static CreativeTabs galaxyCraftAddonsTab = new GalaxyCraftAddonsTab(CreativeTabs.getNextID(), "@MODNAME@");
    private static Logger logger = LogManager.getLogger("@MODNAME@");
    
    
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="com.galaxy_craft.galaxycraftaddons.ClientProxy", serverSide="com.galaxy_craft.galaxycraftaddons.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	logger = event.getModLog();
    	
    	MinecraftForge.EVENT_BUS.register(instance);
    	
    	Thread launchCheck = new Thread() {
    		public void run() {
    			GalaxyCraftAddons.proxy.doLaunchCheck();
    		}
    	};
    	launchCheck.start();
    	
    	//proxy.doMemoryCheck(Config.requiredMemory);
    	
    	Config.load(event);
    	
    	ModItems.initArrays();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	
    	//register recipes
      	/*
    	if(Config.enableCredits) {
      		try {
      			ItemStack industrialCreditStack = IC2Items.getItem("coin");
      			
    			} catch(Exception e){
    			log("Unable to register recpies for IC2!");
    		}
      	}
      	*/
      	
    	//proxy.registerRenderers();
        log("Mod initialized successfully!");
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	proxy.doNEICheck(new ItemStack(ModItems.icon));
    	proxy.registerCommands();
    }
    
    @EventHandler
    public void serverStarting (FMLServerStartingEvent event) {
        //event.registerServerCommand(new GCACommand());
    }
    
    public static void log(Level logLevel, String message) {
    	logger.log(logLevel, message);
    	//FMLLog.log("Galaxy-Craft Addons", logLevel, String.valueOf(message));
    }
    
    public static void log(String message) {
    	log(Level.INFO, message);
    }
    
    public static double round(double value, int places) {
    	return new BigDecimal(value).setScale(places, RoundingMode.HALF_UP).doubleValue();
    }
    
    public static void rotate(int dir) {
        switch(dir) {
        default:
        case 0://bottom
                GL11.glRotated(90, 1, 0, 0);
        case 1://top
                GL11.glRotated(-90, 1, 0, 0);
        case 2://north
                GL11.glRotated(180, 0, 1, 0);
        case 3://south
                GL11.glRotated(0, 0, 1, 0);
        case 4://west
                GL11.glRotated(-90, 0, 1, 0);
        case 5://east
                GL11.glRotated(90, 0, 1, 0);
        }
}
}