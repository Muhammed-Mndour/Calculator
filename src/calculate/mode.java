package calculate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class mode extends JFrame implements ActionListener{
    JButton ba,bq;
    JLabel la,lq;
    mode(){
    this.setTitle("mode");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setVisible(true);
    this.setResizable(false);
    this.setBounds(700,400, 300, 165);
    this.setBackground(Color.YELLOW);
    ba=new JButton("array");
    bq=new JButton("Quadratic Equation");
    ba.setBackground(Color.orange);
    bq.setBackground(Color.green);
     ba.setBounds(15,10,260, 50);
     bq.setBounds(15,70,260, 50);
    this.add(ba);  this.add(bq); 
    ba.addActionListener(this);
    bq.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ba)
        { 
            rmao rmao=new rmao();//FOR ARRAYS
        }
        else if (e.getSource()==bq)
        {
        Qu_Eq Qe=new Qu_Eq();
        }
          }
    
    
    
}
