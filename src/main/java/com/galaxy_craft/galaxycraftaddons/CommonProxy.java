package com.galaxy_craft.galaxycraftaddons;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.sound.SoundLoadEvent;

public class CommonProxy {

	// Client stuff
    public void registerRenderers() {
        // Nothing here as the server doesn't render graphics or entities!
    }
    
    public void registerCommands() {}
    
    public void doNEICheck(ItemStack itemStack) {}
    
    public void doLaunchCheck() {
    	//TODO: write LaunchChecker
    	//new LaunchChecker().doLaunchCheck();
    }
    
    public void doMemoryCheck(int mem) {}
    
	public void doMemoryCheck() {}
    
    public void onSound(SoundLoadEvent event) {}
    
}
