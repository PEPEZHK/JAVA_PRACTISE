package lab5;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ToolsFrame extends JFrame implements ActionListener{
    private JButton clear ;
    private JButton pen ;
    private JButton penSize ;
    private JButton laser ;
    private JButton color ;
    private JButton tolerance ;
    private Controller c ;
    private String penS ;
    public ToolsFrame(Controller c) 
    {
        this.c = c ;
        setLayout(new GridLayout(6 , 1));
        setButtons();
        setPreferredSize(new Dimension(200, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true) ;
    }

    public void setButtons() 
    {
        clear = new JButton("CLear") ;
        clear.setFocusable(false);
        clear.addActionListener(this);
        add(clear) ;

        pen = new JButton("Pen") ;
        pen.setFocusable(false);
        pen.addActionListener(this);
        add(pen) ;

        penSize = new JButton("Pen Size") ;
        penSize.setFocusable(false); 
        penSize.addActionListener(this);
        add(penSize) ;

        laser = new JButton("Laser") ;
        laser.setFocusable(false);
        laser.addActionListener(this);
        add(laser) ;

        color = new JButton("Color") ;
        color.setFocusable(false); 
        color.addActionListener(this);
        add(color) ;

        tolerance = new JButton("Tolerance") ;
        tolerance.setFocusable(false); 
        tolerance.addActionListener(this);
        add(tolerance) ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) 
        {
            c.clear();    
        }
        else if (e.getSource() == pen) 
        {
            c.usePen();
        }
        else if (e.getSource() == penSize) 
        {
            do 
            {
                penS = JOptionPane.showInputDialog("Enter pen size:");
            }
            while(!penS.matches("[0-9]+")) ;
            c.penSize(Integer.parseInt(penS));
        }
        else if (e.getSource() == laser) 
        {
            c.useLaser();
        }
        else if (e.getSource() == color) 
        {
            c.displC();
        }
        else if (e.getSource() == tolerance) 
        {
            c.useTolerance();
        }
    }
}
