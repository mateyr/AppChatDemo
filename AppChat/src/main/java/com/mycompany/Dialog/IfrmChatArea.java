/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Dialog;

import com.mycompany.appchat.Client;
import com.mycompany.appchat.FrmAppSocialMedia;
import com.mycompany.appchat.MyServer;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JOptionPane;


/**
 *
 * @author MateyR
 */
public class IfrmChatArea extends javax.swing.JInternalFrame implements PropertyChangeListener{

    private MyServer server;
    private FrmAppSocialMedia fasm;
   
    /**
     * Creates new form IfrmChatArea
     */
    public IfrmChatArea() {
        initComponents();
        fasm = new FrmAppSocialMedia();
        server = new MyServer(5000);
        server.addPropertyChangeListener(this);
        Thread t = new Thread(server);
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        txtMessage = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAConversation = new javax.swing.JTextArea();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(txtMessage, gridBagConstraints);

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(btnSend, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.BorderLayout());

        txtAConversation.setEditable(false);
        txtAConversation.setColumns(20);
        txtAConversation.setRows(5);
        jScrollPane1.setViewportView(txtAConversation);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 812, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        String message = fasm.getFrmAppcontroller().getUserNameSupport() +":" + txtMessage.getText() + "\n";
        
       if(message.equals("")){
           JOptionPane.showMessageDialog(this,"Bro estas enviando un mensaje vacio :v");
       }
       
       txtAConversation.append(message);
                      
       Client client = new Client(5000, message);
       
       Thread t = new Thread(client);
       
       t.start();
       
       txtMessage.setText("");
       
    }//GEN-LAST:event_btnSendActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAConversation;
    private javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
      txtAConversation.append((String) evt.getNewValue());
    }
}
