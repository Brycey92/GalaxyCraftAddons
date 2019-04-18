package com.galaxy_craft.galaxycraftaddons.commands;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;

public class GCACommand implements ICommand {

	private List<String> aliases, tabCompleteOptions;
	protected String usage =
		"§aOpen a URL\n" +
	   	"§6/gcaddons openurl <url>§r";
	
    public GCACommand() {
        aliases = new ArrayList<String>();
        aliases.add("gcaddons");
        aliases.add("galaxycraftaddons");
        tabCompleteOptions = new ArrayList<String>();
        tabCompleteOptions.add("openurl");
        tabCompleteOptions.add("help");
    }
    
    @Override
	public int compareTo(ICommand o) {
		return 0;
	}
    
    @Override
    public String getName () {
        return "gcaddons";
    }
    @Override
    public String getUsage (ICommandSender iCommandSender) {
        return TextFormatting.RED + "/gcaddons <command>";
    }
    @Override
    public List<String> getAliases () {
        return aliases;
    }
    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
    	//TextComponentString returnText = new TextComponentString("");
    	
        if (args.length == 0) { //no input command
            sender.sendMessage(new TextComponentString(usage));
        } else { //message contains data
            if (args[0].equalsIgnoreCase("openurl")) {
        		return; //TODO: Add server commands
            } else if (args[0].equalsIgnoreCase("help")) {
                sender.sendMessage(new TextComponentString(usage));
            }
        }
    }
    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        if (FMLCommonHandler.instance().getEffectiveSide().isServer()) {
            if (sender instanceof EntityPlayer) {
                return sender.canUseCommand(0,this.getName());
            } else {
                return true;
            }
        }
        return false;
    }
    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) {
        return this.tabCompleteOptions;
    }
    @Override
    public boolean isUsernameIndex (String[] inputString, int i) {
        return false;
    }
    
    public static String getItemName (ItemStack item) {
        return item.getItem().getUnlocalizedName();
    }
    
    public static String getItemDamage (ItemStack item) {
        return Integer.toString(item.getItemDamage());
    }
    
    public static String getItemNBT (ItemStack item) {
        NBTTagCompound nbt = item.getTagCompound();
        if (nbt != null) {
            return item.getTagCompound().toString();
        } else {
            return "null";
        }
    }
}
