package me.xaxis.serverhubsplus;

public enum Perms {

    SHP_HEAL;

    public String string(){

        switch (this){
            case SHP_HEAL -> {
                return "ServerHubsPlus.commands.heal";
            }
        }


        return "";

    }

}
