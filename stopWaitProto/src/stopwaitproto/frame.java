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
public class frame {
  String data;
  int seq;
  
  frame() {}
  
  frame(String d,int in) {
      data=d;
      seq=in%2;
  }
   
  void setframe(String d,int in){
      data=d;
      seq=in%2;
  }
}
