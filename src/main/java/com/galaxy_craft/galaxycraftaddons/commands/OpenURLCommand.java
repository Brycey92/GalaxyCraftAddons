package com.galaxy_craft.galaxycraftaddons.commands;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import java.awt.Desktop;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class OpenURLCommand implements ICommand {

	private List<String> aliases, tabCompleteOptions;
	
    public OpenURLCommand() {
        aliases = new ArrayList<String>();
        aliases.add("openurl");
        tabCompleteOptions = new ArrayList<String>();
        //tabCompleteOptions.add("openurl");
    }
    
    @Override
	public int compareTo(ICommand o) {
		return 0;
	}
	
    @Override
    public String getName () {
        return "openurl";
    }
	
    @Override
    public String getUsage (ICommandSender iCommandSender) {
        return TextFormatting.RED + "/openurl <URL>";
    }
	
    @Override
    public List<String> getAliases () {
        return aliases;
    }
	
    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 0) { //no input command
            sender.sendMessage(new TextComponentString(TextFormatting.GREEN+"Open a URL"+TextFormatting.RESET));
            sender.sendMessage(new TextComponentString(TextFormatting.GOLD+"/openurl <URL>"+TextFormatting.RESET));
        } else { //message contains data
        	// Get client's desktop
        	Desktop d = Desktop.getDesktop();
        	 
        	// Use default browser to connect to the following URL
        	String url = joinString(args);
        	if(!url.matches("(http://|https://|ftp://).*"))
        		url = "http://".concat(url);
        	try {
        		d.browse(new URI(url));
        	} catch (Exception e) {
        		sender.sendMessage(new TextComponentString(TextFormatting.DARK_RED+"You did not enter a valid URL."+TextFormatting.RESET));
        	}
        }
    }
	
    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }
	
    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) {
        return this.tabCompleteOptions;
    }
	
    @Override
    public boolean isUsernameIndex (String[] inputString, int i) {
        return false;
    }
    
    public static String joinString(String[] args) {
    	return StringUtils.join(args, "%20");
    }
}
