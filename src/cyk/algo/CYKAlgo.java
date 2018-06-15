
package cyk.algo;
import java.util.*;
/**
 *
 * @author Richie
 */
class CYK{
   String w[]= {"a","b","c","d","e","f"};
  // String w[]= {"b","a","a","b","a"};
  // String v[][]= new String[w.length][w.length];
   int n=w.length;
   //String[][] g = {{"S","AB","BC"},{"A","BA","a"},{"B","CC","b"},{"C","AB","a"}};
   String g[][]=EnterGram();
   String lc[]=new String [g.length];//new String[g.length];
   String rc[]=new String[g.length];
   
   String[][] EnterGram()
   {
       String[][] ga = {{"S","AX"},
       {"X","YF"},
       {"Y","BZ"},
       {"Z","WE"},
       {"W","CD"},
       {"A","AA"},
       {"B","BB"},
       {"C","CC"},
       {"D","DD"},
       {"E","EE"},
       {"F","FF"},
       {"A","a"},{"B","b"},{"C","c"},{"D","d"},{"E","e"},{"F","f"}};
       return(ga);
   }
   String[][] CYKrun(String g[][],String[] w){
       String v[][]= new String[w.length+2][w.length+2];
       n=w.length;
   for(int q=0,i=1;i<w.length+1;i++,++q)
  {
      if(i==1)
          System.out.println("stop");
      v[i][i]="";
      for(int j=0;j<g.length;j++)
      {
          for(int k=0;k<g[j].length;k++)
          {
              if(g[j][k].equals(w[q]))
              {
                  if(v[i][i].equals(""))
                      v[i][i]=v[i][i].concat(g[j][0]);
                  else
                      v[i][i]=v[i][i].concat(","+g[j][0]);
              }
          }
      }
  }

    String[] f=new String[10];
    String[] s=new String[10];
    int j,flag1=0,flag2=0,iterate=0,flag=0;
  
  for(int len=2;len<n+1;++len)
  {  
      for(int i=1;i<n-len+2;i++)
      {
          j=i+len-1;
          v[i][j]="";           
          for(int k=i;k<j;++k)
          {
               f=v[i][k].split(",");
               flag1=v[i][k].split(",").length;                                        
               s=v[k+1][j].split(",");
               flag2=v[k+1][j].split(",").length;
          
          if(f[0].equals(""))
              flag1=0;
          if(s[0].equals(""))
              flag2=0;
          
          if(flag1!=0&&flag2!=0)                        //make comparisons only if there is any combination to be checked
                  {     
          String[] temp=new String[flag1*flag2]; 
            for(int nn=0,x=0;x<flag1;++x)
            {
               for(int y=0;y<flag2;++y,++nn)
               { 
                   if(flag1==1&&flag2!=1)
                          temp[nn]=v[i][k].concat(s[y]);
                   else if(flag1==1&&flag2==1)
                           temp[nn]=v[i][k].concat(v[k+1][j]);
                   else if(flag1!=1&&flag2!=1)
                           temp[nn]=f[x].concat(s[y]);
                   else if(flag1!=1&&flag2==1)
                           temp[nn]=f[x].concat(v[k+1][j]);  
               }
            }
           
              iterate=1;
            while(iterate<=temp.length) 
            {
              for(int l=0;l<g.length;l++)
              {  
                  String temp2[]=new String[v[i][j].length()];
                  temp2=v[i][j].split(",");
                for(int m=0;m<g[l].length;m++)
                {
                    flag=0;
                    
                    if(g[l][m].equals(temp[iterate-1]))
                    {
                            for(int a=0;a<temp2.length;++a)
                            {
                                if(temp2[a].equals(g[l][0]))
                                {
                                    flag=1;
                                    break;
                                }
                            }
                    }
                     
                    if(g[l][m].equals(temp[iterate-1])&&flag!=1)
                    {
                        if(v[i][j].equals(""))
                             v[i][j]=v[i][j].concat(g[l][0]);
                        else 
                            v[i][j]=v[i][j].concat(","+ g[l][0]);
                    }
                }
              }
              iterate++;
            }
                  }
         }                  // end of K loop
      }                     // end of I loop
  }                         // end of Len loop
  return(v);
 
 }
   void ShowCYK(String v[][],int n)
   {
       System.out.println("\t\t\tCYK Algorithm");
        for(int l=1;l<n+1;l++)
          {
             for(int m=1;m<n+1;m++)
               { 
                   System.out.print("\t");
                   if(null == v[l][m])
                       System.out.print("-");
                   else switch (v[l][m]) {
                     case "":
                         System.out.print((char)216);
                         break;
                     default:
                         System.out.print("{"+v[l][m]+"}");
                         break;
                    }
                }
             System.out.println("");
        }
   }
   void ShowsubCYK(String v[][],int n)
   {
       int i=222;
       System.out.println("\t\t\tCYK Algorithm");
        for(int l=0;l<n+2;l++)
          {
             for(int m=0;m<n+2;m++)
               { 
                   System.out.print("\t");
                   if(null == v[l][m])
                       System.out.print((char)i);
                   else switch (v[l][m]) {
                     case "":
                         System.out.print("-");
                         break;
                     default:
                         System.out.print("{"+v[l][m]+"}");
                         break;
                 }
               }
             System.out.println("");
          }
   }
   
