
package bit_stuffing;


public class frame {
    
    String flag="01111110";
    String framebit;
    int header[]=new int[2];
    int size;
    String data_bit;
    int tot_stuffBit;
    
    frame()
    {
        header[0]=0; header[1]=1;
        size=10;
    }
    
   frame(int n)
   {
        header[0]=0; header[1]=1;
        size=n;
   }
     frame(int n,String s)
   {
        header[0]=0; header[1]=1;
        size=n;
        data_bit=s;
   } 
     
     int getTot_stuffBit()
     {
         return tot_stuffBit;
     }
   
   void setSize(int n) { size= n; }
    int getSize() { return size; }
    
    void setData_bit(String s)
    {  
        data_bit=s;  
    }
    String getData_bit()
    {
        return data_bit;
    }
    
    String bit_stuff() // Stuffing payload.....
    {
        char ch[]=data_bit.toCharArray();
      //  String input[]={"open","door","q"};
        
     
        int cnt=0;
        boolean flg=false;
        int stuffed=0;
       
          
       char ch_new[]=new char[ch.length + ch.length/5];
      
      // System.out.println(data_bit);
        
       for(int i=0;i<ch_new.length;i++)
       {
           if (flg==false)
           {
               ch_new[i]= ch[i-stuffed];
               
               if (ch_new[i]=='1') cnt++;
               else cnt=0;
               
               if (cnt==5) {
                   flg=true;
                   cnt=0;
                   stuffed++;
               }
               
           }
           else //flag is false
           {
               ch_new[i]='0';
               flg=false;
           }           
           if (i+1 == ch.length + stuffed) //loop out if done...
           {
               break;
           }          
           tot_stuffBit=stuffed;           
       }
     
      
        return String.valueOf(ch_new);
    }
    
    
    void framingBit()
    {
        framebit= flag + this.bit_stuff() + flag;
    }
    String getFramebit()
    {
        return framebit;
    }
    
    
}
