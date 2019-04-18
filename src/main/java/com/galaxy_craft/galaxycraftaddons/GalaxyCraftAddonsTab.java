package com.galaxy_craft.galaxycraftaddons;

import com.galaxy_craft.galaxycraftaddons.items.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class GalaxyCraftAddonsTab extends CreativeTabs {
	
	private String name;
	
	public GalaxyCraftAddonsTab(int id, String label) {
		super(id, label);
		name = label;
	}
	
	public GalaxyCraftAddonsTab() {
		super(CreativeTabs.getNextID(), "Galaxy-Craft Addons");
		name = "Galaxy-Craft Addons";
	}

	private String translate() {
		return name;
	}

	@Override
	public String getTranslatedTabLabel() {
		return translate();
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.icon);
	}
}
