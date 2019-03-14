package utils;

import java.io.File;

public class FilesCountTest {

    public static void main(String[] args) {
        File dir = new File("C:\\worksapce\\java");
        FilesCountTest filesCountTest = new FilesCountTest();
        filesCountTest.sum(dir);
        System.out.println(count);
    }

    static int count = 0;

    private void sum(File dir) {
        if (dir.isDirectory()) {
            File[] listFiles = dir.listFiles();
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    sum(file);
                } else {
                    if (file.toString().endsWith(".java")) {
                        System.out.println(file.getPath() + "\\" + file.getName());
                        count++;
                    }
                }
            }
        }
    }
}
