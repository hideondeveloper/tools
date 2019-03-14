package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class RemoteFileIO {

    public static void main(String[] args) throws Exception {
        FileWriter  out=new FileWriter (new File("D:\\data\\hot.dic"),true);
        BufferedWriter bw= new BufferedWriter(out);
        bw.write("我不是药神\r\n");
        bw.flush();
        bw.close();
        out.close();
        read();
    }

    private static void read() throws MalformedURLException, IOException {
        URL urlfile = new URL("http://192.168.50.145:8080/hot.dic");
        BufferedReader in = new BufferedReader(new InputStreamReader(urlfile.openStream()));
        String content = "";
        String inputLine = in.readLine();
        while (inputLine != null) {
            content += inputLine;
            inputLine = in.readLine();
        }
        System.out.println(content);
        in.close();
    }
}
