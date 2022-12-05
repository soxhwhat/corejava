import java.rmi.*;
import java.util.*;
import javax.naming.*;

/**
 * A client that invokes a remote method.
 * @version 1.0 2007-10-09
 * @author Cay Horstmann
 */
public class WarehouseClient
{
   public static void main(String[] args) throws NamingException, RemoteException
   {
      Context namingContext = new InitialContext();
      
      System.out.print("RMI registry bindings: ");
      Enumeration<NameClassPair> e = namingContext.list("rmi://localhost/");
      while (e.hasMoreElements())
         System.out.println(e.nextElement().getName());
      //查找远程对象
      String url = "rmi://localhost/central_warehouse";      
      Warehouse centralWarehouse = (Warehouse) namingContext.lookup(url);      
      //调用远程方法
      String descr = "Blackwell Toaster";
      double price = centralWarehouse.getPrice(descr);
      System.out.println(descr + ": " + price);
   }
}