   void CYKacc(String w[],String v[][])
   {
       String f[]=new String [v[0][n-1].length()];
       f=v[0][n-1].split(",");
        int flag=0;
        for(int a=0;a<v[0][n-1].length();++a)
        {
            if(f[a].equals("S"))
            {
                         flag=1;
                         break;
            }
        }
        if(flag==1)
            System.out.println("The string '"+Arrays.toString(w)+"'is accepted by the grammar");
        else
            System.out.println("The entered string '"+Arrays.toString(w)+"' is not accepted by the grammar");
   }
   
   String[] Lclos(String g[][]){
   int z=0,j=0,k=1,flag=0;
   String l,present,lp;
   for(int e=0;e<g.length;++e)
   {
       j=-1;
       k=1;
       lc[e]=g[e][0];
       
       if(g[e][1].length()<2)       //Code for not duplicating productions which have been defined twice
       {
           lc[e]="";
                continue;
       }
      lp="";
      present=lc[e];
      while(j<k) 
      {  
           String ll[]= new String [lp.length()];
           ll=lp.split(",");
           
           l=Lfind(present);
          
           String lk[]= new String [l.length()];
           if(!l.equals(""))
           { 
                lk=l.split(",");
                for(int p=0;p<lk.length;++p)
                {
                    for(int s=0;s<ll.length;++s)
                    {
                        if(lk[p].equals(ll[s]))
                        {
                            flag=0;
                            break;
                        }
                        else
                            flag=1;
                    }
                    if(flag==1)
                        {
                            if(lp.equals(""))
                                lp=lp.concat(lk[p]);
                            else
                                lp=lp.concat(","+lk[p]);
                        }
                }
           }
           else
               lp=lp.concat("");
              
           ll=lp.split(",");
          
               k=ll.length;
               ++j;
           if(j!=k&&!lp.equals(""))
            present=ll[j];
           
           
           if(j==k)
           {
               if(lp.length()>=1&&!lp.equals(""))
                    lc[e]=lc[e].concat(","+lp);
           }
       }
    }
   
   return(lc);
}
   void ShowLclos()
   {
       //Code for Display
        for(int e=0;e<lc.length;++e)
        {
            String show[]=new String[lc[e].length()];
            show=lc[e].split(",");
            if(lc[e].equals(""))
                continue;
             System.out.println("");
            if(show.length==1)
                 System.out.print("Left closure of ({"+show[0]+"})="+(char)216);
            else
            {
                 System.out.print("Left closure of ({"+show[0]+"})={");
                 for(int i=1;i<show.length;++i)
                 {
                     if(show.length==1)
                         System.out.print(show[i]);
                     else if(i==1&&show.length>1)
                         System.out.print(show[i]);
                     else 
                         System.out.print(","+show[i]);      
                 }
                 System.out.print("}");
            }
        }
   }
  // Function for actually returning the LClosure of the passed element "l" 
   String Lfind(String l){
       int z=-1;
       String ret="";
       for(int i=0;i<g.length;++i)
      {
          for(int k=0;k<g[i].length;++k)
            {
               // z=-1;
                z=g[i][k].lastIndexOf(l);
                if(z==1)
                {
                    if(ret.equals(""))
                      ret=ret.concat(g[i][0]);
                    else
                      ret=ret.concat(","+g[i][0]);
                }   
            }     
        }   
  return(ret); 
    }
   
String[] Rclos(String g[][]){
   int z=0,j=0,k=1,flag=0;
   String l,present,lp;
   for(int e=0;e<g.length;++e)
   {
       j=-1;
       k=1;
       rc[e]=g[e][0];
       
       if(g[e][1].length()<2)       //Code for not duplicating productions which have been defined twice
       {
           rc[e]="";
                continue;
       }
      lp="";
      present=rc[e];
      while(j<k) 
      {  
           String ll[]= new String [lp.length()];
           ll=lp.split(",");
           
           l=Rfind(present);
           
           String lk[]= new String [l.length()];
           if(!l.equals(""))
           { 
                lk=l.split(",");
                for(int p=0;p<lk.length;++p)
                {
                    for(int s=0;s<ll.length;++s)
                    {
                        if(lk[p].equals(ll[s]))
                        {
                            flag=0;
                            break;
                        }
                        else
                            flag=1;
                    }
                    if(flag==1)
                        {
                            if(lp.equals(""))
                                lp=lp.concat(lk[p]);
                            else
                                lp=lp.concat(","+lk[p]);
                        }
                }
           }
           else
               lp=lp.concat("");
              
           ll=lp.split(",");
          
               k=ll.length;
               ++j;
           if(j!=k&&!lp.equals(""))
            present=ll[j];
           
           
           if(j==k)
           {
               if(lp.length()>=1&&!lp.equals(""))
                    rc[e]=rc[e].concat(","+lp);
           }
       }
    }
   
   return(rc);
}

void ShowRclos()
{
    //Code for Display
   for(int e=0;e<rc.length;++e)
   {
       
       String show[]=new String[rc[e].length()];
       show=rc[e].split(",");
       if(rc[e].equals(""))
           continue;
       
       System.out.println("");
       if(show.length==1)
            System.out.print("Right closure of ({"+show[0]+"})="+(char)216);
       else
       {
            System.out.print("Right closure of ({"+show[0]+"})={");
            for(int i=1;i<show.length;++i)
            {
                if(show.length==1)
                    System.out.print(show[i]);
                else if(i==1&&show.length>1)
                    System.out.print(show[i]);
                else 
                    System.out.print(","+show[i]);      
            }
             System.out.print("}");
       }
   }
}
  // Function for actually returning the LClosure of the passed element "l" 
   String Rfind(String l){
       int z=-1;
       String ret="";
       for(int i=0;i<g.length;++i)
      {
          for(int k=0;k<g[i].length;++k)
            {
               // z=-1;
                z=g[i][k].indexOf(l);
                if(k!=0&&z==0)
                {
                    if(ret.equals(""))
                      ret=ret.concat(g[i][0]);
                    else
                      ret=ret.concat(","+g[i][0]);
                }   
            }     
        }   
  return(ret); 
    }
String find(String p,String c[])
{
   String ret="";
   for(int i=0;i<c.length;++i)
   {
       String l[]=new String[c[i].length()];
       l=c[i].split(",");
       if(l[0].equals(p))
       {
           for(int j=0;j<l.length;++j)
           {
               if(j==0)
                 ret=ret.concat(l[j]);
               else
                   ret=ret.concat(","+l[j]);
           }
       }
   }
   return(ret);
}   
   
}               //Class CYK Ends

