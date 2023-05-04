/*******************************************
 *Name:            Kuan-Hua Fu
 *Course:          CS-125-02
 *Lab#:            Lab4
 *Submission Date: 2022/05/05 02:00PM
 *Description:     The code to set the side and get the area and perimeter for the square.
 *******************************************/

public class Square
{
   private double side;
//constructor
   public Square(double s)
   {
       side = s;
   }
//getArea
   public double getArea()
   {
       return side*side;
   }
//getPerimeter
   public double getPerimeter()
   {
       return 4*side;
   }
}