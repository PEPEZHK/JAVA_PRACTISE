import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Paint extends JPanel implements KeyListener, ActionListener
{
    private BufferedImage current ;
    private ArrayList<Integer> iterations ;
    private ArrayList<BufferedImage> images ;
    private Timer timer ;
    private double factor ;
    private int iterationCount ;
    private int index ;
    public Paint() throws IOException 
    {
        index = 0 ;
        timer = new Timer(80, this) ;
        initialize(); 
        setFocusable(true);
        setPreferredSize(new Dimension(current.getWidth(), current.getHeight()));
        addKeyListener(this);
        timer.start();
    }

    
    public void initialize() throws IOException 
    {
        images = new ArrayList<>() ;
        iterations = new ArrayList<>() ;
        factor = 1 ;
        iterations.add(0); 
        images.add(ImageIO.read(new File("gigaChad.jpg"))) ;
        iterations.add(0);
        images.add(ImageIO.read(new File("загрузка (1).png"))) ;
        iterations.add(0);
        images.add(ImageIO.read(new File("загрузка.png"))) ;
        current = images.get(index) ;
        iterationCount = iterations.get(index) ;
    }
    
    public int biggestDiagonal(int x , int y) 
    {
        return Math.min(current.getWidth() - x, current.getHeight() - y); 
    }
    
    public void sort(int x , int y) 
    {
        int maxY = y ;
        int maxX = x ;
        for (int i = 0 ; i < biggestDiagonal(x, y) ; i++) 
        {
            if (brightness(current.getRGB(i+x, i+y)) > brightness(current.getRGB(maxX,maxY))) {
                maxY = i+y ;
                maxX = i+x ;
            }
        }
        swap(x, y, maxX , maxY);
    }
    
    
    public void swap(int x , int y , int maxX , int maxY) 
    {
        int temp =  current.getRGB(x, y);
        current.setRGB(x, y, current.getRGB(maxX,maxY));
        current.setRGB(maxX,maxY, temp);
    }
    
    public void rightSort(int x , int y) 
    {
        if (x < current.getWidth()) 
        {
            sort(x, y);
            rightSort(x+1, y);
        }
    }

    public void downSort(int x , int y) 
    {
        if (y < current.getHeight())
        {
            sort(x, y);
            downSort(x, y+1);
        }
    }
    
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        factor = resize() ;
        g.drawImage(current, 0, 0, (int)(factor * current.getWidth()), (int)(factor * current.getHeight()), this);
    }

    public double resize() 
    {
        if ((double)getWidth()/current.getWidth() >= (double)(getHeight())/current.getHeight()) 
        return (double)(getHeight())/current.getHeight();
        else 
        return (double)getWidth()/current.getWidth() ;
    }

    public double brightness(int f) 
    {
        Color c = new Color(f) ;
        return (0.2126 * c.getRed() + 0.7152 * c.getGreen() + 0.0722 * c.getBlue()) ;
    }

    @Override
    public void keyTyped(KeyEvent e) {}


    @Override
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) 
        {
            if (index < 3) 
            {
                iterations.set(index, iterationCount) ;
                index ++;
                current = images.get(index) ;
                iterationCount = iterations.get(index) ;
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) 
        {
            if (index > 0) 
            {
                iterations.set(index, iterationCount) ;
                index --;
                current = images.get(index) ;
                iterationCount = iterations.get(index) ;
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_R)
        {
            try {
                if (index == 0) 
                {
                    images.set(index, ImageIO.read(new File("gigaChad.jpg"))) ;
                    iterations.set(index, 0) ;
                }
                else if (index == 1)
                {
                    images.set(index, ImageIO.read(new File("загрузка (1).png"))) ;
                    iterations.set(index, 0) ;
                }
                else if (index == 2)
                {
                    images.set(index, ImageIO.read(new File("загрузка.png"))) ;
                    iterations.set(index, 0) ;
                }
                current = images.get(index) ;
                iterationCount = iterations.get(index) ;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        repaint(); 
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) throws IOException {
        Paint p = new Paint() ;
        JFrame f = new JFrame() ;
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p) ;
        f.pack();
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (iterationCount < current.getWidth() - 1 && iterationCount < current.getHeight() - 1)
        {
            sort(iterationCount, iterationCount);

            rightSort(iterationCount+1, iterationCount);
        
            downSort(iterationCount, iterationCount+1);
        
            iterationCount++;

            repaint();
        }
    }
}
