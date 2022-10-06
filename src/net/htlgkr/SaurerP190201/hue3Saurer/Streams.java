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

        System.out.println("Durchschnitt: "+s.average(array));
        Main m = new Main();
        m.readfile();

        System.out.println(s.findWeaponWithLowestDamage(m.weap));
        System.out.println(s.findWeaponWithHighestStrength(m.weap));
        System.out.println(s.collectMissileWeapons(m.weap));
        System.out.println(s.findWeaponWithLongestName(m.weap));
        System.out.println(s.toNameList(m.weap));
        System.out.println(s.sumUpValues(m.weap));
        System.out.println(s.removeDuplicates(m.weap));
        System.out.println(s.sumUpHashCodes(m.weap));
        int[] speedarr = s.toSpeedArray(m.weap);

        String[] strarr = new String[10];

        for (int i = 0; i < 10; i++)
        {
            String adder = String.valueOf((char)(random.nextInt(26)+'a'));
            strarr[i]=adder;
        }
        Arrays.stream(strarr).forEach(System.out::print);
        System.out.println();
        System.out.println(s.upperCase(strarr));
    }

    public double average(int[] numbers)
    {
        return Arrays.stream(numbers).average().getAsDouble();
    }

    public List<String> upperCase(String[] strings)
    {
        return Stream.of(strings).map(String::toUpperCase).collect(Collectors.toList());
    }
    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons)
    {
        weapons.sort(Comparator.comparingInt(x -> x.damage));
        if(weapons.size()>0){return weapons.get(0);}
        else{return null;}
    }
    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons)
    {
        weapons.sort(Comparator.comparingInt(x -> x.strengt));
        if(weapons.size()>0){return weapons.get(weapons.size()-1);}
        else{return null;}
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
        if(weapons.size()>0){return weapons.get(weapons.size()-1);}
        else{return null;}
    }
    public List<String> toNameList(List<Weapon> weapons)
    {
        List<String> a = new ArrayList<>();
        weapons.stream().map(weapon -> weapon.name).collect(Collectors.toCollection(() -> a));
        return a;
    }
    public int[] toSpeedArray(List<Weapon> weapons)
    {
        int[] speedarr;
        ArrayList<Integer> ar = new ArrayList<>();
        weapons.stream().map(Weapon::getSpeed).collect(Collectors.toCollection(() -> ar));
        speedarr = ar.stream().mapToInt(i -> i).toArray();
        Arrays.stream(speedarr).forEach(System.out::print);
        return speedarr;
    }
    public int sumUpValues(List<Weapon> weapons)
    {
        double sum = weapons.stream().mapToDouble(a -> a.value).reduce(0, (b1, b2) -> b1+b2);
        return (int) sum;
    }

    public long sumUpHashCodes(List<Weapon> weapons)
    {
        double sum = weapons.stream().mapToDouble(Weapon::hashCode).reduce(0, Double::sum);
        return (int) sum;
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons)
    {
        List<Weapon> withoutdupli = weapons.stream().distinct().toList();
        return withoutdupli;
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons)
    {
        weapons.forEach(w -> w.setValue((int) (w.getValue()*1.1)));
    }
}