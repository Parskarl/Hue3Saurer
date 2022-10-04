package net.htlgkr.SaurerP190201.hue3Saurer;

import java.util.Objects;
import java.util.function.Predicate;

public class Main3
{
    public static void main(String[] args)
    {
        final Predicate<Integer> isEven = x -> x%2==0;
        final Predicate<Integer> isPositive = x -> x>0;
        final Predicate<Integer> isnull = x -> x==0;
        final Predicate<Integer> isNull = Objects::isNull;
        final Predicate<String> isShortWord = x -> x.length()>4;

        System.out.println("isEven1");
        int x =3;
        System.out.println(isEven.test(x));

        System.out.println("isEven2");
        x =4;
        System.out.println(isEven.test(x));

        System.out.println("isPositive1");
        x =-3;
        System.out.println(isPositive.test(x));

        System.out.println("isPositive2");
        x =4;
        System.out.println(isPositive.test(x));

        System.out.println("isnull1");
        x =3;
        System.out.println(isnull.test(x));

        System.out.println("isnull2");
        x =0;
        System.out.println(isnull.test(x));

        System.out.println("isNull1");
        Integer ntest = null;
        System.out.println(isNull.test(ntest));

        System.out.println("isNull2");
        x =0;
        System.out.println(isNull.test(x));

        System.out.println("isShortWord1");
        String s = "no";
        System.out.println(isShortWord.test(s));

        System.out.println("isShortWord2");
        s ="longerthan";
        System.out.println(isShortWord.test(s));

        System.out.println("NumberisPositiveandEven");
        System.out.println(isEven.and(isPositive).test(4));
        System.out.println(isEven.and(isPositive).test(3));
        System.out.println(isEven.and(isPositive).test(-5));

        System.out.println("NumberisPositiveandOdd");
        System.out.println(isEven.negate().and(isPositive).test(4));
        System.out.println(isEven.negate().and(isPositive).test(3));
        System.out.println(isEven.negate().and(isPositive).test(-5));
    }
}
