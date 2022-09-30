package net.htlgkr.SaurerP190201.hue3Saurer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

public class Main{

    List<weapons> weap = new ArrayList<>();
    static String FILENAME = "src/weapons.csv";
    public static void main(String[] args)
    {
        Main main = new Main();
        main.readfile();
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
    }

    public void readfile()
    {
        try {
            Scanner s = new Scanner(new File(FILENAME));
            s.nextLine();
            while(s.hasNextLine())
            {
                String e = s.nextLine();
                String[] a = e.split(";");
                combatType ct = combatType.getDT(a[1]);
                damageType dt = damageType.getCT(a[2]);
                weapons w = new weapons(a[0],ct,dt,Integer.parseInt(a[3]),Integer.parseInt(a[4]),Integer.parseInt(a[5]),Integer.parseInt(a[6]));
                weap.add(w);
            }
        } catch (FileNotFoundException e){e.printStackTrace();}
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
