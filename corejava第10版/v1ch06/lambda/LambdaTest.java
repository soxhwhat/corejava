package lambda;

import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

/**
 * This program demonstrates the use of lambda expressions.
 * @version 1.0 2015-05-12
 * @author Cay Horstmann
 */
public class LambdaTest
{
   public static void main(String[] args)
   {
      String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars", 
            "Jupiter", "Saturn", "Uranus", "Neptune" };
      System.out.println(Arrays.toString(planets));
      System.out.println("Sorted in dictionary order:");
      Arrays.sort(planets);
      System.out.println(Arrays.toString(planets));
      System.out.println("Sorted by length:");
      /**
       *       Arrays.sort(staff, new Comparator<Employee>() {
       *                  @Override
       *                  public int compare(Employee o1, Employee o2) {
       *                     return o1.getName().compareTo(o2.getName());
       *                  }
       *       });
       */
      Arrays.sort(planets, (first, second) -> first.length() - second.length());
      System.out.println(Arrays.toString(planets));
      /**
       *       Timer timer = new Timer(100000, new ActionListener() {
       *          @Override
       *          public void actionPerformed(ActionEvent e) {
       *             System.out.println("The time is " + new Date());
       *          }
       *       });
        */
      Timer t = new Timer(1000, event ->
         System.out.println("The time is " + new Date()));
      t.start();   
         
      // keep program running until user selects "Ok"
      JOptionPane.showMessageDialog(null, "Quit program?");
      System.exit(0);         
   }
}
