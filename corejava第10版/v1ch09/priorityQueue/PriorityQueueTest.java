package priorityQueue;

import map.Employee;

import java.util.*;
import java.time.*;

/**
 * This program demonstrates the use of a priority queue.
 * @version 1.02 2015-06-20
 * @author Cay Horstmann
 */
public class PriorityQueueTest
{
   public static void main(String[] args)
   {
      /**
       * 使用优先级队列的典型示例是任务调度。每一个任务有一个优先级，任务以随机顺序添加到队列中。每当启动一个新的任务时，都将优先级最高的任务从队列中删除（由于习惯上将1设为“最高”优先级，所以会将最小的元素删除）。
       */
//      PriorityQueue<LocalDate> pq = new PriorityQueue<>();
//      pq.add(LocalDate.of(1906, 12, 9)); // G. Hopper
//      pq.add(LocalDate.of(1815, 12, 10)); // A. Lovelace
//      pq.add(LocalDate.of(1903, 12, 3)); // J. von Neumann
//      pq.add(LocalDate.of(1910, 6, 22)); // K. Zuse
//
//      System.out.println("Iterating over elements...");
//      for (LocalDate date : pq)
//         System.out.println(date);
//      System.out.println("Removing elements...");
//      while (!pq.isEmpty())
//         System.out.println(pq.remove());
      testAList();
   }

   public static void testAList() {
      Employee[] employees = new Employee[52];
      List<Employee> asList = Arrays.asList(employees);
      List<Employee> employees1 = asList.subList(0, 10);
      System.out.println(employees1);
      employees1.clear();
      System.out.println(employees1);
   }
}
