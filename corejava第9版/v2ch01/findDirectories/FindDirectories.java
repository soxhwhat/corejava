package findDirectories;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

/**
 * @author Cay Horstmann
 * @version 1.1 2012-05-31
 */
public class FindDirectories {
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get(args.length == 0 ? System.getProperty("user.dir") : args[0]);
        /**
         * 如何打印出给定目录下的所有子目录
         */
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (attrs.isDirectory())
                    System.out.println(file);
                return FileVisitResult.CONTINUE;
            }

            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });

        /**
         * 迭代目录中的文件
         */
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path entry : stream)
                System.out.println(entry);
        }

        /**
         * 迭代目录中的文件,使用glob模式来过滤文件
         */
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{java,class}")) {
            for (Path entry : stream)
                System.out.println(entry);
        }

        /**
         *
         */
    }
}
