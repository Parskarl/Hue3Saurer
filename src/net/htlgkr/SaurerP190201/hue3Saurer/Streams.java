package net.htlgkr.SaurerP190201.hue3Saurer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams
{
    public static void main(String[] args)
    {
        Streams s = new Streams();
        Random random = new Random();
        int[] array = random.ints(9999, 0,100).toArray();

        System.out.println(s.average(array));
        Main m = new Main();
        m.readfile();

        System.out.println(s.findWeaponWithLowestDamage(m.weap));
        System.out.println(s.findWeaponWithHighestStrength(m.weap));
        System.out.println(s.collectMissileWeapons(m.weap));
        System.out.println(s.findWeaponWithLongestName(m.weap));
        System.out.println(s.toNameList(m.weap));
        System.out.println(s.sumUpValues(m.weap));
        System.out.println(s.removeDuplicates(m.weap));
        s.increaseValuesByTenPercent(m.weap);

        String[] strarr = new String[10];

        for (int i = 0; i < 10; i++)
        {
            String adder = String.valueOf((char)(random.nextInt(26)+'a'));
            strarr[i]=adder;
        }
        Arrays.stream(strarr).map(n1 -> n1).forEach(System.out::print);
        System.out.println();
        System.out.println(s.upperCase(strarr));
    }

    public double average(int[] numbers)
    {
        return Arrays.stream(numbers).average().getAsDouble();
    }

    public List<String> upperCase(String[] strings)
    {
        List<String> strli = Stream.of(strings).map(String::toUpperCase).collect(Collectors.toList());
        return strli;
    }
    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons)
    {
        weapons.sort(Comparator.comparingInt(x -> x.damage));
        return weapons.get(0);
    }
    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons)
    {
        weapons.sort(Comparator.comparingInt(x -> x.strengt));
        return weapons.get(weapons.size()-1);
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons)
    {
        Stream<Weapon> missileweapons = weapons.stream().filter(x -> x.damageType.equals(damageType.MISSILE));
        List<Weapon> a = missileweapons.collect(Collectors.toList());
        return a;
    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons)
    {
        weapons.sort(Comparator.comparingInt(x -> x.name.length()));
        return weapons.get(weapons.size()-1);
    }
    public List<String> toNameList(List<Weapon> weapons)
    {
        List<String> a = new ArrayList<>();
        weapons.stream().map(weapon -> weapon.name).collect(Collectors.toCollection(() -> a));
        return a;
    }
    public int[] toSpeedArray(List<Weapon> weapons)
    {
        return new int[100];
    }
    public int sumUpValues(List<Weapon> weapons)
    {
        double sum = weapons.stream().mapToDouble(a -> a.value).reduce(0, (b1, b2) -> b1+b2);
        return (int) sum;
    }
/*

    public long sumUpHashCodes(List<Weapon> weapons) {
        //implement this
    }
*/
    public List<Weapon> removeDuplicates(List<Weapon> weapons)
    {
        List<Weapon> withoutdupli = weapons.stream().distinct().toList();
        return withoutdupli;
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons)
    {
        weapons.stream().map(weapon -> weapon.value*1.1);
    }
}