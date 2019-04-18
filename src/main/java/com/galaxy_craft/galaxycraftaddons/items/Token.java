package com.galaxy_craft.galaxycraftaddons.items;

import com.galaxy_craft.galaxycraftaddons.GalaxyCraftAddons;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Token extends GCAItem {
	public static final String PREFIX = "token_tier_";
	private int tier;

	public Token() {
		this(0);
	}
	
	public Token(int tokenTier) {
		super();
		tier = tokenTier;
		
	}
	
	@Override
    @SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack itemStack){
		if (tier > 0)
			return EnumRarity.UNCOMMON;
		else
			return EnumRarity.COMMON;
	}
	
	public Item setItemProperties() {
		setCreativeTab(GalaxyCraftAddons.galaxyCraftAddonsTab);
		setRegistryName(GalaxyCraftAddons.MODID, PREFIX + tier);
		setUnlocalizedName(GalaxyCraftAddons.MODID + PREFIX + tier);
		return this;
	}
}
