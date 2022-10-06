package net.htlgkr.SaurerP190201.hue3Saurer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Main{

    List<Weapon> weap = new ArrayList<>();
    List<String> st = new ArrayList<>();
    public static void main(String[] args)
    {
        Main main = new Main();
        main.readfile();
        main.st.remove(0);
        for(String s: main.st)
        {
            String[] a = s.split(";");
            combatType ct = combatType.getDT(a[1]);
            damageType dt = damageType.getCT(a[2]);
            Weapon w = new Weapon(a[0],ct,dt,Integer.parseInt(a[3]),Integer.parseInt(a[4]),Integer.parseInt(a[5]),Integer.parseInt(a[6]));
            main.weap.add(w);
        }
        Printable pr = (w -> w.forEach(System.out::println));

        main.sortfordamage();
        pr.print(main.weap);

        System.out.println();
        main.sortforcombatType();
        pr.print(main.weap);

        System.out.println();
        main.sortfordamageType();
        pr.print(main.weap);

        System.out.println();
        main.sortforname();
        pr.print(main.weap);

        Printable p = (n) ->
        {
            System.out.println("_____________________________________________________________________________________");
            System.out.println("|      Name        |  Combattype  |  Damagetype  | Damage | Speed | Strength | Value |");
            System.out.println("_____________________________________________________________________________________");
            for(Weapon w : n)
            {
                System.out.printf("| %-17s | %-12s | %-12s | %4d | %4d | %5d | %6d |", w.getName(), w.getCombatType(), w.getDamageType(), w.getDamage(), w.getSpeed(), w.getStrengt(), w.getValue());
                System.out.println(" ");
            }
            System.out.println("_____________________________________________________________________________________");
        };
        p.print(main.weap);
    }

    public void readfile()
    {
        String FILENAME = "src/weapons.csv";
        try{
            Files.lines(Path.of(FILENAME)).collect(Collectors.toCollection(() -> st));}
        catch (IOException e){System.out.println("Nix geht");}
        st.remove(0);
        for(String s: st)
        {
            String[] a = s.split(";");
            combatType ct = combatType.getDT(a[1]);
            damageType dt = damageType.getCT(a[2]);
            Weapon w = new Weapon(a[0],ct,dt,Integer.parseInt(a[3]),Integer.parseInt(a[4]),Integer.parseInt(a[5]),Integer.parseInt(a[6]));
            weap.add(w);
        }
            /*s.nextLine();
            while(s.hasNextLine())
            {
                String e = s.nextLine();
                String[] a = e.split(";");
                combatType ct = combatType.getDT(a[1]);
                damageType dt = damageType.getCT(a[2]);
                weapons w = new weapons(a[0],ct,dt,Integer.parseInt(a[3]),Integer.parseInt(a[4]),Integer.parseInt(a[5]),Integer.parseInt(a[6]));
                weap.add(w);
            }*/
    }

    public void sortfordamage()
    {
        Collections.sort(weap, Comparator.comparingInt(p -> p.damage));
    }
    public void sortforcombatType()
    {
        Collections.sort(weap, Comparator.comparing(p -> p.combatType));
    }
    public void sortfordamageType()
    {
        Collections.sort(weap, Comparator.comparing(p -> p.damageType));
    }
    public void sortforname()
    {
        Collections.sort(weap, Comparator.comparing(p -> p.name));
    }

}
