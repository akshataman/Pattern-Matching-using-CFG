/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suman;
//package cyk.algo;


import java.util.Arrays;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Suman Anand
 */
public class NewJFrame extends javax.swing.JFrame {
boolean flag1=true,flag2=true,flag3=true;
String[][] y1 = new String[200][200]; 
String[][] y4 = new String[200][200]; 
String[][] y5 = new String[200][200]; 
/**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }

        public void Grun(String g[][]){
       for(int i = 0;i<g.length;i++){
           for(int j=0;j<g[i].length;j++){
               if(j>=2){
               r4.append("\\"+g[i][j]);
               
               }else{
               r4.append(g[i][j]+"→"+g[i][j+1]);
               j=+1;
               }
           }
           r4.append("\n");
       
       }
    }
public class CYK{
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
//    public void Grun(String g[][]){
//       for(int i = 0;i<g.length;i++){
//           for(int j=0;j<g[i].length;j++){
//               if(j>=2){
//               r4.append("\\"+g[i][j]);
//               
//               }else{
//               r4.append(g[i][j]+"→"+g[i][j+1]);
//               j=+1;
//               }
//           }
//           r4.append("\n");
//       
//       }
//   }
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
        r4.append("\t\t\tCYK Algorithm\n");
        for(int l=1;l<n+1;l++)
          {
             for(int m=1;m<n+1;m++)
               { 
                   r4.append("\t");
                   if(null == v[l][m])
                       r4.append("-");
                   else switch (v[l][m]) {
                     case "":
                         r4.append((char)216+"");
                         break;
                     default:
                         r4.append("{"+v[l][m]+"}");
                         break;
                    }
                }
             r4.append("\n");
        }
   }
   void ShowsubCYK(String v[][],int n)
   {
       int i=222;
       r4.append("\t\t\tCYK Algorithm\n");
        for(int l=0;l<n+2;l++)
          {
             for(int m=0;m<n+2;m++)
               { 
                   r4.append("\t");
                   if(null == v[l][m])
                       r4.append((char)i+"");
                   else switch (v[l][m]) {
                     case "":
                         r4.append("-");
                         break;
                     default:
                         r4.append("{"+v[l][m]+"}");
                         break;
                 }
               }
             r4.append("");
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
            r4.append("The string '"+Arrays.toString(w)+"'is accepted by the grammar\n");
        else
            r4.append("The entered string '"+Arrays.toString(w)+"' is not accepted by the grammar\n");
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
             r4.append("\n");
            if(show.length==1)
                 r4.append("Left closure of ({"+show[0]+"})="+(char)216);
            else
            {
                 r4.append("Left closure of ({"+show[0]+"})={");
                 for(int i=1;i<show.length;++i)
                 {
                     if(show.length==1)
                         r4.append(show[i]);
                     else if(i==1&&show.length>1)
                         r4.append(show[i]);
                     else 
                         r4.append(","+show[i]);      
                 }
                 r4.append("}");
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
       
       r4.append("\n");
       if(show.length==1)
            r4.append("Right closure of ({"+show[0]+"})="+(char)216);
       else
       {
            r4.append("Right closure of ({"+show[0]+"})={");
            for(int i=1;i<show.length;++i)
            {
                if(show.length==1)
                    r4.append(show[i]);
                else if(i==1&&show.length>1)
                    r4.append(show[i]);
                else 
                    r4.append(","+show[i]);      
            }
             r4.append("}");
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AxiomCoordinate = new javax.swing.JDialog();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        Rules = new javax.swing.JDialog();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        theorem4 = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        r1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        list1 = new javax.swing.JList<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        theorem5 = new javax.swing.JDialog();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        r2 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        list2 = new javax.swing.JList<>();
        jLabel11 = new javax.swing.JLabel();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        CYK = new javax.swing.JDialog();
        jScrollPane7 = new javax.swing.JScrollPane();
        r4 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar6 = new javax.swing.JMenuBar();
        jMenu12 = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        theorem1 = new javax.swing.JDialog();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        r = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        l1 = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jMenuBar7 = new javax.swing.JMenuBar();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jOptionPane1 = new javax.swing.JOptionPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        LcRc = new javax.swing.JDialog();
        Sub = new javax.swing.JDialog();
        jScrollPane8 = new javax.swing.JScrollPane();
        r5 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton8 = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        AxiomCoordinate.setMinimumSize(new java.awt.Dimension(400, 400));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon("S:\\Java\\IMG-20170922-WA0002.jpg")); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Coordinates of elements of hexagonal picture"));

        jLabel6.setIcon(new javax.swing.ImageIcon("S:\\Java\\3.PNG")); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Axiom Hexagon Array"));

        jMenu2.setText("File");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Exit");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar2.add(jMenu2);

        jMenu5.setText("View");

        jMenuItem8.setText("jMenuItem8");
        jMenu5.add(jMenuItem8);

        jMenuBar2.add(jMenu5);

        AxiomCoordinate.setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout AxiomCoordinateLayout = new javax.swing.GroupLayout(AxiomCoordinate.getContentPane());
        AxiomCoordinate.getContentPane().setLayout(AxiomCoordinateLayout);
        AxiomCoordinateLayout.setHorizontalGroup(
            AxiomCoordinateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AxiomCoordinateLayout.createSequentialGroup()
                .addGroup(AxiomCoordinateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AxiomCoordinateLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel7))
                    .addGroup(AxiomCoordinateLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        AxiomCoordinateLayout.setVerticalGroup(
            AxiomCoordinateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AxiomCoordinateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Rules.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon("S:\\Java\\r.PNG")); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Rules"));

        jLabel1.setText("Theorem 1:");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\Suman Anand\\Pictures\\t4.PNG")); // NOI18N
        jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Rules"));

        jLabel16.setText("Theorem 2:");

        jMenu6.setText("File");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar3.add(jMenu7);

        Rules.setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout RulesLayout = new javax.swing.GroupLayout(Rules.getContentPane());
        Rules.getContentPane().setLayout(RulesLayout);
        RulesLayout.setHorizontalGroup(
            RulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RulesLayout.createSequentialGroup()
                .addGroup(RulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RulesLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(RulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addGroup(RulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel1))))
                    .addGroup(RulesLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel16)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        RulesLayout.setVerticalGroup(
            RulesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RulesLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(50, 50, 50))
        );

        theorem4.setMinimumSize(new java.awt.Dimension(700, 600));

        r1.setColumns(20);
        r1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        r1.setRows(5);
        jScrollPane3.setViewportView(r1);

        list1.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Operation"));
        list1.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        list1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "r1-rule", "lr-rule", "ll-rule", "r2-rule" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                list1MouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(list1);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Pure Hexagonal Context Free Grammars Generating Hexagonal Patterns");

        jLabel12.setIcon(new javax.swing.ImageIcon("S:\\Java\\3.PNG")); // NOI18N
        jLabel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Axiom Hexagon Array"));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\Suman Anand\\Pictures\\t4.PNG")); // NOI18N
        jLabel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Rules"));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel14.setText("Output Box");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Theorem 4:");

        jMenu10.setText("File");

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setText("Theorem 1");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem9);

        jMenuBar5.add(jMenu10);

        jMenu11.setText("Edit");
        jMenuBar5.add(jMenu11);

        theorem4.setJMenuBar(jMenuBar5);

        javax.swing.GroupLayout theorem4Layout = new javax.swing.GroupLayout(theorem4.getContentPane());
        theorem4.getContentPane().setLayout(theorem4Layout);
        theorem4Layout.setHorizontalGroup(
            theorem4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(theorem4Layout.createSequentialGroup()
                .addGroup(theorem4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(theorem4Layout.createSequentialGroup()
                        .addGroup(theorem4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(theorem4Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(theorem4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(theorem4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13))
                            .addGroup(theorem4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42)
                        .addGroup(theorem4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(theorem4Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(theorem4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)))
                .addGap(0, 55, Short.MAX_VALUE))
        );
        theorem4Layout.setVerticalGroup(
            theorem4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(theorem4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGroup(theorem4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(theorem4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(theorem4Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        theorem5.setMinimumSize(new java.awt.Dimension(700, 600));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\Suman Anand\\Pictures\\5.PNG")); // NOI18N
        jLabel19.setBorder(javax.swing.BorderFactory.createTitledBorder("Rules"));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel20.setText("Output Box");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setText("Theorem 5:");

        r2.setColumns(20);
        r2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        r2.setRows(5);
        jScrollPane5.setViewportView(r2);

        list2.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Operation"));
        list2.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        list2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "r-rule", "lr-rule", "ll-rule" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list2MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                list2MouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(list2);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Pure Hexagonal Context Free Grammars Generating Hexagonal Patterns");

        jMenu8.setText("File");
        jMenuBar4.add(jMenu8);

        jMenu9.setText("Edit");
        jMenuBar4.add(jMenu9);

        theorem5.setJMenuBar(jMenuBar4);

        javax.swing.GroupLayout theorem5Layout = new javax.swing.GroupLayout(theorem5.getContentPane());
        theorem5.getContentPane().setLayout(theorem5Layout);
        theorem5Layout.setHorizontalGroup(
            theorem5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(theorem5Layout.createSequentialGroup()
                .addGroup(theorem5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(theorem5Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel21)
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(theorem5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(theorem5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(theorem5Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(theorem5Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
            .addGroup(theorem5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        theorem5Layout.setVerticalGroup(
            theorem5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(theorem5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGroup(theorem5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(theorem5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(theorem5Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(theorem5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addComponent(jLabel19)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CYK.setMinimumSize(new java.awt.Dimension(750, 550));

        r4.setColumns(20);
        r4.setRows(5);
        jScrollPane7.setViewportView(r4);

        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("CYK Algorithm");

        jMenu12.setText("File");
        jMenuBar6.add(jMenu12);

        jMenu13.setText("Edit");
        jMenuBar6.add(jMenu13);

        CYK.setJMenuBar(jMenuBar6);

        javax.swing.GroupLayout CYKLayout = new javax.swing.GroupLayout(CYK.getContentPane());
        CYK.getContentPane().setLayout(CYKLayout);
        CYKLayout.setHorizontalGroup(
            CYKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CYKLayout.createSequentialGroup()
                .addGroup(CYKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CYKLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButton1))
                    .addGroup(CYKLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel8)))
                .addGap(68, 68, 68)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addContainerGap())
        );
        CYKLayout.setVerticalGroup(
            CYKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CYKLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CYKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CYKLayout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(CYKLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(61, 61, 61))))
        );

        theorem1.setMinimumSize(new java.awt.Dimension(750, 600));

        jLabel23.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel23.setText("to Generate");

        jLabel25.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel25.setText("Hexagonal Patterns");

        r.setColumns(20);
        r.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        r.setRows(5);
        r.setBorder(javax.swing.BorderFactory.createTitledBorder("OUTPUT"));
        jScrollPane9.setViewportView(r);

        l1.setBorder(javax.swing.BorderFactory.createTitledBorder("Select Operation"));
        l1.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        l1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "r-rule", "lr-rule", "ll-rule" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        l1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                l1MouseReleased(evt);
            }
        });
        jScrollPane10.setViewportView(l1);

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel3.setText("Pure Hexagonal Context Free Grammars");

        jLabel26.setIcon(new javax.swing.ImageIcon("S:\\Java\\3.PNG")); // NOI18N
        jLabel26.setBorder(javax.swing.BorderFactory.createTitledBorder("Axiom Hexagon Array"));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon("S:\\Java\\r.PNG")); // NOI18N
        jLabel27.setBorder(javax.swing.BorderFactory.createTitledBorder("Rules"));

        jLabel28.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel28.setText("Generating Hexagonal Patterns");

        jLabel29.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel29.setText("Apply Rule");

        jMenu14.setText("File");

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem12.setText(" Theorem 1");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem12);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem13.setText("Theorem 4");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem13);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem14.setText("Theorem 5");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem14);

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem15.setText("CYK Algorithm");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem15);

        jMenuItem19.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem19.setText("Exit");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem19);

        jMenuBar7.add(jMenu14);

        jMenu15.setText("View");

        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem16.setText("Coordinates of Ho");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem16);

        jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem17.setText("Axiom Hexagonal Array");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem17);

        jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem18.setText("Rules");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem18);

        jMenuBar7.add(jMenu15);

        theorem1.setJMenuBar(jMenuBar7);

        javax.swing.GroupLayout theorem1Layout = new javax.swing.GroupLayout(theorem1.getContentPane());
        theorem1.getContentPane().setLayout(theorem1Layout);
        theorem1Layout.setHorizontalGroup(
            theorem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(theorem1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(theorem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(theorem1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(theorem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, theorem1Layout.createSequentialGroup()
                                .addGroup(theorem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addGroup(theorem1Layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addGroup(theorem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(theorem1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel25))
                                            .addComponent(jLabel23))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        theorem1Layout.setVerticalGroup(
            theorem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(theorem1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(theorem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(theorem1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel28)
                        .addGroup(theorem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(theorem1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(theorem1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LcRcLayout = new javax.swing.GroupLayout(LcRc.getContentPane());
        LcRc.getContentPane().setLayout(LcRcLayout);
        LcRcLayout.setHorizontalGroup(
            LcRcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        LcRcLayout.setVerticalGroup(
            LcRcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        Sub.setMinimumSize(new java.awt.Dimension(750, 550));

        r5.setColumns(20);
        r5.setRows(5);
        r5.setMaximumSize(new java.awt.Dimension(550, 500));
        r5.setMinimumSize(new java.awt.Dimension(550, 500));
        r5.setPreferredSize(new java.awt.Dimension(550, 500));
        jScrollPane8.setViewportView(r5);

        jButton2.setText("Generate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel22.setText("Sub-Sequence");

        javax.swing.GroupLayout SubLayout = new javax.swing.GroupLayout(Sub.getContentPane());
        Sub.getContentPane().setLayout(SubLayout);
        SubLayout.setHorizontalGroup(
            SubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubLayout.createSequentialGroup()
                .addGroup(SubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SubLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButton2))
                    .addGroup(SubLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel22)))
                .addGap(68, 68, 68)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                .addContainerGap())
        );
        SubLayout.setVerticalGroup(
            SubLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(SubLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(61, 61, 61))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(450, 580));
        setMinimumSize(new java.awt.Dimension(450, 580));

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel2.setText("Pure Hexagonal Context Free Grammars");

        jLabel18.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel18.setText("Generating Hexagonal Patterns");

        jLabel4.setText("Select the Screen you wish to visit:");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Theorem 1");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Theorem 4");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Theorem 5");
        jRadioButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton3MouseClicked(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("CYK Algorithm");
        jRadioButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton4MouseClicked(evt);
            }
        });

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("Axioms");
        jRadioButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton5MouseClicked(evt);
            }
        });

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setText("Coordinates of Hexagonal Array");
        jRadioButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton6MouseClicked(evt);
            }
        });

        buttonGroup2.add(jRadioButton7);
        jRadioButton7.setText("Rules");
        jRadioButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton7MouseClicked(evt);
            }
        });

        jLabel5.setText("Other Additional Screens");

        buttonGroup1.add(jRadioButton8);
        jRadioButton8.setText("Sub- String");
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setText("Theorem 1");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Theorem 4");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Theorem 5");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setText("CYK Algo");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("View");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Coordinates of Ho");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem4MouseClicked(evt);
            }
        });
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Axiom Hexagonal Array");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Rules");
        jMenuItem6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem6MouseClicked(evt);
            }
        });
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Exit");
        jMenu4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jMenu4KeyTyped(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton5)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel18))
                    .addComponent(jLabel2))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton8)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton8)
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addGap(9, 9, 9)
                .addComponent(jRadioButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton7)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
    AxiomCoordinate.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MouseClicked

    }//GEN-LAST:event_jMenuItem4MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
  //  jDialog1.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenuItem6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem6MouseClicked
    Rules.setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6MouseClicked

    private void list1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list1MouseClicked
    int z = list1.getSelectedIndex();
    int i=0,j=0,k=0,a=0,b=0,c=0,v=0,count=0,l=0;
    String[][] x = {{"   ","e","   ","a","x","\n"},{"a","   ","a","   ","b","x","\n"},{"   ","b","   ","b","x","\n"},{"\0"}};
    if(flag2)
    {
        flag2=false;
        for( i = 0; i<x.length; i++){
        for( j = 0; j<x[i].length;j++){
        y4[i][j]=x[i][j];    
        }
    }//loop for storing in y
    }
   
    
    switch(z){
        case 0:
            r1.append("R1- rule selected\n");

            for( i = 0; i<x.length; i++){
        for( j = 0; j<x[i].length;j++){
            if(y4[i][j]=="e"){
                v=j;
                while(k<10){
                    if(y4[i][k]=="x"){
                    c=k;
                    }
                k++;
                }
                    y4[i][c]="   ";
                    y4[i][c+1]="a";
                    y4[i][c+2]="x";
                    y4[i][c+3]="\n";
            }
        }
    }    
    for( i = 1; i<y4.length; i++){
        count=0;
        for(j=v;j<y4[i].length;j++){
            if(y4[i][j]=="b"){
                count++;
            }
            if(y4[i][j]=="x"){
                    k=j;
                    while(count>0){
                    if(y4[i][k]=="x"){
                    y4[i][k]="   ";
                        y4[i][k+1]="b";
                        y4[i][k+2]="x";
                        y4[i][k+3]="\n";
                    }
                    k+=2;
                    count--;
                    }    
                        break;
                    }
        }
        v++;
    }
    
        //for finding arrow location
    for( i = 1; i<y4.length; i++){
        for(j=0;j<y4[i].length;j++){
                    if(y4[i][j]=="x"){
                        if(l<j){
                        l=j;// for arrow
                        }
                        break;
                    }
        }
    }
// line for arrow
    for(i=0;i<l;i++){
        r1.append(" ");
    }
        r1.append("  ↓\n");

    for( i = 0; i<y4.length; i++){
        for( j = 0; j<y4[i].length;j++){
            if(y4[i][j]==null||y4[i][j]=="x"||y4[i][j]=="\0"){
            continue;
            }
            r1.append(""+y4[i][j]);       
        }
    }
    
            break;
        case 1:
            r1.append("LR- rule selected\n");
    
    for( i = 0; i<x.length; i++){
        if(y4[i][0]=="\0"){
                    y4[i][0]="   ";
                    y4[i+1][0]="\0";
                    c=i-1;
                    break;
            }
    }    //for finding index of \0
    
    for(j=0;j<y4[c].length-3;j++){
        if(y4[c][j]=="   "){
            y4[c+1][j+1]="   ";
        }
        if(y4[c][j]=="b"){
            y4[c+1][j+1]="b";
        }
        if(y4[c][j]=="x"){
            y4[c+1][j+1]="x";
            y4[c+1][j+2]="\n";
            y4[c][j]="   ";
            y4[c][j+1]="b";
            y4[c][j+2]="x";
            y4[c][j+3]="\n";
            a=j+1;
            break;
        }
    }//appending slant values with an x corresponding value
    while(true){
    if((y4[c][a]=="b") && (y4[c-2][a]=="b")){
        c--;
        y4[c][a]="   ";
        y4[c][a+1]="b";
        y4[c][a+2]="x";
        y4[c][a+3]="\n";
        a=a+1;
    }
    else{
    break;//for coming out of forever loop
    }
    }//for appending diagonal b values
        //for finding arrow location
    for( i = 1; i<y4.length; i++){
        for(j=0;j<y4[i].length;j++){
                    if(y4[i][j]=="x"){
                        if(l<j){
                        l=j;// for arrow
                        }
                        break;
                    }
        }
    }
// line for arrow
    for(i=0;i<l;i++){
        r1.append(" ");
    }
        r1.append("  ↓\n");

    for( i = 0; i<y4.length; i++){
        for( j = 0; j<y4[i].length;j++){
            if(y4[i][j]==null||y4[i][j]=="x"||y4[i][j]=="\0"){
            continue;
            }
            r1.append(""+y4[i][j]);
        }
    }//loop for printing y
            break;
        case 2:
            r1.append("LL- rule selected\n");
            
        for( i = 0; i<y4.length; i++){
        for(j=y4[i].length-2;j>=0;j--){
            y4[i][j+1]=y4[i][j];
        }

        if(y4[i][0]=="\0"){
            y4[i+1][0]="\0";
            c=i-1;
            break;
        }
        y4[i][0]="   ";
    }    //for finding index of \0
    
    for(j=1;j<y4[c].length;j++){
        y4[c+1][j-1]=y4[c][j];
    }//loop for appending last line
    
    for( i = 0; i<y4.length; i++){
        if(y4[i][1]=="a"){
            y4[i+1][a]="a";
            b=i+1;
            break;
        }
    }//finding the index of a and appending diagonal b values
    while(true){
        if(b<=c){
            y4[b+1][a+1]="b";
            b++;
            a++;
        }
        else{
            break;
        }
    }//for diagonal b values
    
        //for finding arrow location
    for( i = 1; i<y4.length; i++){
        for(j=0;j<y4[i].length;j++){
                    if(y4[i][j]=="x"){
                        if(l<j){
                        l=j;// for arrow
                        }
                        break;
                    }
        }
    }
// line for arrow
    for(i=0;i<l;i++){
        r1.append(" ");
    }
        r1.append("  ↓\n");
        
    for( i = 0; i<y4.length; i++){
        for( j = 0; j<y4[i].length;j++){
            if(y4[i][j]==null||y4[i][j]=="x"||y4[i][j]=="\0"){
            continue;
            
            }
            r1.append(""+y4[i][j]);
        }
    }//loop for printing y

            
            break;
        case 3: 
            r1.append("R2- rule selected\n");
        for( i = 0; i<x.length; i++){
        for( j = 0; j<x[i].length;j++){
            if(y4[i][j]=="e"){
                    y4[i][j]="a";
            }
        }
    }
        
        //for finding arrow location
    for( i = 1; i<y4.length; i++){
        for(j=0;j<y4[i].length;j++){
                    if(y4[i][j]=="x"){
                        if(l<j){
                        l=j;// for arrow
                        }
                        break;
                    }
        }
    }
// line for arrow
    for(i=0;i<l;i++){
        r1.append(" ");
    }
        r1.append("  ↓\n");

        
    for( i = 0; i<y4.length; i++){
        for( j = 0; j<y4[i].length;j++){
            if(y4[i][j]==null||y4[i][j]=="x"||y4[i][j]=="\0"){
            continue;
            }
            r1.append(""+y4[i][j]);
        }
    }//loop for printing y
break;
        default:
            r1.append("Select an Item from the List");
    }        // TODO add your handling code here:
    }//GEN-LAST:event_list1MouseClicked

    private void list1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_list1MouseReleased

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    theorem4.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    theorem5.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
    AxiomCoordinate.setVisible(true);        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
    Rules.setVisible(true);        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void list2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list2MouseClicked
    
        int z = list2.getSelectedIndex();
    
    int i=0,j=0,k=0,a=0,b=0,c=0,l=0;
    String[][] x = {{"   ","1","   ","0","x","\n"},{"0","   ","1","   ","0","x","\n"},{"   ","0","   ","1","x","\n"},{"\0"}};
    if(flag3)
    {
        flag3=false;
        for( i = 0; i<x.length; i++){
        for( j = 0; j<x[i].length;j++){
        y5[i][j]=x[i][j];    
        }
    }//loop for storing in y
    }
   
    
    switch(z){
        case 0:
            r2.append("R- rule selected\n");
          
                for( i = 0; i<y5.length; i++){
        for(j=0;j<y5[i].length;j++){
                    if(y5[i][j]=="x"){
                        y5[i][j]="   ";
                        y5[i][j+1]="0";
                        y5[i][j+2]="x";
                        y5[i][j+3]="\n";
                        break;
                    }
        }
    }
                        //for finding arrow location
    for( i = 1; i<y5.length; i++){
        for(j=0;j<y5[i].length;j++){
                    if(y5[i][j]=="x"){
                        if(l<j){
                        l=j;// for arrow
                        }
                        break;
                    }
        }
    }
// line for arrow
    for(i=0;i<l;i++){
        r2.append(" ");
    }
        r2.append("  ↓\n");

                
    for( i = 0; i<y5.length; i++){
        for( j = 0; j<y5[i].length;j++){
            if(y5[i][j]==null||y5[i][j]=="x"||y5[i][j]=="\0"){
            continue;
            }
            r2.append(""+y5[i][j]);
            
        }
    }
    
            break;
        case 1:
            r2.append("LR- rule selected\n");
          
    for( i = 0; i<x.length; i++){
        if(y5[i][0]=="\0"){
                    y5[i][0]="   ";
                    y5[i+1][0]="\0";
                    c=i-1;
                    break;
            }
    }    //for finding index of \0
//    r.append(""+c);
    for(j=0;j<y5[c].length-3;j++){
        y5[c+1][j+1]=y5[c][j];
        if(y5[c][j]=="x"){
            y5[c+1][j+1]="x";
            y5[c+1][j+2]="\n";
            y5[c][j]="   ";
            y5[c][j+1]="0";
            y5[c][j+2]="x";
            y5[c][j+3]="\n";
            a=j+1;
            break;
        }
    }//appending slant values with an x corresponding value
    while(true){
    if((y5[c][a]=="b") && (y5[c-2][a]=="b")){
        c--;
        y5[c][a]="   ";
        y5[c][a+1]="b";
        y5[c][a+2]="x";
        y5[c][a+3]="\n";
        a=a+1;
    }
    else{
    break;//for coming out of forever loop
    }
    }//for appending diagonal b values
    for( i = 0; i<y5.length; i++){
        for( j = 0; j<y5[i].length;j++){
            if(y5[i][j]=="1" && y5[i+1][0]!="\0"){
                y5[i+1][j+1]="2";
            }
        }
    }//for 2 and 1 wala case :D
                  //for finding arrow location
    for( i = 1; i<y5.length; i++){
        for(j=0;j<y5[i].length;j++){
                    if(y5[i][j]=="x"){
                        if(l<j){
                        l=j;// for arrow
                        }
                        break;
                    }
        }
    }
// line for arrow
    for(i=0;i<l;i++){
        r2.append(" ");
    }
        r2.append("  ↓\n");

    for( i = 0; i<y5.length; i++){
        for( j = 0; j<y5[i].length;j++){
            if(y5[i][j]==null||y5[i][j]=="x"||y5[i][j]=="\0"){
            continue;
            }
            r2.append(""+y5[i][j]);
        }
    }//loop for printing y
            break;
        case 2:
            r2.append("LL- rule selected\n");
          

//shifting elements to one right
    for( i = 0; i<y5.length; i++){
        //for finding index of \0
        if(y5[i][0]=="\0"){
            y5[i+1][0]="\0";
            y5[i][0]="   ";
            c=i-1;
            break;
        }
        for(j=y5[i].length-2;j>=0;j--){
            y5[i][j+1]=y5[i][j];
        }
        y5[i][0]="   ";
    }
//finding the index of 0 on y=1    
    for( i = 0; i<y5.length; i++){
        if(y5[i][1]=="0"){
            y5[i+1][a]="0";
            b=i+1;
            break;
        }
    }
    // slant 0 in the hexagon
    while(true){
        if(b<=c){
            y5[b+1][a]="   ";
            y5[b+1][a+1]="0";
            b++;
            a++;
        }
        else{
            break;
        }
    }

  
    for(j=1;j<y5[c].length-2;j++){
        y5[c+1][j+1]=y5[c][j];
        if(y5[c][j+3]=="x"){
            y5[c+1][j+1]=y5[c][j];
            y5[c+1][j+2]="x";
            y5[c+1][j+3]="\n";
            break;
//            y[c+1][j-1]="0";
        }
    }//loop for appending last line
    for(i=0;i<y5.length;i++){
        for(j=0;j<y5[i].length;j++){
            if(y5[i][j]=="2"){
            y5[i][j]="1";
            }
        }
    }
    /*
    
    
    for(j=1;j<y[c].length-2;j++){
        y[c+1][j+1]=y[c][j];
        if(y[c][j+3]=="x"){
            y[c+1][j+1]=y[c][j];
            y[c+1][j+2]="x";
            y[c+1][j+3]="\n";
//            y[c+1][j-1]="0";
        }
    }//loop for appending last line
    
    */
    
