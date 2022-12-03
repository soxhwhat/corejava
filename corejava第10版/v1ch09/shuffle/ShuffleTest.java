package shuffle;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

/**
 * This program demonstrates the random shuffle and sort algorithms.
 * @version 1.11 2012-01-26
 * @author Cay Horstmann
 */
public class ShuffleTest
{
   public static void main(String[] args) throws IOException {
//      List<Integer> numbers = new ArrayList<>();
//      for (int i = 1; i <= 49; i++)
//         numbers.add(i);
//      Collections.shuffle(numbers);
//      List<Integer> winningCombination = numbers.subList(0, 6);
//      Collections.sort(winningCombination);
//      System.out.println(winningCombination);
         split("D:\\1.txt");
   }

   public static void split(String path) throws IOException {
       InputStreamReader reader = new InputStreamReader(new FileInputStream(path), "utf-8");
       StringBuilder builder = new StringBuilder();
       // 将文件中的内容读取到字符串中
        char[] chars = new char[1024];
        int len;
        while ((len = reader.read(chars)) != -1) {
            builder.append(new String(chars, 0, len));
        }
      //以[*]为分隔符，分割字符串
      String[] split = builder.toString().split("\\[[0-9]+]");
      //写入文件
      FileWriter fw =new FileWriter("D:\\2.txt");
      for (String s1 : split) {
            fw.write(s1 + "\r");
      }
   }
}
