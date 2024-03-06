package lab5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

public class PaintFrame extends JFrame implements MouseInputListener{
    private BufferedImage bf ;
    private Controller c ;
    private int penSize = 5 ;
    private Color color ;
    private int X , Y ;
    private int start ;
    private int count = 0 ; 
    public PaintFrame(BufferedImage bf , Controller c) 
    {
        color = Color.BLACK ;
        this.c = c ;
        clearBF() ;
        setPreferredSize(new Dimension(bf.getWidth() , bf.getHeight()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.bf = bf ;
        addMouseListener(this);
        addMouseMotionListener(this);
        pack();
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);   
        g.drawImage(bf , 0 , 0 , this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (c.actBut == 1) 
        {
            X = e.getX() ;
            Y = e.getY() ;
        }
        else if (c.actBut == 2)
        {
            start = bf.getRGB(e.getX(), e.getY()) ;
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
    
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (c.actBut == 1)
        {
            for (int i = X - penSize; i <= X + penSize; i++) {
                for (int j = Y - penSize; j <= Y + penSize; j++) {
                    if (i >= 0 && i < bf.getWidth() && j >= 0 && j < bf.getHeight()) {
                        bf.setRGB(i, j, color.getRGB()); 
                    }
                }
            }
            X = e.getX() ;
            Y = e.getY() ;
        }
        else if (c.actBut == 2)
        {
            goDown(e.getX(), e.getY(), bf.getRGB(e.getX(), e.getY()), start); 
            goUp(e.getX(), e.getY()+1, bf.getRGB(e.getX(), e.getY()), start); 
        } 
        repaint(); 
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public void setPenSize(int r)
    {
        penSize = r ;
    }

    public void setColor(Color color) 
    {
        this.color = color ;
    }

    public void laser(int x , int y , int rgb , int firstC) 
    {
        if (y > 0 && y < bf.getHeight()) 
        {
            if (tolerance(rgb, firstC)) 
            {
                laser(x, y+1, bf.getRGB(x, y), firstC);
                laser(x, y-1, bf.getRGB(x, y), firstC);
                bf.setRGB(x, y, color.getRGB());
            }
        } 
    }

    public void goUp(int x , int y , int rgb , int base)
    {
        if (y < bf.getHeight()) 
        {
            if (tolerance(bf.getRGB(x, y), base)) 
            {
                goUp(x, y+1, bf.getRGB(x, y), base);
                bf.setRGB(x, y, color.getRGB());
            }
        }
    }

    public void goDown(int x , int y , int rgb , int base)
    {
        if (y > 0) 
        {
            if (tolerance(bf.getRGB(x, y), base)) 
            {
                goDown(x, y-1, bf.getRGB(x, y), base);
                bf.setRGB(x, y, color.getRGB());
            }
        }
    }
    

    public boolean tolerance(int firstColor , int secondColor) 
    {
        Color fColor = new Color(firstColor) ;
        Color sColor = new Color(secondColor) ;
        if (c.Tolerance == 1) {if (firstColor == secondColor) return true ;}
        else if ((Math.abs(fColor.getRed() - sColor.getRed()) + Math.abs(fColor.getGreen() - sColor.getGreen()) + Math.abs(fColor.getBlue() - sColor.getBlue()))/3 < c.Tolerance)
        {
            return true ;
        }
        return false ;
    }

    public void clearBF() 
    {
        c.clearBF();
        repaint();
    }
}
