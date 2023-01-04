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
 *
 * 使用内部类的原因
 * 1.内部类方法可以访问该类定义所在的作用域的数据，包括私有的数据。
 * eg：TimePrinter类是一个常规类，它需要通过TalkingClock类的公有方法访问beep标志，而使用内部类可以直接访问。
 * 2.内部类可以对同一个包中的其他类隐藏起来
 * 3.当想要定义回调函数且不想要编写大量代码时，使用匿名内部类比较便捷。
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
    /**
     * 内部类的对象总有一个隐式引用，它指向了创建它的外部类对象。
     * 例如，TimePrinter类的对象有一个隐式引用，它指向了创建它的TalkingClock对象。
     */

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
        //局部内部类，TimePrinter类仅在start方法中使用，所以将它定义为局部内部类。
        //局部内部类不能有访问说明符，因为它只在一个方法中可见。
        class TimePrinter implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                System.out.println("At the tone, the time is " + new Date());
                //TimePrinter类没有实例域或者名为beep的变量，取而代之的是beep引用了创建TimePrinter的TalkingClock对象的域
                // beep = TalkingClock.this.beep;
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        // 编译器修改了所有内部类的构造器，添加一个外围类引用的参数。
//            public TimePrinter(TalkingClock outerClock) {
//                outer = outerClock;
//            }
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
