package linkedList;

import java.util.*;

/**
 * This program demonstrates operations on linked lists.
 * @version 1.11 2012-01-26
 * @author Cay Horstmann
 */
public class LinkedListTest
{
   public static void main(String[] args)
   {
      List<String> a = new LinkedList<>();
      a.add("Amy");
      a.add("Carl");
      a.add("Erica");

      List<String> b = new LinkedList<>();
      b.add("Bob");
      b.add("Doug");
      b.add("Frances");
      b.add("Gloria");

      // merge the words from b into a

      ListIterator<String> aIter = a.listIterator();
      Iterator<String> bIter = b.iterator();

      while (bIter.hasNext())
      {
         if (aIter.hasNext()) aIter.next();
         aIter.add(bIter.next());
      }

      System.out.println(a);

      // remove every second word from b

      bIter = b.iterator();
      while (bIter.hasNext())
      {
         bIter.next(); // skip one element
         if (bIter.hasNext())
         {
//            应该将Java迭代器认为是位于两个元素之间。当调用next时，迭代器就越过下一个元素，并返回刚刚越过的那个元素的引用。
            bIter.next(); // skip next element
            bIter.remove(); // remove that element
         }
      }

      System.out.println(b);

      // bulk operation: remove all words in b from a

      a.removeAll(b);

      System.out.println(a);
   }
}
