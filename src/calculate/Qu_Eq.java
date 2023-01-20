package calculate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Qu_Eq extends JFrame implements ActionListener{
        JButton b1;
        JLabel l1,l2,l3,l4,l5,l6;
        JTextField t1,t2,t3,t4,t5;
 Qu_Eq(){
    this.setTitle("Quadratic Equation");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setVisible(true);
    this.setResizable(false);
    this.setBounds(700,400, 300,260);

 b1=new JButton("Result");
 l1=new JLabel("aX2 + bX + C = 0");
 l2=new JLabel("Enter value for (a)");    l3=new JLabel("Enter value for (b)");  
                    l4=new JLabel("Enter value for (c)");
l5=new JLabel("X1 =");   l6=new JLabel("X2 =");
   
t1=new JTextField("", 15);   t2=new JTextField("", 15);
                t3=new JTextField("", 15);
t4=new JTextField("", 10);   t5=new JTextField("", 10);   
 l1.setBounds(80,5,200,40);  
 l2.setBounds(20,50,150,20);   t1.setBounds(130,50,150,25);
 l3.setBounds(20,80,150,20);   t2.setBounds(130,80,150,25); 
 l4.setBounds(20,110,150,20);  t3.setBounds(130,110,150,25);
 b1.setBounds(100,145,70,30); 
 l5.setBounds(35,185,40,20);   t4.setBounds(70,185,60,25); 
 l6.setBounds(165,185,40,20);  t5.setBounds(200,185,60,25);
 l1.setFont(new Font("",Font.BOLD,20));
 l5.setFont(new Font("",Font.BOLD,15));
 l6.setFont(new Font("",Font.BOLD,15));
 add(b1);  
 add(l1);   add(l2);
 add(l3);   add(l4);   add(l5);  add(l6); 
 add(t1);   add(t2);   add(t3);  add(t4);  add(t5);
 b1.addActionListener(this);
 }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
  int a=Integer.parseInt(t1.getText());
  int b=Integer.parseInt(t2.getText());
  int c=Integer.parseInt(t3.getText());
  
  double x1=((-b+(Math.sqrt(b*b-4*a*c)))/2*a);
  double x2=((-b-(Math.sqrt(b*b-4*a*c)))/2*a);
  String s1=Double.toString(x1); 
  String s2=Double.toString(x2);
  t4.setText(s1);
  t5.setText(s2);
    }
    
    
    
    
}
