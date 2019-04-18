package com.galaxy_craft.galaxycraftaddons.mcstatus;
public class NewStatusResponse {
    private Description description;
    private Players players;
    private Version version;
    private String favicon;
    private int time;
    
    public StatusResponse toStatusResponse() {
    	return new StatusResponse(description.getText(), players, version, favicon, time);
    }
    
    public String getDescription() {
        return description.getText();
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