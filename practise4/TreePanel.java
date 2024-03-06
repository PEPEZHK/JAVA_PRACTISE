package lab4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.Timer; 
import javax.swing.JPanel;

public class TreePanel extends JPanel implements ActionListener{
    private final int[] xList = {65 , 30 , 48 , 150 , 210 , 220 , 240 , 300 , 380 , 400 , 420 , 385 , 280 , 215 , 150 ,65} ;
    private final int[] yList = {350 , 280 , 140 , 100 , 155 , 120 , 105 , 70 , 100 , 150 , 220 , 290 , 300 , 290 , 330 , 350} ;
    private final int[] Xkora = {90 ,  120 , 140 , 135 , 75  , 88 , 100 , 155 , 170 , 160 , 190 , 195 , 235 , 265 , 250 , 295 , 269 , 295 , 335 , 350 , 345 , 270 , 305 , 355} ;
    private final int[] Ykora = {490 , 465 , 425 , 385 , 340 , 260 , 325 , 340 , 270 , 185 , 245 , 303 , 345 , 320 , 240 , 180 , 250 , 320 , 275 , 225 , 320 , 400 , 450 , 490} ;
    static int[] xSpring ;
    static int[] ySpring ; 
    static int[] xFall ;
    static int[] yFall ;
    static int[] xWinter ;
    static int[] yWinter ;
    static int[] xSpringLeaves ;
    static int[] xFallLeaves ;
    static int[] ySpringLeaves ;
    static int[] yFallLeaves ;
    static int season ;
    private Timer timer ;
    static Random r = new Random() ;
    static int counter = 0 ;
    private int shift ;
    static int numsOfFlakes = 60 ;
    private final static int HEIGHT = 500 ;
    private final static int WIDTH = 500 ;
    static int[] x , y , speedX , speedY;
    static int direction = 1 ;
    public TreePanel()
    {
        xSpringLeaves = Arrays.copyOf(xList, xList.length) ;
        xFallLeaves = Arrays.copyOf(xList, xList.length) ;
        xSpring = Arrays.copyOf(Xkora, Xkora.length) ;
        xFall = Arrays.copyOf(Xkora, Xkora.length) ;
        xWinter = Arrays.copyOf(Xkora, Xkora.length) ;
        ySpring = Arrays.copyOf(Ykora, Ykora.length) ;
        yFall = Arrays.copyOf(Ykora, Ykora.length) ;
        yWinter = Arrays.copyOf(Ykora, Ykora.length) ;
        yFallLeaves = Arrays.copyOf(yList, yList.length) ;
        ySpringLeaves = Arrays.copyOf(yList, yList.length) ;
        setSize(WIDTH , HEIGHT);
        timer = new Timer(100 , this) ;
        timer.start(); 
        initializaFlakes();
    }

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        if (season == 1) 
        {
            shift = 3 ;
            setBackground(Color.CYAN);
            g.setColor(new Color(0, 158, 96));
            g.fillRect(0, 490, 500, 50);
            g.setColor(new Color(0, 158, 96));
            chagneLeaves(xSpringLeaves, ySpringLeaves, shift);
            g.fillPolygon(xSpringLeaves , yList, 16);
            chagneTree(xSpring, ySpring, shift);
            g.setColor(new Color(102,51,0));
            g.fillPolygon(xSpring , ySpring , 24);
                
        }
        else if (season == 2) 
        {
            setBackground(new Color(173, 216, 230));
            g.setColor(Color.GREEN);
            g.fillRect(0, 490, 500, 50);
            g.setColor(Color.GREEN);
            g.fillPolygon(xList, yList, 16);
            g.setColor(new Color(102,51,0));
            g.fillPolygon(Xkora, Ykora, 24);
            g.setColor(Color.red);
            g.fillOval(100 , 250 , 25, 25);
            g.setColor(Color.red);
            g.fillOval(80 , 180 , 25, 25);
            g.setColor(Color.red);
            g.fillOval(280 , 230 , 25, 25);
            g.setColor(Color.red);
            g.fillOval(300 , 140 , 25, 25);
            g.setColor(Color.red);
            g.fillOval(190 , 220 , 25, 25);
        }
        else if (season == 3) 
        {
            shift = 4 ;
            setBackground(Color.LIGHT_GRAY);
            
            g.setColor(new Color(255 , 140 , 0));
            g.fillRect(0, 490, 500, 50);
            chagneLeaves(xFallLeaves , yFallLeaves, shift);
            g.setColor(new Color(255, 165, 0));
            g.fillPolygon(xFallLeaves, yList, 16);
            chagneTree(xFall, yFall,shift);
            g.setColor(new Color(102,51,0));
            g.fillPolygon(xFall, yFall ,24);
            
        }
        else if (season == 4)
        {
            shift = 5 ;
            setBackground(Color.DARK_GRAY);
            g.setColor(Color.GRAY);
            g.fillRect(0, 490, 500, 50);
            chagneTree(xWinter , yWinter, shift);
            g.setColor(new Color(102,51,0));
            g.fillPolygon(xWinter, yWinter, 24);
            drawSnowFlakes(g); 
        }  
    }

    public static void chagneTree(int[] x , int[] y , int value) 
    {
        int in = -1 ;
        if (counter <= 4) 
        {
            in = 1 ;
        }
        System.out.println(Arrays.toString(x));
        for (int i = 2 ; i < x.length - 2; i++)
        {
            if (in == -1)
            {
                x[i] -= in*value*((490.0 - y[i])/310) -1;
            }
            else 
            {
                x[i] -= in*value*((490.0 - y[i])/310);
            }
        }
    }

    public static void chagneLeaves(int[] x , int[] y , int value) 
    {
        int in = -1 ;
        if (counter <= 4) 
        {
            in = 1 ;
        }
        for (int i = 2 ; i < x.length - 2; i++)
        {
            if (in == -1)
            {
                x[i] -= in*value*((490.0 - y[i])/310) -1;
            }
            else 
            {
                x[i] -= in*value*((490.0 - y[i])/310);
            }
        }
    }

    public static void drawSnowFlakes(Graphics g)
    {
        g.setColor(Color.WHITE);
        for (int i = 0 ; i < numsOfFlakes ; i++) 
        {
            if (x[i] - speedX[i] == 0 || x[i] - speedX[i] >= WIDTH) 
            {
                x[i] = 0 ;
                speedX[i] = r.nextInt(7) + 5 ;
            }
            else if (y[i] + speedY[i] >= HEIGHT) 
            {
                y[i] = 0 ;
                speedY[i] = r.nextInt(21) + 5 ;
            }
            else 
            {
                int direction = r.nextInt(2) ;
                if (direction == 0) 
                {
                    g.fillOval(x[i] - speedX[i] , y[i] + speedY[i] , 5 , 5);
                    x[i] -= speedX[i] ;  
                    y[i] += speedY[i] ;
                }
                else 
                {
                    g.fillOval(x[i] + speedX[i] , y[i] + speedY[i] , 5 , 5);
                    x[i] += speedX[i] ;  
                    y[i] += speedY[i] ;
                }
            }
        }
    }

    public static void initializaFlakes()
    {
        x = new int[numsOfFlakes] ; 
        y = new int[numsOfFlakes] ; 
        speedX = new int[numsOfFlakes] ; 
        speedY = new int[numsOfFlakes] ; 
        for (int i = 0 ; i < numsOfFlakes ; i++) 
        {
            x[i] = r.nextInt(WIDTH) ;
            y[i] = 0 ;
            speedX[i] = r.nextInt(7) + 5 ;
            speedY[i] = r.nextInt(21) +  5 ;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        counter ++ ;
        if (counter == 10) counter = 0 ;
    }
}
