/*******************************************
 *Name:            Kuan-Hua Fu
 *Course:          CS-125-02
 *Lab#:            Lab4
 *Submission Date: 2022/05/05 02:00PM
 *Description:     The code to compute perimeter and area of a square and display the side length
 *and computing results in a proper location in the application window.
 *******************************************/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class NegativeDoubleException extends Exception
{

//constructor
   public NegativeDoubleException()
   {
       super("NegativeDoubleException");
   }

//returns String
   public String toString()
   {
       return "NegativeDoubleException";
   }
}

public class SquareApp extends JFrame
{
   private JLabel label;
   private JLabel sideLabel;
   private JLabel areaLabel;
   private JLabel perimeterLabel;
   private JTextField field;
   private JButton submitButton;
   private JButton clearButton;
   private JButton exitButton;
   private JPanel panel;
   private Square square;
  
   public SquareApp()
   {
       //set the App window size
       setSize(320, 150);
      
       setDefaultCloseOperation(EXIT_ON_CLOSE);

       // Title
       setTitle("Square Application");

       setResizable(false);

       panel = new JPanel();
      
      
       label = new JLabel("Enter side ");
       panel.add(label);
      
       field = new JTextField("", 20);
       panel.add(field);
      
       submitButton = new JButton("Submit");
       panel.add(submitButton);
       submitButton.addActionListener(e -> {
               String s = field.getText();
               boolean fg = false;
               double sidelength = 0;          
               try{                      
                   sidelength = Double.parseDouble(s);
                   if(sidelength<0) throw new NegativeDoubleException();
                   fg = true;
               }catch(Exception ex){
                   //display error message
                   JOptionPane.showMessageDialog(null, "sideLength must be a positive real number!", "Error!",
                           JOptionPane.ERROR_MESSAGE);
                   field.setText("");
                   }
               if(fg){
                   square = new Square(sidelength);
                   sideLabel.setText("Side Length = " + sidelength);
areaLabel.setText("Area = " + square.getArea());
perimeterLabel.setText("Perimeter = " + square.getPerimeter());
               }
           }
       );
      
       clearButton = new JButton("Clear");
       panel.add(clearButton);
       clearButton.addActionListener(e -> {
field.setText("");
sideLabel.setText("");
areaLabel.setText("");
perimeterLabel.setText("");
}
);
      
       exitButton = new JButton("Exit");
       panel.add(exitButton);
       exitButton.addActionListener(e -> dispose());
  
sideLabel = new JLabel("");
sideLabel.setBounds(50, 50, 350,300);
       panel.add(sideLabel);
  
       areaLabel = new JLabel("");
areaLabel.setBounds(50,50, 350,300);
       panel.add(areaLabel);
  
       perimeterLabel = new JLabel("");
perimeterLabel.setBounds(50,50, 350,300);
       panel.add(perimeterLabel);
  
       add(panel);

       setVisible(true);
   }
  
   public static void main (String[] args) {
       new SquareApp();
   }
}