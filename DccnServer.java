
import java.io.*;
import java.net.*;


public class DccnServer {
    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(4444);
        boolean working = true;
        Socket sr = s.accept();
        InputStream in = sr.getInputStream();
        OutputStream f1 = new FileOutputStream("serverFiles/ground.txt");
        OutputStream f2 = new FileOutputStream("serverFiles/member.txt");
        OutputStream f3 = new FileOutputStream("serverFiles/books.txt");

        byte[] b = new byte[20*1024];
        byte[] b2 = new byte[20*1024];
        byte[] b3 = new byte[20*1024];

        int i ;
        while((i = in.read(b)) >0){
            f1.write(b, 0, i);
        }
        while((i = in.read(b2)) >0){
            f2.write(b, 0, i);
        }
        while((i = in.read(b3)) >0){
            f3.write(b, 0, i);
        }


    }
    
}
