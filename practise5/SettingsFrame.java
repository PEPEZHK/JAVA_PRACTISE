package lab5;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
public class SettingsFrame extends JFrame{
    private JTextField h ;
    private JTextField w ;
    private JButton cont ;
    private Controller c ;
    public SettingsFrame(Controller c)
    {
        this.c = c ;
        setLayout(new GridLayout(3 , 1));
        ActionListener listener = new MyListener() ;
        h = new JTextField(10) ;
        w = new JTextField(10) ;
        cont = new JButton("Continue") ;
        cont.setBorder(new TitledBorder(new EtchedBorder()));
        cont.addActionListener(listener);
        cont.setFocusable(false);
        createPanels() ;
        add(cont) ;
        setPreferredSize(new Dimension(200, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }   

    private class MyListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (h.getText().isEmpty() || w.getText().isEmpty()) {JOptionPane.showMessageDialog(null, "Enter Both Values!");}
            else if (h.getText().length() >= 4 || w.getText().length() >= 4) {JOptionPane.showMessageDialog(null, "Enter Less Values!");}
            else {c.hideScreen(Integer.parseInt(w.getText()),Integer.parseInt(h.getText()));}
        }
    }

    public void createPanels() 
    {
        JPanel width = new JPanel() ;
        width.add(new JLabel("Width: ")) ;
        width.add(w) ;

        JPanel height = new JPanel() ;
        height.add(new JLabel("Height: ")) ;
        height.add(h) ;

        add(width) ;
        add(height) ;
    }
}
