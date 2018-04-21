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
public class receiver {
    frame frm[]=new frame[5];
    boolean received=false;
    
    void receiveFrame(frame f , int ind ){
        frm[ind]=f;    
    }
    
    boolean getReceived() {return received; }
    
    boolean sendAck(){
      if(received==true)
          return true;
      else return false;
    }
    
    void nextFrame(){
        received=false;
    }
}
