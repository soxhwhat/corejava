package timer;

/**
   @version 1.01 2015-05-12
   @author Cay Horstmann
*/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer; 
// to resolve conflict with java.util.Timer

public class TimerTest
{  
   public static void main(String[] args)
   {  
      ActionListener listener = new TimePrinter();

      // construct a timer that calls the listener
      // once every 10 seconds
      Timer t = new Timer(10000, listener);

//      Timer timer = new Timer(100000, new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//            System.out.println("The time is " + new Date());
//         }
//      });
      t.start();

      JOptionPane.showMessageDialog(null, "Quit program?");
      System.exit(0);
   }
}

class TimePrinter implements ActionListener
{  
   public void actionPerformed(ActionEvent event)
   {  
      System.out.println("At the tone, the time is " + new Date());
      Toolkit.getDefaultToolkit().beep();
   }
}
