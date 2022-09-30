package net.htlgkr.SaurerP190201.hue3Saurer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    static ArrayList<weapons> weap = new ArrayList<>();
    static String FILENAME = "src/weapons.csv";
    public static void main(String[] args)
    {
        readfile();
        Stream<weapons> st = weap.stream();
    }

    public static void readfile()
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
}
