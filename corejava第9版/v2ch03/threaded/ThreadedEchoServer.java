package threaded;

import java.io.*;
import java.net.*;
import java.util.*;

/**
   This program implements a multithreaded server that listens to port 8189 and echoes back 
   all client input.
   @author Cay Horstmann
   @version 1.21 2012-06-04
*/
public class ThreadedEchoServer
{  
   public static void main(String[] args )
   {  
      try
      {  
         int i = 1;
         ServerSocket s = new ServerSocket(8189);

         while (true)
         {
            /**
             * 每当程序建立一个新的套接字连接，也就是说当调用accept时，将启动一个新的线程来处理服务器和该客户端之间的连接，而主程序将立即返回并等待下一个连接。
             */
            Socket incoming = s.accept();
            System.out.println("Spawning " + i);
            Runnable r = new ThreadedEchoHandler(incoming);
            Thread t = new Thread(r);
            t.start();
            i++;
         }
      }
      catch (IOException e)
      {  
         e.printStackTrace();
      }
   }

   /**
    * 每当程序建立一个新的套接字连接，也就是说当调用accept时，将启动一个新的线程来处理服务器和该客户端之间的连接，而主程序将立即返回并等待下一个连接。
    */
   public void testHalfClose() throws IOException {
      Socket localhost = new Socket("localhost", 8189);
      Scanner in = new Scanner(localhost.getInputStream());
      PrintWriter writer = new PrintWriter(localhost.getOutputStream());
      writer.println("Hello");
      writer.flush();
      // 半关闭状态
      localhost.shutdownInput();
      while (in.hasNextLine()) {
         System.out.println(in.nextLine());
      }
      localhost.close();
   }
}

/**
   This class handles the client input for one server socket connection. 
*/
class ThreadedEchoHandler implements Runnable
{ 
   private Socket incoming;

   /**
      Constructs a handler.
      @param i the incoming socket
   */
   public ThreadedEchoHandler(Socket i)
   { 
      incoming = i; 
   }

   public void run()
   {  
      try
      {  
         try
         {
            InputStream inStream = incoming.getInputStream();
            OutputStream outStream = incoming.getOutputStream();
            
            Scanner in = new Scanner(inStream);         
            PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);
            
            out.println( "Hello! Enter BYE to exit." );
            
            // echo client input
            boolean done = false;
            while (!done && in.hasNextLine())
            {  
               String line = in.nextLine();            
               out.println("Echo: " + line);            
               if (line.trim().equals("BYE"))
                  done = true;
            }
         }
         finally
         {
            incoming.close();
         }
      }
      catch (IOException e)
      {  
         e.printStackTrace();
      }
   }
}
