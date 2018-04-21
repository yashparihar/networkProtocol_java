
package socketpack;

import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class server_socket {
    

    public static void main(String[] args) throws Exception {
        System.out.println("Server side");
        server_socket srvr = new server_socket();
        srvr.run();
    }
    
    public void run() throws Exception {
      ServerSocket srvrsoc=new ServerSocket(232);
        Socket sock=srvrsoc.accept();
        
   
        
                  PrintStream ps=new PrintStream(sock.getOutputStream());
                Scanner sc=new Scanner(System.in);
                
              Thread t1=new Thread(new Runnable(){

                  @Override
                  public void run() {
                   while(true){       
                        String f;
                    f=sc.nextLine();
                            ps.println(f); 
                   }      
                  }
              });
        
        BufferedReader br=new BufferedReader( new InputStreamReader(sock.getInputStream()));
              
               Thread t2=new Thread(new Runnable(){

                  @Override
                  public void run()  {
                     while(true){
                  
                          String msg=null;
                      try {
                          msg = br.readLine();
                      } catch (IOException ex) {
                          Logger.getLogger(socket_client.class.getName()).log(Level.SEVERE, null, ex);
                      }
                   
                        
                    System.out.println("-------------- "+ msg);
                     
                         
                      }
                }
              });
        
     t1.start();
         t2.start();
         
         t1.join(); t2.join();
             
 
               
           
      
       
    }
}
