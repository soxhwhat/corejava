package abstractClasses;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This program demonstrates abstract classes.
 * @version 1.01 2004-02-21
 * @author Cay Horstmann
 */
public class PersonTest
{
   public static void main(String[] args)
   {
      Person[] people = new Person[2];

      // fill the people array with Student and Employee objects
      people[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
      people[1] = new Student("Maria Morris", "computer science");

      // print out names and descriptions of all Person objects
      for (Person p : people) {

         System.out.println(p.getName() + ", " + p.getDescription());
         System.out.println("The Current Class is: " + p);
      }

      int[] ints = new int[8];
      System.out.println(ints.length);

      ArrayList<Integer> integers = new ArrayList<>(8);
   }
}