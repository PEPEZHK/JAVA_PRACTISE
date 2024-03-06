package lab4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TreeFrame {
    JFrame frame = new JFrame("Merhaba cistik bebek <3") ;
    JButton spring = new JButton("Spring") ; 
    JButton summer = new JButton("Summer") ;
    JButton fall = new JButton("Fall") ;
    JButton winter = new JButton("Winter") ;
    TreePanel tree ;
    public TreeFrame()
    {
        tree = new TreePanel() ;
        JPanel panel = new JPanel() ;
        spring.setFocusable(false);
        spring.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                tree.season = 1 ;
            }
            
        });
        fall.setFocusable(false);
        fall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                tree.season = 3 ;
            }
        });
        summer.setFocusable(false);
        summer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                tree.season = 2 ;
            }
        });
        winter.setFocusable(false);
        winter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                tree.season = 4 ;
            }
        });
        panel.add(spring) ;
        panel.add(summer) ;
        panel.add(fall) ;
        panel.add(winter) ;
        frame.setLayout(new BorderLayout());
        frame.setSize(500 , 600) ;
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel , BorderLayout.SOUTH) ;
        frame.add(tree , BorderLayout.CENTER) ;
    }
}
