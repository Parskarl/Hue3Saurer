package net.htlgkr.SaurerP190201.hue3Saurer;

public class weapons
{
    String name;
    combatType combatType;
    damageType damageType;
    int damage;
    int speed;
    int strengt;
    int value;

    public weapons(String name, net.htlgkr.SaurerP190201.hue3Saurer.combatType combatType, net.htlgkr.SaurerP190201.hue3Saurer.damageType damageType, int damage, int speed, int strengt, int value) {
        this.name = name;
        this.combatType = combatType;
        this.damageType = damageType;
        this.damage = damage;
        this.speed = speed;
        this.strengt = strengt;
        this.value = value;
    }

    @Override
    public String toString() {
        return "weapons{" +
                "name='" + name + '\'' +
                ", combatType=" + combatType +
                ", damageType=" + damageType +
                ", damage=" + damage +
                ", speed=" + speed +
                ", strengt=" + strengt +
                ", value=" + value +
                '}';
    }
}
