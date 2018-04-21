
package bit_stuffing;


import java.util.*;

public class Bit_stuffing {

    
    public static void main(String[] args) {
        
        
        frame frame_sender=new frame(15);
        
        Scanner sc=new Scanner(System.in);
                         
         System.out.println("Enter Data bit: ");
        
        frame_sender.setData_bit(sc.next());
        
        frame_sender.setSize(frame_sender.getData_bit().length());
        
        
        System.out.println("After Bit stuffing The DataBit="+frame_sender.bit_stuff());
        frame_sender.framingBit();
        
        String frameload=frame_sender.getFramebit();
        
       System.out.println("SENDER FRAME - BIT --->  "+ frameload);
      
       
        System.out.println("----------------------------------------");
       //...............now receiver side.............
       
       
       System.out.println("Now Receiver detecting databit from framebit after unstuffing");
        
       frame_receiver frame_receiver=new frame_receiver(frame_sender.getFramebit(), frame_sender.getSize(), frame_sender.getTot_stuffBit());
      
       System.out.println("Data bit From Frame found to be --->  "+ frame_receiver.unStuffing());
       
       
    }
    
}
