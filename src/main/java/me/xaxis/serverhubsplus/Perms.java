package me.xaxis.serverhubsplus;

public enum Perms {

    SHP_HEAL("ServerHubsPlus.commands.heal"),
    SHP_HEAL_OTHERS("ServerHubsPlus.commands.heal.others"),
    SET_HUB("ServerHubsPlus.commands.sethub"),
    TPHERE("ServerHubsPlus.commands.tphere"),
    TP2P("ServerHubsPlus.commands.tp2p"),
    SUICIDE("ServerHubsPlus.commands.suicide"),
    FLY("ServerHubsPlus.commands.fly"),
    FLY_OTHERS("ServerHubsPlus.commands.fly.others"),
    FEED("ServerHubsPlus.commands.feed"),
    FEED_OTHERS("ServerHubsPlus.commands.feed.others"),
    GODMODE("ServerHubsPlus.commands.godmode"),
    GODMODE_OTHERS("ServerHubsPlus.commands.godmode.others"),
    VANISH("ServerHubsPlus.commands.vanish"),
    VANISH_OTHERS("ServerHubsPlus.commands.vanish.others"),
    VANISH_SEE("ServerHubsPlus.commands.vanish.see"),
    INVSEE("ServerHubsPlus.commands.invsee")
    ;

    public String ToString(){

        return permission;

    }

    private final String permission;

    Perms(String permission){
        this.permission = permission;
    }

}
