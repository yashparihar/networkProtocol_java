
package socketpack;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class socket_client {

    public static void main(String[] args) throws Exception {
        System.out.println("Client side");
        socket_client clnt =new socket_client();
        clnt.run();
    }
    
        public void run() throws Exception{
            Socket sock=new Socket("localhost",232);
            
      //    while(true){  
              PrintStream ps=new PrintStream(sock.getOutputStream());
        Scanner sc=new Scanner(System.in);
              Thread t1=new Thread(new Runnable(){

                  @Override
                  public void run() {
                      while(true){  
                      
               //          FileInputStream fin;

                 /*       try {
                            fin=new FileInputStream("in.txt");
                            int i;
                            byte b[]=new byte[16*1024];
                            
                             while((fin.read(b))!=-1){
                                System.out.print(b);  
                                  ps.println(b);
                                 }
                          fin.close();
                          
                          }
                          catch(Exception err){
                              System.out.println("Error: "+err);
                                }   
                     */  
                              
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
                      
                  /*    if (msg.equals("exit")) {
                          break;
                      }
                    */  
                    System.out.println("-------------------"+ msg);
                      
                      }
                 }
              });
              
    
         t1.start();
         t2.start();
         
         t1.join(); t2.join();
      
       
        
       //  }
    }
    
    
}
