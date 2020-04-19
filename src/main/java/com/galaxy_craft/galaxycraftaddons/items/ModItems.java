package com.galaxy_craft.galaxycraftaddons.items;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.apache.logging.log4j.Level;

import com.galaxy_craft.galaxycraftaddons.Config;
import com.galaxy_craft.galaxycraftaddons.GalaxyCraftAddons;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModItems {
	
	/* Adding items? Don't forget to modify:
	 * This set of public static instances
	 * initArrays() USES REFLECTION NOW
	 * registerItems()
	 * Textures (src\main\resources\assets\galaxycraftaddons\textures\)
	 * Models (src\main\resources\assets\galaxycraftaddons\models\)
	 * Recipes (src\main\resources\assets\galaxycraftaddons\recipes)
	 * Lang Files (src\main\resources\assets\galaxycraftaddons\lang)
	 * Respective item class(es)
	 */
	
	public static final GCAItem credit_industrial = new Credit("industrial");
	public static final GCAItem credit_copper = new Credit("copper");
  	public static final GCAItem credit_silver = new Credit("silver");
  	public static final GCAItem credit_gold = new Credit("gold");
  	public static final GCAItem credit_diamond = new Credit("diamond");
  	public static final GCAItem token_tier_1 = new Token(1);
  	public static final GCAItem token_tier_2 = new Token(2);
  	public static final GCAItem token_tier_3 = new Token(3);
  	public static final GCAItem token_tier_4 = new Token(4);
  	public static final GCAItem token_tier_5 = new Token(5);
  	public static final GCAItem token_tier_6 = new Token(6);
  	//TODO: A better way to set creative tab icon? (without getting an item for it)
  	public static final GCAItem icon = new Token(0, "gcicon");
  	
  	public static ArrayList<Item> items = new ArrayList<>();
  	public static ArrayList<ItemBlock> itemBlocks = new ArrayList<ItemBlock>();
  	
  	public static void initArrays() {
  		Field[] fields = ModItems.class.getFields();
  		
  		if(items.isEmpty()) {
  			for(Field field: fields) {
  				if(field.getType() == GCAItem.class) {
					try {
						items.add((Item) field.get(null));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						GalaxyCraftAddons.log(Level.ERROR, "Encountered +  + in class ModItems!");//TODO fix this
						e.printStackTrace();
					} catch (NullPointerException e) {
						GalaxyCraftAddons.log(Level.ERROR, "Encountered non-static field " + field.getName() + " in static-only class ModItems!");
						e.printStackTrace();
					}
  				}
  			}
  			
  			/*
  			items.add(credit_industrial);
  			items.add(credit_copper);
  			items.add(credit_silver);
  			items.add(credit_gold);
  			items.add(credit_diamond);
  			items.add(token_tier_1);
  			items.add(token_tier_2);
  			items.add(token_tier_3);
  			items.add(token_tier_4);
  			items.add(token_tier_5);
  			items.add(token_tier_6);
  			items.add(icon);
  			*/
  		}
  		
  		if(itemBlocks.isEmpty()) {
  			for(Field field: fields) {
  				if(field.getType() == ItemBlock.class) {
					try {
						items.add((ItemBlock) field.get(null));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						GalaxyCraftAddons.log(Level.ERROR, "Encountered non-static field " + field.getName() + " in static-only class ModItems!");
						e.printStackTrace();
					}
  				}
  			}
  		}
  	}
  	
  	@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	//Register the items with the Game Registry
    	if(Config.areCreditsEnabled()) {
    		if(Loader.isModLoaded("ic2")) {
    			try {
    				//TODO: check ic2 credit details, do stuff
    				ic2.api.item.IC2Items.getItem("coin");
    			} catch(Exception e) {
    				GalaxyCraftAddons.log(Level.ERROR, "Failed to load IC2 compatability!");
    			}
    		}
    		else {
    			event.getRegistry().register(credit_industrial.setItemProperties());
    			//TODO: implement our industrial credit
    		}
    		event.getRegistry().register(credit_copper.setItemProperties());
    		event.getRegistry().register(credit_silver.setItemProperties());
    		event.getRegistry().register(credit_gold.setItemProperties());
    		event.getRegistry().register(credit_diamond.setItemProperties());
    	}
    	if(Config.areTokensEnabled()) {
    		event.getRegistry().register(token_tier_1.setItemProperties());
    		event.getRegistry().register(token_tier_2.setItemProperties());
    		event.getRegistry().register(token_tier_3.setItemProperties());
    		event.getRegistry().register(token_tier_4.setItemProperties());
    		event.getRegistry().register(token_tier_5.setItemProperties());
    		event.getRegistry().register(token_tier_6.setItemProperties());
    	}
    	event.getRegistry().register(icon.setItemProperties());
        
    }
}
