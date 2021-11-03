package com.company;
import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.out;


public class Tasks2 {

    public static void main(String[] args)
    {
        //11
        System.out.println(repeat("hello", 3));
        //12
        int b[] = {10, 4, 1, 4, -10, -50, 32, 21};
        int a = differenceMaxMin(b);
        System.out.println(a);
        //13
        int d[] = {2, 4, 2, 8};
        System.out.println(isAvgWhole(d));
        //14
        int[] q = {3, 3, -2, 408, 3, 3};
        cumulativeSum(q);
        //15
        System.out.println();
        System.out.println(getDecimalPlaces("123.4512"));
        //16
        int Fib = Fibonacci(12);
        System.out.println(Fib);
        //17
        System.out.println(isValid("12345"));
        //18
        System.out.println(isStrangerPair("ratio", "orator"));
        //19
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        //20
        System.out.println(boxSeq(6));
        // таски 21-30
        System.out.println("Таски 21-30");
        //21
        System.out.println(solutions(1, 0, -1));
        //22
        System.out.println(findZip("all zip files are Zipped zipped zip"));
        //23
        System.out.println(checkPerfect(97));
        //24
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        //25
        System.out.println(isValidHexCode("#CD5C5C"));
        //26
        int r1[] = {1, 3, 1, 2};
        int r2[] = {2, 5, 7};
        System.out.println(same(new int[]{1, 3, 1, 2}, new int[]{2, 5, 7}));
        //27
        System.out.println(isKaprekar(297));
        //28
        System.out.println(longestZero("01100001011000"));
        //29
        System.out.println(nextPrime(12));
        //30
        System.out.println(rightTriangle(145, 105, 100));
        //31
        System.out.println(textProc(10,7,"hello my name is Bessie and this is my essay"));
    }
    public static String repeat(String a, int b)
    {
        String s = "";
        for(int i = 0; i < a.length(); i++)
        {
            for (int j = 0; j < b; j++)
            {
                s = s + a.charAt(i);
            }
        }
        return s;
    }
    public static int differenceMaxMin(int[] a)
    {
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++)
        {
            if (max < a[i])
            {
                max = a[i];
            }
            if (min > a[i])
            {
                min = a[i];
            }
        }
        return max - min;
    }
    public static boolean isAvgWhole(int[] a)
    {
        int sred = 0;
        int d = 0;
        for (int i = 0; i < a.length; i++)
        {
            sred += a[i];
            d++;
        }
        return sred % d == 0;
    }
    public static void cumulativeSum(int[] a)
    {
        System.out.print(a[0] + " ");
        for (int i = 1; i < a.length; i++)
        {
            a[i] += a[i - 1];
            System.out.print(a[i] + " ");
        }
    }
    public static int getDecimalPlaces (String s)
    {
        int index1 = s.indexOf(".");
        int col = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (i > index1)
            {
                col++;
            }
        }
        return col;
    }
    public static int Fibonacci (int a)//каждый следующий сумма 2 прошлых
    {
        int n0 = 1;
        int n1 = 1;
        int n2 = 0;
        for (int i = 3; i <= a + 1; i++)
        {
            n2 = n0 + n1;
            n0 = n1;
            n1 = n2;
        }
        return n2;
    }
    public static boolean isValid (String s)
    {
        return s.matches("[0-9]+") && s.length() <= 5;
    }
    public static int boxSeq(int a)
    {
        int sh = 0;
        int pole = 0;
        while (sh < a)
        {
                sh++;
                if(sh % 2 == 0)
                {
                    pole = pole - 1;
                }
                else
                {
                    pole = pole + 3;
                }
        }
        return pole;
    }
    public static boolean isStrangerPair(String s1, String s2)
    {
        return (s1.charAt(0) == s2.charAt(s2.length() - 1) && (s2.charAt(0) == s1.charAt(s1.length() - 1)));
    }
    public static boolean isPrefix(String s1, String s2)
    {
        s2 = s2.replace("-", "");
        return s1.startsWith(s2);
    }
    public static boolean isSuffix(String s1, String s2)
    {
        s2 = s2.replace("-", "");
        return s1.endsWith(s2);
    }
    public static int solutions(int a, int b, int c)
    {
        if ((b * b - 4 * a * c) > 0)
        {
            return 2;
        }
        else if ((b * b - 4 * a * c) == 0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    public static int findZip(String s)
    {
        s = s.replaceFirst("zip", "");
        if (s.contains("zip"))
        {
            return s.indexOf("zip") + 3;
        }
        else
            return -1;
    }
    public static boolean checkPerfect(int a)
    {
        int sum = 0;
        for (int i = 1; i < a; i++)
        {
            if (a % i == 0)
            {
                sum += i;
            }
        }
        return sum == a;
    }

    public static boolean same(int[] a1, int[] a2)
    {
        int count = 0;
        int count2 = 0;
        Set set = new HashSet();
        for (int i = 0; i < a1.length; i++)
        {
            if (set.add(a1[i]))
            {
                count++;
            }
        }
        Set set2 = new HashSet();
        for (int i = 0; i < a2.length; i++)
        {
            if (set.add(a2[i]))
            {
                count2++;
            }
        }
        if (count == count2)
            return true;
        else
            return false;
    }
    public static int nextPrime(int n)//делали с Филином
    {
        boolean isPrime = false;
        int m = (int) Math.ceil(Math.sqrt(n));
        int start = 3;
        if (n % 2 == 0)
        {
            n = n + 1;
        }
        while (!isPrime)
        {
            isPrime = true;
            for (int i = start; i <= m; i = i + 2)
            {
                if (n % i == 0)
                {
                    isPrime = false;
                    break;
                }
            }
            if (!isPrime)
            {
                n = n + 2;
            }
        }
        return n;
    }
    public static boolean rightTriangle(int x, int y, int z)
    {
        return (x * x == y * y + z * z || y * y == x * x + z * z || z * z == x * x + y * y);
    }
    public static boolean isKaprekar(int a)
    {
        int q;
        int u;
        int count = 0;
        int b = a*a;
        StringBuilder s = new StringBuilder();
        StringBuilder l = new StringBuilder();
        String kapr = String.valueOf(b);
        for (int i = 0; i < kapr.length(); i++)
        {
            count++;
        }

        if(count%2==0 || count != 1)
        {
            for(int i = 0; i < kapr.length()/2;i++)
            {
                s.append(kapr.charAt(i));
            }
            String j = s.toString();
            u = Integer.parseInt(j);
            for(int i = kapr.length()/2; i < kapr.length();i++)
            {
                l.append(kapr.charAt(i));
            }
            String ll = l.toString();
            q = Integer.parseInt(ll);

        }
        else {
            u=0;
            q = b;
        }
        return (q + u) == a;
    }
        /*int count = 0;
        int left = 0;
        int right = 0;
        int b = a * a;
        int c = 0;
        StringBuffer sb = new StringBuffer("");
        String s = String.valueOf(b);
        for (int i = 0; i < s.length(); i++)
        {
            count++;
        }
        if (count % 2 == 0)
        {
            left = Integer.parseInt(s.trim());
        }
        else
        {
            int pos = 0;
            for (int i = 0; i < (int) s.length()/2; i++)
            {
                String s1 = String.valueOf(s.charAt(i));
                String s2 = s1.concat(s1);
                sb.insert(pos, s1);
                left += Integer.valueOf(s2);
                pos++;
            }
            for (int i = s.length()/2; (int) i < s.length(); i++)
            {
                String s1 = String.valueOf(s.charAt(i));
                String s2 = s1.concat(s1);
                right += Integer.valueOf(s2);
            }
            c = left + right;
        }
        return (c == a);
    }*/
        public static String flipEndChars(String s)
        {
            if (s.length() <= 2)
            {
                return "Incompatible";
            }
            else if (s.charAt(0) == s.charAt(s.length() - 1))
            {
                return "Two's a pair";
            }
            else
            {
                StringBuilder sb = new StringBuilder(s);
                char start = sb.charAt(0);
                char end = sb.charAt(s.length() - 1);
                sb.setCharAt(0, end);
                sb.setCharAt(s.length() - 1, start);
                return sb.toString();
            }
        }
    public static boolean isValidHexCode(String s)
    {
        if (s.charAt(0) == '#' && s.length() == 7)
        {
            for (int i = 1; i <= 6; i++)
            {
                char c = s.charAt(i);
                if ((c < '0' || c > '9') && (c < 'A' || c > 'F') && (c < 'a' || c > 'f'))
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public static String longestZero(String str)
    {
        StringBuilder s = new StringBuilder();
        int count = 0;
        int max = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == '1')
            {
                count = 0;
            }
            else
            {
                count++;
                if (count > max)
                {
                    max = count;
                }
            }
        }
        for (int j = 0; j < max; j++)
        {
            s.append("0");
        }
        if (max == 0)
        {
            return "' '";
        }
        else
        {
            String jj = s.toString();
            return jj;
        }
    }
    public static String textProc(int n, int k, String str)
    {
        String st = "";
        int m = 0;
        String[] j = new String[n];
        j = str.split(" ");
        for (int i = 0; i < n; i++)
        {
            if (m + j[i].length() < k + 1)
            {
                st = st + " " + j[i];
                m = m + j[i].length();
            } else {
                st = st + "\n" + j[i];
                m = j[i].length();
            }
        }
        return st.trim(); //без пробелов в начале в конце строки
    }

}

























