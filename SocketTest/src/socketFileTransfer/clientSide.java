
package socketFileTransfer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class clientSide {
    
    public static void main(String args[]) throws Exception{
    
        clientSide sd=new clientSide();
        sd.run();
    }

    private void run() throws Exception  {
      Socket sock= new Socket("localhost",300);
       
      InputStream in=null;
      OutputStream out=null;
      
      System.out.println("Enter file where data need to be written :");
      String fname=(new Scanner(System.in)).next();
      
      try {
       File file=new File(fname);
      
      
              in = sock.getInputStream();          //READING FILE DATA FROM SOCKET
              out =new FileOutputStream(file);     // PUTTING DATA INTO FILE
      
      }
      catch(Exception ex){
          System.out.println("Error: "+ex);
      }
      
          byte b[]=new byte[20*1024];
          int i;
           while((i=in.read(b))!=-1){
               
               //....DECRYPT FROM INCOMING FILE....
            out.write(b, 0, i);
            }
     
             in.close();
            out.close();
            sock.close();
    }
}
