package com.galaxy_craft.galaxycraftaddons;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiErrorScreen;
import net.minecraftforge.fml.client.CustomModLoadingErrorDisplayException;

public class LowMemoryException extends CustomModLoadingErrorDisplayException {
	
	private static final long serialVersionUID = -458667212537062427L;
	private double memory = 1024;

	public LowMemoryException() {
		// TODO Auto-generated constructor stub
	}
	
	public LowMemoryException(double mem) {
		memory = mem;
		// TODO Auto-generated constructor stub
	}

	public LowMemoryException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initGui(GuiErrorScreen errorScreen, FontRenderer fontRenderer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawScreen(GuiErrorScreen errorScreen, FontRenderer fontRenderer, int mouseRelX, int mouseRelY, float tickTime) {
		double tempMem = GalaxyCraftAddons.round(memory/1024, 2);
		String message = "Not enough memory allocated! Please allocate a minimum of "+ tempMem + " GB of RAM!";
		int textWidth = fontRenderer.getStringWidth(message);
		fontRenderer.drawString(message, (errorScreen.width - textWidth) / 2, (errorScreen.height) / 3, 0xFFFFFF);

	}

}
