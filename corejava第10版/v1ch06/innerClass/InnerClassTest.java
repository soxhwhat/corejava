package innerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * This program demonstrates the use of inner classes.
 *
 * @author Cay Horstmann
 * @version 1.11 2015-05-12
 */
public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock();
        clock.start(1000, true);

        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

/**
 * A clock that prints the time in regular intervals.
 */
class TalkingClock {
//    private int interval;
//    private boolean beep;
//
//    /**
//     * Constructs a talking clock
//     *
//     * @param interval the interval between messages (in milliseconds)
//     * @param beep     true if the clock should beep
//     */
//    public TalkingClock(int interval, boolean beep) {
//        this.interval = interval;
//        this.beep = beep;
//    }

    /**
     * Starts the clock.
     * change:
     * 删除interval和beep两个字段，因为这两个字段只在start方法中使用，所以可以将它们放在局部变量中。
     */
    public void start(int interval, boolean beep) {
        //局部内部类
        class TimePrinter implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                System.out.println("At the tone, the time is " + new Date());
                //TimePrinter类没有实例域或者名为beep的变量，取而代之的是beep引用了创建TimePrinter的TalkingClock对象的域
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }

//   public class TimePrinter implements ActionListener
//   {
//      public void actionPerformed(ActionEvent event)
//      {
//         System.out.println("At the tone, the time is " + new Date());
//         //TimePrinter类没有实例域或者名为beep的变量，取而代之的是beep引用了创建TimePrinter的TalkingClock对象的域
//         if (beep) Toolkit.getDefaultToolkit().beep();
//      }
//   }
}
