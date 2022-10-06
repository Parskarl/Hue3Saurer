package net.htlgkr.SaurerP190201.hue3Saurer;

import java.util.Objects;

public class Weapon
{
    String name;
    combatType combatType;
    damageType damageType;
    int damage;
    int speed;
    int strengt;
    int value;

    public Weapon(String name, net.htlgkr.SaurerP190201.hue3Saurer.combatType combatType, net.htlgkr.SaurerP190201.hue3Saurer.damageType damageType, int damage, int speed, int strengt, int value) {
        this.name = name;
        this.combatType = combatType;
        this.damageType = damageType;
        this.damage = damage;
        this.speed = speed;
        this.strengt = strengt;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public net.htlgkr.SaurerP190201.hue3Saurer.combatType getCombatType() {
        return combatType;
    }

    public net.htlgkr.SaurerP190201.hue3Saurer.damageType getDamageType() {
        return damageType;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStrengt() {
        return strengt;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name+" "+combatType+" "+damageType+" "+damage+" "+speed+" "+strengt+" "+value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return damage == weapon.damage && speed == weapon.speed && strengt == weapon.strengt && value == weapon.value && Objects.equals(name, weapon.name) && combatType == weapon.combatType && damageType == weapon.damageType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, combatType, damageType, damage, speed, strengt, value);
    }
}
