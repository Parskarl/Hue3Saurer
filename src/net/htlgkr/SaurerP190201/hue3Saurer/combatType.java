package net.htlgkr.SaurerP190201.hue3Saurer;

public enum combatType
{
    MELEE, RANGED, NONE;

    public static combatType getDT(String a)
    {
        if(a.equals("MELEE")){return MELEE;}
        else if(a.equals("RANGED")){return RANGED;}
        else if(a.equals("NONE")){return NONE;}
        return NONE;
    }
}
