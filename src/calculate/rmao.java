
package calculate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class rmao implements ActionListener 
{
     private static int col, row; 
     private static double myMatrix [][];
      private static double tempMatrix [][]; 
     private static JTextField inputField [][];
     private static int result;
     private static JButton minusB, plusB,  multiplyB, 
                            getValueB, showMatrix,newMatrix;
     private static JPanel choosePanel [] = new JPanel[8];
     private static int lastCol , lastRow ;
      
 
     rmao ()
     {

         col = row = 0;
         myMatrix = new double [0][0];
         ChooseOperation();
     }
     
     
     //prompting for matrix's dimensions
     private static void getDimension() 
    {
        
      JTextField lField = new JTextField(5); //lenght field 
      JTextField wField = new JTextField(5); //col field
      
      
      //design input line
      JPanel choosePanel [] = new JPanel [2];
       choosePanel [0] = new JPanel();
       choosePanel [1] = new JPanel();
      choosePanel[0].add(new JLabel("Enter Dimensitions") );
      choosePanel[1].add(new JLabel("Rows:"));
      choosePanel[1].add(lField);
      choosePanel[1].add(Box.createHorizontalStrut(15)); // a spacer
      choosePanel[1].add(new JLabel("Cols:"));
      choosePanel[1].add(wField);
        
      result = JOptionPane.showConfirmDialog(null, choosePanel, 
               null,JOptionPane.OK_CANCEL_OPTION, 
               JOptionPane.PLAIN_MESSAGE);
        
      //save last dimensions
      lastCol = col;
      lastRow = row;
      
      //ok option
       if(result == 0)
       {
         
         if(wField.getText().equals(""))
             col = 0;
         else
         {
             if(isInt(wField.getText()))
             {
                 col = Integer.parseInt(wField.getText());
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "Wrong Dimensions");
                 col = lastCol;
                 row = lastRow;
                 return;
             }
            
             if(isInt(lField.getText()))
             {
                 row = Integer.parseInt(lField.getText());
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "Wrong Dimensions");
                 col = lastCol;
                 row = lastRow;
                 return;
             }
          
         }
       if(col < 1 || row < 1)
       {
           JOptionPane.showConfirmDialog(null, "You entered wrong dimensions", 
                   "Error",JOptionPane.PLAIN_MESSAGE);
           col  = lastCol;
           row = lastRow;
          
       }
       else
       {
           tempMatrix = myMatrix;
           myMatrix = new double [row][col];
            if(!setElements(myMatrix, "Fill your new matrix")) //filling the new matrix
            {
                //backup
                
                myMatrix = tempMatrix;
            }
       }
       }
       else if(result == 1)
       {
           col = lastCol;
           row = lastRow;
       }
     }//end get Dimension
    
     //setting a matrix's elementis
    private static boolean setElements(double matrix [][], String title )
    {
        int temp, temp1;             //temprature variable
        String tempString;
        
       JPanel choosePanel [] = new JPanel [row+2];
       choosePanel[0] = new JPanel();
       choosePanel[0].add(new Label(title ));
       choosePanel[choosePanel.length-1] = new JPanel();
       choosePanel[choosePanel.length-1].add(new Label("consider space field as zeros"));
       inputField  = new JTextField [matrix.length][matrix[0].length];
        
       
       //lenght loop
       for(temp = 1; temp <= matrix.length; temp++)
       {
           choosePanel[temp] = new JPanel();
           
           
           for(temp1 = 0; temp1 < matrix[0].length; temp1++)
           {
               inputField [temp-1][temp1] = new JTextField(3);
               choosePanel[temp].add(inputField [temp-1][temp1]);
               
               if(temp1 < matrix[0].length -1)
               {
               choosePanel[temp].add(Box.createHorizontalStrut(15)); // a spacer
               }
               
           }//end col loop
           
       }//end row loop
       
       result = JOptionPane.showConfirmDialog(null, choosePanel, 
       null, JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);
     
      
      if(result == 0)
      {
          checkTextField(inputField);
       for(temp = 0; temp < matrix.length; temp++)
       {
        for(temp1 = 0; temp1 < matrix[0].length; temp1++)
            {
                tempString = inputField[temp][temp1].getText();
                
                
                 if(isDouble(tempString))
                {
                matrix [temp][temp1] = Double.parseDouble(inputField[temp][temp1].getText());
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "You entered wrong elements");
                    
                    //backup
                    col = lastCol;
                    row = lastRow;
                    
                    return false;
                }                      
            }
       }
       return true;
    }
      else
          return false;
    
      
    }//end get Inputs
    
    //for setting spaced fields as zeros
     private static void checkTextField (JTextField field [][] )
     {
         for(int temp = 0; temp < field.length; temp++)
         {
             for(int temp1 = 0; temp1 < field[0].length; temp1++)
             {
                 if(field[temp][temp1].getText().equals(""))
                 field[temp][temp1].setText("0");
             }
         }
     }//end reset
     
    private void ChooseOperation ()
    {
        int temp;

        for(temp = 0; temp < choosePanel.length; temp++)
        {
            choosePanel [temp] = new JPanel ();
        }

        showMatrix = new JButton ("Show Matrix");
        showMatrix.setBackground(Color.orange);
        showMatrix.setPreferredSize(new Dimension(175,35));
        showMatrix.addActionListener(this);
        choosePanel[4].add(showMatrix);
        
        plusB = new JButton ("Plusing with Matrix");
        plusB.setBackground(Color.orange);
        plusB.setPreferredSize(new Dimension(175,35));
        plusB.addActionListener(this);
        choosePanel[2].add(plusB);
        
        minusB = new JButton ("Subtracting with Matrix");
        minusB .setBackground(Color.yellow);
        minusB.setPreferredSize(new Dimension(175,35));
        minusB.addActionListener(this);
        choosePanel[2].add(minusB);
        
        multiplyB = new JButton ("Multiplying by matrix");
        multiplyB .setBackground(Color.green);
        multiplyB.setPreferredSize(new Dimension(175,35));
        multiplyB.addActionListener(this);
        choosePanel[3].add(multiplyB);

        
        if(col == row )
        {
           getValueB = new JButton ("GET Value");
           getValueB.setPreferredSize(new Dimension(175,35));
           getValueB.addActionListener(this);
           getValueB .setBackground(Color.cyan);
           choosePanel[4].add(getValueB);
           

                   
        }
        
        newMatrix = new JButton("New Matrix");
        newMatrix.setPreferredSize(new Dimension(275,35));
        newMatrix.addActionListener(this);
        choosePanel[5].add(newMatrix);
        newMatrix .setBackground(Color.lightGray);
        JOptionPane.showConfirmDialog(null, choosePanel, null,
               JOptionPane.CLOSED_OPTION , JOptionPane.PLAIN_MESSAGE);
         
    }
   
   
    @Override
    public  void actionPerformed(ActionEvent e) 
    {
        
        if(e.getSource() == showMatrix)
        {
            showMatrix( myMatrix, "Your Matrix");
        }
        if(e.getSource() == plusB)
        {
            matrixPlusMatrix();
        }
        
        else if(e.getSource() == minusB)
        {
            matrixMinusMatrix();
        }
         
        else    if(e.getSource() == multiplyB)
        {
            multiplyByMatrix();
        }

        else   if(e.getSource() == getValueB)
        {
            guiGetValue();
        }
        
        else   if(e.getSource() == newMatrix)
        {
            newMatrix();
        }
    }//end action performed

    
    private static void showMatrix(double [][] matrix, String title )
    {
        int temp, temp1;             //temprature variable
        
       JPanel choosePanel [] = new JPanel [matrix.length+1];
       choosePanel[0] = new JPanel ();
       choosePanel[0].add( new JLabel (title) );
   
       for(temp = 1; temp <= matrix.length; temp++)
       {
           choosePanel[temp] = new JPanel();
           
           
           for(temp1 = 0; temp1 < matrix[0].length; temp1++)
           {
               if(matrix[temp-1][temp1] == -0)
               {
                  matrix[temp-1][temp1] = 0; 
               }
               choosePanel[temp].add(new JLabel(String.format("%.2f", matrix[temp-1][temp1])));
               
               if(temp1 < matrix[0].length -1)
               {
               choosePanel[temp].add(Box.createHorizontalStrut(15)); // a spacer
               }
               
           }//end col loop
           
       }//end row loop
       
    if(col == 0 || row == 0)
    {
        JOptionPane.showMessageDialog(null, "You haven't entered any matrix");
    }
    else
    {
    
    JOptionPane.showMessageDialog(null, choosePanel, null, 
            JOptionPane.PLAIN_MESSAGE, null);
    }  
    }//end show Matrix

  private static void matrixPlusMatrix ()
{
if(myMatrix.length < 1)
        {
            JOptionPane.showMessageDialog(null, "You haven't entered any matrix");
        }
        else
        {
double m2[][]=new double [row][col];
double sum[][] = new double [row][col];

    if(setElements(m2, "Fill Aditional Matrix"))
    {

for(int i=0;i<row;i++)
{
for(int j=0;j<col;j++)
{
    sum[i][j]=myMatrix[i][j]+m2[i][j];
}
}
    showMatrix(sum, "Summition Result");
    }
        }//end else checking
}//end plus matrix
    
