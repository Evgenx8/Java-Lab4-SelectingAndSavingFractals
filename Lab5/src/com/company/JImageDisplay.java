package com.company;

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class JImageDisplay extends JComponent
{
    private BufferedImage m;
    public BufferedImage im()
    {
        return m;
    }

    public JImageDisplay(int w, int h)
    {
        m = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Dimension ty = new Dimension(w, h);
        super.setPreferredSize(ty);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(m,0,0,m.getWidth(), m.getHeight(), null);
    }
    public void clearImage()
    {
        Graphics2D itr = m.createGraphics();
        itr.setColor(Color.BLACK);
        itr.fillRect(0, 0, m.getWidth(), m.getHeight());
    }
    public void drawPixel (int x, int y, int rgbColor)
    {
        m.setRGB(x, y, rgbColor);
    }
}
