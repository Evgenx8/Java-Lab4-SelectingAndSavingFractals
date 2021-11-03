package com.company;
import java.util.ArrayList;
import java.util.Arrays;

public class Tasks3
{

    public static void main(String[] args)
    {
        //31
        System.out.println(textProc(10,7,"hello my name is Bessie and this is my essay"));
        //32
        System.out.println(Arrays.toString(split("((()))(())()()(()())")));
        //33
        System.out.println(toCamelCase("is_modal_open"));
        System.out.println(toSnakeCase("getColor"));
        //34
        double arr34[] = {13.25, 15, 30, 1.5};
        System.out.println(overTime(arr34));
        //35
        System.out.println(BMI("154 pounds", "2 meters"));
        //36
        System.out.println(bugger(999));
        //37
        System.out.println(toStarShorthand("abbccc"));
        //38
        System.out.println(doesRhyme("and frequently do?", "you gotta move."));
        //39
        System.out.println(trouble(666789, 12345667));
        //40
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));

    }

    public static String textProc(int n, int k, String str)
    {
        String st = "";
        int m = 0; //кол-о сим. на данный момент
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
    public static String[] split(String str)
    {
        int m = 0, g = 0, p = 0;
        ArrayList<String> j = new ArrayList<>();
        StringBuilder st = new StringBuilder("");
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == '(')
            {
                m++;
                st = st.append("(");
            }
            if (str.charAt(i) == ')')
            {
                g++;
                st = st.append(")");
            }
            if (m == g)
            {
                if (g != 0)
                {
                    j.add(st.toString());
                    p++;
                    st = new StringBuilder();
                }
            }
        }
        return j.toArray(j.toArray(new String[j.size()]));
    }
    public static String toCamelCase(String str)
    {
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == '_')
            {
                str = str.substring(0, i) + str.substring(i + 1, i + 2).toUpperCase() + str.substring(i + 2, str.length());
            }
        }
        return str;
    }
    public static String toSnakeCase(String str)
    {
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) > 'A' && str.charAt(i) < 'Z')
            {
                str = str.substring(0, i) + "_" + str.substring(i, i + 1).toLowerCase() + str.substring(i + 1, str.length());
            }
        }
        return str;
    }
    public static String overTime(double[] arr)
    {
        double k = 0;
        double m = 0;
        //сколько часов проработал сверхурочно до начала раб.дня
        if (9 - arr[0] > 0) {
            k = k + 9 - arr[0];
        }
        //сколько часов проработал сверхурочно после конца раб.дня
        if (arr[1] - 17 > 0) {
            k = k + arr[1] - 17;
        }
        m = arr[1] - arr[0] - k; //общее
        double z = Math.round(arr[2] * (k * arr[3] + m) * 100.0) / 100.0;
        String str = "$";
        str = str + Double.toString(z);
        return str;
    }
    public static String BMI(String str1, String str2)
    {
        double k = 0;
        double c = 0;
        double j;
        String q = " Overweigth", p = " Normal weigth", e = " Underweigth", l = "";
        if(str1.indexOf("k") != -1)
        {
            k = Double.parseDouble(str1.split(" kilos")[0]);
        }
        if(str1.indexOf("p") != -1)
        {
            k = Double.parseDouble(str1.split(" pounds")[0])/2.2;
        }
        if(str2.indexOf("m") != -1)
        {
            c = Double.parseDouble(str2.split(" meters")[0]);
        }
        if(str2.indexOf("i") != -1)
        {
            c = Double.parseDouble(str2.split(" inches")[0])/39;
        }
        j = Math.round(((k/c)/c)*10.0)/10.0;
        if(j < 18.5)
            l = j + e;
        else
        if(j < 24.9)
            l = j + p;
        else
            l = j+q;
        return (l);
    }
    public static int bugger(int n)
    {
        int j = 1, l = n, k = 0;
        while (l/10 >= 1)
        {
            while (l != 0)
            {
                j = j * (l % 10);
                l = l / 10;
            }
            l = j;
            j = 1;
            k++;
        }
        return k;
    }
    public static String toStarShorthand(String str)
    {
        int k = 1;
        for (int i = 1; i < str.length(); i++)
        {
            if (str.charAt(i-1) == str.charAt(i))
            {
                k++;
                str = str.substring(0, i) + str.substring(i+1, str.length());
                i--;
            }
            else
            if(k > 1)
            {
                str = str.substring(0, i) + "*" + k + str.substring(i, str.length());
                k = 1;
            }
        }
        if(k > 1)
            str = str + "*" + k;
        return str;
    }
    public static boolean doesRhyme(String str1, String str2)
    {
        String[] j = new String[str1.length()];
        String[] j1 = new String[str1.length()];
        String[] j2 = new String[str1.length()];
        String[] j3 = new String[str1.length()];
        boolean m = false;
        j = str1.split(" ");
        j1 = str2.split(" ");
        int p = 0, q = 0;
        for (int i = 0; i < j[j.length-1].length(); i++)
        {
            if (j[j.length-1].substring(i, i + 1).matches("^(?i:[aeiouy]).*")) //matches() возращает true, если вся строка совпадает с шаблоном
            {
                j2[p] = j[j.length-1].substring(i, i + 1).toLowerCase();
                p++;
            }
        }
        for (int i = 0; i < j1[j1.length-1].length(); i++)
        {
            if (j1[j1.length-1].substring(i, i + 1).matches("^(?i:[aeiouy]).*"))
            {
                j3[q] = j1[j1.length-1].substring(i, i + 1).toLowerCase();
                q++;
            }
        }
        if (p == q)
        {
            for(int i = 0; i < p; i++)
            {
                if(j2[i].charAt(0) == j3[i].charAt(0))
                {
                    m = true;
                }
                else
                {
                    m = false;
                }
            }
        }
        return m;
    }
    public static boolean trouble(long a, long b)
    {
        long k = a, n = b, c = 0, m = 0, g = 0;
        boolean z = false;
        while (k > 0)
        {
            k = k / 10;
            c++;
        }
        k = a;
        int u[] = new int[(int) c];
        for (long j = c - 1; j >= 0; j--)
        {
            u[(int) j] = (int) (k % 10);
            k = k / 10;
        }
        while (n > 0)
        {
            n = n / 10;
            m++;
        }
        n = b;
        int u1[] = new int[(int) c];
        int u2[] = new int[(int) m];
        for (long j = m - 1; j >= 0; j--)
        {
            u2[(int) j] = (int) (n % 10);
            n = n / 10;
        }
        for(int i = 1; i < c-1; i++)
        {
            if(u[i-1] == u[i] && u[i] == u[i+1])
            {
                u1[(int) g] = u[i];
                g++;
            }
        }
        for(int i = 0; i < m - 1; i++)
        {
            for(int j = 0; j < g; j++)
            {
                if (u1[j] == u2[i] && u1[j] == u2[i+1])
                {
                    z = true;
                }
            }
        }
        return z;
    }
    public static int countUniqueBooks(String str, char bookEnd)
    {
        int k = 0, m, c = 0, b;
        while (str.indexOf(bookEnd) != -1)
        {
            k = str.indexOf(bookEnd);
            m = str.indexOf(bookEnd, k + 1);
            for(int i = k+1; i<m;i++)
            {
                if (str.charAt(i) == str.charAt(i+1))
                {
                    c--;
                }
            }
            str = str.substring(m+1);
            c = c + m - k - 1;
        }
        return c;
    }
}
