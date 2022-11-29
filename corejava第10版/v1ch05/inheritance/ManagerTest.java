package inheritance;

import org.testng.annotations.Test;

import java.lang.annotation.Target;
import java.util.Arrays;

/**
 * This program demonstrates inheritance.
 *
 * @author Cay Horstmann
 * @version 1.21 2004-02-21
 */
public class ManagerTest {
    public static void main(String[] args) {
        // construct a Manager object
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);

        Employee[] staff = new Employee[3];

        // fill the staff array with Manager and Employee objects

        staff[0] = boss;
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);

        // print out information about all Employee objects
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
    }

    @Test
    public void testEmployee() {
        Manager[] managers = new Manager[3];
        Employee[] staff = managers;
        // fill the staff array with Manager and Employee objects
        staff[0] = new Employee("Carl Cracker", 80000, 1987, 12, 15);
//        managers[0].setBonus(5000);
        System.out.printf("name=%s,salary=%s", staff[0].getName(), staff[0].getSalary());
    }

    public static double max(double... values) {
        double largest = Double.NEGATIVE_INFINITY;
        for (double v : values)
            if (v > largest)
                largest = v;
        return largest;
    }

    @Test
    public void testMax() {
        System.out.println(max(3.1, 40.4, -5));
        System.out.println(max(new double[]{1, 2, 3}));
    }
}