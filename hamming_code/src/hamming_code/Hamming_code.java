//Pract 2: Hamming code..


package hamming_code;



import java.util.*;

public class Hamming_code {

    
    
    public static void main(String[] args) {
       
       String dw; //="1011";
      String recieve_cw="";
       int temp[]=new int[4];
       
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter Data word:");
       
       dw=sc.next();
   
    
       temp[0]= ((int) dw.charAt(0) - 48) ^ ((int) dw.charAt(1) - 48) ^ ((int) dw.charAt(2) - 48) ;
        temp[1]= ((int) dw.charAt(1) - 48) ^ ((int) dw.charAt(3) - 48) ^ ((int) dw.charAt(2) - 48) ;
         temp[2]= ((int) dw.charAt(0) - 48) ^ ((int) dw.charAt(1) - 48) ^ ((int) dw.charAt(3) - 48) ;
       
      
       
       dw=dw+temp[0]+ temp[1] + temp[2];
       
        System.out.println("Generated codeword with parity bit="+ dw);
      // pb[0] = dw.charAt(0);
        
        System.out.println("Enter receivers codeword:");
        recieve_cw=sc.next();
        
        System.out.println("\n  Real cw   ="+dw);
        System.out.println(    "Recieve cw="+recieve_cw);
        
        if (dw.length()!=recieve_cw.length())
        {
            System.out.println("Invalid Recivers codeword");
            return;
        }
        
         temp[0]= ((int)  recieve_cw.charAt(0) - 48) ^ ((int)  recieve_cw.charAt(1) - 48) ^ ((int)  recieve_cw.charAt(2) - 48) ^ ((int) recieve_cw.charAt(4) - 48);
        temp[1]= ((int)  recieve_cw.charAt(1) - 48) ^ ((int)  recieve_cw.charAt(3) - 48) ^ ((int)  recieve_cw.charAt(2) - 48) ^ ((int) recieve_cw.charAt(5) - 48);
         temp[2]= ((int) recieve_cw.charAt(0) - 48) ^ ((int)  recieve_cw.charAt(1) - 48) ^ ((int)  recieve_cw.charAt(3) - 48) ^ ((int) recieve_cw.charAt(6) - 48);
        
     /*   System.out.println("t1="+temp[0]);
         System.out.println("t2="+temp[1]);
         System.out.println("t3="+temp[2]);
       */
         
         
         if (temp[0]==0 && temp[1]==0 && temp[2]==0)
         {
           System.out.println("No error");
         }
         else if (temp[0]==0 && temp[1]==0 && temp[2]==1)
         {
           System.out.println("Error in dataword pos 6");
         }
         else if (temp[0]==0 && temp[1]==1 && temp[2]==0)
         {
          System.out.println("Error in dataword pos 5");
         }
         else if (temp[0]==1 && temp[1]==0 && temp[2]==0)
         {
            System.out.println("Error in dataword pos 4");
         }
           else if (temp[0]==0 && temp[1]==1 && temp[2]==1)
         {
            System.out.println("Error in dataword pos 3");
         }
          else if (temp[0]==1 && temp[1]==0 && temp[2]==1)
         {
            System.out.println("Error in dataword pos 0");
         }
          else if (temp[0]==1 && temp[1]==1 && temp[2]==0)
         {
            System.out.println("Error in dataword pos 2");
         }
         else
          {
              System.out.println("Error in dataword pos 1");
          }
    }
    
}
