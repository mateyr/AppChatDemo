/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appchat;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Sistemas-07
 */
public class Client{
    

public static void main(String[] args) {
try{	
Socket s=new Socket("10.9.13.38",6667);
	
DataOutputStream dout=new DataOutputStream(s.getOutputStream());

dout.writeUTF("Hello Server");
dout.flush();

dout.close();
s.close();

}catch(Exception e){System.out.println(e);}
}
}


