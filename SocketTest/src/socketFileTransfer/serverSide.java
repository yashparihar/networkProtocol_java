
package socketFileTransfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class serverSide {
    
    public static void main(String args[]) throws IOException{
        serverSide sr=new serverSide();
        sr.run();
    }

    private void run() throws IOException {
       ServerSocket sr_sock=new ServerSocket(300);
       Socket sock = sr_sock.accept();
       
       
        // FileInputStream fin;
         // PrintWriter ps=new PrintWriter(sock.getOutputStream());
       
       
         InputStream in=null;
         OutputStream out;
         Scanner sc=new Scanner(System.in);
         
         System.out.println("Enter File name to send: ");
         String fname=sc.next();
         
         try{
                 File file=new File(fname);
                 in=new FileInputStream(file);  //GET DATA FROM FILE         
             }
            catch (Exception err){
              System.out.println("File not found: "+err);
              return;
         }
         
                       System.out.println("Sending file "+fname);
        
         out=sock.getOutputStream();       //SEND DATA TO CLIENT
         
         byte[] b=new byte[20*1024];
       int cnt;
       
      
       
       
         while( (cnt=in.read(b) )!=-1 ){
       
             //......ENCRYPTION.......ON CNT
             out.write(b, 0, cnt);
         }
         
         
              System.out.println("Successfully sended file");
         in.close();
         out.close();
         sock.close();
         
         
        
       
         
    }
}
