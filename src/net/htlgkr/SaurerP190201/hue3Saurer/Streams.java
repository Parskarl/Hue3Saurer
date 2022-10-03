package net.htlgkr.SaurerP190201.hue3Saurer;

import java.util.Random;

public class Streams
{
        public static void createarray()
        {
            Random random = new Random();
            int[] array = random.ints(9999, 0,100).toArray();
        }
    }