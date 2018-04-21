
package bit_stuffing;


public class frame_receiver {
    
    String framebit;
    int size;
    int stuffedBit;
    
    frame_receiver(String s,int n,int sb)
    {
        framebit=s;
        size=n;
        stuffedBit=sb;
    }
    
    String unflagging()
    {
        String data="";
        String flgbit="";
        char bit[]=framebit.toCharArray();
        
        int flgno=0;
        
        for(int i=0;i<bit.length;i++)
        {
            flgbit=flgbit+bit[i];
           // System.out.println("----------------------------flgbit="+flgbit);
            
            if (flgno==1)
            {
                data=data+bit[i];
               //  System.out.println("databit="+data);
            }
            
            if (flgbit.length()==8)
            {
                // System.out.println("flgbit len == 8");
                 
                if (flgbit.equals("01111110"))
                {
                    // System.out.println("flgbit equals flg");
                     
                    flgno++;
                    flgbit="";
                    //System.out.println("now flg="+flgno);
                    if (flgno==2)
                    {
                        
                        data=data.substring(0,data.length()-8);
                     //   System.out.println("got data="+ data);
                        break;
                    }
                    
                    
                }
                else
                {
                   //  System.out.println("flgbit not equals flg");
                    flgbit= flgbit.substring(1,flgbit.length());
                   // System.out.println("After shiting"+flgbit);
                }
            }
            
        }
        
       // System.out.println("revieved databit length="+data.length());
        return data;
    }
    
    String unStuffing()
    {
      char new_db[]=new char[size];
      int  cnt=0;
      int stuffbit_enc=0;
      boolean flg=false;
      char db[]=unflagging().toCharArray();
      
      
     // int tot_stuffbit= unflagging().length()- (size);
        
   //  System.out.println("db="+db.length);
      
      if (stuffedBit==0)
      {
      //    System.out.println("No Stuffed bit");
          
          return String.valueOf(db);
      }
     
      for(int i=0;i<size;i++)
      {          
          if (db[i+stuffbit_enc]=='1') {cnt++; }
              else            { cnt=0; }          
          
          if (flg==false)
          {
              new_db[i] = db[i+stuffbit_enc];              
           
              if (cnt==5) {
                  flg=true;
                 cnt=0;
                  stuffbit_enc++;
                  System.out.println("stuffed_encounter="+stuffbit_enc);
              }
          }
          else
          {    
              for(int j=i;j<size;j++)
              {
                  new_db[j] = db[j+stuffbit_enc];                  
              }
              flg=false;
            
              if (stuffbit_enc == stuffedBit) break;
          }
            //all stuffed bit are removed so go out....
      }
      
      return String.valueOf(new_db);
    }
}
