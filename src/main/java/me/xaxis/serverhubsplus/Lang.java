package me.xaxis.serverhubsplus;

public enum Lang {

    DISCORD("Lang.PlayerMessages.discord", "Put your discord link here!"),
    NO_PERMISSION("Lang.CommandMessages.no_permission", "&4You do not have permission to execute this command!"),
    SENDER_NOT_PLAYER("Lang.CommandMessages.sender_not_player", "&4Only players can execute this command!"),
    PREFIX("Lang.FormattingMessages.prefix", "&2[&6SH+&2]&7&r "),
    INVALID_PLAYER("Lang.PlayerMessages.invalid_player", "&4That player is either offline or does not exist!"),
    STRING_NOT_INT("Lang.MiscellaneousMessages.string_not_int", "&4You must enter a integer not a string!"),
    CUSTOM_JOIN_MESSAGE("Lang.PlayerMessages.custom_join_message", "&6Welcome to the server %s!"),
    VANISHED("Lang.PlayerMessages.vanished", "&6You are now &avanished"),
    UNVANISHED("Lang.PlayerMessages.unvanished", "&6You are now &cunvanished"),
    NOT_ENOUGH_ARGS("Lang.CommandMessages.not_enough_args", "&4You have not provided the correct amount of arguments!"),
    CANT_CHAT_IS_LOCKED("Lang.PlayerMessages.cant_chat_is_locked", "&4Chat is currently locked."),
    CHAT_ALREADY_UNLOCKED("Lang.PlayerMessages.chat_already_unlocked", "&4Chat is already unlocked!"),
    CHAT_ALREADY_LOCKED("Lang.PlayerMessages.chat_already_locked", "&4Chat is already locked!"),
    CHAT_LOCKED("Lang.PlayerMessages.chat_locked", "&4Chat has been locked by %s!"),
    CHAT_UNLOCKED("Lang.PlayerMessages.chat_unlocked", "&aChat has been unlocked by %s!"),
    FLY_ENABLED("Lang.PlayerMessages.fly_enabled", "&aFlight has been enabled!"),
    FLY_DISABLED("Lang.PlayerMessages.fly_disabled", "&4Flight has been disabled!"),
    FLY_DISABLED_OTHER("Lang.PlayerMessages.fly_disabled_other", "&4Successfully disabled flight mode for %s!"),
    FLY_ENABLED_OTHER("Lang.PlayerMessages.fly_enabled_other", "&aSuccessfully enabled flight mode for %s!"),
    FLY_INCORRECT_USAGE("Lang.CommandMessages.flight_command_incorrect_usage", "&4Invalid Usage! /fly or /fly <player>"),
    VULNERABLE("Lang.PlayerMessages.vulnerable", "&4You are now vulnerable!"),
    INVULNERABLE("Lang.PlayerMessages.invulnerable", "&aYou are now invulnerable!"),
    OTHER_VULNERABLE("Lang.PlayerMessages.other_vulnerable", "&4Set %s to vulnerable!"),
    OTHER_INVULNERABLE("Lang.PlayerMessages.other_invulnerable", "&4Set %s to invulnerable!"),
    HEAL_OTHER("Lang.PlayerMessages.other_heal", "&aSuccessfully reset %'s health!"),
    HEAL("Lang.PlayerMessages.heal", "&aSuccessfully reset your health!"),
    HEALTH_MAX("Lang.PlayerMessages.health_max", "&4You already are at full health!"),
    HEALTH_OTHER_MAX("Lang.PlayerMessages.health_other_max", "&4%s is already at full health!"),
    HEAL_INCORRECT_USAGE("Lang.CommandMessages.heal_incorrect_usage", "&4Invalid Usage! /heal or /heal <player>"),
    NO_HUB_LOCATION("Lang.PlayerMessages.no_hub_location", "&4Huh... that's odd... no hub location was set!"),
    TELEPORTED_TO_HUB("Lang.PlayerMessages.teleported_to_hub", "&aSuccessfully teleported to hub!"),
    SET_HUB_LOCATION("Lang.PlayerMessages.set_hub_location", "&aSuccessfully set hub location!"),
    SET_HUB_INCORRECT_USAGE("Lang.CommandMessages.set_hub_incorrect_usage", "&4Incorrect Usage! /sethub or /sethub x y z"),
    SUICIDE_INCORRECT_USAGE("Lang.CommandMessages.suicide_incorrect_usage", "&4Incorrect Usage! /suicide"),
    SUICIDE_MESSAGE("Lang.PlayerMessages.suicide_message", "&4You will die in 3 seconds..."),
    TP2P_INCORRECT_USAGE("Lang.CommandMessages.tp2p_incorrect_usage", "&4Incorrect Usage! /tp2p <player>"),
    TP2P_MESSAGE("Lang.PlayerMessages.tp2p_message", "&aSuccessfully teleported to %s!"),
    TPHERE_INCORRECT_USAGE("Lang.CommandMessages.tphere_incorrect_usage", "&4Incorrect Usage! /tphere <player>"),
    TPHERE_MESSAGE("Lang.PlayerMessages.tphere_message", "&aSuccessfully teleported %s to your location!"),
    VANISH_INCORRECT_USAGE("Lang.CommandMessages.vanish_incorrect_usage", "&4Invalid Usage! /vanish or /vanish <player>"),
    VANISHED_OTHER("Lang.PlayerMessages.vanished_other", "&aSuccessfully vanished %s!")
    ;

    public String getDefaultValue(){
        return value;
    }

    public String getPath(){
        return path;
    }

    private final String path;
    private final String value;

    Lang(String path, String defaultValue){
        this.path = path;
        this.value = defaultValue;
    }

}
