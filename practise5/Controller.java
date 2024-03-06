package lab5;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

public class Controller {
    private BufferedImage bf ;
    private PaintFrame pF ;
    private ToolsFrame tF ;
    private SettingsFrame sF ;
    private int h ;
    private int w ;
    private int sizeP ;
    private DisplayColor dC ;
    private Color c ;
    protected int actBut ; 
    protected int Tolerance ;
    private String tolLevel ;
    public Controller() 
    {
        Tolerance = 1 ;
        actBut = 1 ;
        sF = new SettingsFrame(this) ;
    }

    public void clearBF()
    {
        Color col = Color.WHITE ;
        for (int i = 0 ; i < bf.getHeight() ; i++) 
        {
            for (int j = 0 ; j < bf.getWidth() ; j++) 
            {
                bf.setRGB(j, i, col.getRGB());
            }
        }
    }

    public void clear() 
    {
        pF.clearBF(); 
    }

    public void usePen()
    {
        actBut = 1 ;
    }

    public void penSize(int r)
    {
        pF.setPenSize(r);
    }

    public void useLaser() 
    {
        actBut = 2 ;
    }

    public void setColor(Color c)
    {
        pF.setColor(c);
    }
    
    public void displC() 
    {
        dC = new DisplayColor(this) ;
    }

    public void useTolerance()
    {
        do 
        {
            tolLevel = JOptionPane.showInputDialog("Enter tolerance level (0-255):");
        }
        while(!tolLevel.matches("[0-9]+") && Integer.parseInt(tolLevel) < 255) ;
        setToler(Integer.parseInt(tolLevel));
    }

    public void setW(int w) 
    {
        this.w = w ;
    }

    public void setH(int h) 
    {
        this.h = h ;
    }

    public void setBF() 
    {
        bf = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB) ;
    }

    public void hideScreen(int w , int h) 
    {
        setH(h);
        setW(w);
        setBF();
        sF.setVisible(false);
        pF = new PaintFrame(bf ,this) ;
        tF = new ToolsFrame(this) ;
    }

    public void setToler(int level) 
    {
        Tolerance = level ;
    }
}
