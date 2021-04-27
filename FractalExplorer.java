package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

//класс FractalExplorer, который позволит исследовать
//различные области фрактала, путем его создания, отображения через
//графический интерфейс Swing и обработки событий, вызванных
//взаимодействием приложения с пользователем.
public class FractalExplorer {
    //Целое число «размер экрана», которое является шириной и высотой
    //отображения в пикселях. (
    private int size;
    private int rowRemaining;
    //Ссылка JImageDisplay, для обновления отображения в разных
    //методах в процессе вычисления фрактала
    private JImageDisplay display;
    //Объект FractalGenerator. Будет использоваться ссылка на базовый
    //класс для отображения других видов фракталов в будущем.
    private FractalGenerator fractal;
    //Объект Rectangle2D.Double, указывающий диапазона комплексной
    //плоскости, которая выводится на экран.
    private Rectangle2D.Double range;
    private JComboBox comboBox = new JComboBox();
    private JButton saveButton = new JButton("Save");
    private JButton resetButton = new JButton("Reset");

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

        JPanel panel = new JPanel();

        JLabel label = new JLabel("Fractal");

        JComboBox comboBox = new JComboBox();
        comboBox.addItem(new Mandelbrot());
        comboBox.addItem(new Tricorn());
        comboBox.addItem(new Burning_Ship());

        panel.add(label);
        panel.add(comboBox);

        JFrame frame = new JFrame("Fractal Explorer");
        frame.add(display, BorderLayout.CENTER);

        frame.add(panel, BorderLayout.NORTH);

        JButton resetButton = new JButton("Reset");
        JButton saveButton = new JButton("Save");
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(resetButton);
        bottomPanel.add(saveButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        ButtonHandler saveHandler = new ButtonHandler();
        saveButton.addActionListener(saveHandler);


        ButtonHandler fractalChooser = new ButtonHandler();
        comboBox.addActionListener(fractalChooser);



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
    private void enableUI(boolean val) {
        comboBox.setEnabled(val);
        resetButton.setEnabled(val);
        saveButton.setEnabled(val);
    }
    //для вывода на экран фрактала
    private void drawFractal (){
        //Этот метод должен циклически проходить через каждый пиксель в отображении
        rowRemaining = size;
        enableUI(false);
        for(int i = 0; i < size; i++)
        {
            FractalWorker fractalWorker = new FractalWorker(i);
            fractalWorker.execute();
        }
    }

    //внутренний класс для обработки событий
    //java.awt.event.ActionListener от кнопки сброса. Обработчик должен сбросить
    //диапазон к начальному, определенному генератором, а затем перерисовать
    //фрактал.

    private class ResetHandler implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            fractal.getInitialRange(range);
            drawFractal();
        }
    }

    private class FractalWorker extends SwingWorker<Object, Object>
    {
        private int y;
        private int[] rgb;

        public FractalWorker(int y)
        {
            this.y=y;
        }

        @Override
        protected Object doInBackground() throws Exception {
            rgb=new int[size];
            for(int i = 0; i < size; i++)
            {
                double xCoord = FractalGenerator.getCoord(range.x,range.x + range.width, size, i);
                double yCoord = FractalGenerator.getCoord(range.y,range.y + range.height, size, y);
                int iter = fractal.numIterations(xCoord,yCoord);
                if (iter == -1)rgb[i]=0;
                else
                {
                    float hue = 0.7f + (float)iter / 200f;
                    rgb[i] =Color.HSBtoRGB(hue,1f,1f);
                }

            }
            return null;
        }

        protected void done()
        {
            for(int i = 0; i < size; i++)
            {
                display.drawPixel(i,y,rgb[i]);
            }
            display.repaint(0,0,y,size,1);
            rowRemaining--;
            if(rowRemaining == 0) enableUI(true);
        }
    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            String command = e.getActionCommand();
            if (e.getSource() instanceof JComboBox) {
                JComboBox mySource = (JComboBox) e.getSource();
                fractal = (FractalGenerator) mySource.getSelectedItem();
                fractal.getInitialRange(range);
                drawFractal();
            } else if (command.equals("Reset")) {
                fractal.getInitialRange(range);
                drawFractal();
            } else if (command.equals("Save")) {

                JButton button = (JButton) e.getSource();
                JFileChooser fileChooser = new JFileChooser();
                FileFilter filter = new FileNameExtensionFilter("PNG Images", "png");
                fileChooser.setFileFilter(filter);
                fileChooser.setAcceptAllFileFilterUsed(false);
                if (fileChooser.showSaveDialog(button.getParent()) == JFileChooser.APPROVE_OPTION) {
                    try {
                        ImageIO.write(display.getGraphicsConfiguration().createCompatibleImage(size, size), "png", fileChooser.getSelectedFile());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(button.getParent(), ex.getMessage(),
                                "Cannot Save Image", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

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


