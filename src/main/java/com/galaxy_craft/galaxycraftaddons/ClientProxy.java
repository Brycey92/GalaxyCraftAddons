package com.galaxy_craft.galaxycraftaddons;

import com.galaxy_craft.galaxycraftaddons.commands.OpenURLCommand;
import com.galaxy_craft.galaxycraftaddons.items.ModItems;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ClientProxy extends CommonProxy {
	
	//1024/1037959168, default when 1G allocated to 1024/1036433728, 1024/1012^3;
    protected static final long MEM_TO_GB = 1037000000;
	
	@Override
    public void registerRenderers() {
            // This is for rendering entities and so forth later on
    }
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent e)
	{
		for(Item item: ModItems.items)
			registerItemRenderer(item);
		
		for(ItemBlock itemBlock: ModItems.itemBlocks)
			registerItemBlockRenderer(itemBlock);
	}
	
	private static void registerItemRenderer(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		GalaxyCraftAddons.log("Successfully registered model for " + item.getRegistryName() + ".");
	}
	
	private static void registerItemBlockRenderer(ItemBlock iblock)
	{
		ModelLoader.setCustomModelResourceLocation(iblock, 0, new ModelResourceLocation(iblock.getBlock().getRegistryName(), "inventory"));
	}
	
	@Override
	public void registerCommands() {
		ClientCommandHandler.instance.registerCommand(new OpenURLCommand());
	}
	
	/*@Override
	public void doNEICheck(ItemStack itemStack) {
		try{
			Iterator modsIT = Loader.instance().getModList().iterator();
			ModContainer modContainer;
			while (modsIT.hasNext()) {
				modContainer = (ModContainer) modsIT.next();
				if ("Not Enough Items".equals(modContainer.getName().trim())) {
					codechicken.nei.api.API.hideItem(itemStack);
					return;
				}
			}
		} catch(Exception e){}
	}*/
	
	@Override
	public void doLaunchCheck() {}
	
	@Override
	public void doMemoryCheck(int reqMem) {
		/*Runtime runtime = Runtime.getRuntime();
		double testMem = reqMem * 1000 / 1024;
		double maxMem = runtime.maxMemory() / MEM_TO_GB * 1024;
		double totalMem = runtime.totalMemory() / MEM_TO_GB * 1024;
		if(maxMem < testMem && totalMem < testMem) {
			throw new LowMemoryException(reqMem);
		}*/
	}
	
	@Override
	public void doMemoryCheck() {
		doMemoryCheck(Config.getRequiredMemory());
	}
	
	/*@Override
	public void onSound(SoundLoadEvent event) {
		Minecraft mc = Minecraft.getMinecraft();
		try {
	       	String [] soundFiles = {
	       		"sataAndagi.ogg",
	       		};
	       	for (int i = 0; i < soundFiles.length; i++){
	       		event.manager.soundPoolSounds.addSound("assets/"+soundFiles[i], new File("/com/galaxy_craft/galaxycraftaddons/assets/" + soundFiles[i]));
	       	}
	    }
	    catch (Exception e) {
	        System.err.println("[Galaxy-Craft Addons] Failed to register one or more sounds.");
        }
	}*/
}
