package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFileChooser;

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

        JButton reset = new JButton("Reset Display");

        reset rez = new reset();
        reset.addActionListener((ActionListener) rez);

        JPanel south = new JPanel();
        FractalGenerator mand = new Mandelbrot();
        FractalGenerator tric = new Tricorn();
        FractalGenerator burn = new BurningShip();
        JPanel north = new  JPanel();
        JComboBox comboBox = new JComboBox();

        comboBox.addItem(mand);
        comboBox.addItem(tric);
        comboBox.addItem(burn);

        Chooser fractals= new Chooser();
        comboBox.addActionListener(fractals);

        JLabel label = new JLabel("Fractal:");
        north.add(label);
        north.add(comboBox);

        JButton save = new JButton("Save");
        Saver save1 = new Saver();
        save.addActionListener(save1);
        south.add(save);
        south.add(reset);
        kliker klik = new kliker();
        JDisplay.addMouseListener(klik);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(north, BorderLayout.NORTH);
        frame.add(south, BorderLayout.SOUTH);
        frame.add(JDisplay, BorderLayout.CENTER);


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

    private class Saver implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equals("Save"))
            {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
                chooser.setFileFilter(filter);
                chooser.setAcceptAllFileFilterUsed(false);

                if (chooser.showSaveDialog(JDisplay) == JFileChooser.APPROVE_OPTION)
                {
                    java.io.File file = chooser.getSelectedFile();
                    String image = file.getPath();

                    file = new File(image + ".png");
                    try
                    {
                        BufferedImage displayImage = JDisplay.im();
                        ImageIO.write(displayImage, "png", file);
                    } catch (Exception exception)
                    {
                        JOptionPane.showMessageDialog(JDisplay, exception.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else return;
            }
        }
    }

    private class Chooser implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Object source = e.getSource();
            if (source instanceof JComboBox)
            {
                JComboBox comboBox = (JComboBox) source;

                gen = (FractalGenerator) comboBox.getSelectedItem();
                assert gen != null;

                gen.getInitialRange(d);
                drawFractal();
            }
        }
    }

    private class reset implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            gen.getInitialRange(d);
            drawFractal();
        }
    }

    private class kliker extends MouseAdapter
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
