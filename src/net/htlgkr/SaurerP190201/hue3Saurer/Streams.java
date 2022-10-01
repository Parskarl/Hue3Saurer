package net.htlgkr.SaurerP190201.hue3Saurer;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;

public class Streams
{
        public static void createarray()
        {
            Random random = new Random();
            int[] array = random.ints(9999, 0,100).toArray();
        }

        public double average(int[] numbers)
        {
            double av = Arrays.stream(numbers).average().getAsDouble();
            return av;
        }

        public List<String> upperCase(String[] strings) {
            List<String> a = List.of(strings);
            a.stream().map(String::toUpperCase);
            return a;
        }

        public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
            //implement this
        }

        public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
            //implement this
        }

        public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
            //implement this
        }

        public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
            //implement this
        }

        public List<String> toNameList(List<Weapon> weapons) {
            //implement this
        }

        public int[] toSpeedArray(List<Weapon> weapons) {
            //implement this
        }

        public int sumUpValues(List<Weapon> weapons) {
            //implement this
        }

        public long sumUpHashCodes(List<Weapon> weapons) {
            //implement this
        }

        public List<Weapon> removeDuplicates(List<Weapon> weapons) {
            //implement this
        }

        public void increaseValuesByTenPercent(List<Weapon> weapons) {
            //implement this
        }
    }