package com.galaxy_craft.galaxycraftaddons.mcstatus;
public class StatusResponse {
    private String description;
    private Players players;
    private Version version;
    private String favicon;
    private int time;
    
    public StatusResponse(){}
    
    public StatusResponse(String desc, Players play, Version ver, String icon, int pTime) {
    	description = desc;
    	players = play;
    	version = ver;
    	favicon = icon;
    	time = pTime;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Players getPlayers() {
        return players;
    }
    
    public Version getVersion() {
        return version;
    }
    
    public String getFavicon() {
        return favicon;
    }
    
    public int getTime() {
        return time;
    }      
    
    public void setTime(int time) {
        this.time = time;
    }    
}