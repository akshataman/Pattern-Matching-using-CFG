
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Suman Anand
 */
public class table extends JFrame{

    
    JTable table;
        public table(){
            setLayout(new FlowLayout());
        //String[] cols = {"Name","Eye=Color","Gender"};
        String w[]= {"b","a","a","b","a"};
//        Object[][] data = {
//            {"Bill","Hazel","Male"},
//            {"Mary","Black","Female"},
//            {"Rick","Red","Male"},
//            {"Janice","Yellow","Female"},
//        };
//        table = new JTable(data, cols);
//        table.setPreferredScrollableViewportSize(new Dimension(500, 60));
//        table.setFillsViewportHeight(rootPaneCheckingEnabled);
//        JScrollPane scrollpane = new JScrollPane(table);
//        add(scrollpane);
//      

String v[][]= new String[5][5];
  
  String[][] g = {{"S","AB","BC"},{"A","BA","a"},{"B","CC","b"},{"C","AB","a"}};
  int n=w.length;
  for(int i=0;i<w.length;i++)
  {
      v[i][i]="";
      for(int j=0;j<g.length;j++)
      {
          for(int k=0;k<g[j].length;k++)
          {
              if(g[j][k].equals(w[i]))
              {
                  if(v[i][i].equals(""))
                       v[i][i]=v[i][i].concat(g[j][0]);
                  else
                      v[i][i]=v[i][i].concat(","+g[j][0]);
              }
          }
      }
  }
  
 int j,i;
 String[] f=new String[10];
 String[] s=new String[10];
  int flag1=0,flag2=0,iterate=0,flag=0;
  
  for(int len=2;len<n+1;++len)
  {  
      for( i=0;i<n-len+1;i++)
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

  
  /*
  */
        //  i=222;
          //char ch[]={(char)i};
            //       String s1 = new String(ch);
          //System.out.println("\t\t\tCYK Algorithm");
        for(int l=0;l<5;l++)
          {
             for(int m=0;m<5;m++)
               { 
                   //System.out.print("\t");
                   if(null == v[l][m])

                       v[l][m]="-";
                   else switch (v[l][m]) {
                     case "":
                         v[l][m]="Ø";
                         break;
                     default:
                         break;
                 }
               }
          }

  table = new JTable(v, w);
        table.setPreferredScrollableViewportSize(new Dimension(500, 80));
        table.setFillsViewportHeight(rootPaneCheckingEnabled);
        JScrollPane scrollpane = new JScrollPane(table);
        add(scrollpane);
        }
        




    public static void main(String args[]){
            table gui = new table();
            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.setSize(600,200);
            gui.setVisible(true);
            gui.setTitle("CYK Algorithm!!!");
            
//               String w[]= {"b","a","a","b","a"};
//   String v[][]= new String[5][5];
//  
//  String[][] g = {{"S","AB","BC"},{"A","BA","a"},{"B","CC","b"},{"C","AB","a"}};
//  int n=w.length;
//  for(int i=0;i<w.length;i++)
//  {
//      v[i][i]="";
//      for(int j=0;j<g.length;j++)
//      {
//          for(int k=0;k<g[j].length;k++)
//          {
//              if(g[j][k].equals(w[i]))
//              {
//                  if(v[i][i].equals(""))
//                       v[i][i]=v[i][i].concat(g[j][0]);
//                  else
//                      v[i][i]=v[i][i].concat(","+g[j][0]);
//              }
//          }
//      }
//  }
//  
// int j;
// String[] f=new String[10];
// String[] s=new String[10];
//  int flag1=0,flag2=0,iterate=0,flag=0;
//  
//  for(int len=2;len<n+1;++len)
//  {  
//      for(int i=0;i<n-len+1;i++)
//      {
//          j=i+len-1;
//          v[i][j]="";           
//          for(int k=i;k<j;++k)
//          {
//               f=v[i][k].split(",");
//               flag1=v[i][k].split(",").length;                                        
//               s=v[k+1][j].split(",");
//               flag2=v[k+1][j].split(",").length;
//          
//          if(f[0].equals(""))
//              flag1=0;
//          if(s[0].equals(""))
//              flag2=0;
//          
//          if(flag1!=0&&flag2!=0)                        //make comparisons only if there is any combination to be checked
//                  {     
//          String[] temp=new String[flag1*flag2]; 
//            for(int nn=0,x=0;x<flag1;++x)
//            {
//               for(int y=0;y<flag2;++y,++nn)
//               { 
//                   if(flag1==1&&flag2!=1)
//                          temp[nn]=v[i][k].concat(s[y]);
//                   else if(flag1==1&&flag2==1)
//                           temp[nn]=v[i][k].concat(v[k+1][j]);
//                   else if(flag1!=1&&flag2!=1)
//                           temp[nn]=f[x].concat(s[y]);
//                   else if(flag1!=1&&flag2==1)
//                           temp[nn]=f[x].concat(v[k+1][j]);  
//               }
//            }
//           
//              iterate=1;
//            while(iterate<=temp.length) 
//            {
//              for(int l=0;l<g.length;l++)
//              {  
//                  String temp2[]=new String[v[i][j].length()];
//                  temp2=v[i][j].split(",");
//                for(int m=0;m<g[l].length;m++)
//                {
//                    flag=0;
//                    
//                    if(g[l][m].equals(temp[iterate-1]))
//                    {
//                            for(int a=0;a<temp2.length;++a)
//                            {
//                                if(temp2[a].equals(g[l][0]))
//                                {
//                                    flag=1;
//                                    break;
//                                }
//                            }
//                    }
//                     
//                    if(g[l][m].equals(temp[iterate-1])&&flag!=1)
//                    {
//                        if(v[i][j].equals(""))
//                             v[i][j]=v[i][j].concat(g[l][0]);
//                        else 
//                            v[i][j]=v[i][j].concat(","+ g[l][0]);
//                    }
//                }
//              }
//              iterate++;
//            }
//                  }
//         }                  // end of K loop
//      }                     // end of I loop
//  }                         // end of Len loop
//
// //output 
// for(int l=0;l<5;l++)
//   {
//      for(int m=0;m<5;m++)
//        { 
//            //if(v[l][m].length()>1)
//            System.out.print("{"+v[l][m]+"}\t");
//        }
//      System.out.println("");
//   }
//    
// f=v[0][4].split(",");
// flag=0;
// for(int a=0;a<v[0][4].length();++a)
// {
//     if(f[a].equals("S"))
//     {
//                  flag=1;
//                  break;
//     }
// }
// if(flag==1)
//     System.out.println("The string '"+Arrays.toString(w)+"'is accepted by the grammar");
// else
//     System.out.println("The entered string '"+Arrays.toString(w)+"' is not accepted by the grammar");
        }
}
