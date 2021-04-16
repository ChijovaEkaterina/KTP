package com.company;

import javafx.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
//класс FractalExplorer, который позволит исследовать
//различные области фрактала, путем его создания, отображения через
//графический интерфейс Swing и обработки событий, вызванных
//взаимодействием приложения с пользователем.
public class FractalExplorer {
    //Целое число «размер экрана», которое является шириной и высотой
    //отображения в пикселях. (
    private int size;
    //Ссылка JImageDisplay, для обновления отображения в разных
    //методах в процессе вычисления фрактала
    private JImageDisplay display;
    //Объект FractalGenerator. Будет использоваться ссылка на базовый
    //класс для отображения других видов фракталов в будущем.
    private FractalGenerator fractal;
    //Объект Rectangle2D.Double, указывающий диапазона комплексной
    //плоскости, которая выводится на экран.
    private Rectangle2D.Double range;

    //конструктор, который принимает значение
    //размера отображения в качестве аргумента, затем сохраняет это значение в
    //соответствующем поле, а также инициализирует объекты диапазона и
    //фрактального генератора.
    public FractalExplorer(int a) {

        size = a;
        fractal = new Mandelbrot();
        range = new Rectangle2D.Double();
        fractal.getInitialRange(range);
        display = new JImageDisplay(size, size);
    }

    //инициализирует
    //графический интерфейс Swing
    public void createAndShowGUI()
    {
        display.setLayout(new BorderLayout());
        JFrame frame = new JFrame("Fractal Explorer");
        frame.add(display, BorderLayout.CENTER);

        JButton resetButton = new JButton("Reset Display");

        frame.add(resetButton, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ResetHandler handler = new ResetHandler();
        resetButton.addActionListener(handler);

        MouseHandler click = new MouseHandler();
        display.addMouseListener(click);

        //Данные операции правильно разметят содержимое окна, сделают его
        //видимым
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    //для вывода на экран фрактала
    private void drawFractal (){
        //Этот метод должен циклически проходить через каждый пиксель в отображении
        for (int x=0; x<size; x++) {
            for (int y = 0; y < size; y++) {
                double xCoord = FractalGenerator.getCoord (range.x, range.x + range.width, size, x);
                double yCoord = FractalGenerator.getCoord (range.y, range.y + range.height, size, y);
                int iteration=fractal.numIterations(xCoord, yCoord);
                //Если число итераций равно -1 (т.е. точка не выходит за границы,
                //установите пиксель в черный цвет (для rgb значение 0). Иначе выберите
                //значение цвета, основанное на количестве итераций.
                if (iteration == -1) {
                    display.drawPixel(x, y, 0);
                }
                else {
                    float hue = 0.7f + (float) iteration / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);

                    display.drawPixel(x, y, rgbColor);
                }
            }
        }
        display.repaint();
    }

    //внутренний класс для обработки событий
    //java.awt.event.ActionListener от кнопки сброса. Обработчик должен сбросить
    //диапазон к начальному, определенному генератором, а затем перерисовать
    //фрактал.
    private class ResetHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            fractal.getInitialRange(range);
            drawFractal();
        }

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {

        }
    }

    //внутренний класс для обработки событий java.awt.event.MouseListener с дисплея. При получении события о щелчке мышью, класс должен
    //отобразить пиксельные кооринаты щелчка в область фрактала, а затем вызвать
    //метод генератора recenterAndZoomRange() с координатами, по которым
    //щелкнули, и масштабом 0.5. Таким образом, нажимая на какое-либо место на
    //фрактальном отображении, вы увеличиваете его
        private class MouseHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            double xCoord = fractal.getCoord(range.x, range.x + range.width, size, x);
            int y = e.getY();
            double yCoord = fractal.getCoord(range.y, range.y + range.height, size, y);
            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
        }
    }
    public static void main(String[] args)
    {
        FractalExplorer displayExplorer = new FractalExplorer(600);
        displayExplorer.createAndShowGUI();
        displayExplorer.drawFractal();
    }
}


