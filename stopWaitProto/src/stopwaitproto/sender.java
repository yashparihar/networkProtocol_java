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
public class sender {
    frame frm[]=new frame[5];
    boolean ack=false;
    
    
    void setFrame(String d[])
    {
        for (int i=0;i<d.length;i++){
             frm[i].setframe(d[i], i);
        }   
    }
    
  frame getFrame(int ind)
   {
       return frm[ind];
   }
   
   void receiveAck() {
       ack=true;
   }
   
    boolean getAck(){
        return ack;
    }
    
    
    
}
