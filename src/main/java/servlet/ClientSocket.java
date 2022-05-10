package servlet;

import java.io.*;
import java.net.Socket;

/**
 * @author BaiJY
 * @date 2022/05/10
 **/
public class ClientSocket {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream, true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        printWriter.println("GET / HTTP/1.1");
        printWriter.println("Host:localhost:8080");
        printWriter.println("Connection: Close");
        printWriter.println();

        StringBuffer stringBuffer = new StringBuffer(8096);
        while (true) {
            if (in.ready()) {
                int i = 0;
                while (i != -1) {
                    i = in.read();
                    stringBuffer.append((char) i);
                }
                break;
            }
            Thread.sleep(50);
        }
        System.out.println(stringBuffer.toString());
        socket.close();
    }


}
