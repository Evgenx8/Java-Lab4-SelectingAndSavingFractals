package com.company;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class FractalExplorer
{
    private int si;
    private JImageDisplay JDisplay;
    private FractalGenerator gen;
    private Rectangle2D.Double d;


    public FractalExplorer(int size)
    {
        si = size;
        gen = new Mandelbrot();
        d = new Rectangle2D.Double();
        gen.getInitialRange(d);
        JDisplay = new JImageDisplay(si, si);
    }

    public void createAndShowGUI()
    {
        JDisplay.setLayout(new BorderLayout());
        JFrame frame = new JFrame("Fractal Explorer");

        frame.add(JDisplay, BorderLayout.CENTER);

        JButton resetButton = new JButton("Reset Display");

        reset rez = new reset();
        resetButton.addActionListener((ActionListener) rez);

        frame.add(resetButton, BorderLayout.SOUTH);

        Clicker klik = new Clicker();
        JDisplay.addMouseListener(klik);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void drawFractal()
    {
        double x1, y1;
        for (int x = 0; x < si; x++)
        {
            for (int y = 0; y < si; y++)
            {
                x1 = FractalGenerator.getCoord(d.x, d.x + d.width, si, x);
                y1 = FractalGenerator.getCoord(d.y, d.y + d.height, si, y);

                int k = gen.numIterations(x1, y1);

                if (k == -1)
                {
                    JDisplay.drawPixel(x, y, 0);
                } else
                {
                    float hue = 0.7f + (float) k / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);

                    JDisplay.drawPixel(x, y, rgbColor);
                }
            }
        }
        JDisplay.repaint();
    }

    private class reset implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            gen.getInitialRange(d);
            drawFractal();
        }
    }

    private class Clicker extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            super.mouseClicked(e);
            int x = e.getX();
            int y = e.getY();
            double x1, y1;
            x1 = FractalGenerator.getCoord(d.x, d.x + d.width, si, x);
            y1 = FractalGenerator.getCoord(d.y, d.y + d.height, si, y);

            gen.recenterAndZoomRange(d, x1, y1, 0.5);
            drawFractal();
        }
    }

    public static void main(String[] args)
    {
        FractalExplorer displayExplorer = new FractalExplorer(800);
        displayExplorer.createAndShowGUI();
        displayExplorer.drawFractal();
    }
}