private static void matrixMinusMatrix ()
{

    if(myMatrix.length < 1)
        {
            JOptionPane.showMessageDialog(null, "You haven't entered any matrix");
        }
        else
        {
    double m2[][]=new double [row][col];
    double sub[][] = new double [row][col];
    double temp [][] = new double [row][col];


    if(setElements(m2, "Fill Subtracting Matrix"))
    {

for(int i=0;i<row;i++)
{
for(int j=0;j<col;j++)
{
    temp[i][j]=(-1*m2[i][j]);
    sub[i][j]=myMatrix[i][j]+temp[i][j];
}
}
    showMatrix(sub, "Subtracting Result");
    }
        }//end else of checking
}


private static void multiplyByMatrix ()
{
    
      JTextField wField = new JTextField(5); //col field
      int col2 = 0;
      double m2 [][] , results[][];
      int sum;
      
      if(myMatrix.length < 1)
        {
            JOptionPane.showMessageDialog(null, "You haven't entered any matrix");
        }
        else
        {
      
      //design input line
      JPanel choosePanel [] = new JPanel [2];
       choosePanel [0] = new JPanel();
       choosePanel [1] = new JPanel();
       
      choosePanel[0].add(new JLabel("Enter Dimensitions") );
      
      choosePanel[1].add(new JLabel("Rows:"));
      choosePanel[1].add(new JLabel(""+col));
      choosePanel[1].add(Box.createHorizontalStrut(15)); // a spacer
      choosePanel[1].add(new JLabel("Cols:"));
      choosePanel[1].add(wField);
        
      
      result = JOptionPane.showConfirmDialog(null, choosePanel, 
               null,JOptionPane.PLAIN_MESSAGE, 
               JOptionPane.PLAIN_MESSAGE);
      
      if(result == 0)
      {
          if(wField.getText().equals(""))
          {
              col2 = 0;
          }
      else
          {
              if(isInt(wField.getText()) )
              {
              col2 = Integer.parseInt(wField.getText());  
               
              }
          }
     
           m2 = new double [col][col2];
          results = new double [row][col2];
      if(setElements(m2, "Fill multiplying matrix"))
      {
      
      for ( int i = 0 ; i < row ; i++ )
         {
            for ( int j = 0 ; j < col2 ; j++ )
            {   
                sum = 0;
               for ( int k = 0 ; k < col ; k++ )
               {
                  sum +=  myMatrix[i][k]*m2[k][j];
               }
 
               results[i][j] = sum;
             
            }
         }
 
     showMatrix(results, "Mulitiplication Result");
      }//elements checking
      }//dimensions checking
      else
          return;
        }//end else of checking
}//end multiply by matrix method

   
    
    private static void guiGetValue ()
    {
        if(myMatrix.length < 1)
        {
            JOptionPane.showMessageDialog(null, "You haven't entered any matrix");
        }
        else if(col != row)
        {
            JOptionPane.showMessageDialog(null, "You must enter square matrix");
        }
        else
        {
        double result = getValue(myMatrix);
            
    JOptionPane.showMessageDialog(null, String.format("Determination's Value = %.2f", 
            getValue(myMatrix) )  , null, 
            JOptionPane.PLAIN_MESSAGE, null);
        }
    }//end gui get Value
    
    private static void swap (double [] res1, double [] res2)
    {
        int temp;
        double tempDouble;
        
        for(temp = 0; temp < res1.length;temp++)
        {
            tempDouble = res1[temp];
            res1[temp] = res2[temp];
            res2[temp] = tempDouble;
        }
        
    }
        private static double getValue (double [][] matrix)
    {
        int temp, temp1, temp2;
        double coeficient;
        double result = 1;
        int sign = 1;       //1 for positive
                            //-1 for negative
        int zeroCounter ;
        
       double res[][] = new double [matrix.length][matrix[0].length];
       
       //copy matrix
        for(temp = 0; temp < matrix.length; temp++)
        {
            for(temp1 = 0; temp1 < matrix[0].length; temp1++)
            {
                res[temp][temp1] = matrix[temp][temp1];;
            }
            
        }
        
        //rearrange rows
        for(temp = 0; temp < res.length; temp++)
        {
            if(res[temp][temp] != 0)
                continue;
            
            for(temp1 = 1; temp1 < res.length -1 ; temp1++)
            {
                if( res[ (temp1 + temp ) % matrix.length][temp] != 0)
                {       //swapping
                swap(res[temp], res[(temp1 + temp ) % res.length]);    
                sign *= -1;
                break;
                }
           }
        }
            
               
        
        //starting simplifing with gaues method
        for(temp = 1; temp < res.length; temp++)
        {
            for(temp1 = 0; temp1 < temp; temp1++)
            {
                //if required element = 0 || division = 0
                if(res[temp][temp1] == 0 || res[temp1][temp1] == 0)
                    continue;
                else
                {
                    zeroCounter = 0;
                    coeficient = res[temp][temp1]/res[temp1][temp1];
                }
            for(temp2 = 0; temp2 < res.length; temp2++)
            {
                res[temp][temp2] = res[temp][temp2]  
                        - res[temp1][temp2] * coeficient;
                
                if(res[temp][temp2] == 0 )
                    zeroCounter++;
            }
            //over flow zeros
            if(temp < res.length -1 && zeroCounter > temp)
            {
             swap(res[temp], res[temp+1]);
             sign *= -1;
             temp--;
            }
            }
        }
        
        for(temp = 0; temp < res.length; temp++)
        {
            result *= res[temp][temp];
        }
        return result * sign;
     }//end getValue
    
    
      
   private static boolean isInt (String str)
   {
       int temp;
       if (str.length() == '0')
           return false;
       
       for(temp = 0; temp < str.length();temp++)
       {
           if(str.charAt(temp) != '+' && str.charAt(temp) != '-'
                   && !Character.isDigit(str.charAt(temp)))
           {
               return false;
           }
       }
       return true;
   }
   
    private static boolean isDouble (String str)
   {
       int temp;
       if (str.length() == '0')
           return false;
       
       for(temp = 0; temp < str.length();temp++)
       {
           if(str.charAt(temp) != '+' && str.charAt(temp) != '-'
                   && str.charAt(temp) != '.'
                   && !Character.isDigit(str.charAt(temp))
                   )
           {
               return false;
           }
       }
       return true;
   }
   
    private static void newMatrix ()
    {        
        getDimension();
    }



}
