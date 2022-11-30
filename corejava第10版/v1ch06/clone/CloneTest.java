package clone;

import jdk.jfr.StackTrace;
import org.testng.annotations.Test;

/**
 * This program demonstrates cloning.
 *
 * @author Cay Horstmann
 * @version 1.10 2002-07-01
 */
public class CloneTest {
    public static void main(String[] args) {
        try {
            Employee original = new Employee("John Q. Public", 50000);
            original.setHireDay(2000, 1, 1);
            Employee copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2002, 12, 31);
            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStringClone() {
        int[] ints = {1, 2, 3, 4, 5};
        int[] ints2 = ints.clone();
        ints2[0] = 100;
        System.out.println(ints[0]);
    }
}