/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suman;

/**
 *
 * @author Suman Anand
 */
public class check extends javax.swing.JFrame {

    /**
     * Creates new form check
     */
    public check() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        r = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("r-rule");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("lr-rule");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("ll-rule");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("4: r1");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        r.setColumns(20);
        r.setRows(5);
        jScrollPane1.setViewportView(r);

        jButton6.setText("5: r");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("5: lr");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("5: ll");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("test");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(44, 44, 44)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jButton7)
                            .addComponent(jButton8))
                        .addContainerGap(198, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jButton9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   // String[][] x = new String[100][100];
    String[][] y = {{"   ","e","   ","a","\n"},{"a","   ","a","   ","b","\n"},{"   ","b","   ","b","\n"},{"\0"}};
    for(int i = 0; i<y.length; i++){
        for(int j = 0; j<y[i].length;j++){
            r.append(y[i][j]);
        }
    }
    for(int i = 0; i<y.length; i++){
        for(int j = 0; j<y[i].length;j++){
            if(y[i][j]=="e"){
                r.append("for e; "+"i="+i+"j="+j+"\n");
            }
            if(y[i][j]=="\n"){
                r.append("for next line "+"i="+i+"j="+j+"\n");            
            }
        }
    }
    for(int i = 0; i<y.length; i++){
        for(int j = 0; j<y[i].length;j++){
            if(y[i][j]=="\0"){
                r.append("for last element"+"i="+i+"j="+j+"\n");
            }
        }
    }
    //if()
//    x = {{"  e  a\\n"},{"a  a  b\n"},{"  b  b\n"}};
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    String[][] y = new String[10][20]; 
    int i=0,j=0,k=0,c=0;
    String[][] x = {{"   ","e","   ","a","x","\n"},{"a","   ","a","   ","b","x","\n"},{"   ","b","   ","b","x","\n"},{"\0"}};
    for( i = 0; i<x.length; i++){
        for( j = 0; j<x[i].length;j++){
        y[i][j]=x[i][j];    
        }
    }//loop for storing in y
    for( i = 0; i<y.length; i++){
        for( j = 0; j<y[i].length;j++){
            if(y[i][j]==null||y[i][j]=="x"||y[i][j]=="\0"){
            r.append(""+y[i][j]);
            continue;
            }
        }
    }//loop for printing y
    for( i = 0; i<x.length; i++){
        for( j = 0; j<x[i].length;j++){
            if(y[i][j]=="e"){
                while(k<10){
                    if(y[i][k]=="x"){
                    c=k;
                    }
                k++;
                }
                    y[i][c]="   ";
                    y[i][c+1]="a";
                    y[i][c+2]="x";
                    y[i][c+3]="\n";
            }
        }
    }    
    r.append("After appending the e line \n");
    for( i = 0; i<y.length; i++){
        for( j = 0; j<y[i].length;j++){
            if(y[i][j]==null||y[i][j]=="x"||y[i][j]=="\0"){
            continue;
            }
            r.append(""+y[i][j]);       
        }
    }
    for( i = 1; i<y.length; i++){
        for(j=0;j<y[i].length;j++){
                    if(y[i][j]=="x"){
                        c=j;
                        y[i][c]="   ";
                        y[i][c+1]="b";
                        y[i][c+2]="x";
                        y[i][c+3]="\n";
                        break;
                    }
        }
    }
    r.append("After appending the b line \n");
    for( i = 0; i<y.length; i++){
        for( j = 0; j<y[i].length;j++){
            if(y[i][j]==null||y[i][j]=="x"||y[i][j]=="\0"){
            continue;
            }
            r.append(""+y[i][j]);       
        }
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    String[][] y = new String[10][20]; 
    int i=0,j=0,k=0,a=0,b=0,c=0;
    String[][] x = {{"   ","e","   ","a","x","\n"},{"a","   ","a","   ","b","x","\n"},{"   ","b","   ","b","x","\n"},{"\0"}};
    
    for( i = 0; i<x.length; i++){
        for( j = 0; j<x[i].length;j++){
        y[i][j]=x[i][j];    
        }
    }//loop for storing in y
    for( i = 0; i<y.length; i++){
        for( j = 0; j<y[i].length;j++){
            if(y[i][j]==null||y[i][j]=="x"||y[i][j]=="\0"){
            continue;
            }
            r.append(""+y[i][j]);
        }
    }//loop for printing y
    for( i = 0; i<x.length; i++){
        if(y[i][0]=="\0"){
                    y[i][0]="   ";
                    y[i+1][0]="\0";
                    c=i-1;
                    break;
            }
    }    //for finding index of \0

    for(j=0;j<y[c].length-3;j++){
        if(y[c][j]=="   "){
            y[c+1][j+1]="   ";
        }
        if(y[c][j]=="b"){
            y[c+1][j+1]="b";
        }
        if(y[c][j]=="x"){
            y[c+1][j+1]="x";
            y[c+1][j+2]="\n";
            y[c][j]="   ";
            y[c][j+1]="b";
            y[c][j+2]="x";
            y[c][j+3]="\n";
            a=j+1;
            break;
        }
    }//appending slant values with an x corresponding value
    while(true){
    if((y[c][a]=="b") && (y[c-2][a]=="b")){
        c--;
        y[c][a]="   ";
        y[c][a+1]="b";
        y[c][a+2]="x";
        y[c][a+3]="\n";
        a=a+1;
    }
    else{
    break;//for coming out of forever loop
    }
    }//for appending diagonal b values
    
    for( i = 0; i<y.length; i++){
        for( j = 0; j<y[i].length;j++){
            if(y[i][j]==null||y[i][j]=="x"||y[i][j]=="\0"){
            continue;
            }
            r.append(""+y[i][j]);
        }
    }//loop for printing y
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    String[][] y = new String[10][20]; 
    int i=0,j=0,k=0,a=0,b=0,c=0;
    String[][] x = {{"   ","e","   ","a","x","\n"},{"a","   ","a","   ","b","x","\n"},{"   ","b","   ","b","x","\n"},{"\0"}};
    for( i = 0; i<x.length; i++){
        for( j = 0; j<x[i].length;j++){
        y[i][j]=x[i][j];    
        }
    }//loop for storing in y
    for( i = 0; i<y.length; i++){
        for( j = 0; j<y[i].length;j++){
            if(y[i][j]==null||y[i][j]=="x"||y[i][j]=="\0"){
            continue;
            }
            r.append(""+y[i][j]);
        }
    }//loop for printing y
    for( i = 0; i<y.length; i++){
        for(j=y[i].length-2;j>=0;j--){
            y[i][j+1]=y[i][j];
        }

        if(y[i][0]=="\0"){
            y[i+1][0]="\0";
            c=i-1;
            break;
        }
        y[i][0]="   ";
    }    //for finding index of \0
    
    for(j=1;j<y[c].length;j++){
        y[c+1][j-1]=y[c][j];
    }//loop for appending last line
    
    for( i = 0; i<y.length; i++){
        if(y[i][1]=="a"){
            y[i+1][a]="a";
            b=i+1;
            break;
        }
    }//finding the index of a and appending diagonal b values
    while(true){
        if(b<=c){
            y[b+1][a+1]="b";
            b++;
            a++;
        }
        else{
            break;
        }
    }

    r.append("\n");
    
    for( i = 0; i<y.length; i++){
        for( j = 0; j<y[i].length;j++){
            if(y[i][j]==null||y[i][j]=="x"||y[i][j]=="\0"){
            continue;
            }
            r.append(""+y[i][j]);
        }
    }//loop for printing y

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String[][] y = new String[10][20]; 
    int i=0,j=0,k=0,v=0,c=0,count=0;
    String[][] x = {{"   ","e","   ","a","x","\n"},{"a","   ","a","   ","b","x","\n"},{"   ","b","   ","b","x","\n"},{"\0"}};
    for( i = 0; i<x.length; i++){
        for( j = 0; j<x[i].length;j++){
        y[i][j]=x[i][j];    
        }
    }//loop for storing in y
//for first line: i.e. line of e and a!
    for( i = 0; i<x.length; i++){
        for( j = 0; j<x[i].length;j++){
            if(y[i][j]=="e"){
                v=j;
                while(k<10){
                    if(y[i][k]=="x"){
                    c=k;
                    }
                k++;
                }
                    y[i][c]="   ";
                    y[i][c+1]="a";
                    y[i][c+2]="x";
                    y[i][c+3]="\n";
            }
        }
    }    
    r.append("After appending the e line \n");
    for( i = 0; i<y.length; i++){
        for( j = 0; j<y[i].length;j++){
            if(y[i][j]==null||y[i][j]=="x"||y[i][j]=="\0"){
            continue;
            }
            r.append(""+y[i][j]);       
        }
    }
    //for appending the rest of the lines
    for( i = 1; i<y.length; i++){
        count=0;
        for(j=v;j<y[i].length;j++){
            if(y[i][j]=="b"){
                count++;
            }
            if(y[i][j]=="x"){
                    k=j;
                    while(count>0){
                    if(y[i][k]=="x"){
                    y[i][k]="   ";
                        y[i][k+1]="b";
                        y[i][k+2]="x";
                        y[i][k+3]="\n";
                    }
                    k+=2;
                    count--;
                    }    
                        break;
                    }
        }
        v++;
    }
    r.append("After appending the b line \n");
    for( i = 0; i<y.length; i++){
        for( j = 0; j<y[i].length;j++){
            if(y[i][j]==null||y[i][j]=="x"||y[i][j]=="\0"){
            continue;
            }
            r.append(""+y[i][j]);       
        }
    }
                                           
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    String[][] y = new String[10][20]; 
    int i=0,j=0,k=0,v=0,c=0,count=0;
    String[][] x = {{"   ","1","   ","0","x","\n"},{"0","   ","1","   ","0","x","\n"},{"   ","0","   ","1","x","\n"},{"\0"}};
    for( i = 0; i<x.length; i++){
        for( j = 0; j<x[i].length;j++){
        y[i][j]=x[i][j];    
        }
    }//loop for storing in y
    for( i = 0; i<y.length; i++){
        for(j=0;j<y[i].length;j++){
                    if(y[i][j]=="x"){
                        y[i][j]="   ";
                        y[i][j+1]="0";
                        y[i][j+2]="x";
                        y[i][j+3]="\n";
                        break;
                    }
        }
    }
    for( i = 0; i<y.length; i++){
        for( j = 0; j<y[i].length;j++){
            if(y[i][j]==null||y[i][j]=="x"||y[i][j]=="\0"){
            continue;
            }
            r.append(""+y[i][j]);       
        }
    }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    String[][] y = new String[10][20]; 
    int i=0,j=0,k=0,v=0,c=0,count=0,a=0;
    String[][] x = {{"   ","1","   ","0","x","\n"},{"0","   ","1","   ","0","x","\n"},{"   ","0","   ","1","x","\n"},{"\0"}};
    for( i = 0; i<x.length; i++){
        for( j = 0; j<x[i].length;j++){
        y[i][j]=x[i][j];    
        }
    }//loop for storing in y
    
    for( i = 0; i<x.length; i++){
        if(y[i][0]=="\0"){
                    y[i][0]="   ";
                    y[i+1][0]="\0";
                    c=i-1;
                    break;
            }
    }    //for finding index of \0
//    r.append(""+c);
    for(j=0;j<y[c].length-3;j++){
        y[c+1][j+1]=y[c][j];
        if(y[c][j]=="x"){
            y[c+1][j+1]="x";
            y[c+1][j+2]="\n";
            y[c][j]="   ";
            y[c][j+1]="0";
            y[c][j+2]="x";
            y[c][j+3]="\n";
            a=j+1;
            break;
        }
    }//appending slant values with an x corresponding value
    while(true){
    if((y[c][a]=="b") && (y[c-2][a]=="b")){
        c--;
        y[c][a]="   ";
        y[c][a+1]="b";
        y[c][a+2]="x";
        y[c][a+3]="\n";
        a=a+1;
    }
    else{
    break;//for coming out of forever loop
    }
    }//for appending diagonal b values
    for( i = 0; i<y.length; i++){
        for( j = 0; j<y[i].length;j++){
            if(y[i][j]=="1" && y[i+1][0]!="\0"){
                y[i+1][j+1]="2";
            }
        }
    }//for 2 and 1 wala case :D

    /*
    
    */
    for( i = 0; i<y.length; i++){
        for( j = 0; j<y[i].length;j++){
            if(y[i][j]==null||y[i][j]=="x"||y[i][j]=="\0"){
            continue;
            }
            r.append(""+y[i][j]);
        }
    }//loop for printing y
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    String[][] y = new String[10][20]; 
    int i=0,j=0,k=0,v=0,c=0,count=0,a=0,b=0;
    String[][] x = {{"   ","1","   ","0","x","\n"},{"0","   ","1","   ","0","x","\n"},{"   ","0","   ","1","x","\n"},{"\0"}};
    for( i = 0; i<x.length; i++){
        for( j = 0; j<x[i].length;j++){
        y[i][j]=x[i][j];    
        }
    }//loop for storing in y
    
    for( i = 0; i<y.length; i++){
        for(j=y[i].length-2;j>=0;j--){
            y[i][j+1]=y[i][j];
        }//shifting elements to one right

        if(y[i][0]=="\0"){
            y[i+1][0]="\0";
            c=i-1;
            break;
        }
        y[i][0]="   ";
    }    //for finding index of \0
    
    for( i = 0; i<y.length; i++){
        if(y[i][1]=="0"){
            y[i+1][a]="0";
            b=i+1;
            break;
        }
    }//finding the index of a and appending diagonal b values
    while(true){
        if(b<=c){
            y[b+1][a+1]="0";
            b++;
            a++;
        }
        else{
            break;
        }
    }
    
    for(j=1;j<y[c].length-2;j++){
        y[c+1][j-1]=y[c][j];
        if(y[c][j]=="1"){
            y[c+1][j]="   ";
            y[c+1][j+1]="1";
            y[c+1][j+2]="x";
            y[c+1][j+3]="\n";
            y[c+1][j-1]="0";
        }
    }//loop for appending last line
    
    for(i = 0; i<y.length; i++){
        for( j = 0; j<y[i].length;j++){
            if(y[i][j]==null||y[i][j]=="x"||y[i][j]=="\0"){
            continue;
            }
            r.append(""+y[i][j]);
        }
    }//loop for printing y
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
    r.append("abcd");
    System.out.println("abcd");
    System.out.print("1234");
        System.out.print("abcd");
    System.out.println("abcd");

    // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(check.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(check.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(check.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(check.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new check().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea r;
    // End of variables declaration//GEN-END:variables
}
