package net.htlgkr.SaurerP190201.hue3Saurer;

public enum damageType
{
    SLASHING, MISSILE, NONE, BLUNT, PIERCING;

    public static damageType getCT(String a)
    {
        if(a.equals("SLASHING")){return SLASHING;}
        else if(a.equals("MISSILE")){return MISSILE;}
        else if(a.equals("NONE")){return NONE;}
        else if(a.equals("BLUNT")){return BLUNT;}
        else if(a.equals("PIERCING")){return PIERCING;}
        return NONE;
    }
}
