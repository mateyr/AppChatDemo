
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appchat;

/**
 *
 * @author Sistemas-07
 */
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyServer  implements Runnable{

    private PropertyChangeSupport propertySupport;
    private int puerto;
    private String message;
     public void addPropertyChangeListener(PropertyChangeListener pcl) {
        propertySupport.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        propertySupport.removePropertyChangeListener(pcl);
    }
    
  
    public MyServer(int puerto) {
        this.puerto = puerto;
         propertySupport = new PropertyChangeSupport(this);
    }

    @Override
    public void run() {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;

        try {
            //Creamos el socket del servidor
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");

            //Siempre estara escuchando peticiones
            while (true) {

                //Espero a que un cliente se conecte
                sc = servidor.accept();

                //System.out.println("Cliente conectado");
                in = new DataInputStream(sc.getInputStream());
               
                //Leo el mensaje que me envia
                String messageSuport = in.readUTF();
               
                propertySupport.firePropertyChange("Mensaje", message,messageSuport);
          
                //Cierro el socket
                sc.close();
                //System.out.println("Cliente desconectado");

            }

        } catch (IOException ex) {
            Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    
    
    
    
    
    
    
    
    
    
    
    
}

