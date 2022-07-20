package me.xaxis.serverhubsplus;

public enum Perms {

    SHP_HEAL("ServerHubsPlus.commands.heal"),
    SHP_HEAL_OTHERS("ServerHubsPlus.commands.heal.others"),
    SET_HUB("ServerHubsPlus.commands.sethub");

    public String ToString(){

        return permission;

    }

    private final String permission;

    Perms(String permission){
        this.permission = permission;
    }

}
