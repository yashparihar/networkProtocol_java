/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stopwaitproto;

/**
 *
 * @author Yash
 */
import java.util.Timer;
import java.util.TimerTask;

public class StopWaitProto {

    /**
     * @param args the command line arguments
     */
    int sec=0;
    
 
     sender sen=new sender();
       Timer newtimer=new Timer();
       
      TimerTask task=new TimerTask()  {
       public void run()  {
      System.out.println("in task a");
     
      if (sec%2==0){
          
      }
      
      if (++sec==10) {  newtimer.cancel();}
       }
      };
      
    
      
      
      
      public void start(int c) throws InterruptedException{
         if (c==1)
           newtimer.scheduleAtFixedRate(task,0, 1000);
            
       }
   

    
    public static void main(String args[]) throws InterruptedException {
     
      StopWaitProto st=new StopWaitProto();
  
        sender sen=new sender();
     receiver rec=new receiver();
     
         frame frameTemp=new frame();
         
        int ind=0; 
         
       String data[]={"100110","110111","111011"};
       sen.setFrame(data);
       
       while(true){
           
       }
    }
}
