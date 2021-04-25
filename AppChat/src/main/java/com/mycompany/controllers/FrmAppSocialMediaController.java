/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.Dialog.DlgCredentials;
import com.mycompany.Dialog.IfrmChatArea;
import com.mycompany.appchat.FrmAppSocialMedia;
import com.mycompany.appchat.FrmChatDemo;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

/**
 *
 * @author MateyR
 */
public class FrmAppSocialMediaController {
    private FrmAppSocialMedia frmAppSocialMedia;

    private IfrmChatArea chatArea;
    private DlgCredentials Dlgcredentials;
     
    private String userNameSupport;
    private String passwordSupport;

    public String getUserNameSupport() {
        return userNameSupport;
    }

    public String getPasswordSupport() {
        return passwordSupport;
    }
    
                       
    public FrmAppSocialMediaController(FrmAppSocialMedia frmAppSocialMedia) {
        this.frmAppSocialMedia = frmAppSocialMedia;
        
        initComponet();
        
    }
    
    public void initComponet(){
        
        
        frmAppSocialMedia.getMniSignIn().addActionListener((ActionEvent e) -> {
            mniSignInActionPerformed(e);
        });
        
        
    }
    
    
    public void mniSignInActionPerformed(ActionEvent e){
       
      Dlgcredentials = new DlgCredentials(null, true);
      
      Dlgcredentials.setVisible(true);
      
      this.userNameSupport = Dlgcredentials.getUsername();
      this.passwordSupport = Dlgcredentials.getPassword();
      
      chatArea = new IfrmChatArea();
      
      frmAppSocialMedia.getDtkContent().add(chatArea);
      
      chatArea.setVisible(true);
      

      
        
    } 

    
}