public class CYKAlgo {

    public static void main(String[] args){
           //Scanner s = new Scanner(System.in);
   //String[][] G = new String[10][];
  // System.out.println("Enter the Grammar :");
  
 // String[][] g = {{"S","AB","BC"},{"A","BA","a"},{"B","CC","b"},{"C","AB","a"}};
  
   
  /*System.out.println("Enter the string : ");
  
   System.out.println("Enter the grammar : ");
    int i=0,j;
    System.out.println("Enter no. of productions : ");
    
    while(1){
        j=0;
        System.out.println("Enter production "+(i+1)+" : ");
        System.out.println("Enter left : ");
        G[i][j]=
        
    }
        */
  String w[]= {"a","b","c","d","e","f"};
  String sub[]= {"c","d"};   
  int n=w.length,nn=sub.length;
//  String sub[]={"c","d"};
//String w[]= {"b","a","a","b","a"}; 
    CYK ob=new CYK();
    String g[][],lc[],rc[];
        g=ob.g;
    String v[][]=new String[w.length][w.length];
    String vv[][]=new String[sub.length][sub.length];
       // v = ob.v;
   /* v=ob.CYKrun(g,w);
    ob.ShowCYK(v,n);
    ob.CYKacc(w, v); 
    lc=ob.Lclos(g);
    ob.ShowLclos();
    System.out.println("");
    rc=ob.Rclos();
    ob.ShowRclos();
    System.out.println("");
    */
    v=ob.CYKrun(g,w);
    ob.ShowCYK(v, n);
    //ob.ShowsubCYK(vv, nn);
    lc=ob.Lclos(g);
    ob.ShowLclos();
    System.out.println("");
    rc=ob.Rclos(g);
    ob.ShowRclos();
    System.out.println("");
   // ob.Sub(g,w,vv,lc,rc);
   
    
  
 }
}
