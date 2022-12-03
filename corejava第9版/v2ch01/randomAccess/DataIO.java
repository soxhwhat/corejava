package randomAccess;

import java.io.*;

public class DataIO
{
   /**
    * 读取二进制字符串数据
    * @param size
    * @param in
    * @return
    * @throws IOException
    */
   public static String readFixedString(int size, DataInput in) 
      throws IOException
   {  
      StringBuilder b = new StringBuilder(size);
      int i = 0;
      boolean more = true;
      while (more && i < size)
      {  
         char ch = in.readChar();
         i++;
         if (ch == 0) more = false;
         else b.append(ch);
      }
      in.skipBytes(2 * (size - i));
      return b.toString();
   }

   /**
    * 写入二进制字符串数据
    * @param s
    * @param size
    * @param out
    * @throws IOException
    */
   public static void writeFixedString(String s, int size, DataOutput out) 
      throws IOException
   {
      for (int i = 0; i < size; i++)
      {  
         char ch = 0;
         if (i < s.length()) ch = s.charAt(i);
         out.writeChar(ch);
      }
   }
}
