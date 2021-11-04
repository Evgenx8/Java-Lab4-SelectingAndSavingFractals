package com.company;

import java.awt.geom.Rectangle2D;

public class BurningShip extends FractalGenerator
{
    public static final int MAX_ITERATIONS = 2000;

    public void getInitialRange(Rectangle2D.Double range)
    {
        range.x = -2;
        range.y = -2.5;
        range.width = 4;
        range.height = 4;
    }

    public int numIterations(double x, double y)
    {
        double r = 0, i = 0, r1, i1;
        int k = 0;

        while (k < MAX_ITERATIONS && (r * r + i * i) < 4)
        {
            r1 = (r * r) - (i * i) + x;
            i1 = 2 * Math.abs(r*i) + y;
            r = r1;
            i = i1;
            k++;
        }

        if (k == MAX_ITERATIONS)
            return -1;
        return k;
    }

    @Override
    public String toString()
    {
        return "Burning Ship";
    }

}
