package com.company;

import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

public class JImageDisplay extends JComponent {
    private BufferedImage displayImage;
    // Конструктор инициализации
    public JImageDisplay ( int width, int height) {
        //инициализация объекта BufferedImage новым
        //изображением с шириной и высотой, и типом изображения
        //TYPE_INT_RGB.
        displayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //вызвов метод setPreferredSize()
        //родительского класса метод с указанной шириной и высотой.
        Dimension imageDimension= new Dimension(width, height);
        super.setPreferredSize(imageDimension);}
        //собственный код для отрисовки, переопределяющий защищенный метод JComponent
        //paintComponent (Graphics g).
        @Override
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(displayImage, 0, 0, getWidth(), getHeight(), null);
    }
    // устанавливает все пиксели
    //изображения в черный цвет
    public void clearImage() {
        Graphics g = displayImage.getGraphics();
        g.clearRect(0, 0, getWidth(), getHeight());}
    // устанавливает пиксель в определенный цвет
    public void drawPixel (int x, int y, int rgbColor){
            displayImage.setRGB(x, y, rgbColor);
        }

    }



