package me.xaxis.serverhubsplus;

import org.jetbrains.annotations.NotNull;

public enum Lang {

    DISCORD("Lang.discord"),
    NO_PERMISSION("Lang.no_permission"),
    SENDER_NOT_PLAYER("Lang.sender_not_player"),
    PREFIX("Lang.prefix"),
    INVALID_PLAYER("Lang.invalid_player"),
    STRING_NOT_INT("Lang.string_not_int"),
    CUSTOM_JOIN_MESSAGE("Lang.custom_join_message"),
    VANISHED("Lang.vanished"),
    UNVANISHED("Lang.unvanished")
    ;

    public String toString(@NotNull ServerHubsPlus instance){

        return instance.getConfig().getString(path);

    }

    private final String path;

    Lang(String path){

        this.path = path;

    }

}
