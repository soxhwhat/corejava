import java.rmi.*;
import javax.naming.*;

/**
 * This server program instantiates a remote warehouse object, registers it with the naming
 * service, and waits for clients to invoke methods.
 * @version 1.12 2007-10-09
 * @author Cay Horstmann
 */
public class WarehouseServer
{
   public static void main(String[] args) throws RemoteException, NamingException
   {
      /**
       * 要访问服务器上的一个远程对象时，客户端首先需要一个本地的存根对象。可是客户端如何请求得到该存根呢？最普通的方法是调用另一个服务对象上的一个远程方法，以返回值的方式取得存根对象。然而，这就成了先有鸡还是先有蛋的问题。第一个远程对象总要通过某种方式进行定位。为此，JDK提供了自举注册服务（bootstrap registry service）。
       * 服务器程序应该使用自举注册服务来注册自己的远程对象。客户端程序则使用自举注册服务来查找远程对象。自举注册服务是一个特殊的远程对象，它的地址是固定的，即rmi://localhost/。因此，客户端程序可以通过这个地址来访问自举注册服务。
       */
      System.out.println("Constructing server implementation...");
      WarehouseImpl centralWarehouse = new WarehouseImpl();

      System.out.println("Binding server implementation to registry...");
      Context namingContext = new InitialContext();
      namingContext.bind("rmi:central_warehouse", centralWarehouse);

      System.out.println("Waiting for invocations from clients...");
   }
}
