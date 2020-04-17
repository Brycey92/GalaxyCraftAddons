package com.galaxy_craft.galaxycraftaddons.items;

import java.util.List;

import com.galaxy_craft.galaxycraftaddons.GalaxyCraftAddons;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Credit extends GCAItem {
	private static final String PREFIX = "credit_";
	private String name;

	public Credit(String creditName) {
		super();
		name = creditName;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		if(name.equals("industrial")) {
			tooltip.add("1c");
		}
		else if(name.equals("copper")) {
			tooltip.add("8c");
		}
		else if(name.equals("silver")) {
			tooltip.add("64c");
		}
		else if(name.equals("gold")) {
			tooltip.add("512c");
		}
		else if(name.equals("diamond")) {
			tooltip.add("4096c");
		}
		
		/*
		if(GuiScreen.isShiftKeyDown()){
			
        }else{
        	
        }
        */
	}
	
	@Override
    @SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack itemStack){
		if(name.equals("industrial")) {
			return EnumRarity.COMMON;
		}
		else if(name.equals("copper")) {
			return EnumRarity.COMMON;
		}
		else if(name.equals("silver")) {
			return EnumRarity.COMMON;
		}
		else if(name.equals("gold")) {
			return EnumRarity.UNCOMMON;
		}
		else if(name.equals("diamond")) {
			return EnumRarity.RARE;
		}
		else return EnumRarity.COMMON;
	}
	
	public Item setItemProperties() {
		setCreativeTab(GalaxyCraftAddons.galaxyCraftAddonsTab);
        setRegistryName(PREFIX + name);
        setUnlocalizedName(PREFIX + name);
        return this;
	}
}
