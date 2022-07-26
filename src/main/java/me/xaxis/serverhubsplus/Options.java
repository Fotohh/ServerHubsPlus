package me.xaxis.serverhubsplus;

import org.jetbrains.annotations.NotNull;

public enum Options {

    AUTO_TELEPORT_ON_JOIN("Options.Lobby.auto_teleport_on_join"),
    custom_join_messages("Options.OnJoin.custom_join_messages"),
    Vanish("Options.Vanish.enabled")
    ;

    public String toString(@NotNull ServerHubsPlus instance){

        return instance.getConfig().getString(path);

    }

    public Boolean toBoolean(@NotNull ServerHubsPlus instance){

        return instance.getConfig().getBoolean(path);

    }

    private final String path;

    Options(String path){

        this.path = path;

    }

}
