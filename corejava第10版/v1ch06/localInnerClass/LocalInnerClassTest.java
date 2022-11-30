package localInnerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

import static com.google.common.base.Strings.repeat;

/**
 * This program demonstrates the use of local inner classes.
 * @version 1.01 2015-05-12
 * @author Cay Horstmann
 */
public class LocalInnerClassTest
{
   public static void main(String[] args)
   {
//      TalkingClock clock = new TalkingClock();
//      clock.start(1000, true);
//
//      // keep program running until user selects "Ok"
//      JOptionPane.showMessageDialog(null, "Quit program?");
//      System.exit(0);
      repeat(10, () -> System.out.println("Hello, World!"));
   }

   /**
    * 使用lambda表达式的重点是延迟执行（deferred execution）。毕竟，如果想要立即执行代码，完全可以直接执行，而无需把它包装在一个lambda表达式中。之所以希望以后再执行代码，这有很多原因，如：
    * ·在一个单独的线程中运行代码；
    * ·多次运行代码；
    * ·在算法的适当位置运行代码（例如，排序中的比较操作）；
    * ·发生某种情况时执行代码（如，点击了一个按钮，数据到达，等等）；
    * ·只在必要时才运行代码。
    * @param n
    * @param action
    */
   public static void repeat(int n, Runnable action)
   {
      for (int i = 0; i < n; i++) action.run();
   }
}

/**
 * A clock that prints the time in regular intervals.
 */
class TalkingClock
{
   /**
    * Starts the clock.
    * @param interval the interval between messages (in milliseconds)
    * @param beep true if the clock should beep
    */
   public void start(int interval, boolean beep)
   {
      class TimePrinter implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            System.out.println("At the tone, the time is " + new Date());
            if (beep) Toolkit.getDefaultToolkit().beep();
         }
      }
      ActionListener listener = new TimePrinter();
      Timer t = new Timer(interval, listener);
      t.start();
   }
}