                  //for finding arrow location
    for( i = 1; i<y5.length; i++){
        for(j=0;j<y5[i].length;j++){
                    if(y5[i][j]=="x"){
                        if(l<j){
                        l=j;// for arrow
                        }
                        break;
                    }
        }
    }
// line for arrow
    for(i=0;i<l;i++){
        r2.append(" ");
    }
        r2.append("  ↓\n");

    for( i = 0; i<y5.length; i++){
        for( j = 0; j<y5[i].length;j++){
            if(y5[i][j]==null||y5[i][j]=="x"||y5[i][j]=="\0"){
            continue;
            }
            r2.append(""+y5[i][j]);
        }
    }//loop for printing y

            
            break;
        default:
            r2.append("Select an Item from the List");
    }
        
    }//GEN-LAST:event_list2MouseClicked

    private void list2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_list2MouseReleased

    private void jMenu4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4KeyTyped

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
      //      theorem4.dispose();
    //    JFrame.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
    CYK.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

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
    Grun(ob.g);
    v=ob.CYKrun(g,w);
    ob.ShowCYK(v, n);
    lc=ob.Lclos(g);
    ob.ShowLclos();
    r4.append("\n");
    rc=ob.Rclos(g);
    ob.ShowRclos();
    r4.append("\n");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
    //dispose();  
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void l1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1MouseClicked
        int z = l1.getSelectedIndex();
    
    int i=0,j=0,k=0,a=0,b=0,c=0,l=0;
    String[][] x = {{"   ","e","   ","a","x","\n"},{"a","   ","a","   ","b","x","\n"},{"   ","b","   ","b","x","\n"},{"\0"}};
    if(flag1)
    {
        flag1=false;
        for( i = 0; i<x.length; i++){
        for( j = 0; j<x[i].length;j++){
        y1[i][j]=x[i][j];    
        }
    }//loop for storing in y
    }
   
    
    switch(z){
        case 0:
            r.append("R- rule selected\n");
//for appending line 1
    for( i = 0; i<x.length; i++){
        for( j = 0; j<x[i].length;j++){
            if(y1[i][j]=="e"){
                while(k<10){
                    if(y1[i][k]=="x"){
                    c=k;
                    }
                k++;
                }
                    y1[a][c]="   ";
                    y1[a][c+1]="a";
                    y1[a][c+2]="x";
                    y1[a][c+3]="\n";
            }
                    }
    }    
    // for appending lines rest of the lines
    for( i = 1; i<y1.length; i++){
        for(j=0;j<y1[i].length;j++){
                    if(y1[i][j]=="x"){
                        c=j;
                        y1[i][c]="   ";
                        y1[i][c+1]="b";
                        y1[i][c+2]="x";
                        y1[i][c+3]="\n";
                        if(l<j){
                        l=j;// for arrow
                        }
                        break;
                    }
        }
    }
    
    for(i=0;i<l;i++){
        r.append(" ");
    }
        r.append("  ↓\n");

    for( i = 0; i<y1.length; i++){
        for( j = 0; j<y1[i].length;j++){
            if(y1[i][j]==null||y1[i][j]=="x"||y1[i][j]=="\0"){
            continue;
            }
            r.append(""+y1[i][j]);
            
        }
    }
    
            break;
        case 1:
            r.append("LR- rule selected\n");
    
    for( i = 0; i<x.length; i++){
        if(y1[i][0]=="\0"){
                    y1[i][0]="   ";
                    y1[i+1][0]="\0";
                    c=i-1;
                    break;
            }
    }    //for finding index of \0
    
    for(j=0;j<y1[c].length-3;j++){
        if(y1[c][j]=="   "){
            y1[c+1][j+1]="   ";
        }
        if(y1[c][j]=="b"){
            y1[c+1][j+1]="b";
        }
        if(y1[c][j]=="x"){
            y1[c+1][j+1]="x";
            y1[c+1][j+2]="\n";
            y1[c][j]="   ";
            y1[c][j+1]="b";
            y1[c][j+2]="x";
            y1[c][j+3]="\n";
            a=j+1;
            break;
        }
    }//appending slant values with an x corresponding value
    while(true){
    if((y1[c][a]=="b") && (y1[c-2][a]=="b")){
        c--;
        y1[c][a]="   ";
        y1[c][a+1]="b";
        y1[c][a+2]="x";
        y1[c][a+3]="\n";
        a=a+1;
    }
    else{
    break;//for coming out of forever loop
    }
    }//for appending diagonal b values
    for( i = 1; i<y1.length; i++){
        for(j=0;j<y1[i].length;j++){
                    if(y1[i][j]=="x"){
                        if(l<j){
                        l=j;// for arrow
                        }
                        break;
                    }
        }
    }

    for(i=0;i<l;i++){
        r.append(" ");
    }
        r.append("  ↓\n");
    
    for( i = 0; i<y1.length; i++){
        for( j = 0; j<y1[i].length;j++){
            if(y1[i][j]==null||y1[i][j]=="x"||y1[i][j]=="\0"){
            continue;
            }
            r.append(""+y1[i][j]);
        }
    }//loop for printing y
            break;
        case 2:
            r.append("LL- rule selected\n");
            
        for( i = 0; i<y1.length; i++){
        for(j=y1[i].length-2;j>=0;j--){
            y1[i][j+1]=y1[i][j];
        }

        if(y1[i][0]=="\0"){
            y1[i+1][0]="\0";
            c=i-1;
            break;
        }
        y1[i][0]="   ";
    }    //for finding index of \0
    
    for(j=1;j<y1[c].length;j++){
        y1[c+1][j-1]=y1[c][j];
    }//loop for appending last line
    
    for( i = 0; i<y1.length; i++){
        if(y1[i][1]=="a"){
            y1[i+1][a]="a";
            b=i+1;
            break;
        }
    }//finding the index of a and appending diagonal b values
    while(true){
        if(b<=c){
            y1[b+1][a+1]="b";
            b++;
            a++;
        }
        else{
            break;
        }
    }//for diagonal b values

    //for finding arrow location
    for( i = 1; i<y1.length; i++){
        for(j=0;j<y1[i].length;j++){
                    if(y1[i][j]=="x"){
                        if(l<j){
                        l=j;// for arrow
                        }
                        break;
                    }
        }
    }
// line for arrow
    for(i=0;i<l;i++){
        r.append(" ");
    }
        r.append("  ↓\n");

    for( i = 0; i<y1.length; i++){
        for( j = 0; j<y1[i].length;j++){
            if(y1[i][j]==null||y1[i][j]=="x"||y1[i][j]=="\0"){
            continue;
            }
            r.append(""+y1[i][j]);
        }
    }//loop for printing y

            
            break;
        default:
            r.append("Select an Item from the List");
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_l1MouseClicked

    private void l1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_l1MouseReleased

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
    theorem1.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
    theorem5.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
    System.exit(1);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
    jOptionPane1.showMessageDialog(null,"You are already on Page: Theorem 1!");    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
    theorem4.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
    CYK.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
    AxiomCoordinate.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
            AxiomCoordinate.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
    Rules.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
    theorem1.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
theorem4.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jRadioButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton3MouseClicked
theorem5.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3MouseClicked

    private void jRadioButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton4MouseClicked
CYK.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4MouseClicked

    private void jRadioButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton5MouseClicked
      AxiomCoordinate.setVisible(true);   // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5MouseClicked

    private void jRadioButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton6MouseClicked
AxiomCoordinate.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6MouseClicked

    private void jRadioButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton7MouseClicked
Rules.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton7MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
    Sub.setVisible(true);    // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog AxiomCoordinate;
    private javax.swing.JDialog CYK;
    private javax.swing.JDialog LcRc;
    private javax.swing.JDialog Rules;
    private javax.swing.JDialog Sub;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuBar jMenuBar6;
    private javax.swing.JMenuBar jMenuBar7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JList<String> l1;
    private javax.swing.JList<String> list1;
    private javax.swing.JList<String> list2;
    private javax.swing.JTextArea r;
    private javax.swing.JTextArea r1;
    private javax.swing.JTextArea r2;
    private javax.swing.JTextArea r4;
    private javax.swing.JTextArea r5;
    private javax.swing.JDialog theorem1;
    private javax.swing.JDialog theorem4;
    private javax.swing.JDialog theorem5;
    // End of variables declaration//GEN-END:variables
}
