package objectStream;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * @author Cay Horstmann
 * @version 1.10 17 Aug 1998
 */
class ObjectStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.getProperty("user.dir");
        Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        carl.setSecretary(harry);
        Manager tony = new Manager("Tony Tester", 40000, 1990, 3, 15);
        tony.setSecretary(harry);

        Employee[] staff = new Employee[3];

        staff[0] = carl;
        staff[1] = harry;
        staff[2] = tony;

        // save all employee records to the file employee.dat
        // 对象流
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.dat"))) {
            out.writeObject(staff);
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.dat"))) {
            // retrieve all records into a new array

            Employee[] newStaff = (Employee[]) in.readObject();

            // raise secretary's salary
            newStaff[1].raiseSalary(10);

            // print the newly read employee records
            for (Employee e : newStaff)
                System.out.print(e);

            /**
             * 避免输入输出流堵塞的方法
             */
            int available = in.available();
            if (available > 0) {
                byte[] bytes = new byte[available];
                in.read(bytes);
                System.out.println(new String(bytes));
            }

            /**
             * 编码字符串
             */
            String str = "Hello World!";
            ByteBuffer buffer = Charset.forName("UTF-8").encode(str);
            byte[] bytes = buffer.array();

            /**
             * 解码字符串
             */
            byte[] bytes1 = new byte[1024];
            ByteBuffer buffer1 = ByteBuffer.wrap(bytes1);
            CharBuffer charBuffer = Charset.forName("UTF-8").decode(buffer1);
            String s = charBuffer.toString();


            /**
             * 读取二进制文件
             */
            try (DataInputStream in1 = new DataInputStream(new FileInputStream("employee.dat"))) {
                int i = in1.readInt();
                System.out.println(i);
            }
            /**
             * 写入二进制文件
             */
            try (DataOutputStream out1 = new DataOutputStream(new FileOutputStream("employee.dat"))) {
                out1.writeInt(100);
            }

        }
    }
}