package treeSet;

import java.util.*;

/**
 * This program sorts a set of item by comparing their descriptions.
 * @version 1.12 2015-06-21
 * @author Cay Horstmann
 */
public class TreeSetTest
{
   public static void main(String[] args)
   {
      SortedSet<Item> parts = new TreeSet<>();
      parts.add(new Item("Toaster", 1234));
      parts.add(new Item("Widget", 4562));
      parts.add(new Item("Modem", 9912));
      System.out.println(parts);

      /**
       * 自定义treeset的排序规则
       * TreeSet的构造函数接受一个Comparator对象，该对象用于比较集合中的元素。如果没有提供Comparator对象，那么集合中的元素必须实现Comparable接口。
       */
      NavigableSet<Item> sortByDescription = new TreeSet<>(
            Comparator.comparing(Item::getDescription));

      sortByDescription.addAll(parts);
      System.out.println(sortByDescription);

      sortByDescription.add(new Item("Toaster", 1234));
      System.out.println(sortByDescription);

   }
}