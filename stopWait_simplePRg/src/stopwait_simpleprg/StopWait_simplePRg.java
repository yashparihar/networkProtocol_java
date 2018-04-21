/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stopwait_simpleprg;

/**
 *
 * @author Yash
 */
import java.util.Scanner;

public class StopWait_simplePRg {
    /**
     * @param args the command line arguments
     */
  
    static int sended(int s){    
        try{
            Thread.sleep(2000);
            System.out.println("-> Sucessfully data sended");
        }
        catch(Exception e){
            System.out.println("Error:"+e);
        }
        
        return s;//alternate(s);
    }
    
    
    
   static int received(int s){
         
         try{
            Thread.sleep(2000);
            System.out.println("-> Sucessfully data received");
        }
        catch(Exception e){
            System.out.println("Error:"+e);
        }
         
        return alternate(s);
    }
     
     
     
     
  static int ack_sended(int s){
          
          try{
            Thread.sleep(2000);
            System.out.println("-> Sucessfully ack sended");
        }
        catch(Exception e){
            System.out.println("Error:"+e);
        }
          
        return s; //alternate(s);
    }
      
      
        
   static int ack_received(int s){
           
           try{
            Thread.sleep(2000);
            System.out.println("->  Sucessfully ack received");
        }
        catch(Exception e){
            System.out.println("Error:"+e);
        }
           
        return alternate(s);
    }
       
       
       
     // ALTERNATIVE  
    static int alternate(int i){
           if (i==0) return 1;
                   else if(i==1) return 0;
           return 1;
       }
    
    
    //SHOWARRAY...
    static void showArray(int arr[]){
         for(int i=0;i<arr.length;i++){
             System.out.println("data: "+arr[i]);
         
         }    
    }
    
    public static void main(String[] args) {
      
        int arr[]={11,12,14,15}; // SENDER FRAME
     
        int arr2[]=new int[4]; // RECEIVER FRAME
      
        Scanner sc=new Scanner(System.in);
   
        int sen_seq=0,rec_seq=0;
    
        int testCase[]={1,3,1,2};
          /*
             TESTCASE 1 => SUCCESFULLY WORKED
                      2 => SENDED BUT NOT RECEIVED
                      3 => SENDED, RECEIVED , ACK ASLO SENDED , BUT ACK LOST OR DID REVEIVED TO SENDE 
        */
        
        int i=0;
        
        while(i<4) {
           try{
               if (i==4) break;
               
               System.out.println("Sending Data no="+(i+1));
               
               sen_seq=sended(sen_seq); //SENDING DATA
        
               if(testCase[i]!=2 ){
       
                   if (sen_seq==rec_seq){
                             rec_seq=received(rec_seq); //RECEIVED DATA
                           arr2[i]=arr[i];
                       
                           rec_seq =ack_sended(rec_seq); //SENDED ACK   
                         }
                   else {
                        System.out.println("-> [ Data Is Already their ]");
                        System.out.println("-> Sucessfully ack sended");
                       }
               
                     if(testCase[i]!=3){   
                            sen_seq =ack_received(sen_seq) ; //RECEIVED ACK
                       
                          }
               }
               
               if (testCase[i]==2 ){
                   System.out.println(" TIMEOUT -> DATA NOT RECEIVED SUCCESSFULLY");
                   testCase[i]=1;
               }
               else if (testCase[i]==3){
                    System.out.println(" ACKNOWLEDGEMENT LOST/NOT RECEIVED");
                   testCase[i]=1;
               }
               else i++;  
               
               
            
          System.out.println("Receiver Frame data..");
          
         showArray(arr2);
          
          
         }
           catch(Exception e){
               System.out.println("Error: "+e);
           }
            
        }
        
        
        
        
        
        
    }
    
}
