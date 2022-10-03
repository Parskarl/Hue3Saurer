package net.htlgkr.SaurerP190201.hue3Saurer;

import java.util.stream.IntStream;

public class Main4
{
    public static void main(String[] args)
    {
        final int result = IntStream.of(1,2,3,4,5,6,7,8,9,10).filter(x -> x%2!=0).map(x -> x*x).reduce(0,(b1, b2)-> b1+b2);
        System.out.println(result);
    }
}