
package calculate;
 
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JButton;
//import javax.swing.JPanel;
//import javax.swing.JTextField;


public class calc extends JFrame  {
        JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;
        JLabel l1;
        JTextField t1,t2;
        JPanel p1,p2,p3;
        JRadioButton r1,r2;
        ButtonGroup bg; 
        int leng,num;
        double ans,d1,d2,d3;
        String s1,s2,s3="";
        
   public calc(){
    this.setTitle("mohamed mndour");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(340, 310);
    this.setBounds(350,400, 340, 310);
    this.setLayout(null);
    this.setVisible(true);
    this.setResizable(false);
    
    
    
   bg=new ButtonGroup(); 
   p1=new JPanel();    p2=new JPanel(); 
   p3=new JPanel(); 
   t1=new JTextField("",25);   t2=new JTextField("",15);
   b1=new JButton("1");        b11=new JButton("=");  
   b2=new JButton("2");        b12=new JButton(".");  
   b3=new JButton("3");        b13=new JButton("+");
   b4=new JButton("4");        b14=new JButton("-");
   b5=new JButton("5");        b15=new JButton("*");
   b6=new JButton("6");        b16=new JButton("/");
   b7=new JButton("7");      
   b8=new JButton("8");        b18=new JButton("clear");
   b9=new JButton("9");        b19=new JButton("Mode");
   b10=new JButton("0");       b20=new JButton("<--");  

   r1=new JRadioButton("on");      r2=new JRadioButton("off");
   
    ;
    p1.setBackground(Color.red);    p2.setBackground(Color.green);
    p3.setBackground(Color.orange);
    r1.setBackground(Color.green);   r2.setBackground(Color.green);
     
   b19.setFont(new Font("",Font.BOLD,6));
    
    
   this.add(p1);   this.add(p2);  this.add(p3);  
   p1.add(t2);    p1.add(t1);    
   p2.add(b1);    p2.add(b2);
   p2.add(b3);    p2.add(b4);
   p2.add(b5);    p2.add(b6);
   p2.add(b7);    p2.add(b8);
   p2.add(b9);    p2.add(b10);
   p2.add(b11);   p2.add(b12);
   p2.add(b18);
   p2.add(b20);
   p2.add(r1);    p2.add(r2);
   p3.add(b19);   p3.add(b13);
   p3.add(b14);   p3.add(b15);
   p3.add(b16);  
   
   
   bg.add(r1);  bg.add(r2);
   
   p1.setBounds(0, 0, 340, 60);   p2.setBounds(0, 60, 250, 340);
   p3.setBounds(250, 60, 90, 300);
   t2.setBounds(10, 0, 40, 15);
   t1.setBounds(10, 15, 300, 30);
   r1.setBounds(10, 5, 70, 20);
   r2.setBounds(10,25, 70, 20);
   b20.setBounds(90, 10, 70, 30);
   b18.setBounds(170, 10, 70, 30);
   b1.setBounds(10, 50, 70, 30);
   b2.setBounds(90, 50, 70, 30);
   b3.setBounds(170, 50, 70, 30);
   b4.setBounds(10, 90, 70, 30);
   b5.setBounds(90, 90, 70, 30);
   b6.setBounds(170, 90, 70, 30);
   b7.setBounds(10, 130, 70, 30);
   b8.setBounds(90, 130, 70, 30);
   b9.setBounds(170, 130, 70, 30);
   b11.setBounds(10, 170, 70, 30);
   b10.setBounds(90, 170, 70, 30);
   b12.setBounds(170, 170, 70, 30);
   b19.setBounds(10, 10, 50, 30);
   b13.setBounds(10, 50, 50, 30);
   b14.setBounds(10, 90, 50, 30);
   b15.setBounds(10, 130, 50, 30);
   b16.setBounds(10, 170, 50, 30);
   
   
  r1.setEnabled(false);

   
    r1.addMouseListener(new MouseAdapter(){
   
       @Override public void mouseClicked(MouseEvent e) {
          on();
       }  });
    r2.addMouseListener(new MouseAdapter(){
   
       @Override public void mouseClicked(MouseEvent e) {
          off();
       }  });
   
    b1.addMouseListener(new MouseAdapter(){
   
       @Override public void mouseClicked(MouseEvent e) {
          t1.setText(t1.getText()+"1");
       }  });
    b2.addMouseListener(new MouseAdapter(){
   
       @Override public void mouseClicked(MouseEvent e) {
          t1.setText(t1.getText()+"2");
       }  });
    b3.addMouseListener(new MouseAdapter(){
   
       @Override public void mouseClicked(MouseEvent e) {
          t1.setText(t1.getText()+"3");
       }  });
    b4.addMouseListener(new MouseAdapter(){
   
       @Override public void mouseClicked(MouseEvent e) {
          t1.setText(t1.getText()+"4");
      }  });
    b5.addMouseListener(new MouseAdapter(){
   
       @Override public void mouseClicked(MouseEvent e) {
          t1.setText(t1.getText()+"5");
       }  });
    b6.addMouseListener(new MouseAdapter(){
   
       @Override public void mouseClicked(MouseEvent e) {
          t1.setText(t1.getText()+"6");
       }  });
    b7.addMouseListener(new MouseAdapter(){
   
       @Override public void mouseClicked(MouseEvent e) {
          t1.setText(t1.getText()+"7");
       }  });
    b8.addMouseListener(new MouseAdapter(){
   
       @Override public void mouseClicked(MouseEvent e) {
          t1.setText(t1.getText()+"8");
       }  });
    b9.addMouseListener(new MouseAdapter(){
   
       @Override public void mouseClicked(MouseEvent e) {
          t1.setText(t1.getText()+"9");
       }  });
    b10.addMouseListener(new MouseAdapter(){
   
       @Override public void mouseClicked(MouseEvent e) {
          t1.setText(t1.getText()+"0");
       }  });
    b11.addMouseListener(new MouseAdapter(){
   
       @Override public void mouseClicked(MouseEvent e) {
        
    if(s3=="+")
              {
        ans=d1+Double.parseDouble(t1.getText());   
         s2=Double.toString(ans);
         t1.setText(s2);
         
              }
    else if(s3=="-"){
         ans=d1-Double.parseDouble(t1.getText());   
         s2=Double.toString(ans);
         t1.setText(s2);
        
              }
    else if(s3=="*"){
         ans=d1*Double.parseDouble(t1.getText());   
         s2=Double.toString(ans);
         t1.setText(s2);
          
              }
    else if(s3=="/"){
         ans=d1/Double.parseDouble(t1.getText());   
         s2=Double.toString(ans);
         t1.setText(s2);
          
              }
    t2.setText("");
    
    
    
    
    
         
       }  });
    b12.addMouseListener(new MouseAdapter(){
   
       @Override public void mouseClicked(MouseEvent e) {
          t1.setText(t1.getText()+".");
       }  });
    b13.addMouseListener(new MouseAdapter(){
   
       @Override public void mouseClicked(MouseEvent e) {
        d1= Double.parseDouble(t1.getText());    //turn string (t1.getText())to double
        t1.setText("");
        t2.setText(d1+"+");                  //string
        s3="+";                             //to use it in if in button(=)
        
//       d1= Double.parseDouble(t1.getText());   //turn string (t1.getText())to double
//       ans=d1+Double.parseDouble(t1.getText());  // do addition operation
//       s1=Double.toString(ans);  //turn double(addition operation) (ans=d1+Double.parseDouble(t1.getText());)to string
//       t1.setText(s1);
       }  });
    b14.addMouseListener(new MouseAdapter(){
   
       @Override public void mouseClicked(MouseEvent e) {
          
        d1= Double.parseDouble(t1.getText());    //turn string (t1.getText())to double
        t1.setText("");
        t2.setText(d1+"-");  //string
         s3="-";                             //to use it in if in button(=)
       }  });
    b15.addMouseListener(new MouseAdapter(){
   
       @Override public void mouseClicked(MouseEvent e) {
        d1= Double.parseDouble(t1.getText());    //turn string (t1.getText())to double
        t1.setText("");
        t2.setText(d1+"*");  //string
         s3="*";                             //to use it in if in button(=)
          
       }  });
    b16.addMouseListener(new MouseAdapter(){
  
       @Override public void mouseClicked(MouseEvent e) {
        d1= Double.parseDouble(t1.getText());    //turn string (t1.getText())to double
        t1.setText("");
        t2.setText(d1+"/");  //string
        s3="/";                             //to use it in if in button(=)
       }  });
   /* b17.addMouseListener(new MouseAdapter(){
   
       @Override public void mouseClicked(MouseEvent e) {
         
       }  });*/
    b18.addMouseListener(new MouseAdapter(){
   
       @Override public void mouseClicked(MouseEvent e) {
          t1.setText("");
          t2.setText("");
       }  });
    b19.addMouseListener(new MouseAdapter(){
   
       @Override public void mouseClicked(MouseEvent e) {
     mode mo=new mode();
       }  });
    b20.addMouseListener(new MouseAdapter(){
   
        @Override public void mouseClicked(MouseEvent e) {
        String st = null;
        leng=t1.getText().length();
        num=t1.getText().length()-1;
        StringBuilder sb=new StringBuilder(t1.getText());
        sb.deleteCharAt(num);
        st=sb.toString();
        t1.setText(st);
       }  });

 
   
   
   
   
   
   
   
   }
   public void off(){
   t1.setEnabled(false);
   r1.setEnabled(true);     r2.setEnabled(false);
   b1.setEnabled(false);    b2.setEnabled(false);
   b3.setEnabled(false);    b4.setEnabled(false);
   b5.setEnabled(false);    b6.setEnabled(false);
   b7.setEnabled(false);    b8.setEnabled(false);
   b9.setEnabled(false);    b10.setEnabled(false);
   b11.setEnabled(false);   b12.setEnabled(false);
   b13.setEnabled(false);   b14.setEnabled(false);
   b15.setEnabled(false);   b16.setEnabled(false);
   b18.setEnabled(false);
   b19.setEnabled(false);   b20.setEnabled(false);
   }
     public void on(){
   t1.setEnabled(true);
   r1.setEnabled(false);   r2.setEnabled(true);
   b1.setEnabled(true);    b2.setEnabled(true);
   b3.setEnabled(true);    b4.setEnabled(true);
   b5.setEnabled(true);    b6.setEnabled(true);
   b7.setEnabled(true);    b8.setEnabled(true);
   b9.setEnabled(true);    b10.setEnabled(true);
   b11.setEnabled(true);   b12.setEnabled(true);
   b13.setEnabled(true);   b14.setEnabled(true);
   b15.setEnabled(true);   b16.setEnabled(true);
   b18.setEnabled(true);
   b19.setEnabled(true);   b20.setEnabled(true);
   }
 
          public static void main(String[] args) {
    calc mm=new calc();
    
    }  
        
        
}
