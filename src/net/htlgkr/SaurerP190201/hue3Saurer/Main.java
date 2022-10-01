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
        Printable p = (w -> w.forEach(System.out::println));

        main.sortfordamage();
        p.print(main.weap);

        System.out.println();
        main.sortforcombatType();
        p.print(main.weap);

        System.out.println();
        main.sortfordamageType();
        p.print(main.weap);

        System.out.println();
        main.sortforname();
        p.print(main.weap);

        //TODO Aufgabe 1.6 Tabelle;
    }

    public void readfile()
    {
        String FILENAME = "src/weapons.csv";
        try{
            Files.lines(Path.of(FILENAME)).collect(Collectors.toCollection(() -> st));}
        catch (IOException e){System.out.println("Nix geht");}
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
