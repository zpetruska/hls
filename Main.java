import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

   public static void main(String[] args) throws IOException {
      ServerSocket server = new ServerSocket(1337);
      System.out.println("Listening for connection on port 1337 ....");
      while (true) { 
         try (Socket socket = server.accept()) { 
            String httpResponse = "HTTP/1.1 200 OK\r\n\r\n"; 
            socket.getOutputStream().write(httpResponse.getBytes("UTF-8")); 
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }
}
