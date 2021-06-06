package com.mycompany.talk;


import static com.sun.org.apache.xerces.internal.dom.DOMMessageFormatter.formatMessage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import javax.websocket.DeploymentException;
import javax.websocket.EncodeException;
import javax.websocket.Session;
import org.glassfish.tyrus.client.ClientManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gulraiz
 */

public class ClientMain extends ClientData  {
    
      Message m=new Message();
    public void connectClient(String username)throws URISyntaxException, DeploymentException, IOException {
       ClientManager client=ClientManager.createClient();
        
       // 
        
        
       
      
        String m="ws://localhost:4832/ws/chat/"+username;
        System.out.println("client data may"+ m);
        
          sess=client.connectToServer(FXMLController.class, new URI(m));
          
          
    }
    public void sendmessage() throws IOException{
        System.out.println("What's your name?");
        String user ="SLo";
       String message;;
       Scanner scanner = new Scanner(System.in);
        //System.out.println("You are "+user);
         m=new Message();
        m.setFrom(user);
        do{
            message=scanner.nextLine();
            //updaate
            m.setContent(message);
            
            
             sess.getBasicRemote().sendText(message);
             //  sess.getBasicRemote().sendObject(m);
            
            
        }while(!message.equalsIgnoreCase("end"));
        
        
       
                
    }
     public void sendmessagetest() throws IOException, EncodeException{
         sess.getBasicRemote().sendObject(m);
     }
    

   
}
